(ns lists-and-recursion-8)

(def default-orders
  [{:id 123, :ship-to :NC, :net-amount 100.00}
   {:id 124, :ship-to :OK, :net-amount 35.50}
   {:id 125, :ship-to :TX, :net-amount 24.00}
   {:id 126, :ship-to :TX, :net-amount 44.80}
   {:id 127, :ship-to :NC, :net-amount 25.00}
   {:id 128, :ship-to :MA, :net-amount 10.00}
   {:id 129, :ship-to :CA, :net-amount 102.00}
   {:id 130, :ship-to :NC, :net-amount 50.00}])

(def default-tax-rates
  {:NC 0.075, :TX 0.08})

(defn orders-with-tax
  ([] (orders-with-tax default-orders default-tax-rates))
  ([orders tax-rates]
   (for [{:keys [ship-to net-amount]
          :as order} orders]
     (let [total-amount (if (get tax-rates ship-to)
                          (* net-amount (inc (get tax-rates ship-to)))
                          net-amount)]
       (assoc order :total-amount total-amount)))))
