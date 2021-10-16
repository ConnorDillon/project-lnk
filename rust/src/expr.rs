use std::collections::HashMap;
use std::io::{self, Error, ErrorKind, Read, Write};

use serde::{Deserialize, Serialize};
use serde_json::{Map, Value};

#[derive(Debug, Clone, PartialEq)]
pub enum Expr {
    Null,
    Bool(bool),
    Int(i64),
    Float(f64),
    ID(String),
    String(String),
    Array(Vec<Expr>),
    Stream(Vec<Expr>),
    Expr(Vec<Expr>),
    Object(HashMap<String, Expr>),
}

impl Expr {
    pub fn decode_value(value: Value) -> Result<Expr, String> {
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
                    ("expr", Value::Array(a)) => vec_expr(a).map(Expr::Expr),
                    ("stream", Value::Array(a)) => vec_expr(a).map(Expr::Stream),
                    ("object", Value::Object(o)) => {
                        match o
                            .into_iter()
                            .map(|(k, v)| Expr::decode_value(v).map(|x| (k, x)))
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

    pub fn decode_reader<T: Read>(rdr: T) -> io::Result<Expr> {
        let val: Value = serde_json::from_reader(rdr)?;
        Expr::decode_value(val).map_err(|x| Error::new(ErrorKind::InvalidData, x))
    }

    pub fn encode_value(self) -> Value {
        match self {
            Expr::Null => Value::Null,
            Expr::Bool(b) => Value::Bool(b),
            Expr::Int(i) => i.into(),
            Expr::Float(f) => f.into(),
            Expr::ID(s) => value_object("id", Value::String(s)),
            Expr::String(s) => Value::String(s),
            Expr::Array(v) => Value::Array(v.into_iter().map(Expr::encode_value).collect()),
            Expr::Stream(v) => value_object(
                "stream",
                Value::Array(v.into_iter().map(Expr::encode_value).collect()),
            ),
            Expr::Expr(v) => value_object(
                "expr",
                Value::Array(v.into_iter().map(Expr::encode_value).collect()),
            ),
            Expr::Object(o) => value_object(
                "object",
                Value::Object(o.into_iter().map(|(k, v)| (k, v.encode_value())).collect()),
            ),
        }
    }

    pub fn encode_writer<T: Write>(self, wrt: T) -> serde_json::Result<()> {
        let val = self.encode_value();
        serde_json::to_writer(wrt, &val)
    }
}

fn vec_expr(vec: Vec<Value>) -> Result<Vec<Expr>, String> {
    match vec.into_iter().map(Expr::decode_value).collect() {
        Ok(v) => Ok(v),
        Err(e) => Err(format!("{}", e)),
    }
}

fn value_object<T: Into<String>>(tag: T, val: Value) -> Value {
    let mut hm = Map::new();
    hm.insert(tag.into(), val);
    Value::Object(hm)
}

impl From<Value> for Expr {
    fn from(value: Value) -> Expr {
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

impl Into<Value> for Expr {
    fn into(self) -> Value {
        match self {
            Expr::Null => Value::Null,
            Expr::Bool(b) => Value::Bool(b),
            Expr::Int(i) => i.into(),
            Expr::Float(f) => f.into(),
            Expr::ID(s) => value_object("id", Value::String(s)),
            Expr::String(s) => Value::String(s),
            Expr::Array(v) => Value::Array(v.into_iter().map(|x| x.into()).collect()),
            Expr::Stream(v) => Value::Array(v.into_iter().map(|x| x.into()).collect()),
            Expr::Expr(v) => Value::Array(v.into_iter().map(|x| x.into()).collect()),
            Expr::Object(o) => Value::Object(o.into_iter().map(|(k, v)| (k, v.into())).collect()),
        }
    }
}

impl<'de> Deserialize<'de> for Expr {
    fn deserialize<D>(deserializer: D) -> Result<Expr, D::Error>
    where
        D: serde::Deserializer<'de>,
    {
        Value::deserialize(deserializer).map(|x| x.into())
    }
}

impl Serialize for Expr {
    fn serialize<S>(&self, serializer: S) -> Result<S::Ok, S::Error>
    where
        S: ::serde::Serializer,
    {
        Value::serialize(&self.clone().into(), serializer)
    }
}

#[cfg(test)]
mod tests {
    use super::*;
    use quickcheck::{self, Arbitrary, Gen};

    fn arbitrary_f64(g: &mut Gen) -> f64 {
        let mut f = f64::arbitrary(g);
        while f.is_nan() || f.is_infinite() {
            f = f64::arbitrary(g);
        }
        f
    }

    impl Arbitrary for Expr {
        fn arbitrary(g: &mut Gen) -> Self {
            let mut ng = Gen::new(g.size() / 2);
            match g.choose(&[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]).unwrap() {
                1 => Expr::Bool(bool::arbitrary(g)),
                2 => Expr::Int(i64::arbitrary(g)),
                3 => Expr::Float(arbitrary_f64(g)),
                4 => Expr::ID(String::arbitrary(g)),
                5 => Expr::String(String::arbitrary(g)),
                6 => Expr::Array(Vec::<Expr>::arbitrary(&mut ng)),
                7 => Expr::Stream(Vec::<Expr>::arbitrary(&mut ng)),
                8 => Expr::Expr(Vec::<Expr>::arbitrary(&mut ng)),
                9 => Expr::Object(HashMap::<String, Expr>::arbitrary(&mut ng)),
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
                Expr::Expr(v) => Box::new(v.shrink().map(Expr::Expr)),
                Expr::Object(o) => Box::new(o.shrink().map(Expr::Object)),
            }
        }
    }

    #[quickcheck]
    fn encode_decode_value(expr: Expr) -> bool {
        let val = expr.clone().encode_value();
        expr == Expr::decode_value(val).unwrap()
    }

    #[quickcheck]
    fn expr_to_from_value(expr: Expr) -> bool {
        let val1: Value = expr.into();
        let val2: Value = Expr::from(val1.clone()).into();
        val1 == val2
    }
}
