(ns link.interpret.lib
  (:refer-clojure :exclude [format replace find])
  (:require [clojure.string :as str]))

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
      (re-matches p string))))

(defn find [pattern]
  (let [p (re-pattern pattern)]
    (fn [string]
      (re-find p string))))

(defn find_all [pattern]
  (let [p (re-pattern pattern)]
    (fn [string]
      (re-seq p string))))

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
