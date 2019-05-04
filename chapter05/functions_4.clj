(def prefix
  (fn [p]
    (fn [s] (str p " " s))))

(def mrs (prefix "Mrs"))
(mrs "Smith")
((prefix "Elixir") "Rocks")
