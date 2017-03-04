(use '[clojure.string :only (split)])

(defn print-data [arr pos total]
  (println (format "%.5f" (double (/ (nth arr pos) total)))))

(defn inc-element [vec pos]
  (assoc vec pos (inc (nth vec pos))))

(let [size-array (read-string (read-line))
      array-numbers (map #(Integer/parseInt %) (split (read-line) #"\s+"))]
  (loop [result [0 0 0] array array-numbers]
    (if (not (seq array))
      (do
        (print-data result 0 size-array)
        (print-data result 1 size-array)
        (print-data result 2 size-array))
      (cond
        (> (first array) 0) (recur (inc-element result 0) (rest array))
        (< (first array) 0) (recur (inc-element result 1) (rest array))
        :else (recur (inc-element result 2) (rest array))))))
