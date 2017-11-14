(ns com.grzm.foreclojure.alpha-test
  (:require [clojure.test :refer :all]
            [com.grzm.foreclojure.alpha :as fc]))

(deftest
  ^{::fc/problem 1}
  nothing-but-the-truth
  "This is a clojure form. Enter a value which will make the form
  evaluate to true. Don't over think it! If you are confused, see
  the getting started page. Hint: true is equal to true."
  (let [__ true]
    (is (= __ true))))

(deftest
  ^{::fc/problem 2}
  simple-math
  "If you are not familiar with polish notation, simple arithmetic
  might seem confusing.

  Note: Enter only enough to fill in the blank (in this case, a single
  number) - do not retype the whole problem."
  (let [__ 4]
    (is (= (- 10 (* 2 3)) __))))

(deftest
  ^{::fc/problem 3}
  intro-to-strings
  "Clojure strings are Java strings. This means that you can use any
  of the Java string methods on Clojure strings."
  (let [__ "HELLO WORLD"]
    (is (= __ (.toUpperCase "hello world")))))

(deftest
  ^{::fc/problems 4}
  intro-to-lists
  "Lists can be constructed with either a function or a quoted form."
  (is (= (list :a :b :c) '(:a :b :c))))

(deftest
  ^{::fc/problems 5}
  lists-conj
  "When operating on a list, the conj function will return a new list
  with one or more items \"added\" to the front.

  Note that there are two test cases, but you are expected to supply
  only one answer, which will cause all the tests to pass."
  (let [__ '(1 2 3 4)]
    (is (= __ (conj '(2 3 4) 1)))
    (is (= __ (conj '(3 4) 2 1)))))

(deftest
  ^{::fc/problems 6}
  intro-to-vectors
  "Vectors can be constructed several ways. You can compare them with lists.

  Note: the brackets [] surrounding the blanks __ are part of the test case."
  (is (= [:a :b :c] (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c))))

(deftest
  ^{::fc/problems 7}
  vectors-conj
  "When operating on a Vector, the conj function will return a new vector with
  one or more items \"added\" to the end."
  (let [__ [1 2 3 4]]
    (is (= __ (conj [1 2 3] 4)))
    (is (= __ (conj [1 2] 3 4)))))

(deftest
  ^{::fc/problems 8}
  intro-to-sets
  "Sets are collections of unique values."
  (let [__ #{:a :b :c :d}]
    (is (= __ (set '(:a :a :b :c :c :c :c :d :d))))
    (is (= __ (clojure.set/union #{:a :b :c} #{:b :c :d})))))

(deftest
  ^{::fc/problems 9}
  sets-conj
  "When operating on a set, the conj function returns a new set with one
  or more keys \"added\"."
  (let [__ 2]
    (is (= #{1 2 3 4} (conj #{1 4 3} __)))))

(deftest
  ^{::fc/problems 10}
  intro-to-maps
  "Maps store key-value pairs. Both maps and keywords can be used as
  lookup functions. Commas can be used to make maps more readable,
  but they are not required."
  (let [__ 20]
    (is (= __ ((hash-map :a 10, :b 20, :c 30) :b)))
    (is (= __ (:b {:a 10, :b 20, :c 30})))))

(deftest
  ^{::fc/problems 11}
  maps-conj
  "When operating on a map, the conj function returns a new map with one
  or more key-value pairs \"added\"."
  (let [__ [:b 2]]
    (= {:a 1, :b 2, :c 3} (conj {:a 1} __ [:c 3]))))

(deftest
  ^{::fc/problems 12}
  intro-to-sequences
  "All Clojure collections support sequencing. You can operate on sequences
  with functions like first, second, and last."
  (let [__ 3]
    (= __ (first '(3 2 1)))
    (= __ (second [2 3 4]))
    (= __ (last (list 1 2 3)))))

(deftest
  ^{::fc/problems 13}
  sequences-rest
  "The rest function will return all the items of a sequence except the first."
  (let [__ '(20 30 40)]
    (is (= __ (rest [10 20 30 40])))))

(deftest
  ^{::fc/problems 14}
  intro-to-functions
  "Clojure has many different ways to create functions."
  (let [__ 8]
    (is (= __ ((fn add-five [x] (+ x 5)) 3)))
    (is (= __ ((fn [x] (+ x 5)) 3)))
    (is (= __ (#(+ % 5) 3)))
    (is (= __ ((partial + 5) 3)))))

(deftest
  ^{::fc/problems 15}
  double-down
  "Write a function which doubles a number."
  (let [__ (partial * 2)]
    (is (= (__ 2) 4))
    (is (= (__ 3) 6))
    (is (= (__ 11) 22))
    (is (= (__ 7) 14))))

(deftest
  ^{::fc/problems 16}
  hello-world
  "Write a function which returns a personalized greeting."
  (let [__ (partial format "Hello, %s!")]
    (is (= (__ "Dave") "Hello, Dave!"))
    (is (= (__ "Jenn") "Hello, Jenn!"))
    (is (= (__ "Rhea") "Hello, Rhea!"))))

(deftest
  ^{::fc/problems 17}
  sequences-map
  "The map function takes two arguments: a function (f) and a
  sequence (s). Map returns a new sequence consisting of the
  result of applying f to each item of s. Do not confuse the
   map function with the map data structure."
  (let [__ (list 6 7 8)]
    (is (= __ (map #(+ % 5) '(1 2 3))))))

(deftest
  ^{::fc/problems 18}
  sequences-filter
  "The filter function takes two arguments: a predicate function
  (f) and a sequence (s). Filter returns a new sequence consisting
  of all the items of s for which (f item) returns true."
  (let [__ '(6 7)]
    (is (= __ (filter #(> % 5) '(3 4 5 6 7))))))

(deftest
  ^{::fc/problems 19}
  last-element
  "Write a function which returns the last element in a sequence.

   Special Restrictions: last"
  (let [__ (comp first reverse)]
    (is (= (__ [1 2 3 4 5]) 5))
    (is (= (__ '(5 4 3)) 3))
    (is (= (__ ["b" "c" "d"]) "d"))))

(deftest
  ^{::fc/problems 20}
  penultimate-element
  "Write a function which returns the second to last element
  from a sequence."
  (let [__ (comp second reverse)]
    (is (= (__ (list 1 2 3 4 5)) 4))
    (is (= (__ ["a" "b" "c"]) "b"))
    (is (= (__ [[1 2] [3 4]]) [1 2]))))

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

(deftest
  ^{::fc/problems 44}
  rotate-sequence
  "Write a function which can rotate a sequence in either direction."
  (let [__ fc/rotate']
    (is (= (__ 2 [1 2 3 4 5]) '(3 4 5 1 2)))
    (is (= (__ -2 [1 2 3 4 5]) '(4 5 1 2 3)))
    (is (= (__ 6 [1 2 3 4 5]) '(2 3 4 5 1)))
    (is (= (__ 1 '(:a :b :c)) '(:b :c :a)))
    (is (= (__ -4 '(:a :b :c)) '(:c :a :b)))))

(deftest
  ^{::fc/problems 45}
  intro-to-iterate
  "The iterate function can be used to produce an infinite lazy sequence."
  (let [__ '(1 4 7 10 13)]
    (is (= __ (take 5 (iterate #(+ 3 %) 1))))))

(deftest
  ^{::fc/problems 46}
  flipping-out
  "Write a higher-order function which flips the order of the
   arguments of an input function."
  (let [__ (fn [f] (fn [a b] (f b a)))]
    (is (= 3 ((__ nth) 2 [1 2 3 4 5])))
    (is (= true ((__ >) 7 8)))
    (is (= 4 ((__ quot) 2 8)))
    (is (= [1 2 3] ((__ take) [1 2 3 4 5] 3)))))

(deftest
  ^{::fc/problems 47}
  contain-yourself
  "The contains? function checks if a KEY is present in a given
   collection. This often leads beginner clojurians to use it
   incorrectly with numerically indexed collections like vectors
   and lists."
  (let [__ 4]
    (is (contains? #{4 5 6} __))
    (is (contains? [1 1 1 1 1] __))
    (is (contains? {4 :a 2 :b} __))
    (is (not (contains? [1 2 4] __)))))

(deftest
  ^{::fc/problems 48}
  intro-to-some
  "The some function takes a predicate function and a collection.
  It returns the first logical true value of (predicate x) where x
  is an item in the collection."
  (let [__ 6]
    (is (= __ (some #{2 7 6} [5 6 7 8])))
    (is (= __ (some #(when (even? %) %) [5 6 7 8])))))

(deftest
  ^{::fc/problems 49}
  split-a-sequence
  (let [__ (fn [n xs] [(take n xs) (drop n xs)])]
    (is (= (__ 3 [1 2 3 4 5 6]) [[1 2 3] [4 5 6]]))
    (is (= (__ 1 [:a :b :c :d]) [[:a] [:b :c :d]]))
    (is (= (__ 2 [[1 2] [3 4] [5 6]]) [[[1 2] [3 4]] [[5 6]]]))))

(deftest
  ^{::fc/problems 50}
  split-by-type
  "Write a function which takes a sequence consisting
  of items with different types and splits them up into
  a set of homogeneous sub-sequences. The internal order
  of each sub-sequence should be maintained, but the
  sub-sequences themselves can be returned in any order
  (this is why 'set' is used in the test cases)."
  (let [__ (comp vals (partial group-by type))]
    (is (= (set (__ [1 :a 2 :b 3 :c])) #{[1 2 3] [:a :b :c]}))
    (is (= (set (__ [:a "foo"  "bar" :b])) #{[:a :b] ["foo" "bar"]}))
    (is (= (set (__ [[1 2] :a [3 4] 5 6 :b])) #{[[1 2] [3 4]] [:a :b] [5 6]}))))

(deftest
  ^{::fc/problems 51}
  advanced-destructuring
  "Here is an example of some more sophisticated destructuring."
  (let [__ [1 2 3 4 5]]
    (is (= [1 2 [3 4 5] [1 2 3 4 5]]
           (let [[a b & c :as d] __]
             [a b c d])))))

(deftest
  ^{::fc/problems 52}
  intro-to-destructuring
  "Let bindings and function parameter lists support destructuring."
  (is (= [2 4]
         (let [[a b c d e] [0 1 2 3 4]
               __          [c e]]
           __))))

(deftest
  ^{::fc/problems 53}
  longest-increasing-sub-seq
  "Given a vector of integers, find the longest consecutive
  sub-sequence of increasing numbers. If two sub-sequences have
  the same length, use the one that occurs first. An increasing
  sub-sequence must have a length of 2 or greater to qualify."
  (let [__ fc/longest-sub]
    (is (= (__ [1 0 1 2 3 0 4 5]) [0 1 2 3]))
    (is (= (__ [5 6 1 3 2 7]) [5 6]))
    (is (= (__ [2 3 3 4 5]) [3 4 5]))
    (is (= (__ [7 6 5 4]) []))))

(deftest
  ^{::fc/problems 54}
  partition-a-sequence
  "Write a function which returns a sequence of lists of x items
  each. Lists of less than x items should not be returned.
  Special Restrictions: partition, partition-all"
  (let [__ fc/partition']
    (is (= (__ 3 (range 9)) '((0 1 2) (3 4 5) (6 7 8))))
    (is (= (__ 2 (range 8)) '((0 1) (2 3) (4 5) (6 7))))
    (is (= (__ 3 (range 8)) '((0 1 2) (3 4 5))))))

(deftest
  ^{::fc/problems 55}
  count-occurrences
  "Write a function which returns a map containing the
    number of occurences of each distinct item in a sequence."
  (let [__ fc/count-occurrences]
    (is (= (__ [1 1 2 3 2 1 1]) {1 4, 2 2, 3 1}))
    (is (= (__ [:b :a :b :a :b]) {:a 2, :b 3}))
    (is (= (__ '([1 2] [1 3] [1 3])) {[1 2] 1, [1 3] 2}))))

(deftest
  ^{::fc/problems 56}
  find-distinct-items
  "Write a function which removes the duplicates from
  a sequence. Order of the items must be maintained."
  (let [__ fc/find-distinct]
    (is (= (__ [1 2 1 3 1 2 4]) [1 2 3 4]))
    (is (= (__ [:a :a :b :b :c :c]) [:a :b :c]))
    (is (= (__ '([2 4] [1 2] [1 3] [1 3])) '([2 4] [1 2] [1 3])))
    (is (= (__ (range 50)) (range 50)))))

(deftest
  ^{::fc/problems 57}
  simple-recursion
  "A recursive function is a function which calls itself. This is one
  of the fundamental techniques used in functional programming."
  (let [__ '(5 4 3 2 1)]
    (is (= __ ((fn foo [x] (when (> x 0) (conj (foo (dec x)) x))) 5)))))

(deftest
  ^{::fc/problems 58}
  function-composition
  "Write a function which allows you to create function compositions.
  The parameter list should take a variable number of functions, and
  create a function that applies them from right-to-left.
  Special Restrictions: comp"
  (let [__ fc/comp']
    (is (= [3 2 1] ((__ rest reverse) [1 2 3 4])))
    (is (= 5 ((__ (partial + 3) second) [1 2 3 4])))
    (is (= true ((__ zero? #(mod % 8) +) 3 5 7 9)))
    (is (= "HELLO" ((__ #(.toUpperCase %) #(apply str %) take) 5 "hello world")))))

(deftest
  ^{::fc/problems 59}
  juxtaposition
  "Take a set of functions and return a new function that takes a
  variable number of arguments and returns a sequence containing the
  result of applying each function left-to-right to the argument list.
  Special Restrictions: juxt"
  (let [__ (fn juxt* [& fs]
             (fn [& args]
               (map #(apply % args) fs)))]
    (is (= [21 6 1] ((__ + max min) 2 3 5 1 6 4)))
    (is (= ["HELLO" 5] ((__ #(.toUpperCase %) count) "hello")))
    (is (= [2 6 4] ((__ :a :c :b) {:a 2, :b 4, :c 6, :d 8 :e 10})))))

#_(deftest
    ^{::fc/problems             60
      ::fc/difficulty           :medium
      ::fc/topics               [:seqs :core-functions]
      ::fc/special-restrictions ['reductions]}
    sequence-reductions
    "Write a function which behaves like reduce, but returns each
  intermediate value of the reduction. Your function must accept
  either two or three arguments, and the return sequence must be
  lazy."
    (let [__ identity]
      (is (= (take 5 (__ + (range))) [0 1 3 6 10]))
      (is (= (__ conj [1] [2 3 4]) [[1] [1 2] [1 2 3] [1 2 3 4]]))
      (is (= (last (__ * 2 [3 4 5])) (reduce * 2 [3 4 5]) 120))))

(deftest
  ^{::fc/problems 61}
  map-construction
  "Write a function which takes a vector of keys and a vector of values
  and constructs a map from them.
  Special Restrictions: zipmap"
  (let [__ (fn [ks vs]
             (into {} (map (comp vec list) ks vs)))]
    (is (= (__ [:a :b :c] [1 2 3]) {:a 1, :b 2, :c 3}))
    (is (= (__ [1 2 3 4] ["one" "two" "three"]) {1 "one", 2 "two", 3 "three"}))
    (is (= (__ [:foo :bar] ["foo" "bar" "baz"]) {:foo "foo", :bar "bar"}))    ))

#_(deftest
    ^{::fc/problems             62
      ::fc/difficulty           :easy
      ::fc/topics               [:seqs :core-functions]
      ::fc/special-restrictions ['iterate]}
    re-implement-iterate
    "Given a side-effect free function f and an initial value x write a
  function which returns an infinite lazy sequence of x, (f x), (f (f
  x)), (f (f (f x))), etc."
    (let [__ identity]
      (is (= (take 5 (__ #(* 2 %) 1)) [1 2 4 8 16]))
      (is (= (take 100 (__ inc 0)) (take 100 (range))))
      (is (= (take 9 (__ #(inc (mod % 3)) 1)) (take 9 (cycle [1 2 3]))))))

(deftest
  ^{::fc/problems 63}
  group-a-sequence
  "Given a function f and a sequence s, write a function which
  returns a map. The keys should be the values of f applied to each
  item in s. The value at each key should be a vector of corresponding
  items in the order they appear in s."
  (let [__ (fn [f xs]
             (reduce
               (fn [memo el]
                 (let [v (f el)]
                   (if (get memo v)
                     (update-in memo [v] conj el)
                     (assoc memo v [el]))))
               {} xs))]
    (is (= (__ #(> % 5) [1 3 6 8]) {false [1 3], true [6 8]}))
    (is (= (__ #(apply / %) [[1 2] [2 4] [4 6] [3 6]])
           {1/2 [[1 2] [2 4] [3 6]], 2/3 [[4 6]]}))
    (is (= (__ count [[1] [1 2] [3] [1 2 3] [2 3]])
           {1 [[1] [3]], 2 [[1 2] [2 3]], 3 [[1 2 3]]}))))

(deftest
  ^{::fc/problems 64}
  intro-to-reduce
  "Reduce takes a 2 argument function and an optional starting value.
  It then applies the function to the first 2 items in the sequence
  (or the starting value and the first element of the sequence). In the
  next iteration the function will be called on the previous return value
  and the next item from the sequence, thus reducing the entire collection
  to one value. Don't worry, it's not as complicated as it sounds."
  (let [__ +]
    (is (= 15 (reduce __ [1 2 3 4 5])))
    (is (=  0 (reduce __ [])))
    (is (=  6 (reduce __ 1 [2 3])))))

(deftest
  ^{::fc/problems 65}
  black-box-testing
  "Clojure has many sequence types, which act in subtly different ways.
  The core functions typically convert them into a uniform \"sequence\"
  type and work with them that way, but it can be important to understand
  the behavioral and performance differences so that you know which kind
  is appropriate for your application.

  Write a function which takes a collection and returns one of :map, :set,
  :list, or :vector - describing the type of collection it was given. You
  won't be allowed to inspect their class or use the built-in predicates like
  list? - the point is to poke at them and understand their behavior.

  Special Restrictions: class type Class vector? sequential? list? seq?
                        map? set? instance? getClass"
  (let [__ (fn [bb]
             (let [mapped (map identity bb)
                   g      (gensym)
                   h      (gensym)]
               (if (= mapped bb)
                 (if (= h (-> (conj bb g) (conj h) first))
                   :list
                   :vector)
                 (if (= h (-> (conj bb {g h}) (get g)))
                   :map
                   :set))))]
    (is (= :map (__ {:a 1, :b 2})))
    (is (= :list (__ (range (rand-int 20)))))
    (is (= :vector (__ [1 2 3 4 5 6])))
    (is (= :set (__ #{10 (rand-int 5)})))
    (is (= [:map :set :vector :list] (map __ [{} #{} [] ()])))))

(deftest
  ^{::fc/problems 66}
  greatest-common-divisor
  "Given two integers, write a function which returns the greatest common divisor."
  (let [__ fc/brute-force-gcd]
    (is (= (__ 2 4) 2))
    (is (= (__ 10 5) 5))
    (is (= (__ 5 7) 1))
    (is (= (__ 1023 858) 33))))

(deftest
  ^{::fc/problems 67}
  prime-numbers
  "Write a function which returns the first x number of prime numbers."
  (let [__ fc/primes]
    (is (= (__ 2) [2 3]))
    (is (= (__ 5) [2 3 5 7 11]))
    (is (= (last (__ 100)) 541))))

(deftest
  ^{::fc/problems 68}
  recurring-theme
  "Clojure only has one non-stack-consuming looping construct: recur.
  Either a function or a loop can be used as the recursion point.
  Either way, recur rebinds the bindings of the recursion point to the
  values it is passed. Recur must be called from the tail-position,
  and calling it elsewhere will result in an error."
  (let [__ [7 6 5 4 3]]
    (is (= __
           (loop [x      5
                  result []]
             (if (> x 0)
               (recur (dec x) (conj result (+ 2 x)))
               result))))))

(deftest
  ^{::fc/problems 69}
  merge-with-a-function
  "Write a function which takes a function f and a variable number of maps.
  Your function should return a map that consists of the rest of the maps
  conj-ed onto the first. If a key occurs in more than one map, the mapping(s)
  from the latter (left-to-right) should be combined with the mapping in the
  result by calling (f val-in-result val-in-latter)
  Special Restrictions: merge-with"
  (let [__ fc/merge-with']
    (is (= (__ * {:a 2, :b 3, :c 4} {:a 2} {:b 2} {:c 5})
           {:a 4, :b 6, :c 20}))
    (is (= (__ - {1 10, 2 20} {1 3, 2 10, 3 15})
           {1 7, 2 10, 3 15}))
    (is (= (__ concat {:a [3], :b [6]} {:a [4 5], :c [8 9]} {:b [7]})
           {:a [3 4 5], :b [6 7], :c [8 9]}))))


(deftest
  ^{::fc/problems 70}
  word-sorting
  "Write a function that splits a sentence up into a sorted
  list of words. Capitalization should not affect sort order
  and punctuation should be ignored."
  (let [__ (fn [sent]
             (->> sent
                  (re-seq #"\w+")
                  (sort-by clojure.string/lower-case)))]
    (is (= (__  "Have a nice day.")
           ["a" "day" "Have" "nice"]))
    (is (= (__  "Clojure is a fun language!")
           ["a" "Clojure" "fun" "is" "language"]))
    (is (= (__  "Fools fall for foolish follies.")
           ["fall" "follies" "foolish" "Fools" "for"]))))

(deftest
  ^{::fc/problems 71}
  rearranging-code-colon->
  "The -> macro threads an expression x through a variable number of
  forms. First, x is inserted as the second item in the first form,
  making a list of it if it is not a list already. Then the first form
  is inserted as the second item in the second form, making a list of
  that form if necessary. This process continues for all the forms.
  Using -> can sometimes make your code more readable."
  (let [__ last]
    (is (= (__ (sort (rest (reverse [2 5 4 1 3 6]))))
           (-> [2 5 4 1 3 6] (reverse) (rest) (sort) (__))
           5))))

(deftest
  ^{::fc/problems 72}
  rearranging-code-colon->>
  "The ->> macro threads an expression x through a variable number of
  forms. First, x is inserted as the last item in the first form, making
  a list of it if it is not a list already. Then the first form is
  inserted as the last item in the second form, making a list of that form
  if necessary. This process continues for all the forms. Using ->> can
  sometimes make your code more readable."
  (let [__ #(apply + %)]
    (is (= (__ (map inc (take 3 (drop 2 [2 5 4 1 3 6]))))
           (->> [2 5 4 1 3 6] (drop 2) (take 3) (map inc) (__))
           11))))

(deftest
  ^{::fc/problems 73}
  analyze-a-tic-tac-toe-board
  "A tic-tac-toe board is represented by a two dimensional vector.
  X is represented by :x, O is represented by :o, and empty is
  represented by :e. A player wins by placing three Xs or three Os
  in a horizontal, vertical, or diagonal row. Write a function which
  analyzes a tic-tac-toe board and returns :x if X has won, :o if O
  has won, and nil if neither player has won."
  (let [__ fc/tic-tac-toe-win?]
    (is (= nil (__ [[:e :e :e]
                    [:e :e :e]
                    [:e :e :e]])))
    (is (= :x (__ [[:x :e :o]
                   [:x :e :e]
                   [:x :e :o]])))
    (is (= :o (__ [[:e :x :e]
                   [:o :o :o]
                   [:x :e :x]])))
    (is (= nil (__ [[:x :e :o]
                    [:x :x :e]
                    [:o :x :o]])))
    (is (= :x (__ [[:x :e :e]
                   [:o :x :e]
                   [:o :e :x]])))
    (is (= :o (__ [[:x :e :o]
                   [:x :o :e]
                   [:o :e :x]])))
    (is (= nil (__ [[:x :o :x]
                    [:x :o :x]
                    [:o :x :o]])))))

(deftest
  ^{::fc/problem 74}
  filter-perfect-squares
  "Given a string of comma separated integers, write a function
  which returns a new comma separated string that only contains
  the numbers which are perfect squares."
  (let [__ fc/filter-perfect-squares]
    (is (= (__ "4,5,6,7,8,9") "4,9"))
    (is (= (__ "15,16,25,36,37") "16,25,36"))))

(deftest
  ^{::fc/problem    75
    ::fc/difficulty :medium}
  eulers-totient-function
  "Two numbers are coprime if their greatest common divisor equals 1.
  Euler's totient function f(x) is defined as the number of positive
  integers less than x which are coprime to x. The special case f(1)
  equals 1. Write a function which calculates Euler's totient function."
  (let [__ fc/totient]
    (is (= (__ 1) 1))
    (is (= (__ 10) (count '(1 3 7 9)) 4))
    (is (= (__ 40) 16))
    (is (= (__ 99) 60))))

(deftest
  ^{::fc/problem    76
    ::fc/difficulty :medium
    ::fc/topcs      [:recursion]}
  intro-to-trampoline
  "The trampoline function takes a function f and a variable number of
  parameters. Trampoline calls f with any parameters that were
  supplied. If f returns a function, trampoline calls that function
  with no arguments. This is repeated, until the return value is not a
  function, and then trampoline returns that non-function value. This
  is useful for implementing mutually recursive algorithms in a way
  that won't consume the stack."
  (let [__ [1 3 5 7 9 11]]
    (= __
       (letfn
           [(foo [x y] #(bar (conj x y) y))
            (bar [x y] (if (> (last x) 10)
                         x
                         #(foo x (+ 2 y))))]
         (trampoline foo [] 1)))))

(deftest
  ^{::fc/problem    77
    ::fc/difficulty :medium}
  anagram-finder
  "Write a function which finds all the anagrams in a vector of words.
  A word x is an anagram of word y if all the letters in x can be
  rearranged in a different order to form y. Your function should
  return a set of sets, where each sub-set is a group of words which
  are anagrams of each other. Each sub-set should have at least two
  words. Words without any anagrams should not be included in the
  result."
  (let [__ fc/anagrams]
    (is (= (__ ["meat" "mat" "team" "mate" "eat"])
           #{#{"meat" "team" "mate"}}))
    (is (= (__ ["veer" "lake" "item" "kale" "mite" "ever"])
           #{#{"veer" "ever"} #{"lake" "kale"} #{"mite" "item"}}))))

(deftest
  ^{::fc/problem              78
    ::fc/difficulty           :medium
    ::fc/topics               [:core-functions]
    ::fc/special-restrictions ['trampoline]}
  reimplement-trampoline
  "Reimplement the function described in \"Intro to Trampoline\"."
  (let [__ fc/trampoline']
    (is (= (letfn [(triple [x] #(sub-two (* 3 x)))
                   (sub-two [x] #(stop?(- x 2)))
                   (stop? [x] (if (> x 50) x #(triple x)))]
             (__ triple 2))
           82))
    (is (= (letfn [(my-even? [x] (if (zero? x) true #(my-odd? (dec x))))
                   (my-odd? [x] (if (zero? x) false #(my-even? (dec x))))]
             (map (partial __ my-even?) (range 6)))
           [true false true false true false]))))

#_(deftest
    ^{::fc/problem    79
      ::fc/difficulty :hard
      ::fc/topcs      [:graph-theory]}
    triangle-minimal-path
    "Write a function which calculates the sum of the minimal path
  through a triangle. The triangle is represented as a collection of
  vectors. The path should start at the top of the triangle and move
  to an adjacent number on the next row until the bottom of the
  triangle is reached."
    (let [__ fc/triangle-minimal-path]
      (is (= 7 (__ '([1]
                     [2 4]
                     [5 1 4]
                     [2 3 4 5]))))        ; 1->2->1->3
      (is (= 20 (__ '([3]
                      [2 4]
                      [1 9 3]
                      [9 9 2 4]
                      [4 6 6 7 8]
                      [5 7 3 5 1 4])))))) ; 3->4->3->2->7->1

(deftest
  ^{::fc/problem    80
    ::fc/difficulty :medium}
  perfect-numbers
  "A number is perfect if the sum of its divisors equal the number
  itself. 6 is a perfect number because 1+2+3=6. Write a function
  which returns true for perfect numbers and false otherwise."
  (let [__ fc/perfect?]
    (is (= (__ 6) true))
    (is (= (__ 7) false))
    (is (= (__ 496) true))
    (is (= (__ 500) false))
    (is (= (__ 8128) true))))
