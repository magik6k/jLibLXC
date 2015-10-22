# jLibLXC
Java/JVM bindings for liblxc

About
----
PROJECT IS IN EARLY DEVELOPMENT AND MOSTLY EXPERIMENTAL!

This project aims to deliver good, documented bindings and documentation for liblxc

Building
-----
Compile using SBT with `sbt compile`. Debugging can be done with `sbt console`.

To test using Scala REPL as root user, in the main directory execute `sbt package` and then just execute

`sudo scala -classpath target/scala-2.10/jliblxc_2.10-0.1-SNAPSHOT.jar`

Distribution
----
At this moment this project won't run as library due to lack of native loading from jar.
You'll need to wait or do it by yourself. As I said, it's early development.

