(ns link.interpret.lib
  (:refer-clojure :exclude [format replace])
  (:require
   [clojure.string :as str]
   [link.interpret.lib.private :as priv]))

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

(defn match [pattern]
  (let [p (re-pattern pattern)]
    (fn [string]
      (re-find p string))))

(defn match_all [pattern]
  (let [p (re-pattern pattern)]
    (fn [string]
      (re-seq p string))))

(defn capture [pattern]
  (let [[p n] (priv/pattern-names pattern)]
    (fn [string]
      (let [m (re-matcher p string)]
        (when (.find m)
          (priv/get-named-group m n))))))

(defn capture_all [pattern]
  (let [[p n] (priv/pattern-names pattern)]
    (fn [string]
      (let [m (re-matcher p string)]
        (priv/get-named-groups m n)))))

(defn replace [pattern]
  (let [p (re-pattern pattern)]
    (fn [rep-string]
      (fn [string]
        (str/replace string p rep-string)))))

(defn split [pattern]
  (let [p (re-pattern pattern)]
    (fn [string]
      (str/split string p))))

(defn join [sep]
  (fn [coll] (str/join sep coll)))
