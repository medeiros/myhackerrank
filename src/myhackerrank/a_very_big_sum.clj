(use '[clojure.string :only (split)])

(let [n (read-string (read-line))
      elements (mapv #(Long/parseLong %) (split (read-line) #"\s+"))]
  (when (and (>= n 1) (<= n 10))
    (println (reduce + (subvec elements 0 n)))))
