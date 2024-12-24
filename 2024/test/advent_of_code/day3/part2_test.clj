(ns advent-of-code.day3.part2-test
  (:require [clojure.test :refer [deftest is]]
            [advent-of-code.day3.part2 :as d3p2]))

(deftest test-part-2
    (is (= 48 (d3p2/solve-part-2* "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))"))))