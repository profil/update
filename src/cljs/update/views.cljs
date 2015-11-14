(ns update.views
  (:require [re-frame.core :as re-frame :refer [subscribe
                                                dispatch]]))

(defn update-icon
  []
  [:svg {:view-box "0 0 100 100"}
   [:path {:d "M 50 0 L 70 20 L 50 40 Z"}]
   [:path {:d "M 50 20 A 30 30 0 1 0 80 50"
           :fill "transparent"
           :stroke-width "10"}]])

(defn feeds
  []
  (let [feeds (subscribe [:feeds])]
    (fn []
      [:ol
       (map-indexed
         (fn [idx {:keys [title status unread] :as feed}]
           ^{:key feed}
           [:li
            [:span.status {:class (case status
                                    :loading "loading"
                                    "ok")
                           :on-click #(dispatch [:update idx])}
             [update-icon]]
            [:span.title
             {:style (when (pos? unread)
                       {:font-weight "bold"})}
             title]
            (cond
              (nil? unread) [:span.unread.err "ERR"]
              (pos? unread) [:span.unread unread])])
         @feeds)
       [:li.add "+"]])))

(defn app []
  (let []
    (fn []
      [:div.app
       [:div.sidebar
        [feeds]]])))
