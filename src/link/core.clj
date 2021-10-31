(ns link.core
  (:require
   [link.transpile :use transpile]
   [clojure.pprint :as pp])
  (:gen-class))

(defn -main [& args]
  (pp/pprint (transpile (slurp (first args)))))
