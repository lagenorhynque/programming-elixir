(def ->fizzbuzz
  (fn [rem3 rem5 n]
    (cond
      (and (zero? rem3) (zero? rem5)) "FizzBuzz"
      (zero? rem3) "Fizz"
      (zero? rem5) "Buzz"
      :else n)))

(def fizzbuzz
  (fn [n] (->fizzbuzz (rem n 3) (rem n 5) n)))
