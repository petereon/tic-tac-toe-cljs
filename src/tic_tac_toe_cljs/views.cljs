(ns tic-tac-toe-cljs.views
  (:require
   [re-frame.core :as re-frame]
   [tic-tac-toe-cljs.subs :as subs]
    [tic-tac-toe-cljs.events :as events]
   ))

(def log (.-log js/console))

(defn click-events [coord-x coord-y]
  (fn []
    (re-frame/dispatch [::events/place-mark coord-x coord-y])
    (re-frame/dispatch [::events/next-player])
    )
  )

(defn clickable-cell [coord-x coord-y value]
  [:div {:class "cell" :on-click (click-events coord-x coord-y)} value])

(defn main-panel []
  (let [board (re-frame/subscribe [::subs/board])]
    (log @board)
    [:div
     [:table {:class "board"}
      (map-indexed (fn [i row]
                     [:tr
                      (map-indexed (fn [j cell]
                                     [:td (clickable-cell i j cell)]) row)]) @board)]]
      
      ))


