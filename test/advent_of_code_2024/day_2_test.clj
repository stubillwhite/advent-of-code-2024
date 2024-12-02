(ns advent-of-code-2024.day-2-test
  (:require [advent-of-code-2024.day-2 :refer :all]
            [advent-of-code-2024.utils :refer [def-]]
            [clojure.string :as string]
            [clojure.test :refer :all]))

(def- example-input
  (string/join "\n" ["7 6 4 2 1"
                     "1 2 7 8 9"
                     "9 7 6 2 1"
                     "1 3 2 4 5"
                     "8 6 4 4 1"
                     "1 3 6 7 9"]))

(deftest solution-part-one-given-example-input-then-example-result
  (is (= 2 (solution-part-one example-input))))

(deftest solution-part-one-given-problem-input-then-problem-result
  (is (= 306 (solution-part-one problem-input))))

(deftest solution-part-two-given-example-input-then-example-result
  (is (= 4 (solution-part-two example-input))))

(deftest solution-part-two-given-problem-input-then-problem-result
  (is (= 366 (solution-part-two problem-input))))
