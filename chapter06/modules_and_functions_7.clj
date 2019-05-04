(format "%.2f" Math/PI)

(second (re-matches #".*(\..+)$" "dave/test.exs"))

(-> (java.nio.file.Paths/get "." (into-array String []))
    .toAbsolutePath
    .normalize
    str)

;; https://github.com/dakrone/cheshire

(clojure.java.shell/sh "ls")
