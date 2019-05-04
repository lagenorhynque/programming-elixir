(ns modules-and-functions-1-2-3)

(defn double' [n]
  (* n 2))

(defn triple [n]
  (* n 3))

(defn quadruple [n]
  (double' (double' n)))
