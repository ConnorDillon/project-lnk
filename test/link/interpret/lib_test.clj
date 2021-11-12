(ns link.interpret.lib-test
  (:refer-clojure :exclude [format replace])
  (:require
   [clojure.test :refer :all]
   [link.interpret.lib :refer :all]))

(deftest capture-test
  (is (= (into [] ((capture_all "(?<baz>foo)(?<quux>baz)?") "foobazquuxfoo"))
         [{"baz" "foo" "quux" "baz"} {"baz" "foo" "quux" nil}])))
