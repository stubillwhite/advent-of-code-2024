(ns advent-of-code-2024.day-1-test
  (:require [advent-of-code-2024.day-1 :refer :all]
            [advent-of-code-2024.utils :refer [def-]]
            [clojure.string :as string]
            [clojure.test :refer :all]))

(def- example-input
  (string/join "\n" ["3   4"
                     "4   3"
                     "2   5"
                     "1   3"
                     "3   9"
                     "3   3"]))

(deftest solution-part-one-given-example-input-then-example-result
  (is (= 11 (solution-part-one example-input))))

(deftest solution-part-one-given-problem-input-then-problem-result
  (is (= 2378066 (solution-part-one problem-input))))

(deftest solution-part-two-given-example-input-then-example-result
  (is (= 31 (solution-part-two example-input))))

(deftest solution-part-two-given-problem-input-then-problem-result
  (is (= 18934359 (solution-part-two problem-input))))
