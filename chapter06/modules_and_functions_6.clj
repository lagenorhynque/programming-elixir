(ns modules-and-functions-6)

(defn- average [min max]
  (quot (+ min max) 2))

(defn- helper [actual min max expected]
  (cond
    (< actual expected)
    (do (println "Is it" expected)
        (recur actual min (dec expected) (average min (dec expected))))

    (> actual expected)
    (do (println "Is it" expected)
        (recur actual (inc expected) max (average (inc expected) max)))

    :else expected))

(defn guess [actual min max]
  (helper actual min max (average min max)))
