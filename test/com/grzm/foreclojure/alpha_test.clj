(ns com.grzm.foreclojure.alpha-test
  (:require [clojure.test :refer :all]
            [com.grzm.foreclojure.alpha :as fc]))

(deftest
  ^{::fc/problem    1
    ::fc/difficulty :elementary}
  nothing-but-the-truth
  "This is a clojure form. Enter a value which will make the form
  evaluate to true. Don't over think it! If you are confused, see
  the getting started page. Hint: true is equal to true."
  (let [__ true]
    (is (= __ true))))

(deftest
  ^{::fc/problem    2
    ::fc/difficulty :elementary}
  simple-math
  "If you are not familiar with polish notation, simple arithmetic
  might seem confusing.

  Note: Enter only enough to fill in the blank (in this case, a single
  number) - do not retype the whole problem."
  (let [__ 4]
    (is (= (- 10 (* 2 3)) __))))

(deftest
  ^{::fc/problem    3
    ::fc/difficulty :elementary}
  intro-to-strings
  "Clojure strings are Java strings. This means that you can use any
  of the Java string methods on Clojure strings."
  (let [__ "HELLO WORLD"]
    (is (= __ (.toUpperCase "hello world")))))

(deftest
  ^{::fc/problem    4
    ::fc/difficulty :elementary}
  intro-to-lists
  "Lists can be constructed with either a function or a quoted form."
  (is (= (list :a :b :c) '(:a :b :c))))

(deftest
  ^{::fc/problem    5
    ::fc/difficulty :elementary}
  lists-conj
  "When operating on a list, the conj function will return a new list
  with one or more items \"added\" to the front.

  Note that there are two test cases, but you are expected to supply
  only one answer, which will cause all the tests to pass."
  (let [__ '(1 2 3 4)]
    (is (= __ (conj '(2 3 4) 1)))
    (is (= __ (conj '(3 4) 2 1)))))

(deftest
  ^{::fc/problem    6
    ::fc/difficulty :elementary}
  intro-to-vectors
  "Vectors can be constructed several ways. You can compare them with lists.

  Note: the brackets [] surrounding the blanks __ are part of the test case."
  (is (= [:a :b :c] (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c))))

(deftest
  ^{::fc/problem    7
    ::fc/difficulty :elementary}
  vectors-conj
  "When operating on a Vector, the conj function will return a new vector with
  one or more items \"added\" to the end."
  (let [__ [1 2 3 4]]
    (is (= __ (conj [1 2 3] 4)))
    (is (= __ (conj [1 2] 3 4)))))

(deftest
  ^{::fc/problem    8
    ::fc/difficulty :elementary}
  intro-to-sets
  "Sets are collections of unique values."
  (let [__ #{:a :b :c :d}]
    (is (= __ (set '(:a :a :b :c :c :c :c :d :d))))
    (is (= __ (clojure.set/union #{:a :b :c} #{:b :c :d})))))

(deftest
  ^{::fc/problem    9
    ::fc/difficulty :elementary}
  sets-conj
  "When operating on a set, the conj function returns a new set with one
  or more keys \"added\"."
  (let [__ 2]
    (is (= #{1 2 3 4} (conj #{1 4 3} __)))))

(deftest
  ^{::fc/problem    10
    ::fc/difficulty :elementary}
  intro-to-maps
  "Maps store key-value pairs. Both maps and keywords can be used as
  lookup functions. Commas can be used to make maps more readable,
  but they are not required."
  (let [__ 20]
    (is (= __ ((hash-map :a 10, :b 20, :c 30) :b)))
    (is (= __ (:b {:a 10, :b 20, :c 30})))))

(deftest
  ^{::fc/problem    11
    ::fc/difficulty :elementary}
  maps-conj
  "When operating on a map, the conj function returns a new map with one
  or more key-value pairs \"added\"."
  (let [__ [:b 2]]
    (= {:a 1, :b 2, :c 3} (conj {:a 1} __ [:c 3]))))

(deftest
  ^{::fc/problem    12
    ::fc/difficulty :elementary}
  intro-to-sequences
  "All Clojure collections support sequencing. You can operate on sequences
  with functions like first, second, and last."
  (let [__ 3]
    (= __ (first '(3 2 1)))
    (= __ (second [2 3 4]))
    (= __ (last (list 1 2 3)))))

(deftest
  ^{::fc/problem    13
    ::fc/difficulty :elementary}
  sequences-rest
  "The rest function will return all the items of a sequence except the first."
  (let [__ '(20 30 40)]
    (is (= __ (rest [10 20 30 40])))))

(deftest
  ^{::fc/problem    14
    ::fc/difficulty :elementary}
  intro-to-functions
  "Clojure has many different ways to create functions."
  (let [__ 8]
    (is (= __ ((fn add-five [x] (+ x 5)) 3)))
    (is (= __ ((fn [x] (+ x 5)) 3)))
    (is (= __ (#(+ % 5) 3)))
    (is (= __ ((partial + 5) 3)))))

(deftest
  ^{::fc/problem    15
    ::fc/difficulty :elementary}
  double-down
  "Write a function which doubles a number."
  (let [__ (partial * 2)]
    (is (= (__ 2) 4))
    (is (= (__ 3) 6))
    (is (= (__ 11) 22))
    (is (= (__ 7) 14))))

(deftest
  ^{::fc/problem    16
    ::fc/difficulty :elementary}
  hello-world
  "Write a function which returns a personalized greeting."
  (let [__ (partial format "Hello, %s!")]
    (is (= (__ "Dave") "Hello, Dave!"))
    (is (= (__ "Jenn") "Hello, Jenn!"))
    (is (= (__ "Rhea") "Hello, Rhea!"))))

(deftest
  ^{::fc/problem    17
    ::fc/difficulty :elementary}
  sequences-map
  "The map function takes two arguments: a function (f) and a
  sequence (s). Map returns a new sequence consisting of the
  result of applying f to each item of s. Do not confuse the
   map function with the map data structure."
  (let [__ (list 6 7 8)]
    (is (= __ (map #(+ % 5) '(1 2 3))))))

(deftest
  ^{::fc/problem    18
    ::fc/difficulty :elementary}
  sequences-filter
  "The filter function takes two arguments: a predicate function
  (f) and a sequence (s). Filter returns a new sequence consisting
  of all the items of s for which (f item) returns true."
  (let [__ '(6 7)]
    (is (= __ (filter #(> % 5) '(3 4 5 6 7))))))

(deftest
  ^{::fc/problem              19
    ::fc/difficulty           :easy
    ::fc/special-restrictions #{'last}}
  last-element
  "Write a function which returns the last element in a sequence."
  (let [__ (comp first reverse)]
    (is (= (__ [1 2 3 4 5]) 5))
    (is (= (__ '(5 4 3)) 3))
    (is (= (__ ["b" "c" "d"]) "d"))))

(deftest
  ^{::fc/problem    20
    ::fc/difficulty :easy}
  penultimate-element
  "Write a function which returns the second to last element
  from a sequence."
  (let [__ (comp second reverse)]
    (is (= (__ (list 1 2 3 4 5)) 4))
    (is (= (__ ["a" "b" "c"]) "b"))
    (is (= (__ [[1 2] [3 4]]) [1 2]))))

(deftest
  ^{::fc/problem    21
    ::fc/difficulty :easy}
  nth-element
  (let [__ fc/enth]
    (is (= (__ '(4 5 6 7) 2) 6))
    (is (= (__ [:a :b :c] 0) :a))
    (is (= (__ [1 2 3 4] 1) 2))
    (is (= (__ '([1 2] [3 4] [5 6]) 2) [5 6]))))

(deftest
  ^{::fc/problem    22
    ::fc/difficulty :easy}
  count-a-sequence
  (let [__ fc/cownt]
    (is (= (__ '(1 2 3 3 1)) 5))
    (is (= (__ "Hello World") 11))
    (is (= (__ [[1 2] [3 4] [5 6]]) 3))
    (is (= (__ '(13)) 1))
    (is (= (__ '(:a :b :c)) 3))))

(deftest
  ^{::fc/problem    23
    ::fc/difficulty :easy}
  reverse-a-sequence
  (let [__ fc/revers]
    (is (= (__ [1 2 3 4 5]) [5 4 3 2 1]))
    (is (= (__ (sorted-set 5 7 2 7)) '(7 5 2)))
    (is (= (__ [[1 2] [3 4] [5 6]]) [[5 6] [3 4] [1 2]]))))

(deftest
  ^{::fc/problem    24
    ::fc/difficulty :easy}
  sum-it-all-up
  (let [__ fc/sum]
    (is (= (__ [1 2 3]) 6))
    (is (= (__ (list 0 -2 5 5)) 8))
    (is (= (__ #{4 2 1}) 7))
    (is (= (__ '(0 0 -1)) -1))
    (is (= (__ '(1 10 3)) 14))))

(deftest
  ^{::fc/problem    25
    ::fc/difficulty :easy}
  find-the-odd-numbers
  (let [__ fc/filter-odd]
    (is (= (__ #{1 2 3 4 5}) '(1 3 5)))
    (is (= (__ [4 2 1 6]) '(1)))
    (is (= (__ [2 2 4 6]) '()))
    (is (= (__ [1 1 1 3]) '(1 1 1 3)))))

(deftest
  ^{::fc/problem    26
    ::fc/difficulty :easy}
  fibonacci-sequence
  (let [__ fc/fibonacci-seq]
    (is (= (__ 3) '(1 1 2)))
    (is (= (__ 6) '(1 1 2 3 5 8)))
    (is (= (__ 8) '(1 1 2 3 5 8 13 21)))))

(deftest
  ^{::fc/problem    27
    ::fc/difficulty :easy}
  palindrome-detector
  (let [__ fc/palindrome?]
    (is (false? (__ '(1 2 3 4 5))))
    (is (true? (__ "racecar")))
    (is (true? (__ [:foo :bar :foo])))
    (is (true? (__ '(1 1 3 3 1 1))))
    (is (false? (__ '(:a :b :c))))))

(deftest
  ^{::fc/problem    28
    ::fc/difficulty :easy}
  flatten-a-sequence
  (let [__ fc/flatten']
    (is (= (__ '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6)))
    (is (= (__ ["a" ["b"] "c"]) '("a" "b" "c")))
    (is (= (__ '((((:a))))) '(:a)))))

(deftest
  ^{::fc/problem    29
    ::fc/difficulty :easy}
  get-the-caps
  (let [__ fc/caps]
    (is (= (__ "HeLlO, WoRlD!") "HLOWRD"))
    (is (empty? (__ "nothing")))
    (is (= (__ "$#A(*&987Zf") "AZ"))))

(deftest
  ^{::fc/problem    30
    ::fc/difficulty :easy}
  compress-a-sequence
  (let [__ fc/dedupe']
    (is (= (apply str (__ "Leeeeeerrroyyy")) "Leroy"))
    (is (= (__ [1 1 2 3 3 2 2 3]) '(1 2 3 2 3)))
    (is (= (__ [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2])))))

(deftest
  ^{::fc/problem    31
    ::fc/difficulty :easy}
  pack-a-sequence
  (let [__ fc/pack]
    (is (= (__ [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3))))
    (is (= (__ [:a :a :b :b :c]) '((:a :a) (:b :b) (:c))))
    (is (= (__ [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4]))))))

(deftest
  ^{::fc/problem    32
    ::fc/difficulty :easy}
  duplicate-a-sequence
  (let [__ fc/duplicate]
    (is (= (__ [1 2 3]) '(1 1 2 2 3 3)))
    (is (= (__ [:a :a :b :b]) '(:a :a :a :a :b :b :b :b)))
    (is (= (__ [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4])))
    (is (= (__ [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4])))))

(deftest
  ^{::fc/problem    33
    ::fc/difficulty :easy}
  replicate-a-sequence
  (let [__ fc/replicate']
    (is (= (__ [1 2 3] 2) '(1 1 2 2 3 3)))
    (is (= (__ [:a :b] 4) '(:a :a :a :a :b :b :b :b)))
    (is (= (__ [4 5 6] 1) '(4 5 6)))
    (is (= (__ [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4])))
    (is (= (__ [44 33] 2) [44 44 33 33]))))

(deftest
  ^{::fc/problem    34
    ::fc/difficulty :easy}
  implement-range
  (let [__ fc/range']
    (is (= (__ 1 4) '(1 2 3)))
    (is (= (__ -2 2) '(-2 -1 0 1)))
    (is (= (__ 5 8) '(5 6 7)))))

(deftest
  ^{::fc/problem    35
    ::fc/difficulty :elementary}
  local-bindings
  (let [__ 7]
    (is (= __ (let [x 5] (+ 2 x))))
    (is (= __ (let [x 3, y 10] (- y x))))
    (is (= __ (let [x 21] (let [y 3] (/ x y)))))))

(deftest
  ^{::fc/problem    36
    ::fc/difficulty :elementary}
  let-it-be
  (let [x 7
        y 3
        z 1]
    (is (= 10 (+ x y)))
    (is (= 4 (+ y z)))
    (is (= 1 z))))

(deftest
  ^{::fc/problem    37
    ::fc/difficulty :elementary}
  regular-expressions
  (let [__ "ABC"]
    (is (= __ (apply str (re-seq #"[A-Z]+" "bA1B3Ce "))))))

(deftest
  ^{::fc/problem    38
    ::fc/difficulty :easy}
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
  ^{::fc/problem    39
    ::fc/difficulty :easy}
  interleave-two-seqs
  "Write a function which takes two sequences and returns the first item
  from each, then the second item from each, then the third, etc."
  (let [__ fc/interleave']
    (is (= (__ [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c)))
    (is (= (__ [1 2] [3 4 5 6]) '(1 3 2 4)))
    (is (= (__ [1 2 3 4] [5]) [1 5]))
    (is (= (__ [30 20] [25 15]) [30 25 20 15]))))

(deftest
  ^{::fc/problem              40
    ::fc/difficulty           :easy
    ::fc/special-restrictions #{'interpose}}
  interpose-a-seq
  "Write a function which separates the items of a sequence by an arbitrary value."
  (let [__ fc/interpose']
    (is (= (__ 0 [1 2 3]) [1 0 2 0 3]))
    (is (= (apply str (__ ", " ["one" "two" "three"])) "one, two, three"))
    (is (= (__ :z [:a :b :c :d]) [:a :z :b :z :c :z :d]))))

(deftest
  ^{::fc/problem    41
    ::fc/difficulty :easy}
  drop-every-nth-item
  "Write a function which drops every Nth item from a sequence."
  (let [__ fc/drop-nth]
    (is (= (__ [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8]))
    (is (= (__ [:a :b :c :d :e :f] 2) [:a :c :e]))
    (is (= (__ [1 2 3 4 5 6] 4) [1 2 3 5 6]))))

(deftest
  ^{::fc/problem    42
    ::fc/difficulty :easy}
  factorial-fun
  "Write a function which calculates factorials."
  (let [__ fc/factorial']
    (is (= (__ 1) 1))
    (is (= (__ 3) 6))
    (is (= (__ 5) 120))
    (is (= (__ 8) 40320))))

(deftest
  ^{::fc/problem    43
    ::fc/difficulty :medium}
  reverse-interleave
  (let [__ fc/reverse-interleave]
    (is (= (__ [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6))))
    (is (= (__ (range 9) 3) '((0 3 6) (1 4 7) (2 5 8))))
    (is (= (__ (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9))))))

(deftest
  ^{::fc/problem    44
    ::fc/difficulty :medium}
  rotate-sequence
  "Write a function which can rotate a sequence in either direction."
  (let [__ fc/rotate']
    (is (= (__ 2 [1 2 3 4 5]) '(3 4 5 1 2)))
    (is (= (__ -2 [1 2 3 4 5]) '(4 5 1 2 3)))
    (is (= (__ 6 [1 2 3 4 5]) '(2 3 4 5 1)))
    (is (= (__ 1 '(:a :b :c)) '(:b :c :a)))
    (is (= (__ -4 '(:a :b :c)) '(:c :a :b)))))

(deftest
  ^{::fc/problem    45
    ::fc/difficulty :easy}
  intro-to-iterate
  "The iterate function can be used to produce an infinite lazy sequence."
  (let [__ '(1 4 7 10 13)]
    (is (= __ (take 5 (iterate #(+ 3 %) 1))))))

(deftest
  ^{::fc/problem    46
    ::fc/difficulty :medium}
  flipping-out
  "Write a higher-order function which flips the order of the
   arguments of an input function."
  (let [__ (fn [f] (fn [a b] (f b a)))]
    (is (= 3 ((__ nth) 2 [1 2 3 4 5])))
    (is (= true ((__ >) 7 8)))
    (is (= 4 ((__ quot) 2 8)))
    (is (= [1 2 3] ((__ take) [1 2 3 4 5] 3)))))

(deftest
  ^{::fc/problem    47
    ::fc/difficulty :easy}
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
  ^{::fc/problem    48
    ::fc/difficulty :easy}
  intro-to-some
  "The some function takes a predicate function and a collection.
  It returns the first logical true value of (predicate x) where x
  is an item in the collection."
  (let [__ 6]
    (is (= __ (some #{2 7 6} [5 6 7 8])))
    (is (= __ (some #(when (even? %) %) [5 6 7 8])))))

(deftest
  ^{::fc/problem    49
    ::fc/difficulty :easy}
  split-a-sequence
  (let [__ (fn [n xs] [(take n xs) (drop n xs)])]
    (is (= (__ 3 [1 2 3 4 5 6]) [[1 2 3] [4 5 6]]))
    (is (= (__ 1 [:a :b :c :d]) [[:a] [:b :c :d]]))
    (is (= (__ 2 [[1 2] [3 4] [5 6]]) [[[1 2] [3 4]] [[5 6]]]))))

(deftest
  ^{::fc/problem    50
    ::fc/difficulty :medium}
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
  ^{::fc/problem    51
    ::fc/difficulty :easy}
  advanced-destructuring
  "Here is an example of some more sophisticated destructuring."
  (let [__ [1 2 3 4 5]]
    (is (= [1 2 [3 4 5] [1 2 3 4 5]]
           (let [[a b & c :as d] __]
             [a b c d])))))

(deftest
  ^{::fc/problem    52
    ::fc/difficulty :elementary}
  intro-to-destructuring
  "Let bindings and function parameter lists support destructuring."
  (is (= [2 4]
         (let [[a b c d e] [0 1 2 3 4]
               __          [c e]]
           __))))

(deftest
  ^{::fc/problem    53
    ::fc/difficulty :hard}
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
  ^{::fc/problem              54
    ::fc/difficulty           :medium
    ::fc/special-restrictions #{'partition 'partition-all}}
  partition-a-sequence
  "Write a function which returns a sequence of lists of x items
  each. Lists of less than x items should not be returned."
  (let [__ fc/partition']
    (is (= (__ 3 (range 9)) '((0 1 2) (3 4 5) (6 7 8))))
    (is (= (__ 2 (range 8)) '((0 1) (2 3) (4 5) (6 7))))
    (is (= (__ 3 (range 8)) '((0 1 2) (3 4 5))))))

(deftest
  ^{::fc/problem    55
    ::fc/difficulty :medium}
  count-occurrences
  "Write a function which returns a map containing the
    number of occurences of each distinct item in a sequence."
  (let [__ fc/count-occurrences]
    (is (= (__ [1 1 2 3 2 1 1]) {1 4, 2 2, 3 1}))
    (is (= (__ [:b :a :b :a :b]) {:a 2, :b 3}))
    (is (= (__ '([1 2] [1 3] [1 3])) {[1 2] 1, [1 3] 2}))))

(deftest
  ^{::fc/problem    56
    ::fc/difficulty :medium}
  find-distinct-items
  "Write a function which removes the duplicates from
  a sequence. Order of the items must be maintained."
  (let [__ fc/find-distinct]
    (is (= (__ [1 2 1 3 1 2 4]) [1 2 3 4]))
    (is (= (__ [:a :a :b :b :c :c]) [:a :b :c]))
    (is (= (__ '([2 4] [1 2] [1 3] [1 3])) '([2 4] [1 2] [1 3])))
    (is (= (__ (range 50)) (range 50)))))

(deftest
  ^{::fc/problem    57
    ::fc/difficulty :elementary}
  simple-recursion
  "A recursive function is a function which calls itself. This is one
  of the fundamental techniques used in functional programming."
  (let [__ '(5 4 3 2 1)]
    (is (= __ ((fn foo [x] (when (> x 0) (conj (foo (dec x)) x))) 5)))))

(deftest
  ^{::fc/problem              58
    ::fc/difficulty           :medium
    ::fc/special-restrictions #{'comp}}
  function-composition
  "Write a function which allows you to create function compositions.
  The parameter list should take a variable number of functions, and
  create a function that applies them from right-to-left."
  (let [__ fc/comp']
    (is (= [3 2 1] ((__ rest reverse) [1 2 3 4])))
    (is (= 5 ((__ (partial + 3) second) [1 2 3 4])))
    (is (= true ((__ zero? #(mod % 8) +) 3 5 7 9)))
    (is (= "HELLO" ((__ #(.toUpperCase %) #(apply str %) take) 5 "hello world")))))

(deftest
  ^{::fc/problem              59
    ::fc/difficulty           :medium
    ::fc/special-restrictions #{'juxt}}
  juxtaposition
  "Take a set of functions and return a new function that takes a
  variable number of arguments and returns a sequence containing the
  result of applying each function left-to-right to the argument list."
  (let [__ (fn juxt* [& fs]
             (fn [& args]
               (map #(apply % args) fs)))]
    (is (= [21 6 1] ((__ + max min) 2 3 5 1 6 4)))
    (is (= ["HELLO" 5] ((__ #(.toUpperCase %) count) "hello")))
    (is (= [2 6 4] ((__ :a :c :b) {:a 2, :b 4, :c 6, :d 8 :e 10})))))

#_
(deftest
  ^{::fc/problem              60
    ::fc/difficulty           :medium
    ::fc/topics               #{:seqs :core-functions}
    ::fc/special-restrictions #{'reductions}}
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
  ^{::fc/problem              61
    ::fc/difficulty           :easy
    ::fc/special-restrictions #{'zipmap}}
  map-construction
  "Write a function which takes a vector of keys and a vector of values
  and constructs a map from them."
  (let [__ (fn [ks vs]
             (into {} (map (comp vec list) ks vs)))]
    (is (= (__ [:a :b :c] [1 2 3]) {:a 1, :b 2, :c 3}))
    (is (= (__ [1 2 3 4] ["one" "two" "three"]) {1 "one", 2 "two", 3 "three"}))
    (is (= (__ [:foo :bar] ["foo" "bar" "baz"]) {:foo "foo", :bar "bar"}))    ))

(deftest
  ^{::fc/problem              62
    ::fc/difficulty           :easy
    ::fc/topics               #{:seqs :core-functions}
    ::fc/special-restrictions #{'iterate}}
  re-implement-iterate
  "Given a side-effect free function f and an initial value x write a
  function which returns an infinite lazy sequence of x, (f x), (f (f
  x)), (f (f (f x))), etc."
  (let [__ (fn iterate' [f init]
             (cons init
                   (lazy-seq (iterate' f (f init)))))]
    (is (= (take 5 (__ #(* 2 %) 1)) [1 2 4 8 16]))
    (is (= (take 100 (__ inc 0)) (take 100 (range))))
    (is (= (take 9 (__ #(inc (mod % 3)) 1)) (take 9 (cycle [1 2 3]))))))

(deftest
  ^{::fc/problem    63
    ::fc/difficulty :easy}
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
  ^{::fc/problem    64
    ::fc/difficulty :elementary}
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
  ^{::fc/problem              65
    ::fc/difficulty           :medium
    ::fc/special-restrictions #{'class 'type 'Class
                                'vector? 'sequential? 'list?
                                'seq? 'map? 'set? 'instance? 'getClass?}}
  black-box-testing
  "Clojure has many sequence types, which act in subtly different ways.
  The core functions typically convert them into a uniform \"sequence\"
  type and work with them that way, but it can be important to understand
  the behavioral and performance differences so that you know which kind
  is appropriate for your application.

  Write a function which takes a collection and returns one of :map, :set,
  :list, or :vector - describing the type of collection it was given. You
  won't be allowed to inspect their class or use the built-in predicates like
  list? - the point is to poke at them and understand their behavior."
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
  ^{::fc/problem    66
    ::fc/difficulty :easy}
  greatest-common-divisor
  "Given two integers, write a function which returns the greatest common divisor."
  (let [__ fc/brute-force-gcd]
    (is (= (__ 2 4) 2))
    (is (= (__ 10 5) 5))
    (is (= (__ 5 7) 1))
    (is (= (__ 1023 858) 33))))

(deftest
  ^{::fc/problem    67
    ::fc/difficulty :medium}
  prime-numbers
  "Write a function which returns the first x number of prime numbers."
  (let [__ fc/primes]
    (is (= (__ 2) [2 3]))
    (is (= (__ 5) [2 3 5 7 11]))
    (is (= (last (__ 100)) 541))))

(deftest
  ^{::fc/problem    68
    ::fc/difficulty :elementary}
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
  ^{::fc/problem              69
    ::fc/difficulty           :medium
    ::fc/special-restrictions #{'merge-with}}
  merge-with-a-function
  "Write a function which takes a function f and a variable number of maps.
  Your function should return a map that consists of the rest of the maps
  conj-ed onto the first. If a key occurs in more than one map, the mapping(s)
  from the latter (left-to-right) should be combined with the mapping in the
  result by calling (f val-in-result val-in-latter)"
  (let [__ fc/merge-with']
    (is (= (__ * {:a 2, :b 3, :c 4} {:a 2} {:b 2} {:c 5})
           {:a 4, :b 6, :c 20}))
    (is (= (__ - {1 10, 2 20} {1 3, 2 10, 3 15})
           {1 7, 2 10, 3 15}))
    (is (= (__ concat {:a [3], :b [6]} {:a [4 5], :c [8 9]} {:b [7]})
           {:a [3 4 5], :b [6 7], :c [8 9]}))))

(deftest
  ^{::fc/problem    70
    ::fc/difficulty :medium}
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
  ^{::fc/problem    71
    ::fc/difficulty :elementary}
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
  ^{::fc/problem    72
    ::fc/difficulty :elementary}
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
  ^{::fc/problem    73
    ::fc/difficulty :hard}
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
  ^{::fc/problem    74
    ::fc/difficulty :medium}
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
    ::fc/topics               #{:core-functions}
    ::fc/special-restrictions #{'trampoline}}
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

#_
(deftest
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

(deftest
  ^{::fc/problem              81
    ::fc/difficulty           :easy
    ::fc/topics               #{:set-theory}
    ::fc/special-restrictions #{'intersection}}
  set-intersection
  "Write a function which returns the intersection of two sets. The
  intersection is the sub-set of items that each set has in common."
  (let [__ fc/intersection']
    (is (= (__ #{0 1 2 3} #{2 3 4 5}) #{2 3}))
    (is (= (__ #{0 1 2} #{3 4 5}) #{}))
    (is (= (__ #{:a :b :c :d} #{:c :e :a :f :d}) #{:a :c :d}))))

#_
(deftest
  ^{::fc/problem    82
    ::fc/difficulty :hard
    ::fc/topics     #{:seqs}}
  word-chains
  "A word chain consists of a set of words ordered so that each word
  differs by only one letter from the words directly before and after
  it. The one letter difference can be either an insertion, a deletion,
  or a substitution. Here is an example word chain:

  cat -> cot -> coat -> oat -> hat -> hot -> hog -> dog

  Write a function which takes a sequence of words, and returns true if
  they can be arranged into one continous word chain, and false if they
  cannot."
  (let [__ fc/word-chain?]
    (is (= true (__ #{"hat" "coat" "dog" "cat" "oat" "cot" "hot" "hog"})))
    (is (= false (__ #{"cot" "hot" "bat" "fat"})))
    (is (= false (__ #{"to" "top" "stop" "tops" "toss"})))
    (is (= true (__ #{"spout" "do" "pot" "pout" "spot" "dot"})))
    (is (= true (__ #{"share" "hares" "shares" "hare" "are"})))
    (is (= false (__ #{"share" "hares" "hare" "are"})))))

(deftest
  ^{::fc/problem    83
    ::fc/difficulty :easy}
  a-half-truth
  "Write a function which takes a variable number of booleans. Your
  function should return true if some of the parameters are true, but
  not all of the parameters are true. Otherwise your function should
  return false."
  (let [__ (fn [& args]
             (= 2 (count (keys (group-by identity args)))))]
    (is (= false (__ false false)))
    (is (= true (__ true false)))
    (is (= false (__ true)))
    (is (= true (__ false true false)))
    (is (= false (__ true true true)))
    (is (= true (__ true true true false)))))

#_
(deftest
  ^{::fc/problem    84
    ::fc/difficulty :hard
    ::topics        #{:set-theory}}
  transitive-closure
  "Write a function which generates the transitive closure of a binary
  relation. The relation will be represented as a set of 2 item vectors."
  (let [__ #()]
    (is (let [divides #{[8 4] [9 3] [4 2] [27 9]}]
          (= (__ divides) #{[4 2] [8 4] [8 2] [9 3] [27 9] [27 3]})))
    (is (let [more-legs
              #{["cat" "man"] ["man" "snake"] ["spider" "cat"]}]
          (= (__ more-legs)
             #{["cat" "man"] ["cat" "snake"] ["man" "snake"]
               ["spider" "cat"] ["spider" "man"] ["spider" "snake"]})))
    (is (let [progeny
              #{["father" "son"] ["uncle" "cousin"] ["son" "grandson"]}]
          (= (__ progeny)
             #{["father" "son"] ["father" "grandson"]
               ["uncle" "cousin"] ["son" "grandson"]})))))

#_
(deftest
  ^{::fc/problem    85
    ::fc/difficulty :medium
    ::fc/topcs      [:set-theory]}
  power-set
  "Write a function which generates the power set of a given set. The
  power set of a set x is the set of all subsets of x, including the
  empty set and x itself."
  (let [__ #()]
    (is (= (__ #{1 :a}) #{#{1 :a} #{:a} #{} #{1}}))
    (is (= (__ #{}) #{#{}}))
    (is (= (__ #{1 2 3})
           #{#{} #{1} #{2} #{3} #{1 2} #{1 3} #{2 3} #{1 2 3}}))
    (is (= (count (__ (into #{} (range 10)))) 1024))))

(deftest
  ^{::fc/problem    86
    ::fc/difficulty :medium
    ::fc/topics     #{:math}}
  happy-numbers
  "Happy numbers are positive integers that follow a particular
  formula: take each individual digit, square it, and then sum the
  squares to get a new number. Repeat with the new number and
  eventually, you might get to a number whose squared sum is 1. This
  is a happy number. An unhappy number (or sad number) is one that
  loops endlessly. Write a function that determines if a number is
  happy or not."
  (let [__ fc/happy?]
    (is (= (__ 7) true))
    (is (= (__ 986543210) true))
    (is (= (__ 2) false))
    (is (= (__ 3) false))))

;; no problem 87

(deftest
  ^{::fc/problem    88
    ::fc/difficulty :easy
    ::fc/topics     #{:set-theory}}
  symmetric-difference
  "Write a function which returns the symmetric difference of two
  sets. The symmetric difference is the set of items belonging to one
  but not both of the two sets."
  (let [__ fc/symmetric-difference]
    (is (= (__ #{1 2 3 4 5 6} #{1 3 5 7}) #{2 4 6 7}))
    (is (= (__ #{:a :b :c} #{}) #{:a :b :c}))
    (is (= (__ #{} #{4 5 6}) #{4 5 6}))
    (is (= (__ #{[1 2] [2 3]} #{[2 3] [3 4]}) #{[1 2] [3 4]}))))

#_
(deftest
  ^{::fc/problem    89
    ::fc/difficulty :hard
    ::fc/topics     #{:graph-theory}}
  graph-tour
  "Starting with a graph you must write a function that returns true
  if it is possible to make a tour of the graph in which every edge is
  visited exactly once.

  The graph is represented by a vector of tuples, where each tuple
  represents a single edge.

  The rules are:

  - You can start at any node.
  - You must visit each edge exactly once.
  - All edges are undirected."
  (let [__ ]
    (is (= true (__ [[:a :b]])))
    (is (= false (__ [[:a :a] [:b :b]])))
    (is (= false (__ [[:a :b] [:a :b] [:a :c] [:c :a]
                      [:a :d] [:b :d] [:c :d]])))
    (is (= true (__ [[1 2] [2 3] [3 4] [4 1]])))
    (is (= true (__ [[:a :b] [:a :c] [:c :b] [:a :e]
                     [:b :e] [:a :d] [:b :d] [:c :e]
                     [:d :e] [:c :f] [:d :f]])))
    (is (= false (__ [[1 2] [2 3] [2 4] [2 5]])))))

(deftest
  ^{::fc/problem    90
    ::fc/difficulty :easy
    ::fc/topics     #{:set-theory}}
  cartesian-product
  "Write a function which calculates the Cartesian product of two sets."
  (let [__ fc/cartesian-product]
    (is (= (__ #{"ace" "king" "queen"} #{"♠" "♥" "♦" "♣"})
           #{["ace"   "♠"] ["ace"   "♥"] ["ace"   "♦"] ["ace"   "♣"]
             ["king"  "♠"] ["king"  "♥"] ["king"  "♦"] ["king"  "♣"]
             ["queen" "♠"] ["queen" "♥"] ["queen" "♦"] ["queen" "♣"]}))
    (is (= (__ #{1 2 3} #{4 5})
           #{[1 4] [2 4] [3 4] [1 5] [2 5] [3 5]}))
    (is (= 300 (count (__ (into #{} (range 10))
                          (into #{} (range 30))))))))

#_
(deftest
  ^{::fc/problem    91
    ::fc/difficulty :hard
    ::fc/topic      [:graph-theory]}
  graph-connectivity
  "Given a graph, determine whether the graph is connected. A
  connected graph is such that a path exists between any two given
  nodes.

  -Your function must return true if the graph is connected and false
   otherwise.

  -You will be given a set of tuples representing the edges of a
   graph. Each member of a tuple being a vertex/node in the graph.

  -Each edge is undirected (can be traversed either direction)."
  (let [__ #()]
    (is (= true (__ #{[:a :a]})))
    (is (= true (__ #{[:a :b]})))
    (is (= false (__ #{[1 2] [2 3] [3 1]
                       [4 5] [5 6] [6 4]})))
    (is (= true (__ #{[1 2] [2 3] [3 1]
                      [4 5] [5 6] [6 4] [3 4]})))
    (is (= false (__ #{[:a :b] [:b :c] [:c :d]
                       [:x :y] [:d :a] [:b :e]})))
    (is (= true (__ #{[:a :b] [:b :c] [:c :d]
                      [:x :y] [:d :a] [:b :e] [:x :a]})))))

(deftest
  ^{::fc/problem    92
    ::fc/difficulty :hard
    :topic          [:strings :math]}
  read-roman-numerals
  "Roman numerals are easy to recognize, but not everyone knows all
  the rules necessary to work with them. Write a function to parse a
  Roman-numeral string and return the number it represents.

  You can assume that the input will be well-formed, in upper-case,
  and follow the [subtractive
  principle](http://en.wikipedia.org/wiki/Roman_numerals#Subtractive_principle).
  You don't need to handle any numbers greater than MMMCMXCIX (3999), the
  largest number representable with ordinary letters."
  (let [__ fc/roman->dec]
    (is (= 14 (__ "XIV")))
    (is (= 827 (__ "DCCCXXVII")))
    (is (= 3999 (__ "MMMCMXCIX")))
    (is (= 48 (__ "XLVIII")))))

#_
(deftest
  ^{::fc/problem    93
    ::fc/difficulty :medium
    ::fc/topic      [:seqs]}
  partially-flatten-a-sequence
  "Write a function which flattens any nested combination of
  sequential things (lists, vectors, etc.), but maintains the lowest
  level sequential items. The result should be a sequence of sequences
  with only one level of nesting."
  (let [__ fc/partial-flatten]
    (is (= (__ [["Do"] ["Nothing"]])
           [["Do"] ["Nothing"]]))
    (is (= (__ [[[[:a :b]]] [[:c :d]] [:e :f]])
           [[:a :b] [:c :d] [:e :f]]))
    (is (= (__ '((1 2)((3 4)((((5 6)))))))
           '((1 2)(3 4)(5 6))))))

#_
(deftest
  ^{::fc/problem    94
    ::fc/difficulty :hard
    ::fc/topics     #{:game}}
  game-of-life
  "The game of life is a cellular automaton devised by mathematician
  John Conway.

  The 'board' consists of both live (#) and dead ( ) cells. Each cell
  interacts with its eight neighbours (horizontal, vertical, diagonal),
  and its next state is dependent on the following rules:

  1) Any live cell with fewer than two live neighbours dies, as if
     caused by under-population.
  2) Any live cell with two or three live neighbours lives on to the
      next generation.
  3) Any live cell with more than three live neighbours dies, as if
     by overcrowding.
  4) Any dead cell with exactly three live neighbours becomes a live cell,
     as if by reproduction.

  Write a function that accepts a board, and returns a board
  representing the next generation of cells."
  (let [__]
    (is (= (__ ["      "
                " ##   "
                " ##   "
                "   ## "
                "   ## "
                "      "])
           ["      "
            " ##   "
            " #    "
            "    # "
            "   ## "
            "      "]))
    (is (= (__ ["     "
                "     "
                " ### "
                "     "
                "     "])
           ["     "
            "  #  "
            "  #  "
            "  #  "
            "     "]))
    (is (= (__ ["      "
                "      "
                "  ### "
                " ###  "
                "      "
                "      "])
           ["      "
            "   #  "
            " #  # "
            " #  # "
            "  #   "
            "      "]))))

(deftest
  ^{::fc/problem    95
    ::fc/difficulty :easy
    ::fc/topics     #{:trees}}
  to-tree-or-not-to-tree
  "Write a predicate which checks whether or not a given sequence
  represents a [binary tree](https://en.wikipedia.org/wiki/Binary_tree).
  Each node in the tree must have a value, a left child, and a right child."
  (let [__ fc/binary-tree?]
    (is (= (__ '(:a (:b nil nil) nil))
           true))
    (is (= (__ '(:a (:b nil nil)))
           false))
    (is (= (__ [1 nil [2 [3 nil nil] [4 nil nil]]])
           true))
    (is (= (__ [1 [2 nil nil] [3 nil nil] [4 nil nil]])
           false))
    (is (= (__ [1 [2 [3 [4 nil nil] nil] nil] nil])
           true))
    (is (= (__ [1 [2 [3 [4 false nil] nil] nil] nil])
           false))
    (is (= (__ '(:a nil ()))
           false))))

(deftest
  ^{::fc/problem    96
    ::fc/difficulty :easy
    ::fc/topics     #{:trees}}
  beauty-is-symmetry
  "Let us define a binary tree as \"symmetric\" if the left half of the
  tree is the mirror image of the right half of the tree. Write a
  predicate to determine whether or not a given binary tree is
  symmetric. (see [To Tree, or not to
  Tree](http://www.4clojure.com/problem/95) for a reminder on the tree
  representation we're using)."
  (let [__ fc/symmetric?]
    (is (= (__ '(:a (:b nil nil) (:b nil nil))) true))
    (is (= (__ '(:a (:b nil nil) nil)) false))
    (is (= (__ '(:a (:b nil nil) (:c nil nil))) false))
    (is (= (__ [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
                [2 [3 nil [4 [6 nil nil] [5 nil nil]]] nil]])
           true))
    (is (= (__ [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
                [2 [3 nil [4 [5 nil nil] [6 nil nil]]] nil]])
           false))
    (is (= (__ [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
                [2 [3 nil [4 [6 nil nil] nil]] nil]])
           false))))

(deftest
  ^{::fc/problem    97
    ::fc/difficulty :easy}
  pascals-triangle
  "[Pascal's triangle](https://en.wikipedia.org/wiki/Pascal%27s_triangle)
  is a triangle of numbers computed using the following rules:

  - The first row is 1.
  - Each successive row is computed by adding together adjacent
    numbers in the row above, and adding a 1 to the beginning and
    end of the row.

  Write a function which returns the nth row of Pascal's Triangle."
  (let [__ fc/pascals-triangle-row]
    (is (= (__ 1) [1]))
    (is (= (map __ (range 1 6))
           [,,,,[1]
            ,,,[1 1]
            ,,[1 2 1]
            ,[1 3 3 1]
            [1 4 6 4 1]]))
    (is (= (__ 11)
           [1 10 45 120 210 252 210 120 45 10 1]))))

#_
(deftest
  ^{::fc/problem    98
    ::fc/difficulty :medium}
  equivalence-classes
  "A function f defined on a domain D induces an [equivalence
  relation](http://en.wikipedia.org/wiki/Equivalence_relation) on D,
  as follows: a is equivalent to b with respect to f if and only if (f
  a) is equal to (f b). Write a function with arguments f and D that
  computes the [equivalence
  classes](http://en.wikipedia.org/wiki/Equivalence_class) of D with
  respect to f."
  (let [__ fc/equivalence-class]
    (is (= (__ #(* % %) #{-2 -1 0 1 2})
           #{#{0} #{1 -1} #{2 -2}}))
    (is (= (__ #(rem % 3) #{0 1 2 3 4 5 })
           #{#{0 3} #{1 4} #{2 5}}))
    (is (= (__ identity #{0 1 2 3 4})
           #{#{0} #{1} #{2} #{3} #{4}}))
    (is (= (__ (constantly true) #{0 1 2 3 4})
           #{#{0 1 2 3 4}}))))

(deftest
  ^{::fc/problem    99
    ::fc/difficulty :easy
    ::fc/topics     #{:math :seqs}}
  product-digits
  "Write a function which multiplies two numbers and returns the
  result as a sequence of its digits."
  (let [__ (fn [a b] (->> (* a b) str seq (map #(Integer/parseInt (str %)))))]
    (is (= (__ 1 1) [1]))
    (is (= (__ 99 9) [8 9 1]))
    (is (= (__ 999 99) [9 8 9 0 1]))))

(deftest
  ^{::fc/problem    100
    ::fc/difficulty :easy
    ::fc/topics     #{:math}}
  least-common-multiple
  "Write a function which calculates the [least common
  multiple](http://en.wikipedia.org/wiki/Least_common_multiple). Your
  function should accept a variable number of positive integers or
  ratios."
  (let [__ fc/brute-force-lcm]
    (is (== (__ 2 3) 6))
    (is (== (__ 5 3 7) 105))
    (is (== (__ 1/3 2/5) 2))
    (is (== (__ 3/4 1/6) 3/2))
    (is (== (__ 7 5/7 2 3/5) 210))))

#_
(deftest
  ^{::fc/problem    101
    ::fc/difficulty :hard
    ::fc/topics     #{:seqs}}
  levenshtein-distance
  "Given two sequences x and y, calculate the [Levenshtein
   distance](Levenshtein distance) of x and y, i. e. the
   minimum number of edits needed to transform x into y.
   The allowed edits are:

  - insert a single item
  - delete a single item
  - replace a single item with another item

  WARNING: Some of the test cases may timeout if you write an
  inefficient solution!"
  (let [__ ]
    (is (= (__ "kitten" "sitting") 3))
    (is (= (__ "closure" "clojure") (__ "clojure" "closure") 1))
    (is (= (__ "xyx" "xyyyx") 2))
    (is (= (__ "" "123456") 6))
    (is (= (__ "Clojure" "Clojure") (__ "" "") (__ [] []) 0))
    (is (= (__ [1 2 3 4] [0 2 3 4 5]) 2))
    (is (= (__ '(:a :b :c :d) '(:a :d)) 2))
    (is (= (__ "ttttattttctg" "tcaaccctaccat") 10))
    (is (= (__ "gaattctaatctc" "caaacaaaaaattt") 9))))

#_
(deftest
  ^{::fc/problem    102
    ::fc/difficulty :medium
    ::fc/topics     #{:strings}}
  into-camel-case
  "When working with java, you often need to create an object with
  fieldsLikeThis, but you'd rather work with a hashmap that has
  :keys-like-this until it's time to convert. Write a function which
  takes lower-case hyphen-separated strings and converts them to
  camel-case strings."
  (let [__]
    (is (= (__ "something") "something"))
    (is (= (__ "multi-word-key") "multiWordKey"))
    (is (= (__ "leaveMeAlone") "leaveMeAlone"))))

#_
(deftest
  ^{::fc/problem    103
    ::fc/difficulty :medium
    ::fc/topics     #{:seqs :combinatorics}}
  generating-k-combinations
  "Given a sequence S consisting of n elements generate all
  [k-combinations](https://secure.wikimedia.org/wikipedia/en/wiki/Combination)
  of S, i. e. generate all possible sets consisting of k distinct
  elements taken from S. The number of k-combinations for a sequence
  is equal to the [binomial
  coefficient](https://secure.wikimedia.org/wikipedia/en/wiki/Binomial_coefficient)."
  (let [__ ]
    (is (= (__ 1 #{4 5 6}) #{#{4} #{5} #{6}}))
    (is (= (__ 10 #{4 5 6}) #{}))
    (is (= (__ 2 #{0 1 2}) #{#{0 1} #{0 2} #{1 2}}))
    (is (= (__ 3 #{0 1 2 3 4}) #{#{0 1 2} #{0 1 3} #{0 1 4} #{0 2 3} #{0 2 4}
                                 #{0 3 4} #{1 2 3} #{1 2 4} #{1 3 4} #{2 3 4}}))
    (is (= (__ 4 #{[1 2 3] :a "abc" "efg"}) #{#{[1 2 3] :a "abc" "efg"}}))
    (is (= (__ 2 #{[1 2 3] :a "abc" "efg"}) #{#{[1 2 3] :a} #{[1 2 3] "abc"} #{[1 2 3] "efg"}
                                              #{:a "abc"} #{:a "efg"} #{"abc" "efg"}}))))

#_
(deftest
  ^{::fc/problem    104
    ::fc/difficulty :medium
    ::fc/topics     #{:strings :math}}
  write-roman-numerals
  "This is the inverse of [Problem
  92](http://www.4clojure.com/problem/92), but much easier. Given an
  integer smaller than 4000, return the corresponding roman numeral in
  uppercase, adhering to the [subtractive
  principle](http://www.numericana.com/answer/roman.htm#valid)."
  (let [__]
    (is (= "I" (__ 1)))
    (is (= "XXX" (__ 30)))
    (is (= "IV" (__ 4)))
    (is (= "CXL" (__ 140)))
    (is (= "DCCCXXVII" (__ 827)))
    (is (= "MMMCMXCIX" (__ 3999)))
    (is (= "XLVIII" (__ 48)))))

#_
(deftest
  ^{::fc/problem    105
    ::fc/difficulty :medium
    ::topics        #{:maps :seqs}}
  identify-keys-and-values
  "Given an input sequence of keywords and numbers, create a map such
  that each key in the map is a keyword, and the value is a sequence
  of all the numbers (if any) between it and the next keyword in the
  sequence."
  (let [__]
    (is (= {} (__ [])))
    (is (= {:a [1]} (__ [:a 1])))
    (is (= {:a [1], :b [2]} (__ [:a 1, :b 2])))
    (is (= {:a [1 2 3], :b [], :c [4]} (__ [:a 1 2 3 :b :c 4])))))

#_
(deftest
  ^{::fc/problem    106
    ::fc/difficulty :hard
    ::fc/topics     #{:numbers}}
  number-maze
  "Given a pair of numbers, the start and end point, find a path
  between the two using only three possible operations:

 - double
 - halve (odd numbers cannot be halved)
 - add 2

  Find the shortest path through the "maze". Because there are
  multiple shortest paths, you must return the length of the shortest
  path, not the path itself."
  (let [__]
    (is (= 1 (__ 1 1)))    ; 1
    (is (= 3 (__ 3 12)))   ; 3 6 12
    (is (= 3 (__ 12 3)))   ; 12 6 3
    (is (= 3 (__ 5 9)))    ; 5 7 9
    (is (= 9 (__ 9 2)))    ; 9 18 20 10 12 6 8 4 2
    (is (= 5 (__ 9 12))))) ; 9 11 22 24 12

(deftest
  ^{::fc/problem    107
    ::fc/difficulty :easy
    ::fc/topics     #{:higher-order-functions :math}}
  simple-closures
  "Lexical scope and first-class functions are two of the most basic
  building blocks of a functional language like Clojure. When you
  combine the two together, you get something very powerful called
  **lexical closures**. With these, you can exercise a great deal of
  control over the lifetime of your local bindings, saving their
  values for use later, long after the code you're running now has
  finished.

  It can be hard to follow in the abstract, so let's build a simple
  closure. Given a positive integer *n*, return a function (f x) which
  computes x<sup>n</sup>. Observe that the effect of this is to
  preserve the value of *n* for use outside the scope in which it is
  defined."
  (let [__ (fn [n]
             (fn [x] (apply * (repeat n x))))]
    (is (= 256 ((__ 2) 16)
           ((__ 8) 2)))
    (is (= [1 8 27 64] (map (__ 3) [1 2 3 4])))
    (is (= [1 2 4 8 16] (map #((__ %) 2) [0 1 2 3 4])))))

#_
(deftest
  ^{::fc/problem    108
    ::fc/difficulty :medium
    ::fc/topics     #{:seqs :sorting}}
  lazy-searching
  "Given any number of sequences, each sorted from smallest to
  largest, find the smallest single number which appears in all of the
  sequences. The sequences may be infinite, so be careful to search
  lazily."
  (let [__ ]
    (is (= 3 (__ [3 4 5])))
    (iss (= 4 (__ [1 2 3 4 5 6 7] [0.5 3/2 4 19])))
    (is (= 7 (__ (range) (range 0 100 7/6) [2 3 5 7 11 13])))
    (is (= 64 (__ (map #(* % % %) (range)) ;; perfect cubes
                  (filter #(zero? (bit-and % (dec %))) (range)) ;; powers of 2
                  (iterate inc 20)))))) ;; at least as large as 20

;; no problem 109

#_
(deftest
  ^{::fc/problem    110
    ::fc/difficulty :medium
    ::fc/topics     #{:seqs}}
  sequence-of-pronunciations
  "Write a function that returns a lazy sequence of \"pronunciations\"
  of a sequence of numbers. A pronunciation of each element in the
  sequence consists of the number of repeating identical numbers and
  the number itself. For example, [1 1] is pronounced as [2 1] (\"two
  ones\"), which in turn is pronounced as [1 2 1 1] (\"one two, one
  one\").

  Your function should accept an initial sequence of numbers, and return
  an infinite lazy sequence of pronunciations, each element being a
  pronunciation of the previous element."
  (let [__]
    (is (= [[1 1] [2 1] [1 2 1 1]] (take 3 (__ [1]))))
    (is (= [3 1 2 4] (first (__ [1 1 1 4 4]))))
    (is (= [1 1 1 3 2 1 3 2 1 1] (nth (__ [1]) 6)))
    (is (= 338 (count (nth (__ [3 2]) 15))))))

#_
(deftest
  ^{::fc/problem    111
    ::fc/difficulty :hard
    ::fc/topics     #{:game}}
  crossword-puzzle
  "Write a function that takes a string and a partially-filled
  crossword puzzle board, and determines if the input string can be
  legally placed onto the board.

  The crossword puzzle board consists of a collection of
  partially-filled rows. Empty spaces are denoted with an underscore
  (_), unusable spaces are denoted with a hash symbol (#), and
  pre-filled spaces have a character in place; the whitespace
  characters are for legibility and should be ignored.

  For a word to be legally placed on the board:

  - It may use empty spaces (underscores)

  - It may use but must not conflict with any pre-filled characters.

  - It must not use any unusable spaces (hashes).

  - There must be no empty spaces (underscores) or extra characters
    before or after the word (the word may be bound by unusable spaces
    though).

  - Characters are not case-sensitive.

  - Words may be placed vertically (proceeding top-down only), or
    horizontally (proceeding left-right only)."
  (let [__ ]
    (is (= true  (__ "the" ["_ # _ _ e"])))
    (is (= false (__ "the" ["c _ _ _"
                            "d _ # e"
                            "r y _ _"])))
    (is (= true  (__ "joy" ["c _ _ _"
                            "d _ # e"
                            "r y _ _"])))
    (is (= false (__ "joy" ["c o n j"
                            "_ _ y _"
                            "r _ _ #"])))
    (is (= true  (__ "clojure" ["_ _ _ # j o y"
                                "_ _ o _ _ _ _"
                                "_ _ f _ # _ _"])))))
#_
(deftest
  ^{::fc/problem    112
    ::fc/difficulty :medium
    ::fc/topics     #{:seqs}}
  sequs-horribilus
  "Create a function which takes an integer and a nested collection of
  integers as arguments. Analyze the elements of the input collection
  and return a sequence which maintains the nested structure, and
  which includes all elements starting from the head whose sum is less
  than or equal to the input integer."
  (let [__]
    (is (=  (__ 10 [1 2 [3 [4 5] 6] 7])
            '(1 2 (3 (4)))))
    (is (=  (__ 30 [1 2 [3 [4 [5 [6 [7 8]] 9]] 10] 11])
            '(1 2 (3 (4 (5 (6 (7))))))))
    (is (=  (__ 9 (range))
            '(0 1 2 3)))
    (is (=  (__ 1 [[[[[1]]]]])
            '(((((1)))))))
    (is (=  (__ 0 [1 2 [3 [4 5] 6] 7])
            '()))
    (is (=  (__ 0 [0 0 [0 [0]]])
            '(0 0 (0 (0)))))
    (is (=  (__ 1 [-10 [1 [2 3 [4 5 [6 7 [8]]]]]])
            '(-10 (1 (2 3 (4))))))))

#_
(deftest
  ^{::fc/problem              113
    ::fc/difficulty           :hard
    ::fc/topics               #{:types}
    ::fc/special-restrictions #{'proxy}}
  making-data-dance
  "Write a function that takes a variable number of integer
  arguments. If the output is coerced into a string, it should return
  a comma (and space) separated list of the inputs sorted smallest to
  largest. If the output is coerced into a sequence, it should return
  a seq of unique input elements in the same order as they were
  entered."
  (let [__ ]
    (is (= "1, 2, 3" (str (__ 2 1 3))))
    (is (= '(2 1 3) (seq (__ 2 1 3))))
    (is (= '(2 1 3) (seq (__ 2 1 3 3 1 2))))
    (is (= '(1) (seq (apply __ (repeat 5 1)))))
    (is (is (= "1, 1, 1, 1, 1" (str (apply __ (repeat 5 1))))))
    (is (and (= nil (seq (__)))
             (=  "" (str (__)))))))

#_
(deftest
  ^{::fc/problem    114
    ::fc/difficulty :medium
    ::fc/topics     #{:seqs :higher-order-functions}}
  global-take-while
  "[take-while](http://clojuredocs.org/clojure_core/clojure.core/take-while)
  is great for filtering sequences, but it limited: you
  can only examine a single item of the sequence at a time. What if
  you need to keep track of some state as you go over the sequence?

  Write a function which accepts an integer n, a predicate p, and a
  sequence. It should return a lazy sequence of items in the list up
  to, but not including, the nth item that satisfies the predicate."
  (let [__]
    (is (= [2 3 5 7 11 13]
           (__ 4 #(= 2 (mod % 3))
               [2 3 5 7 11 13 17 19 23])))
    (is (= ["this" "is" "a" "sentence"]
           (__ 3 #(some #{\i} %)
               ["this" "is" "a" "sentence" "i" "wrote"])))
    (is (= ["this" "is"]
           (__ 1 #{"a"}
               ["this" "is" "a" "sentence" "i" "wrote"])))))

#_
(deftest
  ^{::fc/problem    115
    ::fc/difficulty :medium
    ::fc/topics     #{:math}}
  the-balance-of-n
  "A balanced number is one whose component digits have the same sum
  on the left and right halves of the number. Write a function which
  accepts an integer n, and returns true iff n is balanced."
  (let [__]
    (is (= true (__ 11)))
    (is (= true (__ 121)))
    (is (= false (__ 123)))
    (is (= true (__ 0)))
    (is (= false (__ 88099)))
    (is (= true (__ 89098)))
    (is (= true (__ 89089)))
    (is (= (take 20 (filter __ (range)))
           [0 1 2 3 4 5 6 7 8 9 11 22 33 44 55 66 77 88 99 101]))))

#_
(deftest
  ^{::fc/problem    116
    ::fc/difficulty :medium
    ::fc/topics     #{:math}}
  prime-sandwich
  "A [balanced prime](http://en.wikipedia.org/wiki/Balanced_prime) is
  a prime number which is also the mean of the primes directly before
  and after it in the sequence of valid primes. Create a function
  which takes an integer n, and returns true iff it is a balanced
  prime."
  (let [__]
    (is (= false (__ 4)))
    (is (= true (__ 563)))
    (is (= 1103 (nth (filter __ (range)) 15)))))

#_
(deftest
  ^{::fc/problem    117
    ::fc/difficulty :hard
    ::fc/topics     #{:game}}
  for-science!
  "A mad scientist with tenure has created an experiment tracking mice
  in a maze. Several mazes have been randomly generated, and you've
  been tasked with writing a program to determine the mazes in which
  it's possible for the mouse to reach the cheesy endpoint. Write a
  function which accepts a maze in the form of a collection of rows,
  each row is a string where:

 - spaces represent areas where the mouse can walk freely

 - hashes (#) represent walls where the mouse can not walk

 - M represents the mouse's starting point

 - C represents the cheese which the mouse must reach

  The mouse is not allowed to travel diagonally in the maze (only
  up/down/left/right), nor can he escape the edge of the maze. Your
  function must return true iff the maze is solvable by the mouse."
  (let [__]
    (is (= true  (__ ["M   C"])))
    (is (= false (__ ["M # C"])))
    (is (= true  (__ ["#######"
                      "#     #"
                      "#  #  #"
                      "#M # C#"
                      "#######"])))
    (is (= false (__ ["########"
                      "#M  #  #"
                      "#   #  #"
                      "# # #  #"
                      "#   #  #"
                      "#  #   #"
                      "#  # # #"
                      "#  #   #"
                      "#  #  C#"
                      "########"])))
    (is (= false (__ ["M     "
                      "      "
                      "      "
                      "      "
                      "    ##"
                      "    #C"])))
    (is (= true  (__ ["C######"
                      " #     "
                      " #   # "
                      " #   #M"
                      "     # "])))
    (is (= true  (__ ["C# # # #"
                      "        "
                      "# # # # "
                      "        "
                      " # # # #"
                      "        "
                      "# # # #M"])))))

(deftest
  ^{::fc/problem              118
    ::fc/difficulty           :easy
    ::fc/topics               #{:core-seqs}
    ::fc/special-restrictions #{'map 'map-indexed 'mapcat 'for}}
  re-implement-map
  "Map is one of the core elements of a functional programming
  language. Given a function f and an input sequence s, return a lazy
  sequence of (f x) for each element x in s."
  (let [__ fc/map']
    (is (= [3 4 5 6 7]
           (__ inc [2 3 4 5 6])))
    (is (= (repeat 10 nil)
           (__ (fn [_] nil) (range 10))))
    (is (= [1000000 1000001]
           (->> (__ inc (range))
                (drop (dec 1000000))
                (take 2))))))

#_
(deftest
  ^{::fc/problem    119
    ::fc/difficulty :hard
    ::fc/topics     #{:game}}
  win-at-tic-tac-toe
  "As in [Problem 73](http://www.4clojure.com/problem/73), a
  tic-tac-toe board is represented by a two dimensional vector. X is
  represented by :x, O is represented by :o, and empty is represented
  by :e. Create a function that accepts a game piece and board as
  arguments, and returns a set (possibly empty) of all valid board
  placements of the game piece which would result in an immediate win.

  Board coordinates should be as in calls to get-in. For example, [0
  1] is the topmost row, center position."
  (let [__]
    (is (= (__ :x [[:o :e :e]
                   [:o :x :o]
                   [:x :x :e]])
           #{[2 2] [0 1] [0 2]}))
    (is (= (__ :x [[:x :o :o]
                   [:x :x :e]
                   [:e :o :e]])
           #{[2 2] [1 2] [2 0]}))
    (is (= (__ :x [[:x :e :x]
                   [:o :x :o]
                   [:e :o :e]])
           #{[2 2] [0 1] [2 0]}))
    (is (= (__ :x [[:x :x :o]
                   [:e :e :e]
                   [:e :e :e]])
           #{}))
    (is (= (__ :o [[:x :x :o]
                   [:o :e :o]
                   [:x :e :e]])
           #{[2 2] [1 1]}))))

(deftest
  ^{::fc/problem    120
    ::fc/difficulty :easy
    ::fc/topics     #{:math}}
  sum-of-square-of-digits
  "Write a function which takes a collection of integers as an
  argument. Return the count of how many elements are smaller than the
  sum of their squared component digits. For example: 10 is larger
  than 1 squared plus 0 squared; whereas 15 is smaller than 1 squared
  plus 5 squared."
  (let [__ (fn [coll]
             (count (for [n     coll
                          :when (< n (->> (str n)
                                          seq
                                          (map #(-> (str %)
                                                    (Integer/parseInt)
                                                    ((fn [x] (* x x)))))
                                          (reduce +)))]
                      n)))]
    (is (= 8 (__ (range 10))))
    (is (= 19 (__ (range 30))))
    (is (= 50 (__ (range 100))))
    (is (= 50 (__ (range 1000))))))

#_
(deftest
  ^{::fc/problem              121
    ::fc/difficulty           :medium
    ::fc/topics               #{:functions}
    ::fc/special-restrictions #{'eval 'resolve}}
  universal-computation-engine
  "Given a mathematical formula in prefix notation, return a function
  that calculates the value of the formula. The formula can contain
  nested calculations using the four basic mathematical operators,
  numeric constants, and symbols representing variables. The returned
  function has to accept a single parameter containing the map of
  variable names to their values."
  (let [__]
    (is (= 2 ((__ '(/ a b))
              '{b 8 a 16})))
    (is (= 8 ((__ '(+ a b 2))
              '{a 2 b 4})))
    (is (= [6 0 -4]
           (map (__ '(* (+ 2 a)
                        (- 10 b)))
                '[{a 1 b 8}
                  {b 5 a -2}
                  {a 2 b 11}])))
    (is (= 1 ((__ '(/ (+ x 2)
                      (* 3 (+ y 1))))
              '{x 4 y 1})))))

(deftest
  ^{::fc/problem    122
    ::fc/difficulty :easy}
  read-a-binary-number
  "Convert a binary number, provided in the form of a string, to its
  numerical value."
  (let [__ fc/binary->dec]
    (is (= 0     (__ "0")))
    (is (= 7     (__ "111")))
    (is (= 8     (__ "1000")))
    (is (= 9     (__ "1001")))
    (is (= 255   (__ "11111111")))
    (is (= 1365  (__ "10101010101")))
    (is (= 65535 (__ "1111111111111111")))))

;; no problem 123

#_
(deftest
  ^{::fc/problem    124
    ::fc/difficulty :hard
    ::fc/topics     #{:game}}
  analyze-reversi
  "[Reversi](http://en.wikipedia.org/wiki/Reversi) is normally played
  on an 8 by 8 board. In this problem, a 4 by 4 board is represented
  as a two-dimensional vector with black, white, and empty pieces
  represented by 'b, 'w, and 'e, respectively. Create a function that
  accepts a game board and color as arguments, and returns a map of
  legal moves for that color. Each key should be the coordinates of a
  legal move, and its value a set of the coordinates of the pieces
  flipped by that move.

  Board coordinates should be as in calls to get-in. For example, [0
  1] is the topmost row, second column from the left."
  (let [__]
    (is (= {[1 3] #{[1 2]}, [0 2] #{[1 2]}, [3 1] #{[2 1]}, [2 0] #{[2 1]}}
           (__ '[[e e e e]
                 [e w b e]
                 [e b w e]
                 [e e e e]] 'w)))
    (is (= {[3 2] #{[2 2]}, [3 0] #{[2 1]}, [1 0] #{[1 1]}}
           (__ '[[e e e e]
                 [e w b e]
                 [w w w e]
                 [e e e e]] 'b)))
    (is (= {[0 3] #{[1 2]}, [1 3] #{[1 2]}, [3 3] #{[2 2]}, [2 3] #{[2 2]}}
           (__ '[[e e e e]
                 [e w b e]
                 [w w b e]
                 [e e b e]] 'w)))
    (is (= {[0 3] #{[2 1] [1 2]}, [1 3] #{[1 2]}, [2 3] #{[2 1] [2 2]}}
           (__ '[[e e w e]
                 [b b w e]
                 [b w w e]
                 [b w w w]] 'b)))))

#_
(deftest
  ^{::fc/problem    125
    ::fc/difficulty :hard
    ::fc/topics     #{:logic :fun :brain-teaser}}
  gus-quinundrum
  "Create a function of no arguments which returns a string that is an
  exact copy of the function itself.

  Hint: read [this](http://en.wikipedia.org/wiki/Quine_(computing)) if
  you get stuck (this question is harder than it first appears); but
  it's worth the effort to solve it independently if you can!

  Fun fact: Gus is the name of the [4Clojure
  dragon](http://i.imgur.com/FBd8z.png)."
  (let [__ ]
    (is (= (str '__) (__)))))

(deftest
  ^{::fc/problem    126
    ::fc/difficulty :easy
    ::fc/topics     #{:fun :brain-teaser}}
  through-the-looking-glass
  "Enter a value which satisfies the following:"
  (let [__ java.lang.Class]
    (is (let [x __]
          (and (= (class x) x) x)))))
#_
(deftest
  ^{::fc/problem    127
    ::fc/difficulty :hard
    ::fc/topics     #{:search :data-juggling}}
  love-triangle
  "Everyone loves triangles, and it's easy to understand why—they're
  so wonderfully symmetric (except scalenes, they suck).

  Your passion for triangles has led you to become a miner (and
  part-time Clojure programmer) where you work all day to chip out
  isosceles-shaped minerals from rocks gathered in a nearby open-pit
  mine. There are too many rocks coming from the mine to harvest them
  all so you've been tasked with writing a program to analyze the
  mineral patterns of each rock, and determine which rocks have the
  biggest minerals.

  Someone has already written a
  [computer-vision](http://en.wikipedia.org/wiki/Computer_vision)
  system for the mine. It images each rock as it comes into the
  processing centre and creates a cross-sectional
  [bitmap](http://en.wikipedia.org/wiki/Bit_array) of mineral (1) and
  rock (0) concentrations for each one.

  You must now create a function which accepts a collection of
  integers, each integer when read in base-2 gives the
  bit-representation of the rock (again, 1s are mineral and 0s are
  worthless scalene-like rock). You must return the cross-sectional
  area of the largest harvestable mineral from the input rock, as
  follows:

  - The minerals only have smooth faces when sheared vertically or
    horizontally from the rock's cross-section

  - The mine is only concerned with harvesting isosceles triangles
    (such that one or two sides can be sheared)

  - If only one face of the mineral is sheared, its opposing vertex
    must be a point (ie. the smooth face must be of odd length), and
    its two equal-length sides must intersect the shear face at 45°
    (ie. those sides must cut even-diagonally)

  - The harvested mineral may not contain any traces of rock

  - The mineral may lie in any orientation in the plane

  - Area should be calculated as the sum of 1s that comprise the
    mineral

  - Minerals must have a minimum of three measures of area to be
    harvested

  - If no minerals can be harvested from the rock, your function
    should return nil"
  (let [__]
    (is (= 10 (__ [15 15 15 15 15])))
                                        ; 1111      1111
                                        ; 1111      *111
                                        ; 1111  ->  **11
                                        ; 1111      ***1
                                        ; 1111      ****

    (is (= 15 (__ [1 3 7 15 31])))
                                        ; 00001      0000*
                                        ; 00011      000**
                                        ; 00111  ->  00***
                                        ; 01111      0****
                                        ; 11111      *****

    (is (= 3 (__ [3 3])))
                                        ; 11      *1
                                        ; 11  ->  **

    (is (= 4 (__ [7 3])))
                                        ; 111      ***
                                        ; 011  ->  0*1

    (is (= 6 (__ [17 22 6 14 22])))
                                        ; 10001      10001
                                        ; 10110      101*0
                                        ; 00110  ->  00**0
                                        ; 01110      0***0
                                        ; 10110      10110

    (is (= 9 (__ [18 7 14 14 6 3])))
                                        ; 10010      10010
                                        ; 00111      001*0
                                        ; 01110      01**0
                                        ; 01110  ->  0***0
                                        ; 00110      00**0
                                        ; 00011      000*1

    (is (= nil (__ [21 10 21 10])))
                                        ; 10101      10101
                                        ; 01010      01010
                                        ; 10101  ->  10101
                                        ; 01010      01010

    (is (= nil (__ [0 31 0 31 0])))
                                        ; 00000      00000
                                        ; 11111      11111
                                        ; 00000  ->  00000
                                        ; 11111      11111
                                        ; 00000      00000
    ))

(deftest
  ^{::fc/problem    128
    ::fc/difficulty :easy
    ::fc/topics     #{:strings :game}}
  recognize-playing-cards
  "A standard American deck of playing cards has four suits - spades,
  hearts, diamonds, and clubs - and thirteen cards in each suit. Two
  is the lowest rank, followed by other integers up to ten; then the
  jack, queen, king, and ace.

  It's convenient for humans to represent these cards as suit/rank
  pairs, such as H5 or DQ: the heart five and diamond queen
  respectively. But these forms are not convenient for programmers, so
  to write a card game you need some way to parse an input string into
  meaningful components. For purposes of determining rank, we will
  define the cards to be valued from 0 (the two) to 12 (the ace)

  Write a function which converts (for example) the string \"SJ\" into
  a map of {:suit :spade, :rank 9}. A ten will always be represented
  with the single character \"T\", rather than the two characters
  \"10\"."
  (let [__ fc/playing-card]
    (is (= {:suit :diamond :rank 10} (__ "DQ")))
    (is (= {:suit :heart :rank 3} (__ "H5")))
    (is (= {:suit :club :rank 12} (__ "CA")))
    (is (= (range 13) (map (comp :rank __ str)
                           '[S2 S3 S4 S5 S6 S7
                             S8 S9 ST SJ SQ SK SA])))))

;; No problem 129

#_(deftest
    ^{::fc/problem 130}
    problem-130)

#_(deftest
    ^{::fc/problem 131}
    problem-131)

#_(deftest
    ^{::fc/problem 132}
    problem-132)

;; No problem 133

(deftest
  ^{::fc/problem    134
    ::fc/difficulty :elementary
    ::topics        #{:maps}}
  a-nil-key
  "Write a function which, given a key and map, returns true iff the
  map contains an entry with that key and its value is nil."
  (let [__ (fn [k m]
             (true? (and (some #{k} (keys m))
                         (nil? (get m k)))))]
    (is (true?  (__ :a {:a nil :b 2})))
    (is (false? (__ :b {:a nil :b 2})))
    (is (false? (__ :c {:a nil :b 2})))))

(deftest
  ^{::fc/problem    135
    ::fc/difficulty :easy
    ::fc/topics     #{:higher-order-functions :math}}
  infix-calculator
  "Your friend Joe is always whining about Lisps using the prefix
  notation for math. Show him how you could easily write a function
  that does math using the infix notation. Is your favorite language
  that flexible, Joe? Write a function that accepts a variable length
  mathematical expression consisting of numbers and the operations +,
  -, *, and /. Assume a simple calculator that does not do precedence
  and instead just calculates left to right."
  (let [__ (fn [init & r]
             (reduce (fn [memo [f n]] (f memo n))
                     init
                     (partition 2 r)))]
    (is (= 7  (__ 2 + 5)))
    (is (= 42 (__ 38 + 48 - 2 / 2)))
    (is (= 8  (__ 10 / 2 - 1 * 2)))
    (is (= 72 (__ 20 / 2 + 2 + 4 + 8 - 6 - 10 * 9)))))

;; No problem 136

#_
(deftest
  ^{::fc/problem 137}
  problem-137)

#_
(deftest
  ^{::fc/problem 138}
  problem-138)

#_
(deftest
  ^{::fc/problem   139
    ::fc/approved? false}
  problem-139)

#_
(deftest
  ^{::fc/problem 140}
  problem-140)

#_
(deftest
  ^{::fc/problem 141}
  problem-141)

;; No problem 142

(deftest
  ^{::fc/problem    143
    ::fc/difficulty :easy
    ::topics        #{:seqs :math}}
  dot-product
  "Create a function that computes the [dot
  product](http://en.wikipedia.org/wiki/Dot_product#Definition) of two
  sequences. You may assume that the vectors will have the same
  length."
  (let [__ (fn [a b] (reduce + (map #(* % %2) a b)))]
    (is (= 0 (__ [0 1 0] [1 0 0])))
    (is (= 3 (__ [1 1 1] [1 1 1])))
    (is (= 32 (__ [1 2 3] [4 5 6])))
    (is (= 256 (__ [2 5 6] [100 10 1])))))

#_
(deftest
  ^{::fc/problem 144}
  problem-144)

(deftest
  ^{::fc/problem    145
    ::fc/difficulty :elementary
    ::fc/topics     #{:core-functions :seqs}}
  for-the-win
  "Clojure's for macro is a tremendously versatile mechanism for
  producing a sequence based on some other sequence(s). It can take
  some time to understand how to use it properly, but that investment
  will be paid back with clear, concise sequence-wrangling later. With
  that in mind, read over these for expressions and try to see how
  each of them produces the same result."
  (let [__ [1 5 9 13 17 21 25 29 33 37]]
    (is (= __ (for [x     (range 40)
                    :when (= 1 (rem x 4))]
                x)))
    (is (= __ (for [x      (iterate #(+ 4 %) 0)
                    :let   [z (inc x)]
                    :while (< z 40)]
                z)))
    (is (= __ (for [[x y] (partition 2 (range 20))]
                (+ x y))))))

(deftest
  ^{::fc/problem    146
    ::fc/difficulty :easy
    ::fc/topics     #{:seqs :maps}}
  trees-into-tables
  "Because Clojure's `for` macro allows you to \"walk\" over multiple
  sequences in a nested fashion, it is excellent for transforming all
  sorts of sequences. If you don't want a sequence as your final
  output (say you want a map), you are often still best-off using for,
  because you can produce a sequence and feed it into a map, for
  example.

  For this problem, your goal is to \"flatten\" a map of
  hashmaps. Each key in your output map should be the
  \"path\"<sup>1</sup> that you would have to take in the original map
  to get to a value, so for example `{1 {2 3}}` should result in `{[1
  2] 3}`. You only need to flatten one level of maps: if one of the
  values is a map, just leave it alone.

  <sup>1</sup> That is, `(get-in original [k1 k2])` should be the same
  as `(get result [k1 k2])`"
  (let [__ fc/tree->table]
    (is (= (__ '{a {p 1, q 2}
                 b {m 3, n 4}})
           '{[a p] 1, [a q] 2
             [b m] 3, [b n] 4}))
    (is (= (__ '{[1] {a b c d}
                 [2] {q r s t u v w x}})
           '{[[1] a] b, [[1] c] d,
             [[2] q] r, [[2] s] t,
             [[2] u] v, [[2] w] x}))
    (is (= (__ '{m {1 [a b c] 3 nil}})
           '{[m 1] [a b c], [m 3] nil}))))

(deftest
  ^{::fc/problem    147
    ::fc/difficulty :easy
    ::fc/topics     #{:seqs}}
  pascals-trapezoid
  "Write a function that, for any given input vector of numbers,
  returns an infinite lazy sequence of vectors, where each next one is
  constructed from the previous following the rules used in [Pascal's
  Triangle](http://en.wikipedia.org/wiki/Pascal's_triangle). For
  example, for [3 1 2], the next row is [3 4 3 2].

  Beware of arithmetic overflow! In clojure (since version 1.3 in
  2011), if you use an arithmetic operator like + and the result is
  too large to fit into a 64-bit integer, an exception is thrown. You
  can use +' to indicate that you would rather overflow into Clojure's
  slower, arbitrary-precision bigint."
  (let [__ fc/pascals-triangle-rows]
    (is (= (second (__ [2 3 2])) [2 5 5 2]))
    (is (= (take 5 (__ [1])) [[1] [1 1] [1 2 1] [1 3 3 1] [1 4 6 4 1]]))
    (is (= (take 2 (__ [3 1 2])) [[3 1 2] [3 4 3 2]]))
    (is (= (take 100 (__ [2 4 2])) (rest (take 101 (__ [2 2])))))))

#_
(deftest
  ^{::fc/problem   149
    ::fc/approved? false}
  problem-149)

#_
(deftest
  ^{::fc/problem   150
    ::fc/approved? false}
  problem-150)

;; no problem 151

#_(deftest
    ^{::fc/problem 152}
    problem-152)

(deftest
  ^{::fc/problem    153
    ::fc/difficulty :easy
    ::fc/topics     #{:set-theory}}
  pairwise-disjoint-sets
  "Given a set of sets, create a function which returns true if no two
  of those sets have any elements in common<sup>1</sup> and false
  otherwise. Some of the test cases are a bit tricky, so pay a little
  more attention to them.

  <sup>1</sup>Such sets are usually called *pairwise disjoint* or
  *mutually disjoint*."
  (let [__ fc/pairwise-disjoint?]
    (is (= (__ #{#{\U} #{\s} #{\e \R \E} #{\P \L} #{\.}})
           true))
    (is (= (__ #{#{:a :b :c :d :e}
                 #{:a :b :c :d}
                 #{:a :b :c}
                 #{:a :b}
                 #{:a}})
           false))
    (is (= (__ #{#{[1 2 3] [4 5]}
                 #{[1 2] [3 4 5]}
                 #{[1] [2] 3 4 5}
                 #{1 2 [3 4] [5]}})
           true))
    (is (= (__ #{#{'a 'b}
                 #{'c 'd 'e}
                 #{'f 'g 'h 'i}
                 #{''a ''c ''f}})
           true))
    (is (= (__ #{#{'(:x :y :z) '(:x :y) '(:z) '()}
                 #{#{:x :y :z} #{:x :y} #{:z} #{}}
                 #{'[:x :y :z] [:x :y] [:z] [] {}}})
           false))
    (is (= (__ #{#{(= "true") false}
                 #{:yes :no}
                 #{(class 1) 0}
                 #{(symbol "true") 'false}
                 #{(keyword "yes") ::no}
                 #{(class '1) (int \0)}})
           false))
    (is (= (__ #{#{distinct?}
                 #{#(-> %) #(-> %)}
                 #{#(-> %) #(-> %) #(-> %)}
                 #{#(-> %) #(-> %) #(-> %)}})
           true))
    (is (= (__ #{#{(#(-> *)) + (quote mapcat) #_ nil}
                 #{'+ '* mapcat (comment mapcat)}
                 #{(do) set contains? nil?}
                 #{, , , #_, , empty?}})
           false))))

;; no such problem 154

#_
(deftest
  ^{::fc/problem   155
    ::fc/approved? false}
  problem-155)

(deftest
  ^{::fc/problem    156
    ::fc/difficulty :elementary
    ::fc/topics     #{:seqs}}
  map-defaults
  "When retrieving values from a map, you can specify default values
  in case the key is not found:

  (= 2 (:foo {:bar 0, :baz 1} 2))

  However, what if you want the map itself to contain the default
  values? Write a function which takes a default value and a sequence
  of keys and constructs a map."
  (let [__ #(into {} (map vector %2 (repeat %)))]
    (is (= (__ 0 [:a :b :c]) {:a 0 :b 0 :c 0}))
    (is (= (__ "x" [1 2 3]) {1 "x" 2 "x" 3 "x"}))
    (is (= (__ [:a :b] [:foo :bar]) {:foo [:a :b] :bar [:a :b]}))))

(deftest
  ^{::fc/problem    157
    ::fc/difficulty :easy
    ::fc/topics     #{:seqs}}
  indexing-sequences
  "Transform a sequence into a sequence of pairs containing the
  original elements along with their index."
  (let [__ #(map list % (range))]
    (is (= (__ [:a :b :c]) [[:a 0] [:b 1] [:c 2]]))
    (is (= (__ [0 1 3]) '((0 0) (1 1) (3 2))))
    (is (= (__ [[:foo] {:bar :baz}]) [[[:foo] 0] [{:bar :baz} 1]]))))

#_
(deftest
  ^{::fc/problem 158}
  problem-158)

#_
(deftest
  ^{::fc/problem   159
    ::fc/approved? false}
  problem-159)

#_
(deftest
  ^{::fc/problem   160
    ::fc/approved? false}
  problem-160)

(deftest
  ^{::fc/problem    161
    ::fc/difficulty :elementary
    ::fc/topics     #{:set-theory}}
  subset-and-superset
  "Set A is a subset of set B, or equivalently B is a superset of A,
  if A is \"contained\" inside B. A and B may coincide."
  (let [__ #{1 2}]
    (is (clojure.set/superset? __ #{2}))
    (is (clojure.set/subset? #{1} __))
    (is (clojure.set/superset? __ #{1 2}))
    (is (clojure.set/subset? #{1 2} __))))

(deftest
  ^{::fc/problem    162
    ::fc/difficulty :elementary
    ::fc/topics     #{:logic}}
  logical-falsity-and-truth
  "In Clojure, only nil and false represent the values of logical
  falsity in conditional tests - anything else is logical truth."
  (let [__ 1]
    (is (= __ (if-not false 1 0)))
    (is (= __ (if-not nil 1 0)))
    (is (= __ (if true 1 0)))
    (is (= __ (if [] 1 0)))
    (is (= __ (if [0] 1 0)))
    (is (= __ (if 0 1 0)))
    (is (= __ (if 1 1 0)))))

#_
(deftest
  ^{::fc/problem   163
    ::fc/approved? false}
  problem-163)

#_
(deftest
  ^{::fc/problem 164}
  problem-164)

#_
(deftest
  ^{::fc/problem   165
    ::fc/approved? false}
  problem-165)

(deftest
  ^{::fc/problem    166
    ::fc/difficulty :easy}
  comparisons
  "For any orderable data type it's possible to derive all of the
  basic comparison operations (<, ≤, =, ≠, ≥, and >) from a single
  operation (any operator but = or ≠ will work). Write a function that
  takes three arguments, a less than operator for the data and two items
  to compare. The function should return a keyword describing the
  relationship between the two items. The keywords for the relationship
  between *x* and *y* are as follows:

 - x = y → :eq
 - x > y → :gt
 - x < y → :lt"
  (let [__ #(cond (% %2 %3) :lt (% %3 %2) :gt :else :eq)]
    (is (= :gt (__ < 5 1)))
    (is (= :eq (__ (fn [x y] (< (count x) (count y))) "pear" "plum")))
    (is (= :lt (__ (fn [x y] (< (mod x 5) (mod y 5))) 21 3)))
    (is (= :gt (__ > 0 2)))))

#_
(deftest
  ^{::fc/problem   167
    ::fc/approved? false}
  problem-167)

#_
(deftest
  ^{::fc/problem 168}
  problem-168)

#_
(deftest
  ^{::fc/problem   169
    ::fc/approved? false}
  problem-169)

;; no such problem 170

#_
(deftest
  ^{::fc/problem 171}
  problem-171)

#_
(deftest
  ^{::fc/problem   172
    ::fc/approved? false}
  problem-172)

(deftest
  ^{::fc/problem    173
    ::fc/difficulty :easy
    ::fc/topics     #{:destructuring}}
  intro-to-destructuring-2
  "Sequential destructuring allows you to bind symbols to parts of
  sequential things (vectors, lists, seqs, etc.): [(let [bindings* ]
  exprs*)](http://clojure.org/special_forms#Special%20Forms--(let%20[bindings*%20]%20exprs*))
  Complete the bindings so all let-parts evaluate to 3."
  ;; __ a c
  (is (= 3
         (let [[a c] [+ (range 3)]] (apply a c))
         (let [[[a c] b] [[+ 1] 2]] (a c b))
         (let [[a c] [inc 2]] (a c)))))

#_
(deftest
  ^{::fc/problem   174
    ::fc/approved? false}
  problem-174)

#_
(deftest
  ^{::fc/problem   175
    ::fc/approved? false}
  problem-175)

;; no such problem 176

#_
(deftest
  ^{::fc/problem 177}
  problem-177)

#_
(deftest
  ^{::fc/problem 178}
  problem-178)

;; problems 179-209, unapproved

;; no such problem 210

(comment
  ;; all solved problems ordered by name
  (->> (ns-interns 'com.grzm.foreclojure.alpha-test)
       vals
       (map meta)
       (filter :test)
       (map :name)
       sort)

  ;; count of solved problems by difficulty
  (->> (ns-interns 'com.grzm.foreclojure.alpha-test)
       vals
       (map meta)
       (filter :test)
       (map ::fc/difficulty)
       frequencies)
  )
