(ns link.core-test
  (:require [clojure.test :refer :all]
            [link.core :refer :all]))

(deftest math-test
  (is (= (eval (transpile "1 + 1")) 2))
  (is (= (eval (transpile "1 + 2 * 3 - (4 + 2) / 2")) 4)))

(deftest bool-test
  (is (= (eval (transpile "2 < 1")) false))
  (is (= (eval (transpile "3 < 4 and not (6 < 5)")) true))
  (is (= (eval (transpile "1 == 2 or 1 != 2 and 2 >= 2")) true)))

(deftest let-test
  (is (= (eval (transpile "f a b = a + b; x = 1; y = 1; f x y")) 2))
  (is (= (eval (transpile "let f a b = a + b; x = 1; y = 1 in f x y")) 2)))

(deftest map-test
  (let [src "test-map f x = if count x == 0 
               then x
               else f (first x) : test-map f (rest x);
             test-inc x = x + 1;
             test-map test-inc [1, 2, 3]"]
    (is (= (apply vector (eval (transpile src))) [2 3 4]))))
