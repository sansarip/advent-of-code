(ns advent-of-code.day3.part1
  (:require
   [advent-of-code.day3.utils :as utils]
   [clojure.java.io :as io]))

(defn parse-factor-tuples [input-string]
  (let [matches (re-seq #"mul\((\d\d?\d?),(\d\d?\d?)\)" input-string)]
    (map (fn [[_ a b]] [(Integer/parseInt a) (Integer/parseInt b)]) matches)))

(defn solve-part-1* [input-string]
  (-> input-string
      parse-factor-tuples
      utils/multiply-factor-tuples
      utils/sum))

(defn solve-part-1 [input-path]
  (solve-part-1* (slurp input-path)))

(comment
  (re-seq #"\d\d?\d?" "456 sds")
  (solve-part-1 (io/resource "day-03-example.txt")))

