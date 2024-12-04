(ns advent-of-code-2024.day-4
  (:require
   [advent-of-code-2024.utils :refer [def- map-vals sum]]
   [clojure.java.io :as io]
   [clojure.set :refer [select]]
   [clojure.string :as string]))

(def problem-input
  (string/trim (slurp (io/resource "day-4-input.txt"))))

(defn- parse-input [input]
  (->> (string/split-lines input)
       (map-indexed (fn [y line] (map-indexed (fn [x ch] [[x y] ch]) line)))
       (apply concat)
       (into {})))

(defn- xmas-match-count [grid [x y]]
  (let [deltas (for [x (range -1 2) y (range -1 2)] [x y])
        slices (map (fn [[dx dy]] (map (fn [n] [(+ x (* n dx)) (+ y (* n dy))])
                                      (range 4)))
                    deltas)
        words  (->> slices
                    (map (fn [slice] (string/join (map (partial get grid) slice)))))]
    (count (filter (fn [s] (= s "XMAS")) words))))

(defn solution-part-one [input]
  (let [grid (parse-input input)]
    (->> (keys grid)
         (map (partial xmas-match-count grid))
         (sum))))

;; Part two

(defn- x-mas-match-count [grid [x y]]
  (let [deltas [[[-1 -1] [0 0] [1 1]]
                [[1 -1] [0 0] [-1 1]]]
        slices (map (fn [diagonal] (map (fn [[dx dy]] [(+ x dx) (+ y dy)])
                                       diagonal))
                    deltas)
        words  (->> slices
                    (map (fn [slice] (string/join (map (partial get grid) slice)))))]
    (if (every? (fn [w] (or (= w "MAS") (= w "SAM"))) words) 1 0)))

(defn solution-part-two [input]
  (let [grid (parse-input input)]
    (->> (keys grid)
         (map (partial x-mas-match-count grid))
         (sum))))
