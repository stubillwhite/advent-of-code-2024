(ns advent-of-code-2024.utils
  (:require [clojure.string :as string]))

(defmacro def-
  ([name & decls]
    (list* `def (vary-meta name assoc :private true) decls)))

(defmacro defmulti-
  [name & decls]
  (list* `defmulti (vary-meta name assoc :private true) decls))

(defmacro defmethod-
  [name & decls]
  (list* `defmethod (vary-meta name assoc :private true) decls))

(defn sum [coll]
  (apply + coll))

(defn product [coll]
  (apply * coll))

(defn re-seq-matches [re s]
  (let [m (re-matcher re s)]
    ((fn step []
       (when (.find m)
         (cons {:start (. m start) :end (. m end) :group (. m group)}
               (lazy-seq (step))))))))

(defn map-vals [f m]
  (into {} (for [[k v] m] [k (f v)])))

(defn take-until [pred coll]
  (lazy-seq
    (when-let [s (seq coll)]
      (if (pred (first s))
        (cons (first s) nil)
        (cons (first s) (take-until pred (rest s)))))))
