(ns advent-of-code-2024.day-4-test
  (:require [advent-of-code-2024.day-4 :refer :all]
            [advent-of-code-2024.utils :refer [def-]]
            [clojure.string :as string]
            [clojure.test :refer :all]))

(def- example-input
  (string/join "\n" ["MMMSXXMASM"
                     "MSAMXMSMSA"
                     "AMXSXMAAMM"
                     "MSAMASMSMX"
                     "XMASAMXAMM"
                     "XXAMMXXAMA"
                     "SMSMSASXSS"
                     "SAXAMASAAA"
                     "MAMMMXMMMM"
                     "MXMXAXMASX"]))

(deftest solution-part-one-given-example-input-then-example-result
  (is (= 18 (solution-part-one example-input))))

(deftest solution-part-one-given-problem-input-then-problem-result
  (is (= 2560 (solution-part-one problem-input))))

(deftest solution-part-two-given-example-input-then-example-result
  (is (= 9 (solution-part-two example-input))))

(deftest solution-part-two-given-problem-input-then-problem-result
  (is (= 1910 (solution-part-two problem-input))))
