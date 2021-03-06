(ns com.grzm.foreclojure.alpha)

(defn spy-> [x label]
  (prn {:label label :x x})
  x)

(defn spy->> [label x]
  (prn {:label label :x x})
  x)

(def
  ^{::problem 21}
  enth
  "Nth element"
  (fn [coll i]
    "implementation of nth"
    (when (and (seq coll)
               (<= 0 i (dec (count coll))))
      (if (zero? i)
        (first coll)
        (recur (rest coll) (dec i))))))

(def
  ^{::problem 22}
  cownt
  "Count a Sequence
  Write a function which returns the total number of elements in a sequence"
  (letfn [(cownt* [coll]
            (if (seq coll)
              (inc (cownt* (rest coll)))
              0))]
    cownt*))

(def
  ^{::problem 23}
  revers
  "Reverse a Sequence"
  (letfn [(revers* [coll]
            (when (seq coll)
              (into (list) coll)))]
    revers*))

(def
  ^{::problem 24}
  sum
  "Sum It All Up
  Write a function which returns the sum of a sequence of numbers."
  (partial reduce + 0))

(def
  ^{::problem 25}
  filter-odd
  "Find the odd numbers"
  (partial filter odd?))

(def
  ^{::problem 26}
  fibonacci-seq
  "Fibonacci Sequence"
  (letfn [(fib [n]
            (condp = n
              1 '(1)
              2 '(1 1)
              (let [fib' (fib (dec n))]
                (conj fib' (+ (first fib') (second fib'))))))]
    (comp reverse fib)))

(def
  ^{::problem 27}
  palindrome?
  "Palindrome Detector
  Write a function which returns true if the sequence is a palindrome.
  Hint: \"racecar\" does not equal '(\\r \\a \\c \\e \\c \\a \\r)"
  (fn [coll]
    (let [coll-seq (seq coll)]
      (= coll-seq (reverse coll-seq)))))

(def
  ^{::problem 28}
  flatten'
  "Flatten a Sequence
  Write a function which flattens a sequence.
  Special Restrictions: flatten"
  (letfn [(flatten* [coll]
            (if (coll? coll)
              (when (seq coll)
                (concat (flatten* (first coll)) (flatten* (rest coll))))
              (list coll)))]
    flatten*))

(def
  ^{::problem 29}
  caps
  "Write a function which takes a string and returns a new string
  containing only the capital letters"
  (fn [s] (clojure.string/replace s #"[^A-Z]", "")))

(def
  ^{::problem 30}
  dedupe'
  "Write a function which removes consecutive duplicates from a sequence"
  (comp reverse
        (partial reduce
                 (fn [memo el]
                   (if (= (first memo) el)
                     memo
                     (conj memo el)))
                 '())))

(def
  ^{::problem 31}
  pack
  "Write a function which packs consecutive duplicates into sub-lists"
  (comp reverse
        (partial reduce
                 (fn [memo el]
                   (if (= (ffirst memo) el)
                     (conj (rest memo) (conj (first memo) el))
                     (conj memo (list el))))
                 '())))

(def
  ^{::problem 32}
  duplicate
  "Write a function which duplicates each element of a sequence."
  (partial reduce
           (fn [memo el]
             (-> memo
                 (conj el)
                 (conj el)))
           []))

(def
  ^{::problem 33}
  replicate'
  "Write a function which replicates each element of a
  sequence a variable number of times."
  (fn [xs n]
    (mapcat #(repeat n %) xs)))

(def
  ^{::problem 34}
  range'
  "Write a function which creates a list of all integers in a given range.
  Special Restrictions: `range`"
  (fn [start end]
    (take-while #(< % end) (iterate inc start))))

(def
  ^{::problem 39}
  interleave'
  "Write a function which takes two sequences and returns the first item
  from each, then the second item from each, then the third, etc."
  (fn [& xss]
    (apply (partial mapcat vector) xss)))

(def
  ^{::problem 40}
  interpose'
  "Write a function which separates the items of a sequence by an arbitrary value.
  Special Restrictions: interpose"
  (fn [sep xs]
    ((comp drop-last interleave) xs (repeat sep))))

(def
  ^{::problem 41}
  drop-nth
  "Write a function which drops every Nth item from a sequence."
  (fn [xs n]
    (apply concat (partition (dec n) n [] xs))))

(def
  ^{::problem 42}
  factorial'
  "Write a function which calculates factorials."
  (fn [n]
    (if (zero? n) 1 ;; unused
        (apply * (range 1 (inc n))))))

(def
  ^{::problem 43}
  reverse-interleave
  "Write a function which reverses the interleave process into x
  number of subsequences."
  ;; XXX There's *got* to be a better way to do this!
  (fn [xs n]
    (let [groups (group-by first (map-indexed (fn [i el] (list (rem i n) el)) xs))
          ks     (sort (keys groups))]
      (->> ks
           (map (fn [k] (map second (get groups k))))))))

(def
  ^{::problem 44}
  rotate'
  "Write a function which can rotate a sequence in either direction."
  (fn [i xs]
    (let [n     (count xs)
          i'    (rem i n)
          i''   (if (neg? i') (+ n i') i')
          [h t] (split-at i'' xs)]
      (concat t h))))

(def
  ^{::problem 53}
  longest-sub
  "Given a vector of integers, find the longest consecutive
  sub-sequence of increasing numbers. If two sub-sequences have
  the same length, use the one that occurs first. An increasing
   sub-sequence must have a length of 2 or greater to qualify."
  (fn [xs]
    (->> (partition 2 1 xs)
         (partition-by (partial apply <))
         (filter #(apply < (first %)))
         (reduce (fn [memo el]
                   (let [c (count el)]
                     (if (and (< (count memo) c)
                              (<= 1 c))
                       el
                       memo)))
                 [])
         ((fn [x]
            (concat (map first (butlast x)) (last x)))))))

(def
  ^{::problem 54}
  partition'
  "Write a function which returns a sequence of lists of x items
  each. Lists of less than x items should not be returned.
  Special Restrictions: partition, partition-all"
  (letfn [(p [n xs]
            (if (and (seq xs)
                     (<= n (count xs)))
              (conj (p n (drop n xs)) (take n xs))
              '()))]
    p))

(def
  ^{::problem 55}
  count-occurrences
  "Write a function which returns a map containing the
  number of occurences of each distinct item in a sequence."
  (fn [xs]
    (->> (group-by identity xs)
         (map (fn [[k v]] [k (count v)]))
         (into {}))))

(def
  ^{::problem 56}
  find-distinct
  "Write a function which removes the duplicates from
  a sequence. Order of the items must be maintained."
  (partial reduce (fn [memo el]
                    (if (some #(= el %) memo)
                      memo
                      (conj memo el))) []))

(def
  ^{::problem 58}
  comp'
  "Write a function which allows you to create function compositions.
  The parameter list should take a variable number of functions, and
  create a function that applies them from right-to-left.
  Special Restrictions: comp"
  (fn comp* [& fs]
    (let [f (first fs)
          r (rest fs)]
      (fn [& args]
        (if (seq r)
          (f (apply (apply comp* r) args))
          (apply f args))))))

(def
  ^{::problem              60
    ::difficulty           :medium
    ::topics               #{:seqs :core-functions}
    ::special-restrictions #{'reductions}}
  reductions'
  "Write a function which behaves like reduce, but returns each
  intermediate value of the reduction. Your function must accept
  either two or three arguments, and the return sequence must be
  lazy."
  (fn r
    ([f [init & xs]]
     (r f init xs))
    ([f memo [x & xs]]
     (let [memo' (f memo x)]
       (if (seq xs)
         (cons memo (lazy-seq (r f memo' xs)))
         (list memo memo'))))))

(def
  ^{::problem 66}
  brute-force-gcd
  "Given two integers, write a function which returns the greatest common divisor."
  (fn [& args]
    (let [[m & r :as sorted] (sort args)]
      (reduce (fn [memo el]
                (if (every? #(zero? (rem % el)) sorted)
                  el
                  memo))
              (range 1 (inc m))))))

(def
  ^{::problem 67}
  primes
  "Write a function which returns the first x number of prime numbers."
  (fn [n]
    (letfn [(prime? [x]
              (cond
                (= 2 x)   true
                (= 3 x)   true
                (even? x) false
                :else     (not (apply (some-fn zero?)
                                      (for [i (range 3 (inc (Math/sqrt x)) 2)]
                                        (rem x i))))))]
      (take n (filter prime? (drop 2 (range)))))))

(def
  ^{::problem 69}
  merge-with'
  "Write a function which takes a function f and a variable number of maps.
  Your function should return a map that consists of the rest of the maps
  conj-ed onto the first. If a key occurs in more than one map, the mapping(s)
  from the latter (left-to-right) should be combined with the mapping in the
  result by calling (f val-in-result val-in-latter)
  Special Restrictions: merge-with"
  (fn [f & ms]
    (reduce (fn [m k]
              (assoc m k (reduce f (remove nil? (map #(get % k) ms)))))
            {}
            (flatten (map keys ms)))))

(def
  ^{::problems 73}
  tic-tac-toe-win?
  "A tic-tac-toe board is represented by a two dimensional vector.
  X is represented by :x, O is represented by :o, and empty is
  represented by :e. A player wins by placing three Xs or three Os
  in a horizontal, vertical, or diagonal row. Write a function which
  analyzes a tic-tac-toe board and returns :x if X has won, :o if O
  has won, and nil if neither player has won."
  (fn [board]
    (let [rows (concat
                 board
                 (apply map vector board)
                 (list
                   (map-indexed (fn [i r] (nth r i)) board)
                   (map-indexed (fn [i r] (nth r i)) (reverse board))))]
      (some #{:x :o}
            (map #(when (apply = %) (first %))
                 rows)))))

(def
  ^{::problem 74}
  filter-perfect-squares
  "Given a string of comma separated integers, write a function
  which returns a new comma separated string that only contains
  the numbers which are perfect squares."
  (fn [s]
    (->> (clojure.string/split s #",")
         (map #(Integer/parseInt %))
         (filter #(let [r (Math/sqrt %)]
                    (= r (Math/floor r))))
         (clojure.string/join ","))))

(def
  ^{::problem    75
    ::difficulty :medium}
  totient
  "Two numbers are coprime if their greatest common divisor equals 1.
  Euler's totient function f(x) is defined as the number of positive
  integers less than x which are coprime to x. The special case f(1)
  equals 1. Write a function which calculates Euler's totient function."
  (fn [n]
    (if (= n 1)
      1
      (letfn [(gcd [a b]
                (if (zero? b)
                  a
                  (recur b (rem a b))))]
        (count (filter #(= 1 (gcd % n)) (range n)))))))

(def
  ^{::problem    77
    ::difficulty :medium}
  anagrams
  "Write a function which finds all the anagrams in a vector of words.
  A word x is an anagram of word y if all the letters in x can be
  rearranged in a different order to form y. Your function should
  return a set of sets, where each sub-set is a group of words which
  are anagrams of each other. Each sub-set should have at least two
  words. Words without any anagrams should not be included in the
  result."
  (fn [words]
    (->> words
         (group-by sort)
         vals
         (filter #(< 1 (count %)))
         (map set)
         (into #{}))))

(def
  ^{::problem              78
    ::difficulty           :medium
    ::topics               [:core-functions]
    ::special-restrictions ['trampoline]}
  trampoline'
  "Reimplement the function described in \"Intro to Trampoline\"."
  (fn t
    [f & args]
    (let [res (apply f args)]
      (if (fn? res)
        (t res)
        res))))

#_
(def
  ^{::problem    79
    ::difficulty :hard
    ::topcs      [:graph-theory]}
  triangle-minimal-path
  "Write a function which calculates the sum of the minimal path
  through a triangle. The triangle is represented as a collection of
  vectors. The path should start at the top of the triangle and move
  to an adjacent number on the next row until the bottom of the
  triangle is reached."
  (fn [xs]
    (-> (reduce (fn [memo el]
                  (map list el (partition 2 1 memo)))
                (reverse xs)))))

(def
  ^{::problem    80
    ::difficulty :medium}
  perfect?
  "A number is perfect if the sum of its divisors equal the number
  itself. 6 is a perfect number because 1+2+3=6. Write a function
  which returns true for perfect numbers and false otherwise."
  (fn [n]
    (let [divisors (for [i     (range 1 (inc (/ n 2)))
                         :when (zero? (rem n i))]
                     i)]
      (= n (reduce + divisors)))))

(def
  ^{::problem              81
    ::difficulty           :easy
    ::topics               [:set-theory]
    ::special-restrictions ['intersection]}
  intersection'
  "Write a function which returns the intersection of two sets. The
  intersection is the sub-set of items that each set has in common."
  (fn [f & sets]
    (reduce (fn [m e]
              (set (remove nil? (map #(some #{%} m) e))))
            f sets)))

(def
  ^{::problem    85
    ::difficulty :medium
    ::topcs      [:set-theory]}
  power-set
  "Write a function which generates the power set of a given set. The
  power set of a set x is the set of all subsets of x, including the
  empty set and x itself."
  (fn p [xs]
    (let [f (first xs)
          r (disj xs f)]
      (if (seq xs)
        (set (concat (map #(conj % f) (p r)) (p r)))
        #{#{}}))))

(def
  ^{::problem    86
    ::difficulty :medium
    ::topics     [:math]}
  happy?
  "Happy numbers are positive integers that follow a particular
  formula: take each individual digit, square it, and then sum the
  squares to get a new number. Repeat with the new number and
  eventually, you might get to a number whose squared sum is 1. This
  is a happy number. An unhappy number (or sad number) is one that
  loops endlessly. Write a function that determines if a number is
  happy or not."
  (fn h
    ([n]
     (h n #{}))
    ([n seen]
     (if (seen n)
       false
       (let [m (reduce + (map #(let [x (Integer/parseInt (str %))]
                                 (* x x))
                              (seq (str n))))]
         (if (= m 1)
           true
           (h m (conj seen n))))))))

(def
  ^{::problem    88
    ::difficulty :easy
    ::topics     [:set-theory]}
  symmetric-difference
  "Write a function which returns the symmetric difference of two
  sets. The symmetric difference is the set of items belonging to one
  but not both of the two sets."
  (fn [a b]
    (clojure.set/union
      (clojure.set/difference a b)
      (clojure.set/difference b a))))

(def
  ^{::problem    90
    ::difficulty :easy
    ::topics     [:set-theory]}
  cartesian-product
  "Write a function which calculates the Cartesian product of two sets."
  (fn [a b]
    (set (for [x a
               y b]
           [x y]))))

(def
  ^{::problem    92
    ::difficulty :hard
    ::topic      [:strings :math]}
  roman->dec
  "Roman numerals are easy to recognize, but not everyone knows all
  the rules necessary to work with them. Write a function to parse a
  Roman-numeral string and return the number it represents.

  You can assume that the input will be well-formed, in upper-case,
  and follow the [subtractive
  principle](http://en.wikipedia.org/wiki/Roman_numerals#Subtractive_principle).
  You don't need to handle any numbers greater than MMMCMXCIX (3999), the
  largest number representable with ordinary letters."
  (fn [s]
    (let [d       {\M 1000
                   \D 500
                   \C 100
                   \L 50
                   \X 10
                   \V 5
                   \I 1}
          [f & r] (map #(get d %) (seq s))]
      (->> (reduce (fn [memo e]
                     (if (< (first memo) e)
                       (conj (rest memo) (- e (first memo)))
                       (conj memo e)))
                   (list f)
                   r)
           (reduce +)))))

(def
  ^{::problem    93
    ::difficulty :medium
    ::topic      [:seqs]}
  partial-flatten
  "Write a function which flattens any nested combination of
  sequential things (lists, vectors, etc.), but maintains the lowest
  level sequential items. The result should be a sequence of sequences
  with only one level of nesting."
  (fn [xs]
    (letfn [(unnest [[f & r :as coll]]
              (if (coll? f)
                (if (seq r)
                  (mapcat unnest coll)
                  (unnest f))
                (list coll)))]
      (reduce (fn [ret e]
                (concat ret (unnest e))) (list) xs))))

(def
  ^{::problem    95
    ::difficulty :easy
    ::topics     [:trees]}
  binary-tree?
  "Write a predicate which checks whether or not a given sequence
  represents a [binary tree](https://en.wikipedia.org/wiki/Binary_tree).
  Each node in the tree must have a value, a left child, and a right child."
  (fn t? [xs]
    (if (coll? xs)
      (and (= 3 (count xs))
           (let [[_ a b] xs]
             (and (t? a) (t? b))))
      ;; not sure why false isn't a valid value for a leaf,
      ;; but this is necessary to reject [1 [2 [3 [4 false nil] nil] nil] nil]
      ;; as not a tree
      (not (false? xs)))))

(def
  ^{::problem    96
    ::difficulty :easy
    ::topics     [:trees]}
  symmetric?
  "Let us define a binary tree as \"symmetric\" if the left half of the
  tree is the mirror image of the right half of the tree. Write a
  predicate to determine whether or not a given binary tree is
  symmetric. (see [To Tree, or not to
  Tree](http://www.4clojure.com/problem/95) for a reminder on the tree
  representation we're using)."
  (fn [[_ a b]]
    (letfn [(mirror [t]
              (if (coll? t)
                (let [[h a b] t]
                  [h (mirror b) (mirror a)])
                t))]
      (= a (mirror b)))))

(def
  ^{::problem    97
    ::difficulty :easy}
  pascals-triangle-row
  "[Pascal's triangle](https://en.wikipedia.org/wiki/Pascal%27s_triangle)
  is a triangle of numbers computed using the following rules:

  - The first row is 1.
  - Each successive row is computed by adding together adjacent
    numbers in the row above, and adding a 1 to the beginning and
    end of the row.

  Write a function which returns the nth row of Pascal's Triangle."
  (fn [n]
    (letfn [(next-row [r]
              (condp = r
                []  [1]
                [1] [1 1]
                (vec (concat [1] (map #(apply + %) (partition 2 1 r)) [1]))))]
      (nth (iterate next-row []) n))))

(def
  ^{::problem    98
    ::difficulty :medium}
  equivalence-classes
  "A function f defined on a domain D induces an [equivalence
  relation](http://en.wikipedia.org/wiki/Equivalence_relation) on D,
  as follows: a is equivalent to b with respect to f if and only if (f
  a) is equal to (f b). Write a function with arguments f and D that
  computes the [equivalence
  classes](http://en.wikipedia.org/wiki/Equivalence_class) of D with
  respect to f."
  (fn [f xs]
    (->> (group-by f xs)
         vals
         (map set)
         set)))

(comment
  (defn int-lcm
    [coll]
    (->> (range)
         (filter (fn [n]
                   (every? #(zero? (rem n %)) coll)))
         second))
  )

(def
  ^{::problem    100
    ::difficulty :easy
    ::topics     #{:math}}
  brute-force-lcm
  "Write a function which calculates the [least common
  multiple](http://en.wikipedia.org/wiki/Least_common_multiple). Your
  function should accept a variable number of positive integers or
  ratios."
  ;; https://www.edugain.com/articles/6/LCM-of-Fractions
  (fn [& args]
    (let [lcm   (fn [coll]
                  (->> (range)
                       (filter (fn [n]
                                 (every? #(zero? (rem n %)) coll)))
                       second))
          rats  (map #(if (ratio? %) [(numerator %) (denominator %)] [% 1]) args)
          lcd   (lcm (map second rats))
          rats' (map (fn [[n d]] [(* n (/ lcd d)) lcd]) rats)
          num   (lcm (map first rats'))]
      (/ num lcd))))

(def
  ^{::problem    103
    ::difficulty :medium
    ::topics     #{:seqs :combinatorics}}
  k-combos
  "Given a sequence S consisting of n elements generate all
  [k-combinations](https://secure.wikimedia.org/wikipedia/en/wiki/Combination)
  of S, i. e. generate all possible sets consisting of k distinct
  elements taken from S. The number of k-combinations for a sequence
  is equal to the [binomial
  coefficient](https://secure.wikimedia.org/wikipedia/en/wiki/Binomial_coefficient)."
  (fn [n xs]
    (letfn [(power-set [xs]
              (let [f (first xs)
                    r (disj xs f)]
                (if (seq xs)
                  (set (concat (map #(conj % f) (power-set r))
                               (power-set r)))
                  #{#{}})))]
      (set (filter #(= n (count %)) (power-set xs))))))

(def
  ^{::problem    104
    ::difficulty :medium
    ::topics     #{:strings :math}}
  dec->roman
  "This is the inverse of [Problem
  92](http://www.4clojure.com/problem/92), but much easier. Given an
  integer smaller than 4000, return the corresponding roman numeral in
  uppercase, adhering to the [subtractive
  principle](http://www.numericana.com/answer/roman.htm#valid)."
  (fn [n]
    (let [ds [[1000 "M"],
              [900  "CM"],
              [500  "D"],
              [400  "XD"],
              [100  "C"],
              [90   "XC"],
              [50   "L"],
              [40   "XL"],
              [10   "X"],
              [9    "IX"]
              [5    "V"],
              [4    "IV"]
              [1    "I"]]]
      (->>
        (loop [r    n
               ds   ds
               coll []]
          (if (zero? r)
            coll
            (let [[m d] (first ds)]
              (if (< r m)
                (recur r (rest ds) coll)
                (recur (- r m) ds (conj coll d))))))
        (apply str)))))

(def
  ^{::problem    108
    ::difficulty :medium
    ::topics     #{:seqs :sorting}}
  lazy-search
  "Given any number of sequences, each sorted from smallest to
  largest, find the smallest single number which appears in all of the
  sequences. The sequences may be infinite, so be careful to search
  lazily."
  (fn ls [& xss]
    (let [firsts (map first xss)]
      (if (apply = firsts)
        (first firsts)
        (let [m (apply max firsts)]
          (apply ls (map #(drop-while (partial > m) %) xss)))))))

(def
  ^{::problem    110
    ::difficulty :medium
    ::topics     #{:seqs}}
  pronunciations
  "Write a function that returns a lazy sequence of \"pronunciations\"
  of a sequence of numbers. A pronunciation of each element in the
  sequence consists of the number of repeating identical numbers and
  the number itself. For example, [1 1] is pronounced as [2 1] (\"two
  ones\"), which in turn is pronounced as [1 2 1 1] (\"one two, one
  one\").

  Your function should accept an initial sequence of numbers, and return
  an infinite lazy sequence of pronunciations, each element being a
  pronunciation of the previous element."
  (fn [init]
    (next (iterate #(->> (partition-by identity %)
                         (mapcat (fn [x] [(count x) (first x)]))
                         vec) init))))

(def
  ^{::problem    111
    ::difficulty :hard
    ::topics     #{:game}}
  xword-fits?
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
  (fn [w p]
    (let [wc (count w)
          ws (seq w)
          p' (map (fn [r]
                    (->> (seq r)
                         (filter #(not= \space %)))) p)]
      (->> (concat p' (apply map vector p'))
           (mapcat #(partition-by (fn [e] (= \# e)) %))
           (filter #(= (count %) wc))
           (some (fn [r] (->> (map list r ws)
                              (every? (fn [[x l]]
                                        (or (= x \_)
                                            (= x l)))))))
           boolean))))

(def
  ^{::problem    114
    ::difficulty :medium
    ::topics     #{:seqs :higher-order-functions}}
  global-take-while
  "[take-while](http://clojuredocs.org/clojure_core/clojure.core/take-while)
  is great for filtering sequences, but it limited: you
  can only examine a single item of the sequence at a time. What if
  you need to keep track of some state as you go over the sequence?

  Write a function which accepts an integer n, a predicate p, and a
  sequence. It should return a lazy sequence of items in the list up
  to, but not including, the nth item that satisfies the predicate."
  (fn tw
    [n p [a & r]]
    (when a
      (let [n' (if (p a) (dec n) n)]
        (when (pos? n')
          (cons a (lazy-seq (tw n' p r))))))))

(def
  ^{::problem    116
    ::difficulty :medium
    ::topics     #{:math}}
  balanced-prime?
  "A [balanced prime](http://en.wikipedia.org/wiki/Balanced_prime) is
  a prime number which is also the mean of the primes directly before
  and after it in the sequence of valid primes. Create a function
  which takes an integer n, and returns true iff it is a balanced
  prime."
  (let [prime? (fn [x]
                 (cond
                   (> 2 x)
                   false

                   (#{2 3 5 7 11 13 17 19 23 29
                      31 37 41 43 47 53 59 61 67 71
                      73 79 83 89 97 101 103 107 109 113
                      127 131 137 139 149 151 157 163 167 173
                      179 181 191 193 197 199 211 223 227 229} x)
                   true

                   (even? x)
                   false

                   :else
                   (empty? (for [i     (range 3 (inc (Math/sqrt x)) 2)
                                 :when (zero? (rem x i))]
                             i))))
        m-prime? (memoize prime?)]
    (fn [n]
      (let []
        (and (m-prime? n)
             (if-let [prev-prime (first (for [d     (range n) ;;   = n - next-prime + n
                                              :let  [p (- n (inc d))]
                                              :when (m-prime? p)]
                                          p))]
               (let [maybe-next-prime (- (* 2 n) prev-prime)]
                 (and (m-prime? maybe-next-prime)
                      (= maybe-next-prime (first (for [x     (drop
                                                               (inc n)
                                                               (range (inc maybe-next-prime)))
                                                       :when (m-prime? x)]
                                                   x)))))
               false))))))

(def
  ^{::problem              118
    ::difficulty           :easy
    ::topics               #{:core-seqs}
    ::special-restrictions #{'map 'map-indexed 'mapcat 'for}}
  map'
  "Map is one of the core elements of a functional programming
  language. Given a function f and an input sequence s, return a lazy
  sequence of (f x) for each element x in s."
  (fn [f xs] (reductions #(f %2) (f (first xs)) (rest xs))))

(def
  ^{::problem    119
    ::difficulty :hard
    ::topics     #{:game}}
  tic-tac-toe-wins
  "As in [Problem 73](http://www.4clojure.com/problem/73), a
  tic-tac-toe board is represented by a two dimensional vector. X is
  represented by :x, O is represented by :o, and empty is represented
  by :e. Create a function that accepts a game piece and board as
  arguments, and returns a set (possibly empty) of all valid board
  placements of the game piece which would result in an immediate win.

  Board coordinates should be as in calls to get-in. For example, [0
  1] is the topmost row, center position."
  (fn [p b]
    (let [ab   (map-indexed (fn [i r]
                              (map-indexed
                                (fn [j p] {:pos [i j] :p p}) r)) b)
          rows (concat ab
                       (apply map vector ab)
                       (list
                         (map-indexed (fn [i r] (nth r i)) ab)
                         (map-indexed (fn [i r] (nth r i)) (reverse ab))))]
      (->> (filter (fn [r]
                     (= {p 2 :e 1} (frequencies (map :p r))))
                   rows)
           (map (fn [r] (:pos (first (filter #(= :e (:p %)) r)))))
           set))))

(def
  ^{::problem              121
    ::difficulty           :medium
    ::topics               #{:functions}
    ::special-restrictions #{'eval 'resolve}}
  puter
  "Given a mathematical formula in prefix notation, return a function
  that calculates the value of the formula. The formula can contain
  nested calculations using the four basic mathematical operators,
  numeric constants, and symbols representing variables. The returned
  function has to accept a single parameter containing the map of
  variable names to their values."
  (fn [es]
    (fn [m]
      (letfn [(a [e]
                (if (list? e)
                  (let [[f & args] e
                        res        (map a args)]
                    (apply ({'+ +, '- -, '/ /, '* *} f) res))
                  (get m e e)))]
        (a es)))))
(def
  ^{::problem    122
    ::difficulty :easy}
  binary->dec
  "Convert a binary number, provided in the form of a string, to its
  numerical value."
  (fn [s]
    (->> (reverse s)
         (map-indexed (fn [i c]
                        (* (Integer/parseInt (str c)) (Math/pow 2 i))))
         (reduce +)
         int)))

(def
  ^{::problems   128
    ::difficulty :easy
    ::topics     #{:strings :game}}
  playing-card
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
  (fn [[suit rank]]
    {:suit (get {\S :spade, \D :diamond, \H :heart, \C :club} suit)
     :rank (if-let [r (get {\A 12, \K 11, \Q 10, \J 9, \T 8} rank)]
             r
             (- (Integer/parseInt (str rank)) 2))}))

(def
  ^{::problem    132
    ::difficulty :medium
    ::topics     #{:seqs :core-functions}}
  insert-pred
  "Write a function that takes a two-argument predicate, a value, and
  a collection; and returns a new collection where the value is
  inserted between every two items that satisfy the predicate."
  (fn ip [p v [a b & r :as xs]]
    (if (seq xs)
      (cons a (if (and b (p a b))
                (cons v (lazy-seq (ip p v (next xs))))
                (lazy-seq (ip p v (next xs))))))))

(def
  ^{::problem    141
    ::difficulty :medium
    ::topics     #{:game :cards}}
  trick-winner
  "In [trick-taking card
  games](http://en.wikipedia.org/wiki/Trick-taking_game) such as
  bridge, spades, or hearts, cards are played in groups known as
  \"tricks\" - each player plays a single card, in order; the first
  player is said to \"lead\" to the trick. After all players have
  played, one card is said to have \"won\" the trick. How the winner is
  determined will vary by game, but generally the winner is the
  highest card played in the suit that was led. Sometimes (again
  varying by game), a particular suit will be designated \"trump\",
  meaning that its cards are more powerful than any others: if there
  is a trump suit, and any trumps are played, then the highest trump
  wins regardless of what was led.

  Your goal is to devise a function that can determine which of a
  number of cards has won a trick. You should accept a trump suit, and
  return a function winner. Winner will be called on a sequence of
  cards, and should return the one which wins the trick. Cards will be
  represented in the format returned by [Problem 128, Recognize
  Playing Cards](http://www.4clojure.com/problem/128/): a hash-map of
  :suit and a numeric :rank. Cards with a larger rank are stronger."
  (fn [trump]
    (fn [xs]
      (let [res (reduce (fn [memo {:keys [rank suit]}]
                          (cond
                            (and (= suit trump)
                                 (> rank (:trump memo 0)))
                            (assoc memo :trump rank)

                            (and (= suit (:suit memo))
                                 (> rank (:rank memo)))
                            (assoc memo :rank rank)

                            :else memo))
                        xs)]
        (if-let [rank (:trump res)]
          {:suit trump, :rank rank}
          (select-keys res [:suit :rank]))))))

(def
  ^{::problem    146
    ::difficulty :easy
    ::topics     #{:seqs :maps}}
  tree->table
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
  (fn [m]
    (->>
      (for [[k mv]  m
            [ik iv] mv]
        [[k ik] iv])
      (into {}))))

(def
  ^{::problem    147
    ::difficulty :easy
    ::topics     #{:seqs}}
  pascals-triangle-rows
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
  (fn [r]
    (letfn [(next-row [p]
              (condp = (count p)
                0 [1]
                1 [(first p) (first p)]
                (let [f (first p)
                      l (last p)]
                  (vec (concat [f] (map #(apply +' %) (partition 2 1 p)) [l])))) )]
      (iterate next-row r))))

(def
  ^{::problem    153
    ::difficulty :easy
    ::topics     #{:set-theory}}
  pairwise-disjoint?
  "Given a set of sets, create a function which returns true if no two
  of those sets have any elements in common<sup>1</sup> and false
  otherwise. Some of the test cases are a bit tricky, so pay a little
  more attention to them.

  <sup>1</sup>Such sets are usually called *pairwise disjoint* or
  *mutually disjoint*."
  (fn d [sets]
    (let [f (first sets)
          r (disj sets f)]
      (if (seq r)
        (and (reduce (fn [m el]
                       (-> (clojure.set/intersection f el)
                           empty?
                           (and m)
                           boolean))
                     true r)
             (d r))
        true))))

(def
  ^{::problem    171
    ::difficulty :medium}
  compact-intervals
  "Write a function that takes a sequence of integers and returns a
  sequence of \"intervals\". Each interval is a a vector of two
  integers, start and end, such that all integers between start and
  end (inclusive) are contained in the input sequence."
  (fn [xs]
    (->> xs
         distinct
         sort
         (reduce (fn [ret e]
                   (if-let [curr (ffirst ret)]
                     (if (= (inc curr) e)
                       (conj (rest ret) (conj (first ret) e))
                       (conj ret (list e)))
                     (conj ret (list e))))
                 '())
         reverse
         (map (juxt (partial apply min) (partial apply max))))))

(def
  ^{::problem    177
    ::difficulty :medium
    ::topics     #{:parsing}}
  balanced?
  "When parsing a snippet of code it's often a good idea to do a
  sanity check to see if all the brackets match up. Write a function
  that takes in a string and returns truthy if all square [ ]
  round ( ) and curly { } brackets are properly paired and legally nested,
  or returns falsey otherwise."
  (fn balanced? [s]
    (loop [last-l (inc (count s))
           s      (clojure.string/replace s #"[^]\[{}()]" "")]
      (let [l (count s)]
        (if (< l last-l)
          (recur l (clojure.string/replace s #"\(\)|\[\]|\{\}" ""))
          (zero? l))))))

(def
  ^{::problem    178
    ::difficulty :hard
    ::topics     #{:strings :game}}
  best-hand
  "Following on from [Recognize Playing
  Cards](http://www.4clojure.com/problem/128), determine the best
  poker hand that can be made with five cards. The hand rankings are
  listed below for your convenience.

  1. Straight flush: All cards in the same suit, and in sequence

  2. Four of a kind: Four of the cards have the same rank

  3. Full House: Three cards of one rank, the other two of another
     rank

  4. Flush: All cards in the same suit

  5. Straight: All cards in sequence (aces can be high or low, but not
     both at once)

  6. Three of a kind: Three of the cards have the same rank

  7. Two pair: Two pairs of cards have the same rank

  8. Pair: Two cards have the same rank

  9. High card: None of the above conditions are met"
  (fn [cs]
    (letfn [(straight? [cs]
              (let [ranks  (sort (map :rank cs))
                    ranks' (sort (map #(if (= % 12) -1 %) ranks))]
                (or (and (apply < ranks)
                         (= 4 (- (last ranks)
                                 (first ranks))))
                    (and (apply < ranks')
                         (= 4 (- (last ranks')
                                 (first ranks')))))))
            (grouped-rank-counts [cs]
              (->> (group-by :rank cs)
                   vals
                   (map count)
                   sort))]
      (->> (map (fn [[s r]]
                  {:suit ({\D :diamond, \H :heart, \C :club, \S :spade} s)
                   :rank (get (zipmap "23456789TJQKA" (range)) r)}) cs)
           ((fn [cs]
              (cond
                (and (apply = (map :suit cs))
                     (straight? cs))
                :straight-flush

                (->> (grouped-rank-counts cs)
                     last
                     (= 4))
                :four-of-a-kind

                (->> (grouped-rank-counts cs)
                     (= [2 3]))
                :full-house

                (apply = (map :suit cs))
                :flush

                (straight? cs)
                :straight

                (->> (grouped-rank-counts cs)
                     last
                     (= 3))
                :three-of-a-kind

                (->> (grouped-rank-counts cs)
                     reverse
                     (take 2)
                     (= [2 2]))
                :two-pair

                (->> (group-by :rank cs)
                     vals
                     count
                     (= 4))
                :pair

                :else :high-card)))))))
