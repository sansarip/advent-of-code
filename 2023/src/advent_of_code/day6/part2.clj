(ns advent-of-code.day6.part2
  (:require
   [advent-of-code.day6.part1 :as d6p1]
   [clojure.string :as str]))

(defn parse-input [input]
  (let [[[_ _ & times] [_ _ & distances]] (re-seq d6p1/numbers-rgx input)]
    {:time (parse-long (str/join times))
     :distance (parse-long (str/join distances))}))

(defn solve-part-2 [input-path]
  (let [input (slurp input-path)
        race-info-map (parse-input input)]
    (d6p1/race-info-map->num-ways-to-win race-info-map)))

(comment
  (parse-input (slurp "src/advent_of_code/day6/input.txt"))
  (solve-part-2 "src/advent_of_code/day6/input.txt"))