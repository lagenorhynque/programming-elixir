(ns modules-and-functions-5)

(defn gcd [x y]
  (if (zero? y)
    x
    (recur y (rem x y))))
