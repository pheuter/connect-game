(ns connect-game.shared.components.board
  (:require-macros
   [natal-shell.components :refer [text]])
  (:require
   [om.next :as om :refer-macros [defui]]))

(set! js/window.React (js/require "react-native"))

(defui Board
  Object
  (render
   [this]
   (text
    {:style {:fontSize 36 :color "#000"}}
    "Board")))

(def board (om/factory Board))
