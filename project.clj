(defproject connect-game "0.1.0-SNAPSHOT"
  :description "A puzzle game written in ClojureScript using React Native and om.next"
  :url "https://github.com/pheuter/connect-game"
  :license {:name "MIT License"
            :url  "http://choosealicense.com/licenses/mit/"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.170"]
                 [org.omcljs/om "1.0.0-alpha28" :exclusions [cljsjs/react cljsjs/react-dom]]
                 [natal-shell "0.1.6"]]
  :plugins [[lein-cljsbuild "1.1.1"]
            [lein-figwheel "0.5.0-6"]]
  :clean-targets ["target/" "index.ios.js" "index.android.js"]
  :aliases {"prod-build" ^{:doc "Recompile code with prod profile."}
            ["do" "clean"
             ["with-profile" "prod" "cljsbuild" "once" "ios"]
             ["with-profile" "prod" "cljsbuild" "once" "android"]]}
  :profiles {:dev  {:dependencies [[figwheel-sidecar "0.5.0-6"]
                                   [com.cemerick/piggieback "0.2.1"]]
                    :source-paths ["src" "env/dev"]
                    :cljsbuild    {:builds {:ios     {:source-paths ["src" "env/dev"]
                                                      :figwheel     true
                                                      :compiler     {:output-to     "target/ios/not-used.js"
                                                                     :main          "env.ios.main"
                                                                     :output-dir    "target/ios"
                                                                     :optimizations :none}}
                                            :android {:source-paths ["src" "env/dev"]
                                                      :figwheel     true
                                                      :compiler     {:output-to     "target/android/not-used.js"
                                                                     :main          "env.android.main"
                                                                     :output-dir    "target/android"
                                                                     :optimizations :none}}}}
                    :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}}
             :prod {:cljsbuild {:builds {:ios     {:source-paths ["src" "env/prod"]
                                                   :compiler     {:output-to     "index.ios.js"
                                                                  :main          "env.ios.main"
                                                                  :output-dir    "target/ios"
                                                                  :optimizations :simple}}
                                         :android {:source-paths ["src" "env/prod"]
                                                   :compiler     {:output-to     "index.android.js"
                                                                  :main          "env.android.main"
                                                                  :output-dir    "target/android"
                                                                  :optimizations :simple}}}}
                    }})
