(ns com.grzm.foreclojure.alpha-test
  (:require [clojure.test :refer :all]
            [com.grzm.foreclojure.alpha :as fc]))

(deftest
  ^{::fc/problem 21}
  nth-element
  (let [__ fc/enth]
    (is (= (__ '(4 5 6 7) 2) 6))
    (is (= (__ [:a :b :c] 0) :a))
    (is (= (__ [1 2 3 4] 1) 2))
    (is (= (__ '([1 2] [3 4] [5 6]) 2) [5 6]))))

(deftest
  ^{:fc/problem 22}
  count-a-sequence
  (let [__ fc/cownt]
    (is (= (__ '(1 2 3 3 1)) 5))
    (is (= (__ "Hello World") 11))
    (is (= (__ [[1 2] [3 4] [5 6]]) 3))
    (is (= (__ '(13)) 1))
    (is (= (__ '(:a :b :c)) 3))))

(deftest
  ^{::fc/problem 23}
  reverse-a-sequence
  (let [__ fc/revers]
    (is (= (__ [1 2 3 4 5]) [5 4 3 2 1]))
    (is (= (__ (sorted-set 5 7 2 7)) '(7 5 2)))
    (is (= (__ [[1 2] [3 4] [5 6]]) [[5 6] [3 4] [1 2]]))))

(deftest
  ^{::fc/problem 24}
  sum-it-all-up
  (let [__ fc/sum]
    (is (= (__ [1 2 3]) 6))
    (is (= (__ (list 0 -2 5 5)) 8))
    (is (= (__ #{4 2 1}) 7))
    (is (= (__ '(0 0 -1)) -1))
    (is (= (__ '(1 10 3)) 14))))

(deftest
  ^{::fc/problem 25}
  find-the-odd-numbers
  (let [__ fc/filter-odd]
    (is (= (__ #{1 2 3 4 5}) '(1 3 5)))
    (is (= (__ [4 2 1 6]) '(1)))
    (is (= (__ [2 2 4 6]) '()))
    (is (= (__ [1 1 1 3]) '(1 1 1 3)))))

(deftest
  ^{::fc/problem 26}
  fibonacci-sequence
  (let [__ fc/fibonacci-seq]
    (is (= (__ 3) '(1 1 2)))
    (is (= (__ 6) '(1 1 2 3 5 8)))
    (is (= (__ 8) '(1 1 2 3 5 8 13 21)))))

(deftest
  ^{::fc/problem 27}
  palindrome-detector
  (let [__ fc/palindrome?]
    (is (false? (__ '(1 2 3 4 5))))
    (is (true? (__ "racecar")))
    (is (true? (__ [:foo :bar :foo])))
    (is (true? (__ '(1 1 3 3 1 1))))
    (is (false? (__ '(:a :b :c))))))

(deftest
  ^{::fc/problem 28}
  flatten-a-sequence
  (let [__ fc/flatten']
    (is (= (__ '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6)))
    (is (= (__ ["a" ["b"] "c"]) '("a" "b" "c")))
    (is (= (__ '((((:a))))) '(:a)))))

(deftest
  ^{::fc/problem 29}
  get-the-caps
  (let [__ fc/caps]
    (is (= (__ "HeLlO, WoRlD!") "HLOWRD"))
    (is (empty? (__ "nothing")))
    (is (= (__ "$#A(*&987Zf") "AZ"))))

(deftest
  ^{::fc/problem 30}
  compress-a-sequence
  (let [__ fc/dedupe']
    (is (= (apply str (__ "Leeeeeerrroyyy")) "Leroy"))
    (is (= (__ [1 1 2 3 3 2 2 3]) '(1 2 3 2 3)))
    (is (= (__ [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2])))))

(deftest
  ^{::fc/problem 31}
  pack-a-sequence
  (let [__ fc/pack]
    (is (= (__ [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3))))
    (is (= (__ [:a :a :b :b :c]) '((:a :a) (:b :b) (:c))))
    (is (= (__ [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4]))))))

(deftest
  ^{::fc/problem 32}
  duplicate-a-sequence
  (let [__ fc/duplicate]
    (is (= (__ [1 2 3]) '(1 1 2 2 3 3)))
    (is (= (__ [:a :a :b :b]) '(:a :a :a :a :b :b :b :b)))
    (is (= (__ [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4])))
    (is (= (__ [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4])))))

(deftest
  ^{::fc/problem 33}
  replicate-a-sequence
  (let [__ fc/replicate']
    (is (= (__ [1 2 3] 2) '(1 1 2 2 3 3)))
    (is (= (__ [:a :b] 4) '(:a :a :a :a :b :b :b :b)))
    (is (= (__ [4 5 6] 1) '(4 5 6)))
    (is (= (__ [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4])))
    (is (= (__ [44 33] 2) [44 44 33 33]))))

(deftest
  ^{::fc/problem 34}
  implement-range
  (let [__ fc/range']
    (is (= (__ 1 4) '(1 2 3)))
    (is (= (__ -2 2) '(-2 -1 0 1)))
    (is (= (__ 5 8) '(5 6 7)))))
