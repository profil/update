(ns update.views
  (:require [re-frame.core :as re-frame :refer [subscribe]]))

(defn main-panel []
  (let [name (subscribe [:name])]
    (fn []
      [:div "Hello from " @name])))
