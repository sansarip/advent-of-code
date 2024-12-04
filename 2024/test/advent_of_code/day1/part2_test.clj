(ns advent-of-code.day1.part2-test
  (:require [clojure.test :refer [deftest is]]
            [advent-of-code.day1.part2 :as d1p2]
            [clojure.java.io :as io]))

(deftest test-part-1
  (let [expected 31]
    (is (= expected (d1p2/solve-part-2 (io/resource "day-01-example.txt"))))))