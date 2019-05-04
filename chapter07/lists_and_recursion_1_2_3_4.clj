(ns lists-and-recursion-1-2-3-4)

(defn- -mapsum [f acc [head & tail :as coll]]
  (if (empty? coll)
    acc
    (recur f (+ (f head) acc) tail)))

(defn mapsum [f coll]
  (-mapsum f 0 coll))

(defn- -max [acc [head & tail :as coll]]
  (cond
    (empty? coll) acc
    (> head acc) (recur head tail)
    :else (recur acc tail)))

(defn max' [[head & tail]] (-max head tail))

(defn caesar [[head & tail :as s] n]
  (cond
    (empty? s) ""

    (> (+ (int head) n) (int \z))
    (str (char (- (+ (int head) n)
                  (inc (- (int \z) (int \a)))))
         (caesar tail n))

    :else (str (char (+ (int head) n))
               (caesar tail n))))

(defn span [from to]
  (if (> from to)
    ()
    (cons from (span (inc from) to))))
