(use '[clojure.string :only (split)])

(defn abs [n]
  (cond
    (neg? n) (- n)
    :else n))

(let [matrix-size (read-string (read-line))]
  (loop [result [0 0] row-n 0 pos-idx 0 neg-idx (dec matrix-size)]
    (if (< row-n matrix-size)
      (let [data (map #(Integer/parseInt %) (split (read-line) #"\s+"))]
        (recur
          (assoc
            (assoc result 0 (+ (nth data pos-idx) (nth result 0)))
            1 (+ (nth data neg-idx) (nth result 1)))
          (inc row-n)
          (inc pos-idx)
          (dec neg-idx)))
      (println (abs (- (nth result 0) (nth result 1)))))))
