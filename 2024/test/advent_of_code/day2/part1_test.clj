(ns advent-of-code.day2.part1-test
  (:require [clojure.test :refer [deftest is testing]]
            [advent-of-code.day2.part1 :as d2p1]
            [clojure.java.io :as io]))

(deftest test-part-1
  (is (= 2 (d2p1/solve-part-1 (io/resource "day-02-example.txt")))))

(deftest sorted-order
  (testing "handles ascending"
    (is (= :asc (d2p1/sorted-order [1 2 3]))))
  (testing "handles descending"
    (is (= :desc (d2p1/sorted-order [3 2 1]))))
  (testing "handles same numbers"
    (is (nil? (d2p1/sorted-order [1 1 1]))))
  (testing "handles no numbers"
    (is (nil? (d2p1/sorted-order []))))
  (testing "handles unsorted"
    (is (nil? (d2p1/sorted-order [1 2 3 2 1])))
    (is (nil? (d2p1/sorted-order [3 2 1 2 0])))
    (is (nil? (d2p1/sorted-order [0 2 1 2 3])))
    (is (nil? (d2p1/sorted-order [1 3 2 4 5])))))

(deftest numbers->max-difference-between-neighbors
  (testing "handles valid steps"
    (is (true? (d2p1/valid-steps? [0 1 2 3 4])))
    (is (true? (d2p1/valid-steps? [4 3 2 1 0])))
    (is (true? (d2p1/valid-steps? [0 3 1 4 2]))))
  (testing "handles invalid steps"
    (is (false? (d2p1/valid-steps? [0 0 0 0 0])))
    (is (false? (d2p1/valid-steps? [0 1 5 2 3])))
    (is (false? (d2p1/valid-steps? [1 0 0 3 2]))))
  (testing "handles no numbers"
    (is (false? (d2p1/valid-steps? [])))))
  