(ns update.subs
  (:require-macros [reagent.ratom :refer [reaction]])
  (:require [re-frame.core :as re-frame :refer [register-sub]]))

(register-sub
  :feeds
  (fn [db]
    (reaction (:feeds @db))))
