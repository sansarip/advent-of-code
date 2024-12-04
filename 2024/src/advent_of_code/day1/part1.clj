(ns advent-of-code.day1.part1
  (:require
   [advent-of-code.day1.utils :as utils]
   [clojure.java.io :as io]))

(defn sort-numbers [numbers]
  (map sort numbers))

(defn abs-diff [a b]
  (abs (- b a)))

(defn sum-diffs [[left right]]
  (apply + (map abs-diff left right)))

(defn solve-part-1* [input-string]
  (-> input-string
      utils/parse-numbers
      utils/partition-numbers
      sort-numbers
      sum-diffs))

(defn solve-part-1 [input-path]
  (solve-part-1* (slurp input-path)))

(comment 
  (solve-part-1* "3 4\n4 3\n2 5\n1 3\n3 9\n3 3")
  (solve-part-1 (io/resource "day-01.txt")))