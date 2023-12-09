(ns advent-of-code.day6.part1)

(def numbers-rgx #"((\d+)\s+(\d+)\s+(\d+)\s+(\d+))")

(defn race-info-map->num-ways-to-win [{:keys [time distance]}]
  (let [speeds (range 1 (inc time))]
    (reduce (fn inc-winnable [c speed]
              (let [remaining-time (- time speed)
                    possible-distance (* speed remaining-time)]
                (if (> possible-distance distance)
                  (inc c)
                  c)))
            0
            speeds)))

(defn parse-input [input]
  (let [[[_ _ & time-strs] [_ _ & distance-strs]] (re-seq numbers-rgx input)]
    (map-indexed
     (fn ->race-info [idx time-str]
       {:time (parse-long time-str)
        :distance (parse-long (nth distance-strs idx))})
     time-strs)))

(defn solve-part-1 [input-path]
  (let [input (slurp input-path)
        race-info-maps (parse-input input)
        ways-to-win (map race-info-map->num-ways-to-win race-info-maps)]
    (apply * ways-to-win)))

(comment
  (re-seq #"((\d+)\s+(\d+)\s+(\d+)\s+(\d+))" (slurp "src/advent_of_code/day6/input.txt"))
  (parse-input (slurp "src/advent_of_code/day6/input.txt"))
  (race-info-map->num-ways-to-win {:time 62, :distance 644})
  (map race-info-map->num-ways-to-win [{:time 7 :distance 9} {:time 15 :distance 40} {:time 30 :distance 200}])
  (solve-part-1 "src/advent_of_code/day6/input.txt"))