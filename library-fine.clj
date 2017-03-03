(use '[clojure.string :only (split)])

(let [actual-return-date (map #(Integer/parseInt %) (split (read-line) #"\s+"))
      actual-return-day (nth actual-return-date 0)
      actual-return-month (nth actual-return-date 1)
      actual-return-year (nth actual-return-date 2)
      expected-return-date (map #(Integer/parseInt %) (split (read-line) #"\s+"))
      expected-return-day (nth expected-return-date 0)
      expected-return-month (nth expected-return-date 1)
      expected-return-year (nth expected-return-date 2)]

  (when (and
    (>= actual-return-day 1) (<= actual-return-day 31)
    (>= expected-return-day 1) (<= expected-return-day 31)
    (>= actual-return-month 1) (<= actual-return-month 12)
    (>= expected-return-month 1) (<= expected-return-month 12)
    (>= actual-return-year 1) (<= actual-return-year 3000)
    (>= expected-return-year 1) (<= expected-return-year 3000))

    (cond
      (> actual-return-year expected-return-year)
        (println 10000)
      (and (= actual-return-year expected-return-year)
        (> actual-return-month expected-return-month))
        (println (* 500 (- actual-return-month expected-return-month)))
      (and (= actual-return-year expected-return-year)
        (= actual-return-month expected-return-month)
        (> actual-return-day expected-return-day))
        (println (* 15 (- actual-return-day expected-return-day)))
      :else (println 0))))
