(ns update.handlers
  (:require [re-frame.core :as re-frame :refer [register-handler
                                                dispatch]]
            [update.db :as db]))

(register-handler
  :initialize-db
  (fn  [_ _]
    db/default-db))
