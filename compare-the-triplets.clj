(use '[clojure.string :only (split)])

(let [alice-scores (map #(Integer/parseInt %) (split (read-line) #"\s+"))
      bob-scores (map #(Integer/parseInt %) (split (read-line) #"\s+"))
      result [0 0]]

  (when (and
    (>= (count alice-scores) 1) (<= (count alice-scores) 100)
    (>= (count bob-scores) 1) (<= (count bob-scores) 100))

    (loop [alice alice-scores, bob bob-scores res result]
      (if (or (not (seq alice)) (not (seq bob)))
        (println (str (nth res 0) " " (nth res 1)))
        (cond
          (> (first alice) (first bob))
            (recur (rest alice) (rest bob) (assoc res 0 (inc (nth res 0))))
          (< (first alice) (first bob))
            (recur (rest alice) (rest bob) (assoc res 1 (inc (nth res 1))))
          :else
            (recur (rest alice) (rest bob) res))))))
