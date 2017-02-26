(use '[clojure.string :only (split)])

(let [n_t (read-line)
      n (Integer/parseInt n_t)]
  (let [arr_temp (read-line)
        arr_t (split arr_temp #"\s+")
        arr (mapv #(Integer/parseInt %) arr_t)
        arr_sub (subvec arr 0 n)]
    (println (reduce + arr_sub))))
