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
