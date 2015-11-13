(ns update.core
  (:require [reagent.core :as reagent]
            [re-frame.core :as re-frame]
            [update.handlers]
            [update.subs]
            [update.views :as views]))

(defn mount-root []
  (reagent/render [views/app] (.-body js/document)))

(defn ^:export init [] 
  (re-frame/dispatch-sync [:initialize-db])
  (mount-root))
