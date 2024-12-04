(ns advent-of-code.day1.utils)

(defn parse-numbers [input]
  (map #(Integer/parseInt %) (re-seq #"\d+" input)))

(defn partition-numbers [numbers]
  [(take-nth 2 numbers) (take-nth 2 (rest numbers))])