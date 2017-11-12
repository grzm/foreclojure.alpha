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
    (= __ ((fn foo [x] (when (> x 0) (conj (foo (dec x)) x))) 5))))

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
  ^{::fc/problems 68}
  recurring-theme
  "Clojure only has one non-stack-consuming looping construct: recur.
  Either a function or a loop can be used as the recursion point.
  Either way, recur rebinds the bindings of the recursion point to the
  values it is passed. Recur must be called from the tail-position,
  and calling it elsewhere will result in an error."
  (let [__ [7 6 5 4 3]]
    (= __
       (loop [x 5
              result []]
         (if (> x 0)
           (recur (dec x) (conj result (+ 2 x)))
           result)))))

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
  ^{::fc/problems 71}
  rearranging-code-colon->
  "The -> macro threads an expression x through a variable number of
  forms. First, x is inserted as the second item in the first form,
  making a list of it if it is not a list already. Then the first form
  is inserted as the second item in the second form, making a list of
  that form if necessary. This process continues for all the forms.
  Using -> can sometimes make your code more readable."
  (let [__ last]
    (= (__ (sort (rest (reverse [2 5 4 1 3 6]))))
       (-> [2 5 4 1 3 6] (reverse) (rest) (sort) (__))
       5)))
