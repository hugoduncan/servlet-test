(defproject servlet-test "1.0.0-SNAPSHOT"
  :description "FIXME: write"
  :dependencies [[org.clojure/clojure "1.2.0"]
                 [org.clojure/clojure-contrib "1.2.0"]
                 [net.cgrand/moustache "1.0.0"]
                 [ring "0.3.7"]
                 [org.cloudhoist/pallet "0.6.3-SNAPSHOT"]
                 [org.cloudhoist/automated-admin-user "0.5.1-SNAPSHOT"]
                 [org.cloudhoist/etc-default "0.5.0"]
                 [org.cloudhoist/java "0.5.1"]
                 [org.cloudhoist/tomcat "0.6.1-SNAPSHOT"]
                 [org.cloudhoist/pallet-crates-all "0.5.0"]
                 [org.jclouds/jclouds-all "1.0.0"]
                 [org.jclouds.driver/jclouds-jsch "1.0.0"]]

  :dev-dependencies [[uk.org.alienscience/leiningen-war "0.0.3"]
                     [org.cloudhoist/pallet-lein "0.4.1"]
                     [lein-ring "0.4.5"] ; https://github.com/weavejester/lein-ring
                     [vmfest "0.2.3"]]

  :repositories {"sonatype"
                 "http://oss.sonatype.org/content/repositories/releases"
                 "sonatype-snapshots"
                 "http://oss.sonatype.org/content/repositories/snapshots"}

  :aot [servlet-test.core])
