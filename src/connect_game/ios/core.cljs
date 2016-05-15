(ns connect-game.ios.core
  (:require-macros
   [natal-shell.components :refer [view]])
  (:require
   [om.next :as om :refer-macros [defui]]
   [re-natal.support :as sup]
   [connect-game.shared.components.board :refer [board]]
   [connect-game.shared.state :as state]))

(set! js/window.React (js/require "react-native"))

(def app-registry (.-AppRegistry js/React))

(def AppRootStyle
  {:flex           1
   :justifyContent "center"
   :alignItems     "center"})

(defui AppRoot
  Object
  (render
   [this]
   (view
    {:style AppRootStyle}
    (board))))

(defonce RootNode (sup/root-node! 1))
(defonce app-root (om/factory RootNode))

(defn init []
  (om/add-root! state/reconciler AppRoot 1)
  (.registerComponent app-registry "ConnectGame" (fn [] app-root)))
