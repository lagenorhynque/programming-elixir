(ns strings-and-binaries-1)

(defn printable-ascii-characters? [s]
  (every? #(<= (int \space) (int %) (int \~)) s))
