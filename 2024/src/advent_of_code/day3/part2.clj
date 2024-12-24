(ns advent-of-code.day3.part2
  (:require
   [advent-of-code.day3.utils :as utils]))

(defn match->factor-tuple [match]
  (let [[_ _ _ _ factor1 factor2] match]
    [(Integer/parseInt factor1) (Integer/parseInt factor2)]))

(defn don't? [[s]]
  (= "don't()" s))

(defn do? [[s]]
  (= "do()" s))

(defn parse-commands [input-string]
  (re-seq #"(don't\(\))|(do\(\))|(mul\((\d\d?\d?),(\d\d?\d?)\))" input-string))

(defn parse-factor-tuples [input-string]
  (loop [matches (parse-commands input-string)
         factor-tuples []
         is-enabled? true]
    (let [[match] matches
          other-matches (rest matches)]
      (cond
        (not match) factor-tuples
        (don't? match) (recur other-matches factor-tuples false)
        (do? match) (recur other-matches factor-tuples true)
        is-enabled? (let [factor-tuple (match->factor-tuple match)]
                      (recur other-matches (conj factor-tuples factor-tuple) is-enabled?))
        :else (recur other-matches factor-tuples is-enabled?)))))

(defn solve-part-2* [input-string]
  (-> input-string
      parse-factor-tuples
      utils/multiply-factor-tuples
      utils/sum))

(defn solve-part-2 [input-path]
  (solve-part-2* (slurp input-path)))

(comment
  (solve-part-2* "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))"))