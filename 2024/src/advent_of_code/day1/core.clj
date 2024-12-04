(ns advent-of-code.day1.core
  (:require
   [advent-of-code.day1.part1 :as d1p1]
   [advent-of-code.day1.part2 :as d1p2]
   [clojure.java.io :as io]))

(def input-path (io/resource "day-01.txt"))
(def solve-part-1 #(d1p1/solve-part-1 input-path))
(def solve-part-2 #(d1p2/solve-part-2 input-path))
