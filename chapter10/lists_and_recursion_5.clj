(ns lists-and-recursion-5
  (:refer-clojure :exclude [every? filter run! split-at take]))

(defn every? [pred coll]
  (if (empty? coll)
    true
    (and (boolean (pred (first coll)))
         (recur pred (rest coll)))))

(defn run! [proc coll]
  (when (seq coll)
    (proc (first coll))
    (recur proc (rest coll))))

(defn filter [pred coll]
  (lazy-seq
   (when-let [[head & tail] (seq coll)]
     (if (pred head)
       (cons head (filter pred tail))
       (filter pred tail)))))

(defn split-at [n [head & tail :as coll]]
  (cond
    (empty? coll) [() ()]
    (not (pos? n)) [() (seq coll)]
    :else (let [[fst snd] (split-at (dec n) tail)]
            [(cons head fst) snd])))

(defn take [n coll]
  (lazy-seq
   (when (and (pos? n) (seq coll))
     (cons (first coll) (take (dec n) (rest coll))))))
