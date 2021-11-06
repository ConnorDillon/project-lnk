(ns link.interpret-test
  (:require [clojure.test :refer :all]
            [link.interpret :refer :all]))

(deftest math-test
  (is (= (interpret "1 + 1") 2))
  (is (= (interpret "1 + 2 * 3 - (4 + 2) / 2") 4)))

(deftest bool-test
  (is (= (interpret "2 < 1") false))
  (is (= (interpret "3 < 4 and not (6 < 5)") true))
  (is (= (interpret "1 == 2 or 1 != 2 and 2 >= 2") true)))

(deftest let-test
  (is (= (interpret "f a b = a + b; x = 1; y = 1; f x y") 2))
  (is (= (interpret "let f a b = a + b; x = 1; y = 1 in f x y") 2)))

(deftest map-test
  (let [src "map f x = if empty x
               then x
               else f (head x) & map f (tail x);
             inc x = x + 1;
             map inc [1, 2, 3]"]
    (is (= (apply vector (interpret src)) [2 3 4]))))

(deftest lambda-test
  (is (= (interpret "(\\x y. x + y) 1 1") 2))
  (is (= (interpret "f g = g 1; f \\x. x + 1") 2))
  (is (= (interpret "f g x = g x; f (\\x. x + 1) 1") 2)))

(deftest field-test
  (is (= (interpret "foo = {bar: 1}; foo.bar") 1))
  (is (= (interpret "foo = [0, 1]; foo[1]") 1))
  (is (= (interpret "foo = {bar: [{\"baz\": 1}]}; foo[\"bar\"][0].baz") 1)))
