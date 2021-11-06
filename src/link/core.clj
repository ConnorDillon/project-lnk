(ns link.core
  (:require [link.interpret :as i])
  (:gen-class))

(defn -main [& args]
  (let [result (i/interpret (slurp (first args)))]
    (if (seqable? result)
      (doall (map println result))
      (println result))))
