(ns advent-of-code.day3.core 
  (:require
   [advent-of-code.day3.part1 :as d3p1]
   [advent-of-code.day3.part2 :as d3p2]
   [clojure.java.io :as io]))

(def input-path (io/resource "day-03.txt"))
(def solve-part-1 #(d3p1/solve-part-1 input-path))
(def solve-part-2 #(d3p2/solve-part-2 input-path))