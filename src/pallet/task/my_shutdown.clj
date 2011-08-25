(ns pallet.task.my-shutdown
 (:use (clojure.contrib strint core))
 (:require
   [servlet-test.ops.nodes :as webdeploy-nodes]
   pallet.core
   [org.jclouds.compute :as jcompute]
   [clojure.contrib.logging :as log]))

(defonce cloud-service (pallet.compute/compute-service-from-config-file "aws-ec2"))

(when-not webdeploy-nodes/warfile-path
  (throw (IllegalStateException. "No .war file defined, cannot deploy")))

(pallet.core/converge {webdeploy-nodes/appserver 0}
                      :compute cloud-service))
