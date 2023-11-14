(ns tic-tac-toe-cljs.subs
  (:require
   [re-frame.core :as re-frame]))

(re-frame/reg-sub
 ::board
 (fn [db]
   (:board db)))
