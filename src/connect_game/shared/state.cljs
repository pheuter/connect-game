(ns connect-game.shared.state
  (:require [om.next :as om]
            [re-natal.support :as sup]))

(defonce app-state {})

(defmulti read om/dispatch)

(defmulti mutate om/dispatch)

(defonce reconciler
  (om/reconciler
   {:state        app-state
    :parser       (om/parser {:read read :mutate mutate})
    :root-render  sup/root-render
    :root-unmount sup/root-unmount}))
