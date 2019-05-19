(ns strings-and-binaries-4
  (:require [clojure.string :as str]))

(defn calculate [s]
  (letfn [(-calculate [x op y]
            (case op
              "+" (+ x y)
              "-" (- x y)
              "*" (* x y)
              "/" (/ x y)))]
    (let [[x op y] (str/split s #"\s+")]
      (-calculate (Long/parseLong x) op (Long/parseLong y)))))
