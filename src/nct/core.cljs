(ns nct.core
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require
   [clojure.browser.repl :as repl]
   [kvlt.chan :as chan]
   [cljs.core.async :refer [chan >!]]))

;; (defonce conn
;;   (repl/connect "http://localhost:9000/repl"))

(enable-console-print!)
(println "Hello world!")

(defn -main [& args]
  (go
   (let [url "https://nuv.la/"
         {:keys [status]} (<! (kvlt.chan/request! {:url url}))]
         (println "STATUS: " status)))
  (println "Hello world main!"))

(set! *main-cli-fn* -main)
