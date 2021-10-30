(ns link.core
  (:import
   LinkLexer
   LinkParser
   [org.antlr.v4.runtime CharStreams CommonTokenStream])
  (:require
   [link.visitor :as vis]
   [clojure.pprint :as pp])
  (:gen-class))

(defn transpile [src]
  (let [input-stream (CharStreams/fromString src)
        lexer (LinkLexer. input-stream)
        stream (CommonTokenStream. lexer)
        parser (LinkParser. stream)
        tree (.prog parser)
        visitor (vis/->Visitor)]
    (.visitProg visitor tree)))

(defn -main [& args]
  (pp/pprint (transpile (slurp (first args)))))
