(ns link.visitor
  (:import LinkVisitor
           LinkParser$PipeOperContext
           LinkParser$OperPipeContext
           LinkParser$ArrayContext
           LinkParser$EmptyArrayContext
           LinkParser$StreamContext
           LinkParser$EmptyStreamContext
           LinkParser$ObjectContext
           LinkParser$EmptyObjectContext
           LinkParser$ExprOperContext
           LinkParser$IdContext
           LinkParser$IfContext
           LinkParser$StringContext
           LinkParser$IntContext
           LinkParser$FloatContext
           LinkParser$ApplyContext
           LinkParser$SubExprContext
           LinkParser$ApplyExprContext
           LinkParser$LambdaContext
           LinkParser$LetContext
           LinkParser$FieldContext
           LinkParser$ConsContext)
  (:gen-class))

(defn id-symbol [id]
  (symbol (.getText id)))

(defn get-str [x]
  (let [s (.getText x)]
    (subs s 1 (- (count s) 1))))

(defn visitExpr [this ctx]
  (cond
    (instance? LinkParser$IntContext ctx) (.visitInt this ctx)
    (instance? LinkParser$FloatContext ctx) (.visitFloat this ctx)
    (instance? LinkParser$StringContext ctx) (.visitString this ctx)
    (instance? LinkParser$FieldContext ctx) (.visitField this ctx)
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
    :else (list (id-symbol (.op ctx)) (visitOper this (.oper ctx 0)) (visitOper this (.oper ctx 1)))))

(deftype Visitor []
  LinkVisitor

  (visitProg [this ctx]
    (let [f (fn [x] (.visitAssign this x))
          vars (apply vector (apply concat (map f (.assign ctx))))]
      (when-let [p (.pipe ctx)]
        (list 'let vars (visitPipe this p)))))

  (visitInt [this ctx]
    (Integer/parseInt (.getText ctx)))

  (visitFloat [this ctx]
    (Float/parseFloat (.getText ctx)))

  (visitString [this ctx]
    (get-str ctx))

  (visitField [this ctx]
    (.getText ctx))

  (visitId [this ctx]
    (id-symbol ctx))

  (visitApply [this ctx]
    (apply list (cons (id-symbol (.ID ctx)) (map (partial visitExpr this) (.expr ctx)))))

  (visitApplyExpr [this ctx]
    (apply list (cons (visitPipe this (.pipe ctx)) (map (partial visitExpr this) (.expr ctx)))))

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
    (list 'fn (apply vector (map id-symbol (.ID ctx))) (visitOper this (.oper ctx))))

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
      [id (if (empty? args) body (list 'fn args body))]))

  (visitPair [this ctx]
    [(if-let [id (.ID ctx)]
       (id-symbol id)
       (get-str (.STRING ctx)))
     (visitPipe this (.pipe ctx))]))

;; (defn run []
;;   (do
;;     (let [input-stream (org.antlr.v4.runtime.ANTLRFileStream. "../../dev/input")
;;          lexer (LinkLexer. input-stream)
;;          stream (org.antlr.v4.runtime.CommonTokenStream. lexer)
;;          parser (LinkParser. stream)
;;          tree (.prog parser)
;;          visitor (Visitor.)]
;;      (.visitProg visitor tree))))
