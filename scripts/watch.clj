(require '[cljs.build.api :as b])

(b/watch "src"
  {:main 'node-cljs-test.core
   :output-to "out/node_cljs_test.js"
   :output-dir "out"})
