(ns advent-of-code.day4.utils 
  (:require
   [clojure.string :as str]))

(def deltas {:up [0 -1]
             :up-left [-1 -1]
             :up-right [1 -1]
             :down [0 1]
             :down-left [-1 1]
             :down-right [1 1]
             :left [-1 0]
             :right [1 0]})

(def directions (vec (keys deltas)))

(defn get-in-grid [grid [x y]]
  (get-in grid (reverse [x y])))

(defn move [grid [x y] direction]
  (let [[dx dy] (deltas direction)
        updated-pos [(+ x dx) (+ y dy)]
        item (get-in-grid grid updated-pos)]
    (when item
      [item updated-pos])))

(defn parse-char-grid [input-string]
  (mapv #(vec %) (str/split-lines input-string)))
