(ns link.interpret
  (:require
   [clojure.data.json :as json]
   [link.transpile :as t]))

(defn input [kind]
  (when (= kind "lines")
    (lazy-seq
     (if-let [l (read-line)]
       (cons l (input kind))
       ()))))

(def defs
  (list
   'do
   (list 'def 'lines "lines")
   (list 'def 'input input)))

(defn env-use []
  (use
   '[clojure.core
     :only [+
            -
            *
            /
            =
            >
            >=
            <
            <=
            and
            or
            not
            fn
            let
            count
            lazy-seq
            cons
            first
            rest
            empty?]
     :rename {first head
              rest tail
              empty? empty}]
   '[clojure.data.json
     :only [read-str
            write-str]
     :rename {read-str from_json
              write-str to_json}]))

(defn interpret [src]
  (let [n (ns-name *ns*)]
    (in-ns 'link.env)
    (env-use)
    (eval defs)
    (let [result (eval (t/transpile src))]
      (in-ns n)
      result)))
