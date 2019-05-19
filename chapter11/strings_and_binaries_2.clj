(ns strings-and-binaries-2)

(defn anagram? [word1 word2]
  (= (sort word1) (sort word2)))
