(ns strings-and-binaries-5
  (:require [clojure.string :as str]))

(defn center [ss]
  (let [lengths (map count ss)
        max-length (apply max lengths)]
    (->> ss
         (map (fn [s]
                (let [length (count s)
                      pad-size (quot (- max-length length) 2)]
                  (->> (concat (repeat pad-size \space) (seq s) (repeat \space))
                       (take max-length)
                       str/join))))
         (run! println))))
