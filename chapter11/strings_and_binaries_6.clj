(ns strings-and-binaries-6
  (:require [clojure.string :as str]))

(defn capitalize-sentences
  ([s] (capitalize-sentences s ". "))
  ([s separator]
   (->> (str/split s (re-pattern separator) -1)
        (map str/capitalize)
        (str/join separator))))
