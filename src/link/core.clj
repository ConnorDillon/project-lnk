(ns link.core
  (:require [link.interpret :use interpret])
  (:gen-class))

(defn -main [& args]
  (println (interpret (slurp (first args)))))
