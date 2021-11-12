(ns link.transpile
  (:import
   [org.antlr.v4.runtime CharStreams CommonTokenStream]
   LinkLexer
   LinkVisitor
   LinkParser
   LinkParser$PipeOperContext
   LinkParser$OperPipeContext
   LinkParser$ArrayContext
   LinkParser$EmptyArrayContext
   LinkParser$StreamContext
   LinkParser$EmptyStreamContext
   LinkParser$ObjectContext
   LinkParser$EmptyObjectContext
   LinkParser$ExprOperContext
   LinkParser$DotContext
   LinkParser$IdContext
   LinkParser$IfContext
   LinkParser$StringContext
   LinkParser$RawStringContext
   LinkParser$IntContext
   LinkParser$FloatContext
   LinkParser$ApplyContext
   LinkParser$SubExprContext
   LinkParser$ApplyExprContext
   LinkParser$LambdaContext
   LinkParser$LetContext
   LinkParser$ConsContext)
  (:require
   [clojure.string :as str])
  (:gen-class))

(defn id-symbol [id]
  (symbol (.getText id)))

(defn fix-str [x]
  (let [s (subs x 1 (- (count x) 1))]
    (if (= (first x) \")
      (-> s
          (str/replace "\\\"" "\"")
          (str/replace "\\n" "\n")
          (str/replace "\\r" "\r")
          (str/replace "\\t" "\t")
          (str/replace "\\\\" "\\"))
      (str/replace s "''" "'"))))

(defn parse-str [x]
  (fix-str (.getText x)))

(defn curry [args body]
  (if (empty? args)
    body
    (curry (butlast args) (list 'fn [(last args)] body))))

(defn app [f args]
  (if (empty? args)
    f
    (app (list f (first args)) (rest args))))

(defn visitExpr [this ctx]
  (cond
    (instance? LinkParser$IntContext ctx) (.visitInt this ctx)
    (instance? LinkParser$FloatContext ctx) (.visitFloat this ctx)
    (instance? LinkParser$StringContext ctx) (.visitString this ctx)
    (instance? LinkParser$RawStringContext ctx) (.visitRawString this ctx)
    (instance? LinkParser$DotContext ctx) (.visitDot this ctx)
    (instance? LinkParser$IdContext ctx) (.visitId this ctx)
    (instance? LinkParser$ApplyContext ctx) (.visitApply this ctx)
    (instance? LinkParser$ApplyExprContext ctx) (.visitApplyExpr this ctx)
    (instance? LinkParser$ObjectContext ctx) (.visitObject this ctx)
    (instance? LinkParser$EmptyObjectContext ctx) (.visitEmptyObject this ctx)
    (instance? LinkParser$ArrayContext ctx) (.visitArray this ctx)
    (instance? LinkParser$EmptyArrayContext ctx) (.visitEmptyArray this ctx)
    (instance? LinkParser$StreamContext ctx) (.visitStream this ctx)
    (instance? LinkParser$EmptyStreamContext ctx) (.visitEmptyStream this ctx)
    (instance? LinkParser$IfContext ctx) (.visitIf this ctx)
    (instance? LinkParser$LetContext ctx) (.visitLet this ctx)
    (instance? LinkParser$LambdaContext ctx) (.visitLambda this ctx)
    (instance? LinkParser$SubExprContext ctx) (.visitSubExpr this ctx)))

(defn visitPipe [this ctx]
  (cond
    (instance? LinkParser$PipeOperContext ctx) (.visitPipeOper this ctx)
    (instance? LinkParser$OperPipeContext ctx) (.visitOperPipe this ctx)))

(defn visitOper [this ctx]
  (cond
    (instance? LinkParser$ExprOperContext ctx) (.visitExprOper this ctx)
    (instance? LinkParser$ConsContext ctx) (.visitCons this ctx)
    :else (let [x (id-symbol (.op ctx))
                y (visitOper this (.oper ctx 0))
                z (visitOper this (.oper ctx 1))]
            (case x
              == (list '= y z)
              != (list 'not (list '= y z))
              (list x y z)))))

(deftype Visitor []
  LinkVisitor

  (visitProg [this ctx]
    (let [f (fn [x] (apply list 'def (.visitAssign this x)))
          defs (apply list (map f (.assign ctx)))]
      (when-let [p (.pipe ctx)]
        (apply list 'do (concat defs (list (visitPipe this p)))))))

  (visitInt [this ctx]
    (Integer/parseInt (.getText ctx)))

  (visitFloat [this ctx]
    (Float/parseFloat (.getText ctx)))

  (visitString [this ctx]
    (parse-str ctx))

  (visitRawString [this ctx]
    (parse-str ctx))

  (visitDot [this ctx]
    (let [e1 (.expr ctx 1)]
      (list
       get
       (visitExpr this (.expr ctx 0))
       (if (instance? LinkParser$IdContext e1)
         (.getText e1)
         (visitExpr this e1)))))

  (visitId [this ctx]
    (id-symbol ctx))

  (visitApply [this ctx]
    (app (id-symbol (.ID ctx)) (map (partial visitExpr this) (.expr ctx))))

  (visitApplyExpr [this ctx]
    (app (visitPipe this (.pipe ctx)) (map (partial visitExpr this) (.expr ctx))))

  (visitObject [this ctx]
    (apply hash-map (apply concat (map (fn [x] (.visitPair this x)) (.pair ctx)))))

  (visitEmptyObject [this ctx]
    {})

  (visitArray [this ctx]
    (apply vector (map (partial visitPipe this) (.pipe ctx))))

  (visitEmptyArray [this ctx]
    [])

  (visitStream [this ctx]
    (apply list (map (partial visitPipe this) (.pipe ctx))))

  (visitEmptyStream [this ctx]
    (list))

  (visitIf [this ctx]
    (apply list 'if (map (partial visitOper this) (.oper ctx))))

  (visitLet [this ctx]
    (let [f (fn [x] (.visitAssign this x))
          vars (apply vector (apply concat (map f (.assign ctx))))]
      (list 'let vars (visitOper this (.oper ctx)))))

  (visitLambda [this ctx]
    (curry (map id-symbol (.ID ctx)) (visitOper this (.oper ctx))))

  (visitSubExpr [this ctx]
    (visitPipe this (.pipe ctx)))

  (visitCons [this ctx]
    (list 'lazy-seq (list 'cons (visitOper this (.oper ctx 0)) (visitOper this (.oper ctx 1)))))

  (visitOr [this ctx]
    (visitOper this ctx))

  (visitExprOper [this ctx]
    (visitExpr this (.expr ctx)))

  (visitMulDiv [this ctx]
    (visitOper this ctx))

  (visitAddSub [this ctx]
    (visitOper this ctx))

  (visitAnd [this ctx]
    (visitOper this ctx))

  (visitCompare [this ctx]
    (visitOper this ctx))

  (visitOperPipe [this ctx]
    (visitOper this (.oper ctx)))

  (visitPipeOper [this ctx]
    (list (visitPipe this (.pipe ctx 1)) (visitPipe this (.pipe ctx 0))))

  (visitAssign [this ctx]
    (let [syms (map id-symbol (.ID ctx))
          id (first syms)
          args (apply vector (rest syms))
          body (visitPipe this (.pipe ctx))]
      [id (curry args body)]))

  (visitPair [this ctx]
    [(if-let [id (.ID ctx)]
       (.getText id)
       (parse-str (.STRING ctx)))
     (visitPipe this (.pipe ctx))]))

(defn transpile [src]
  (let [input-stream (CharStreams/fromString src)
        lexer (LinkLexer. input-stream)
        stream (CommonTokenStream. lexer)
        parser (LinkParser. stream)
        tree (.prog parser)
        visitor (->Visitor)]
    (.visitProg visitor tree)))
