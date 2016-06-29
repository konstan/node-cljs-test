(defproject node-cljs-test "0.1.0-SNAPSHOT"
  :description "test of node.js and clojurescript"
  :url "https://github.com/loomis/node-cljs-test.git"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.89"]]
  :jvm-opts ^:replace ["-Xmx1g" "-server"]
  :plugins [[lein-npm "0.6.1"]
            [lein-cljsbuild "1.1.3"]]
  :npm {:dependencies [[source-map-support "0.4.0"]]}
  :source-paths ["src" "target/classes"]
  :clean-targets ["out" "release"]
  :target-path "target"

  :cljsbuild {
              :builds [{:id "dev"
                        :source-paths ["src"]
                        :compiler {:main nct.core
                                   :output-to "out/nct.js"
                                   :output-dir "out"
                                   :optimizations :none
                                   :target :nodejs
                                   :cache-analysis true
                                   :source-map true}}]})
