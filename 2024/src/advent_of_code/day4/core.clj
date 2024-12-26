(ns advent-of-code.day4.core
  (:require
   [advent-of-code.day4.part1 :as d4p1]
   [advent-of-code.day4.part2 :as d4p2]
   [clojure.java.io :as io]))

(def input-path (io/resource "day-04.txt"))
(def solve-part-1 #(d4p1/solve-part-1 input-path))
(def solve-part-2 #(d4p2/solve-part-2 input-path))
