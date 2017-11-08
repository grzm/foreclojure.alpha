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
