(ns connect-game.shared.utils.fetch
  (:require-macros
   [cljs.core.async.macros :refer [go]])
  (:require
   [cljs.core.async :refer [<! >! chan] :as a]))

(defn fetch-json [uri]
  (let [ch (chan 1)]
    (-> (js/fetch uri)
        (.then #(.json %))
        (.then #(go (>! ch %)))
        (.catch #(js/console.error %)))
    ch))
