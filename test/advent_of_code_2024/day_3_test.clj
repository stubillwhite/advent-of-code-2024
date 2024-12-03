(ns advent-of-code-2024.day-3-test
  (:require [advent-of-code-2024.day-3 :refer :all]
            [advent-of-code-2024.utils :refer [def-]]
            [clojure.string :as string]
            [clojure.test :refer :all]))

(def- example-input-one "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))")

(def- example-input-two "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))")


(deftest solution-part-one-given-example-input-then-example-result
  (is (= 161 (solution-part-one example-input-one))))

(deftest solution-part-one-given-problem-input-then-problem-result
  (is (= 184122457 (solution-part-one problem-input))))

(deftest solution-part-two-given-example-input-then-example-result
  (is (= 48 (solution-part-two example-input-two))))

(deftest solution-part-two-given-problem-input-then-problem-result
  (is (= 107862689 (solution-part-two problem-input))))
