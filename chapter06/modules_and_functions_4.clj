(ns modules-and-functions-4)

(defn sum [n]
  (if (zero? n)
    0
    (+ n (sum (dec n)))))
