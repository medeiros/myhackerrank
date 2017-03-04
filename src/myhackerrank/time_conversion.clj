(use '[clojure.string :only (split)])

(defn print-time [hh mm ss]
  (println (str (format "%02d" hh) ":" (format "%02d" mm) ":" (format "%02d" ss))))

(let [time (split (read-line) #"\:")
      hour (Integer/parseInt (nth time 0))
      minute (Integer/parseInt (nth time 1))
      second (Integer/parseInt (subs (nth time 2) 0 2))
      type (subs (nth time 2) 2 4)]
  (when (and (>= hour 1) (<= hour 12)
             (>= minute 0) (<= minute 59)
             (>= second 0) (<= second 59))
    (cond
      (and (= type "AM") (= hour 12)) (print-time 0 minute second)
      (and (= type "PM") (= hour 12)) (print-time 12 minute second)
      (= type "PM") (print-time (+ 12 hour) minute second)
      :else (print-time hour minute second))))
