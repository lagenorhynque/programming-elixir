(def list-concat
  (fn [xs ys] (concat xs ys)))
(list-concat [:a :b] [:c :d])

(def sum
  (fn [x y z] (+ x y z)))
(sum 1 2 3)

(def pair-tuple->list
  (fn [[x y]] (list x y)))
(pair-tuple->list [1234 5678])
