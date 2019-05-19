(ns lists-and-recursion-7)

(defn- span [from to]
  (if (> from to)
    ()
    (cons from (span (inc from) to))))

(defn primes [n]
  (for [x (span 2 n)
        :when (every? #(not (zero? (rem x %)))
                      (span 2 (Math/sqrt x)))]
    x))
