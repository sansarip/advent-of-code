(ns advent-of-code.day4.part2
  (:require
   [advent-of-code.day4.utils :as utils]
   [clojure.java.io :as io]))

(defn x? [grid [x y] mapping]
  (let [[bottom-left] (utils/move grid [x y] :down-left)
        [bottom-right] (utils/move grid [x y] :down-right)
        [top-left] (utils/move grid [x y] :up-left)
        [top-right] (utils/move grid [x y] :up-right)
        expected-top-right (mapping bottom-left)
        expected-top-left (mapping bottom-right)]
    (and (boolean expected-top-right) 
         (boolean expected-top-left)
         (= expected-top-right top-right)
         (= expected-top-left top-left))))

(defn count-x-mas-occurences [grid]
  (let [ms-mapping {\M \S
                    \S \M}
        x-count (atom 0)]
    (doseq [x (range (count (grid 0)))
            y (range (count grid))]
      (when (and x y (= \A (utils/get-in-grid grid [x y])) 
                 (x? grid [x y] ms-mapping))
        (swap! x-count inc)))
    @x-count))

(defn solve-part-2* [input-string]
  (count-x-mas-occurences (utils/parse-char-grid input-string)))

(defn solve-part-2 [input-path]
  (solve-part-2* (slurp input-path)))

(comment 
  (let [grid [[\S \. \S \. \.]
              [\. \A \. \. \.]
              [\M \. \M \. \.]
              [\. \. \. \A \.]
              [\. \. \. \. \M]]]
    (count-x-mas-occurences grid))
  (solve-part-2 (io/resource "day-04.txt")))