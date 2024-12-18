(ns advent-of-code.day2.core
  (:require
   [advent-of-code.day2.part1 :as d2p1]
   [advent-of-code.day2.part2 :as d2p2]
   [clojure.java.io :as io]))

(def input-path (io/resource "day-02.txt"))
(def solve-part-1 #(d2p1/solve-part-1 input-path))
(def solve-part-2 #(d2p2/solve-part-2 input-path))