(ns build-monitor.web
  (:use compojure.core
        ring.middleware.json
        ring.util.response)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [clojure.data.json :refer (read-json json-str)]
            [ring.util.response :as resp]
            [ring.adapter.jetty :as jetty]
            [build-monitor.http-wrapper :as http]
            [clojure.xml :as xml]
            [clojure.zip :as zip])
  (:gen-class))

;;copy-pasta from clojure docs
(defn zip-str [s]
  (zip/xml-zip (xml/parse (java.io.ByteArrayInputStream. (.getBytes s)))))

(defn process-cc-tray [url]
  (->>
   (http/get-string-response url)
   (zip-str)
   first
   :content
   (map #(:attrs %))
   )
  )

(defroutes app-routes
  (GET "/" []
       (resp/file-response "index.html" {:root "resources"}))
  (GET "/builds.json" []
       (process-cc-tray "https://api.travis-ci.org/repositories/github/hub/cc.xml"))
  (route/files "/" {:root "resources"})
  (route/not-found (json-str {:error "not found"}))
)


(defn init []
  )

(defn destroy []
  )

(def app
  (->
   (handler/site app-routes)
   (wrap-json-response)
   ))


(defn -main
  ([] (-main 80))
  ([port]
      (jetty/run-jetty app {:port (Integer. port) :join? false})))
