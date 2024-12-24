(ns advent-of-code.day3.part1-test
  (:require
   [clojure.java.io :as io]
   [clojure.test :refer [deftest is]]
   [advent-of-code.day3.part1 :as d3p1]))

(deftest test-part-1
  (is (= 161 (d3p1/solve-part-1 (io/resource "day-03-example.txt")))))