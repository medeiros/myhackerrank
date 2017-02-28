(let [n (read-string (read-line))]
  (dotimes [i n]
    (println (format (str \% n \s) (apply str (repeat (inc i) "#"))))))
