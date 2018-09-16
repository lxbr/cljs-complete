(ns com.github.lxbr.cljs-complete
  (:require [cljs-tooling.complete :as t]
            [cljs.env]))

(defmacro completions
  [prefix current-ns]
  (->> (t/completions @cljs.env/*compiler* prefix current-ns)
       (into [] (map :candidate))
       (list `seq)))
