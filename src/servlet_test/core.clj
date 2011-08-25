(ns servlet-test.core
  (:use [net.cgrand.moustache]
        [ring.util.servlet :only (defservice)])
  (:gen-class :extends javax.servlet.http.HttpServlet))

(def routes
  (app
   [_] {:get (fn [req] {:status 200 :body "HELLO, WORLD!"})}))

(defservice #'routes)
