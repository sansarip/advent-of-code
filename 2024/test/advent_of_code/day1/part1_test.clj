(ns advent-of-code.day1.part1-test
  (:require [clojure.test :refer [deftest is]]
            [advent-of-code.day1.part1 :as d1p1]
            [clojure.java.io :as io]))

(deftest test-part-1
  (let [expected 11]
    (is (= expected (d1p1/solve-part-1 (io/resource "day-01-example.txt"))))))