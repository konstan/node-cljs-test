(ns nct.core
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require
   [clojure.browser.repl :as repl]
   [cljs.tools.cli :refer [parse-opts]]
   [cljs.nodejs :as node]
   [kvlt.chan :as chan]
   [taoensso.timbre :as log]
   [cljs.core.async :refer [chan >!]]))

(def default-url "https://httpbin.org/get")

(def cli-options
  [
   ["-i" "--insecure" "Insecure connection"]
   ["-u" "--url URL" "URL to connect to" :default default-url]
   ["-d" "--debug" "Debug output"]
   ["-h" "--help"]
   ])

(defn usage [options-summary]
  (str "Usage: program-name [options]\n"
       "Options:\n"
       options-summary))

(defn exit [status msg]
    (println msg)
    (.exit node/process status))

(defn parse-args
  [args]
  (let [{:keys [options arguments errors summary]} (parse-opts args cli-options)]
    (cond
      (:help options) (exit 0 (usage summary))
      errors (exit 1 errors))
    (if (:debug options)
      (log/set-level! :debug))
    {:options options :arguments arguments}))

(enable-console-print!)

(defn -main [& args]
  (let [{:keys [options arguments]} (parse-args args)]
    (go
     (let [{:keys [status] :as r} (<! (kvlt.chan/request! {:method :get
                                                           :url (:url options)
                                                           :kvlt.platform/insecure? (:insecure options)}))]
      (if status
        (println "STATUS: " status)
        (println "ERROR: " r))))))

(set! *main-cli-fn* -main)
