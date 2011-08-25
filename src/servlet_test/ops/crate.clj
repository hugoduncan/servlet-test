(ns servlet-test.ops.crate
 (:use (clojure.contrib strint core))
 (:require
   (pallet core resource)
   pallet.action.service
   (pallet.crate
     [tomcat :as tomcat]
     [etc-default :as default])))

(defn tomcat-deploy
  "Deploys the specified .war file to tomcat.  An optional :port kwarg
   defines the port that tomcat will serve on (defaults to 80)."
  [pallet-request warfile & {:keys [port] :or {port 80}}]
  (pallet.action.service/with-restart pallet-request "tomcat*"
    (default/write "tomcat6"
      ; configure tomcat's heap to utilize 2/3 of machine's total memory
      :JAVA_OPTS (->> pallet-request
                   :target-node
                   .getHardware
                   .getRam
                   (* 0.66)
                   int
                   (format "-Xmx%sm"))
      ; allow tomcat to run on ports < 1024
      :AUTHBIND "yes")
    (tomcat/server-configuration
      (tomcat/server :port port
       (tomcat/service
        (tomcat/engine "catalina" "host" (tomcat/valve :request-dumper))
        (tomcat/connector :port (str port) :protocol "HTTP/1.1"
            :connectionTimeout "20000"
            :redirectPort "8443"))))
    (tomcat/deploy "ROOT" :local-file warfile :clear-existing true)))
