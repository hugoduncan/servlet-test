(ns pallet.task.my-deploy
 (:use (clojure.contrib strint core))
 (:require
   [servlet-test.ops.nodes :as webdeploy-nodes]
   pallet.core
   pallet.utils
   [org.jclouds.compute :as jcompute]
   [clojure.contrib.logging :as log]))

(defonce cloud-service (pallet.compute/compute-service-from-config-file "aws-ec2"))

(when-not webdeploy-nodes/warfile-path
  (throw (IllegalStateException. "No .war file defined, cannot deploy")))

(pallet.core/converge {webdeploy-nodes/groupserver 1}
                      :compute cloud-service
                      :phase [:configure :deploy])
