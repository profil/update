(ns update.db
  (:require [cljs.reader :refer [read-string]]))

(defn get-item!
  [ls-key]
  (some-> ls-key
          (js/localStorage.getItem)
          (read-string)))

(defn put-item!
  [ls-key data]
  (js/localStorage.setItem ls-key (str data)))

(defn init-db
  []
  (merge {:ls-key "db"}
         (get-item! "db")))

(defn save-db
  [db]
  (put-item! "db" db))
