(ns com.grzm.foreclojure.alpha-test
  (:require [clojure.test :refer :all]
            [com.grzm.foreclojure.alpha :as fc]))

(deftest
  ^{::fc/problem 21}
  nth-element
  (let [__ fc/enth]
    (= (__ '(4 5 6 7) 2) 6)
    (= (__ [:a :b :c] 0) :a)
    (= (__ [1 2 3 4] 1) 2)
    (= (__ '([1 2] [3 4] [5 6]) 2) [5 6])))
