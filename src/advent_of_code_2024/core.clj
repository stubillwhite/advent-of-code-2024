(ns advent-of-code-2024.core
  (:require
    [taoensso.timbre :as timbre]))

(timbre/refer-timbre)

(defn add-one
  ([x] 
   (+ x 1)))
