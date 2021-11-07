(defproject link "0.1.0-SNAPSHOT"
  :description "Prototype data processing DSL and engine"
  :url "https://github.com/ConnorDillon/project-link"
  :license {:name "AGPL-3.0"
            :url "https://www.gnu.org/licenses/agpl-3.0.txt"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/data.json "2.4.0"]
                 [org.antlr/antlr4-runtime "4.9.2"]]
  :main ^:skip-aot link.core
  :target-path "target/%s"
  :java-source-paths ["src/java"]
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
