(ns nct.core
  (:require [clojure.browser.repl :as repl]))

;; (defonce conn
;;   (repl/connect "http://localhost:9000/repl"))

(enable-console-print!)
(println "Hello world!")

(defn -main [& args]
  (println "Hello world main!"))

(set! *main-cli-fn* -main)
