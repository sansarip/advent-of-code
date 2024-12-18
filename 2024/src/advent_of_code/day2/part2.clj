(ns advent-of-code.day2.part2 
  (:require
   [advent-of-code.day2.utils :as utils]
   [clojure.java.io :as io]))

(defn remove-nth [coll n]
  (concat (take n coll) (drop (inc n) coll)))

(defn recur-safe?
  ([nums]
   (recur-safe? nums -1))
  ([nums ignored-index]
   (and (< ignored-index (count nums))
        (let [should-ignore? (<= 0 ignored-index)
              nums-without-ignored (if should-ignore?
                                     (remove-nth nums ignored-index)
                                     nums)]
          (or (utils/safe? nums-without-ignored)
              (recur-safe? nums (inc ignored-index)))))))

(defn solve-part-2* [input-string]
    (->> (utils/parse-reports input-string)
        (map recur-safe?)
        (filter true?)
        count))

(defn solve-part-2 [input-path]
  (solve-part-2* (slurp input-path)))

(comment 
  (remove-nth '(1 2 3 4) 1)
  (solve-part-2 (io/resource "day-02.txt")))