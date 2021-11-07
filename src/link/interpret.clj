(ns link.interpret
  (:require [link.transpile :as t]))

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
              write-str to_json}]
   'link.interpret.lib))

(defn interpret [src]
  (let [n (ns-name *ns*)]
    (in-ns 'link.env)
    (env-use)
    (let [result (eval (t/transpile src))]
      (in-ns n)
      result)))
