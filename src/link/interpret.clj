(ns link.interpret
  (:require [link.transpile :as t]))

(defn interpret [src]
  (let [keep
        #{'defn
          'eval
          '+
          '-
          '*
          '/
          '=
          '>
          '>=
          '<
          '<=
          'and
          'or
          'not
          'fn
          'let
          'count
          'lazy-seq
          'cons
          }]
    (->>
     (keys (ns-map *ns*))
     (filter (fn [x] (not (contains? keep x))))
     (map (fn [x] (ns-unmap *ns* x)))
     (doall))
    (eval
     '(do 
       (def empty clojure.core/empty?)
       (def head clojure.core/first)
       (def tail clojure.core/rest)))
    (eval (t/transpile src))))

