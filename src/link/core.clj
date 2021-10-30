(ns link.core
  (:import
   LinkLexer
   LinkParser
   [org.antlr.v4.runtime ANTLRFileStream CommonTokenStream])
  (:require
   [link.visitor :as vis]
   [clojure.pprint :as pp])
  (:gen-class))

(defn -main [& args]
  (let [input-stream (ANTLRFileStream. (first args))
        lexer (LinkLexer. input-stream)
        stream (CommonTokenStream. lexer)
        parser (LinkParser. stream)
        tree (.prog parser)
        visitor (vis/->Visitor)]
    (pp/pprint (.visitProg visitor tree))))
