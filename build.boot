(set-env!
  :resource-paths #{"resources" "src"}
  :source-paths   #{"test"}
  :dependencies   '[[adzerk/boot-test "RELEASE" :scope "test"]
                    [metosin/boot-alt-test "0.3.2" :scope "test"]
                    [org.clojure/clojure "RELEASE"]])

(def project 'com.grzm.foreclojure.alpha)
(def version "0.1.90-SNAPSHOT")

(task-options!
  pom {:project     project
       :version     version
       :description "4Clojure.com exercises"
       :url         "http://github.com/grzm/foreclojure.alpha"
       :scm         {:url "https://github.com/grzm/foreclojure.alpha"}
       :license     {"MIT"
                     "https://opensource.org/licenses/MIT"}})

(deftask build
  "Build and install the project locally."
  []
  (comp (pom) (jar) (install)))

(require '[metosin.boot-alt-test :refer [alt-test]])
