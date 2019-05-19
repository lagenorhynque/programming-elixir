(ns strings-and-binaries-7
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(def default-order-file
  "./order.csv")

(defn- csv-row->cols [row]
  (-> row str/trim (str/split #",")))

(defn- columns->order [header-cols [id [_ & ship-to] net-amount]]
  (zipmap header-cols
          [(Long/parseLong id) (keyword (str/join ship-to)) (Double/parseDouble net-amount)]))

(defn read-from-csv
  ([] (read-from-csv default-order-file))
  ([order-file]
   (try
     (with-open [rdr (io/reader order-file)]
       (let [[header & rows] (line-seq rdr)
             header-cols (->> header csv-row->cols (map keyword))]
         (doall (map #(->> % csv-row->cols (columns->order header-cols)) rows))))
     (catch java.io.FileNotFoundException _
       (println "No such file found:" order-file)))))
