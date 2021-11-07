(ns link.core
  (:require [link.interpret :as i])
  (:gen-class))

(defn -main [& args]
  (let [result (i/interpret (slurp (first args)))]
    (cond
      (string? result) (println result)
      (seqable? result) (doall (map println result))
      :else (println result))))
