(ns advent-of-code.day4.part1
  (:require
   [advent-of-code.day4.utils :as utils]
   [clojure.string :as str]))

(defn word? [grid [x y] direction expected-word]
  (boolean
   (loop [pos [x y]
          sub-str (str (utils/get-in-grid grid pos))]
     (let [is-expected-char? (str/includes? expected-word sub-str)
           is-word? (= sub-str expected-word)]
       (or is-word?
           (when is-expected-char?
             (when-let [[next-char next-pos] (utils/move grid pos direction)]
               (recur next-pos (str sub-str next-char)))))))))

(defn count-xmas-occurences [grid]
  (let [xmas-count (atom 0)
        expected-word "XMAS"]
    (doseq [x (range (count (grid 0)))
            y (range (count grid))
            direction utils/directions]
      (when (word? grid [x y] direction expected-word)
        (swap! xmas-count inc)))
    @xmas-count))

(defn solve-part-1* [input-string]
  (count-xmas-occurences (utils/parse-char-grid input-string)))

(defn solve-part-1 [input-path]
  (solve-part-1* (slurp input-path)))

(comment
  (utils/move [[\a \b \c]
         [\d \e \f]
         [\g \h \i]]
        [0 0]
        :right)
  (let [grid [[\X \M \A \S]
              [\M \. \. \.]
              [\A \. \. \.]
              [\S \. \. \.]]]
    (word? grid [0 0] :down-right "XMAS"))
  (count-xmas-occurences [[\X \M \A \S]
                          [\M \. \. \.]
                          [\A \. \. \.]
                          [\S \. \. \.]]))