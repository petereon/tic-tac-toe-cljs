(ns tic-tac-toe-cljs.events
  (:require
   [re-frame.core :as re-frame]
   [tic-tac-toe-cljs.db :as db]))

(defn assoc-seq [s i v]
  (map-indexed (fn [j x] (if (= i j) v x)) s))

(re-frame/reg-event-db
 ::initialize-db
 (fn [_ _]
   db/default-db))


(re-frame/reg-event-db
 ::place-mark
 (fn [db [_ coord-x coord-y]] (let [board (get db :board)
                                    current-player (get db :current-player)]
                                (assoc db :board
                                       (assoc-seq board coord-x (assoc-seq (nth board coord-x) coord-y current-player))))))

(re-frame/reg-event-db
 ::next-player
 (fn [db _] (let [current-player (get db :current-player)]
              (assoc db :current-player (if (= current-player :x) :o :x)))))