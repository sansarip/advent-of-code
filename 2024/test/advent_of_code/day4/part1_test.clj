(ns advent-of-code.day4.part1-test
  (:require
   [clojure.java.io :as io]
   [clojure.test :refer [deftest is]]
   [advent-of-code.day4.part1 :as d4p1]))

(deftest test-part-1
  (is (= 18 (d4p1/solve-part-1 (io/resource "day-04-example.txt")))))