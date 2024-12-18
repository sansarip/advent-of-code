(ns advent-of-code.day2.utils
  (:require [clojure.string :as str]))

(defn abs-diff [a b]
  (abs (- b a)))

(defn sorted-order [nums]
  (cond
    (empty? nums) nil
    (apply < nums) :asc
    (apply > nums) :desc
    :else nil))

(defn valid-step? [num]
  (< 0 num 4))

(defn valid-steps? [nums]
  (let [steps (map #(abs-diff %1 %2) nums (rest nums))]
    (and (boolean (not-empty nums))
         (every? valid-step? steps))))

(defn safe? [nums]
  (and (sorted-order nums) (valid-steps? nums)))

(defn parse-reports [input-string]
  (letfn [(parse-nums [vector] (map #(Integer/parseInt %) vector))]
    (map (comp parse-nums #(str/split %1 #" "))
         (str/split-lines input-string))))