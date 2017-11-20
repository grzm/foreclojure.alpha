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

#_
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
    (letfn [(unnest [coll]
              (if (some coll? coll)
                (map unnest coll)
                coll))]
      (mapcat unnest xs))))

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
