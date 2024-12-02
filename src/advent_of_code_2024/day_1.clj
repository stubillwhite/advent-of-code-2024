(ns advent-of-code-2024.day-1
  (:require
   [advent-of-code-2024.utils :refer [map-vals sum]]
   [clojure.java.io :as io]
   [clojure.string :as string]))

(def problem-input
  (string/trim (slurp (io/resource "day-1-input.txt"))))

(defn- parse-input [input]
  (let [lines (->> (string/split-lines input)
                   (map (fn [s] (string/split s #"\s+")))
                   (map (partial map parse-long)))]
    [(map first lines) (map last lines)]))

(defn solution-part-one [input]
  (let [distance (fn [[a b]] (abs (- a b)))]
    (->> (parse-input input)
         (map sort)
         (apply interleave)
         (partition 2)
         (map distance)
         (sum))))

;; Part two

(defn solution-part-two [input]
  (let [[list-one list-two] (parse-input input)
        frequencies         (->> list-two (group-by identity) (map-vals count))]
    (->> list-one
         (map (fn [x] (* x (get frequencies x 0))))
         (sum))))
