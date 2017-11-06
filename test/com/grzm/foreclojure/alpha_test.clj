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

(deftest
  ^{::fc/problem 35}
  local-bindings
  (let [__ 7]
    (is (= __ (let [x 5] (+ 2 x))))
    (is (= __ (let [x 3, y 10] (- y x))))
    (is (= __ (let [x 21] (let [y 3] (/ x y)))))))

(deftest
  ^{::fc/problem 36}
  let-it-be
  (let [x 7
        y 3
        z 1]
    (is (= 10 (+ x y)))
    (is (= 4 (+ y z)))
    (is (= 1 z))))

(deftest
  ^{::fc/problem 37}
  regular-expressions
  (let [__ "ABC"]
    (is (= __ (apply str (re-seq #"[A-Z]+" "bA1B3Ce "))))))

(deftest
  ^{::fc/problem 38}
  maximum-value
  (let [__ (fn [& xs]
             (reduce (fn [memo el]
                       (if (< memo el) el memo))
                     (first xs)
                     (rest xs)))]
    (is (= (__ 1 8 3 4) 8))
    (is (= (__ 30 20) 30))
    (is (= (__ 45 67 11) 67))))

(deftest
  ^{::fc/problems 39}
  interleave-two-seqs
  "Write a function which takes two sequences and returns the first item
  from each, then the second item from each, then the third, etc."
  (let [__ fc/interleave']
    (is (= (__ [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c)))
    (is (= (__ [1 2] [3 4 5 6]) '(1 3 2 4)))
    (is (= (__ [1 2 3 4] [5]) [1 5]))
    (is (= (__ [30 20] [25 15]) [30 25 20 15]))))

(deftest
  ^{::fc/problems 40}
  interpose-a-seq
  "Write a function which separates the items of a sequence by an arbitrary value.
  Special Restrictions: interpose"
  (let [__ fc/interpose']
    (is (= (__ 0 [1 2 3]) [1 0 2 0 3]))
    (is (= (apply str (__ ", " ["one" "two" "three"])) "one, two, three"))
    (is (= (__ :z [:a :b :c :d]) [:a :z :b :z :c :z :d]))))

(deftest
  ^{::fc/problems 41}
  drop-every-nth-item
  "Write a function which drops every Nth item from a sequence."
  (let [__ fc/drop-nth]
    (is (= (__ [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8]))
    (is (= (__ [:a :b :c :d :e :f] 2) [:a :c :e]))
    (is (= (__ [1 2 3 4 5 6] 4) [1 2 3 5 6]))))

(deftest
  ^{::fc/problems 42}
  factorial-fun
  "Write a function which calculates factorials."
  (let [__ fc/factorial']
    (is (= (__ 1) 1))
    (is (= (__ 3) 6))
    (is (= (__ 5) 120))
    (is (= (__ 8) 40320))))

(deftest
  ^{::fc/problems 43}
  reverse-interleave
  (let [__ fc/reverse-interleave]
    (is (= (__ [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6))))
    (is (= (__ (range 9) 3) '((0 3 6) (1 4 7) (2 5 8))))
    (is (= (__ (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9))))))
