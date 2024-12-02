(ns advent-of-code-2024.day-2
  (:require
   [advent-of-code-2024.utils :refer [def- map-vals]]
   [clojure.java.io :as io]
   [clojure.string :as string]))

(def problem-input
  (string/trim (slurp (io/resource "day-2-input.txt"))))

(defn parse-input [input]
  (->> (string/split-lines input)
       (map (fn [s] (map parse-long (string/split s #"\s+"))))))

(defn- small-deltas? [xs]
  (->> (partition 2 1 xs)
       (map (fn [[a b]] (abs (- a b))))
       (every? (fn [x] (<= 1 x 3)))))

(defn- safe? [xs]
  (and (or (apply < xs) (apply > xs))
       (small-deltas? xs)))

(defn solution-part-one [input]
  (->> (parse-input input)
       (filter safe?)
       (count)))

;; Part two

(defn- drop-nth [coll n]
  (concat (take n coll)
          (drop (inc n) coll)))

(defn- dampen [xs]
  (cons xs (map (partial drop-nth xs) (range (count xs)))))

(defn- safe-if-dampened? [xs]
  (let [any? (comp boolean some)]
    (any? safe? (dampen xs))))

(defn solution-part-two [input]
  (->> (parse-input input)
       (filter safe-if-dampened?)
       (count)))



