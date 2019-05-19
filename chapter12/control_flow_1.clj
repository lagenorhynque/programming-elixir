(ns control-flow-1)

(defn- fizzbuzz [n]
  (let [fizz? (zero? (rem n 3))
        buzz? (zero? (rem n 5))]
    (cond
      (and fizz? buzz?) "FizzBuzz"
      fizz? "Fizz"
      buzz? "Buzz"
      :else n)))

(defn upto [n]
  (when (pos? n) (map fizzbuzz (range 1 (inc n)))))
