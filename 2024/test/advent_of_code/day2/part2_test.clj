(ns advent-of-code.day2.part2-test
  (:require [clojure.test :refer [deftest is]]
            [advent-of-code.day2.part2 :as d2p2]
            [clojure.java.io :as io]))

(deftest test-part-2
  (is (= 4 (d2p2/solve-part-2 (io/resource "day-02-example.txt")))))
