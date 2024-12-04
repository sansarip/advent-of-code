(ns advent-of-code.day1.part2 
  (:require
    [advent-of-code.day1.utils :as utils]))

(defn num-occurrences [n numbers]
  (count (filter #(= n %) numbers)))

(defn sum-similarity-scores [[left right]]
  (apply + (map (fn [n] (* n (num-occurrences n right))) left)))

(defn solve-part-2* [input]
  (-> input
      (utils/parse-numbers)
      (utils/partition-numbers)
      sum-similarity-scores))

(defn solve-part-2 [input-path]
  (solve-part-2* (slurp input-path)))

(comment
  (solve-part-2* "3 4\n4 3\n2 5\n1 3\n3 9\n3 3"))
