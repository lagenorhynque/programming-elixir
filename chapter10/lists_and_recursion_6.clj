(ns lists-and-recursion-6
  (:refer-clojure :exclude [flatten]))

(defn flatten [coll]
  (letfn [(-flatten [acc [head & tail :as coll]]
            (cond
              (empty? coll) (reverse acc)
              (sequential? head) (concat (-flatten acc head)
                                         (-flatten () tail))
              :else (-flatten (cons head acc) tail)))]
    (-flatten () coll)))
