(ns advent-of-code.day6.core
  (:require [advent-of-code.day6.part1 :as d6p1]
            [advent-of-code.day6.part2 :as d6p2]))

(def input "src/advent_of_code/day6/input.txt")
(def solve-part-1 #(d6p1/solve-part-1 input))
(def solve-part-2 #(d6p2/solve-part-2 input))
