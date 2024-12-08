(ns advent-of-code-2024.day-5-test
  (:require [advent-of-code-2024.day-5 :refer :all]
            [advent-of-code-2024.utils :refer [def-]]
            [clojure.string :as string]
            [clojure.test :refer :all]))

(def- example-input
  (string/join "\n" ["47|53"
                     "97|13"
                     "97|61"
                     "97|47"
                     "75|29"
                     "61|13"
                     "75|53"
                     "29|13"
                     "97|29"
                     "53|29"
                     "61|53"
                     "97|53"
                     "61|29"
                     "47|13"
                     "75|47"
                     "97|75"
                     "47|61"
                     "75|61"
                     "47|29"
                     "75|13"
                     "53|13"
                     ""
                     "75,47,61,53,29"
                     "97,61,53,29,13"
                     "75,29,13"
                     "75,97,47,61,53"
                     "61,13,29"
                     "97,13,75,29,47"]))

(deftest solution-part-one-given-example-input-then-example-result
  (is (= 143 (solution-part-one example-input))))

(deftest solution-part-one-given-problem-input-then-problem-result
  (is (= 5747 (solution-part-one problem-input))))

(deftest solution-part-two-given-example-input-then-example-result
  (is (= 123 (solution-part-two example-input))))

(deftest solution-part-two-given-problem-input-then-problem-result
  (is (= 5502 (solution-part-two problem-input))))
