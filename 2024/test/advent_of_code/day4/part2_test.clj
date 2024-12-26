(ns advent-of-code.day4.part2-test
  (:require
   [clojure.test :refer [deftest is]]
   [advent-of-code.day4.part2 :as d4p2]))

(deftest test-part-1
  (is (= 9 (d4p2/solve-part-2* ".M.S......
..A..MSMS.
.M.S.MAA..
..A.ASMSM.
.M.S.M....
..........
S.S.S.S.S.
.A.A.A.A..
M.M.M.M.M.
.........."))))