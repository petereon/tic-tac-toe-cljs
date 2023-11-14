(ns tic-tac-toe-cljs.db)

(def default-db
  {:board [["" "" ""]
           ["" "" ""]
           ["" "" ""]]
   :current-player :x 
   :players {:x "Player 1"
             :o "Player 2"}})
