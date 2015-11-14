(ns update.handlers
  (:require [re-frame.core :as re-frame :refer [register-handler
                                                dispatch]]
            [update.db :as db]))

(register-handler
  :initialize-db
  (fn  [_ _]
    (db/init-db)))

(register-handler
  :update
  (fn [db [_ idx]]
    (js/setTimeout #(dispatch [:abort idx]) 1500)
    (assoc-in db [:feeds idx :status] :loading)))

(register-handler
  :abort
  (fn [db [_ idx]]
    (assoc-in db [:feeds idx :status] :ok)))
