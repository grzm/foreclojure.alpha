(ns com.grzm.foreclojure.alpha)

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
            (concat (map first (butlast x)) (last x))))))
  )

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

#_(def
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
