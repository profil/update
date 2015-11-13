(ns update.subs
  (:require-macros [reagent.ratom :refer [reaction]])
  (:require [re-frame.core :as re-frame :refer [register-sub]]))

(register-sub
  :name
  (fn [db]
    (reaction (:name @db))))
