(ns link.interpret.lib
  (:refer-clojure :exclude [format]))

(def lines "lines")

(defn input [kind]
  (when (= kind "lines")
    (lazy-seq
     (if-let [l (read-line)]
       (cons l (input kind))
       ()))))

(defn format [fmt]
  (fn [args]
    (apply clojure.core/format fmt args)))
