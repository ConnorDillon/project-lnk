use std::collections::HashMap;
use std::convert::{TryFrom, TryInto};
use std::io::{self, Error, ErrorKind, Read, Write};

use serde::{Deserialize, Serialize};
use serde_json::{Map, Value};

#[derive(Debug, Clone, PartialEq)]
pub enum Expr<A> {
    Null,
    Bool(bool),
    Int(i64),
    Float(f64),
    ID(String),
    String(String),
    Array(Vec<Expr<A>>),
    Stream(Vec<Expr<A>>),
    Expr(A),
    Object(HashMap<String, Expr<A>>),
}

impl<A> Expr<A> {
    pub fn map<B, C: FnMut(A) -> B>(self, mut op: C) -> Expr<B> {
	self.map_ref(&mut op)
    }

    fn map_ref<B, C: FnMut(A) -> B>(self, op: &mut C) -> Expr<B> {
        match self {
            Expr::Null => Expr::Null,
            Expr::Bool(x) => Expr::Bool(x),
            Expr::Int(x) => Expr::Int(x),
            Expr::Float(x) => Expr::Float(x),
            Expr::ID(x) => Expr::ID(x),
            Expr::String(x) => Expr::String(x),
            Expr::Array(x) => Expr::Array(x.into_iter().map(|x| x.map_ref(op)).collect()),
            Expr::Stream(x) => Expr::Stream(x.into_iter().map(|x| x.map_ref(op)).collect()),
            Expr::Object(x) => Expr::Object(x.into_iter().map(|(x, y)| (x, y.map_ref(op))).collect()),
            Expr::Expr(e) => Expr::Expr(op(e)),
        }
    }
}

impl<A> From<Value> for Expr<A> {
    fn from(value: Value) -> Self {
        match value {
            Value::Null => Expr::Null,
            Value::Bool(b) => Expr::Bool(b),
            Value::String(s) => Expr::String(s),
            Value::Number(n) => match n.as_i64() {
                Some(i) => Expr::Int(i),
                None => Expr::Float(n.as_f64().unwrap()),
            },
            Value::Array(v) => Expr::Array(v.into_iter().map(|x| x.into()).collect()),
            Value::Object(o) => Expr::Object(o.into_iter().map(|(k, v)| (k, v.into())).collect()),
        }
    }
}

impl<A: Into<Value>> Into<Value> for Expr<A> {
    fn into(self) -> Value {
        match self {
            Expr::Null => Value::Null,
            Expr::Bool(b) => Value::Bool(b),
            Expr::Int(i) => i.into(),
            Expr::Float(f) => f.into(),
            Expr::ID(s) => Value::String(s),
            Expr::String(s) => Value::String(s),
            Expr::Array(v) => Value::Array(v.into_iter().map(|x| x.into()).collect()),
            Expr::Stream(v) => Value::Array(v.into_iter().map(|x| x.into()).collect()),
            Expr::Expr(e) => e.into(),
            Expr::Object(o) => Value::Object(o.into_iter().map(|(k, v)| (k, v.into())).collect()),
        }
    }
}

impl<'de> Deserialize<'de> for Expr<Void> {
    fn deserialize<D>(deserializer: D) -> Result<Self, D::Error>
    where
        D: serde::Deserializer<'de>,
    {
        Value::deserialize(deserializer).map(|x| x.into())
    }
}

impl Serialize for Expr<Void> {
    fn serialize<S>(&self, serializer: S) -> Result<S::Ok, S::Error>
    where
        S: ::serde::Serializer,
    {
        Value::serialize(&self.clone().into(), serializer)
    }
}

pub fn encode_value<A: Into<Value> + TryFrom<Value>>(expr: Expr<A>) -> Value {
    match expr {
        Expr::Null => Value::Null,
        Expr::Bool(b) => Value::Bool(b),
        Expr::Int(i) => i.into(),
        Expr::Float(f) => f.into(),
        Expr::ID(s) => value_object("id", Value::String(s)),
        Expr::String(s) => Value::String(s),
        Expr::Array(v) => Value::Array(v.into_iter().map(encode_value).collect()),
        Expr::Stream(v) => value_object(
            "stream",
            Value::Array(v.into_iter().map(encode_value).collect()),
        ),
        Expr::Expr(e) => value_object("expr", e.into()),
        Expr::Object(o) => value_object(
            "object",
            Value::Object(o.into_iter().map(|(k, v)| (k, encode_value(v))).collect()),
        ),
    }
}

pub fn encode_writer<A: Into<Value> + TryFrom<Value>, B: Write>(
    expr: Expr<A>,
    wrt: B,
) -> serde_json::Result<()> {
    let val = encode_value(expr);
    serde_json::to_writer(wrt, &val)
}

pub fn decode_value<A: Into<Value> + TryFrom<Value>>(value: Value) -> Result<Expr<A>, String> {
    match value {
        Value::Null => Ok(Expr::Null),
        Value::Bool(b) => Ok(Expr::Bool(b)),
        Value::String(s) => Ok(Expr::String(s)),
        Value::Number(n) => match n.as_i64() {
            Some(i) => Ok(Expr::Int(i)),
            None => match n.as_f64() {
                Some(f) => Ok(Expr::Float(f)),
                None => Err("Invalid number".into()),
            },
        },
        Value::Array(v) => vec_expr(v).map(Expr::Array),
        Value::Object(o) => match o.into_iter().next() {
            Some((k, v)) => match (&*k, v) {
                ("id", Value::String(s)) => Ok(Expr::ID(s)),
                ("expr", e) => e.try_into().map_err(|_| "foo".into()).map(Expr::Expr),
                ("stream", Value::Array(a)) => vec_expr(a).map(Expr::Stream),
                ("object", Value::Object(o)) => {
                    match o
                        .into_iter()
                        .map(|(k, v)| decode_value(v).map(|x| (k, x)))
                        .collect()
                    {
                        Ok(o) => Ok(Expr::Object(o)),
                        Err(e) => Err(format!("{}", e)),
                    }
                }
                _ => Err("Invalid object".into()),
            },
            None => Ok(Expr::Object(HashMap::new())),
        },
    }
}

pub fn decode_reader<A: Into<Value> + TryFrom<Value>, B: Read>(rdr: B) -> io::Result<Expr<A>> {
    let val: Value = serde_json::from_reader(rdr)?;
    decode_value(val).map_err(|x| Error::new(ErrorKind::InvalidData, x))
}

fn vec_expr<A: TryFrom<Value> + Into<Value>>(vec: Vec<Value>) -> Result<Vec<Expr<A>>, String> {
    match vec.into_iter().map(decode_value).collect() {
        Ok(v) => Ok(v),
        Err(e) => Err(format!("{}", e)),
    }
}

fn value_object<A: Into<String>>(tag: A, val: Value) -> Value {
    let mut hm = Map::new();
    hm.insert(tag.into(), val);
    Value::Object(hm)
}

#[derive(Clone, Debug, PartialEq)]
pub struct List(Vec<Expr<List>>);

impl Into<Value> for List {
    fn into(self) -> Value {
        Value::Array(self.0.into_iter().map(encode_value).collect())
    }
}

impl TryFrom<Value> for List {
    type Error = String;
    fn try_from(value: Value) -> Result<Self, Self::Error> {
        match value {
            Value::Array(v) => vec_expr(v).map(List),
            _ => Err("Not a list".into()),
        }
    }
}

#[derive(Clone)]
pub enum Void {}

impl Void {
    pub fn absurd(self) -> ! {
        match self {}
    }
}

impl Into<Value> for Void {
    fn into(self) -> Value {
        self.absurd()
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use quickcheck::{self, Arbitrary, Gen};

    fn arbitrary_f64(g: &mut Gen) -> f64 {
        let mut f = f64::arbitrary(g);
        while f.is_nan() || f.is_infinite() {
            f = <_>::arbitrary(g);
        }
        f
    }

    impl<A: Arbitrary> Arbitrary for Expr<A> {
        fn arbitrary(g: &mut Gen) -> Self {
            let mut ng = Gen::new(g.size() / 2);
            match g.choose(&[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]).unwrap() {
                1 => Expr::Bool(<_>::arbitrary(g)),
                2 => Expr::Int(<_>::arbitrary(g)),
                3 => Expr::Float(arbitrary_f64(g)),
                4 => Expr::ID(<_>::arbitrary(g)),
                5 => Expr::String(<_>::arbitrary(g)),
                6 => Expr::Array(<_>::arbitrary(&mut ng)),
                7 => Expr::Stream(<_>::arbitrary(&mut ng)),
                8 => Expr::Expr(<_>::arbitrary(g)),
                9 => Expr::Object(<_>::arbitrary(&mut ng)),
                _ => Expr::Null,
            }
        }

        fn shrink(&self) -> Box<dyn Iterator<Item = Self>> {
            match self {
                Expr::Null => quickcheck::empty_shrinker(),
                Expr::Bool(b) => Box::new(b.shrink().map(Expr::Bool)),
                Expr::Int(i) => Box::new(i.shrink().map(Expr::Int)),
                Expr::Float(f) => Box::new(f.shrink().map(Expr::Float)),
                Expr::ID(s) => Box::new(s.shrink().map(Expr::ID)),
                Expr::String(s) => Box::new(s.shrink().map(Expr::ID)),
                Expr::Array(v) => Box::new(v.shrink().map(Expr::Array)),
                Expr::Stream(v) => Box::new(v.shrink().map(Expr::Stream)),
                Expr::Expr(e) => Box::new(e.shrink().map(Expr::Expr)),
                Expr::Object(o) => Box::new(o.shrink().map(Expr::Object)),
            }
        }
    }

    impl Arbitrary for List {
        fn arbitrary(g: &mut Gen) -> Self {
            List(<_>::arbitrary(&mut Gen::new(g.size() / 2)))
        }

        fn shrink(&self) -> Box<dyn Iterator<Item = Self>> {
            Box::new(self.0.shrink().map(List))
        }
    }

    #[quickcheck]
    fn encode_decode_value(expr: Expr<List>) -> bool {
        let val = encode_value(expr.clone());
        expr == decode_value(val).unwrap()
    }

    #[quickcheck]
    fn expr_to_from_value(expr: Expr<()>) -> bool {
        let val1: Value = expr.into();
        let val2: Value = Expr::<Void>::from(val1.clone()).into();
        val1 == val2
    }
}
