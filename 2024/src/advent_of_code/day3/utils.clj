(ns advent-of-code.day3.utils)

(defn multiply-factor-tuples [factor-tuples]
  (map (partial apply *) factor-tuples))

(defn sum [nums]
  (apply + nums))
