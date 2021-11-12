(ns link.interpret.lib.private)

(def named-group #"\(\?<([a-zA-Z][a-zA-Z0-9]*)>")

(defn pattern-names [str]
  (let [names (into [] (map second (re-seq named-group str)))]
    [(re-pattern str)  (when (not (empty? names)) names)]))

(defn get-named-group [matcher names]
  (into {} (map (fn [x] [x (.group matcher x)]) names)))

(defn get-named-groups [matcher names]
  (when (.find matcher)
    (lazy-seq
     (cons
      (get-named-group matcher names)
      (get-named-groups matcher names)))))
