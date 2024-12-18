(ns advent-of-code.day2.part1
  (:require
   [advent-of-code.day2.utils :as utils]
   [clojure.java.io :as io]))

(defn solve-part-1* [input-string]
  (->> (utils/parse-reports input-string)
       (map utils/safe?)
       (filter true?)
       count))

(defn solve-part-1 [input-path]
  (solve-part-1* (slurp input-path)))

(comment 
  (solve-part-1 (io/resource "day-02.txt")))