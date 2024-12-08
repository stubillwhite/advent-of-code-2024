(ns advent-of-code-2024.day-5
  (:require
   [advent-of-code-2024.utils :refer [map-vals sum]]
   [clojure.java.io :as io]
   [clojure.string :as string]))

(def problem-input
  (string/trim (slurp (io/resource "day-5-input.txt"))))

(defn- parse-input [input]
  (let [[a b]      (string/split input #"\n\n")]
    {:rules   (->> (string/split-lines a)
                   (map (fn [s] (map parse-long (string/split s #"\|"))))
                   (group-by first)
                   (map-vals (partial map fnext)))

     :updates (->> (string/split-lines b)
                   (map (fn [s] (map parse-long (string/split s #",")))))}))

(defn- correctly-ordered? [rules xs]
  (let [satisfies-rules? (fn [n x]
                           (let [predecessors (take n xs)]
                             (not-any? (fn [r] (some #{r} predecessors)) (rules x))))]
    (every? identity (map-indexed satisfies-rules? xs))))

(defn- midpoint [coll]
  (nth coll (/ (count coll) 2)))

(defn solution-part-one [input]
  (let [{:keys [rules updates]} (parse-input input)]
    (->> updates
         (filter (partial correctly-ordered? rules))
         (map midpoint)
         (sum))))

;; Part two

(defn solution-part-two [input]
  (let [{:keys [rules updates]} (parse-input input)
        toplogical-order        (fn [a b] (if (some #{a} (rules b)) -1 0))]
    (->> updates
         (filter (partial (complement correctly-ordered?) rules))
         (map (partial sort-by identity toplogical-order))
         (map midpoint)
         (sum))))
