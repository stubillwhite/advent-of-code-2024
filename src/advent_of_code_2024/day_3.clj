(ns advent-of-code-2024.day-3
  (:require
   [advent-of-code-2024.utils :refer [def- map-vals sum]]
   [clojure.java.io :as io]
   [clojure.string :as string]))

(def problem-input
  (string/trim (slurp (io/resource "day-3-input.txt"))))

(def- instr-regex
  (->> [#"(mul\(\d+,\d+\))"
        #"(do\(\))"
        #"(don't\(\))"]
       (map str)
       (string/join "|")
       (re-pattern)))

(defn- parse-match [[s & groups]]
  (let [opcode (re-find #"[^\(]+" s)]
    {:opcode opcode
     :args   (case opcode
               "mul"   (->> (re-find #"\((\d+),(\d+)\)" s) (rest) (map parse-long) (vec))
               "do"    nil
               "don't" nil)}))

(defn- parse-input [input]
  (->> input
       (re-seq instr-regex)
       (map parse-match)))

(defn- create-state [can-disable]
  {:can-disable can-disable
   :disabled    false
   :total       0})

(defn- execute-instr [{:keys [can-disable disabled total] :as state} {:keys [opcode args]}]
  (case opcode
    "mul"   (if disabled state (assoc state :total (+ total (* (get args 0) (get args 1)))))
    "do"    (assoc state :disabled false)
    "don't" (assoc state :disabled (if can-disable true false))))

(defn solution-part-one [input]
  (->> (parse-input input)
       (reduce execute-instr (create-state false))
       (:total)))

;; Part two

(defn solution-part-two [input]
  (->> (parse-input input)
       (reduce execute-instr (create-state true))
       (:total)))
