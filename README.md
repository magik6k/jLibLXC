# jLibLXC
Scala/Java bindings for liblxc

About
----
This project aims to deliver good, documented bindings and documentation for liblxc.

Usage
-----
```scala
//Start all containers
Lxc.getContainers.map(container => new LxcContainer(container)).foreach()

//Start a container
val container = new LxcContainer("MyContainer")
container.start()
```

Note that some parts of the API may change in future.

Things that don't work / aren't tested properly / implemented
-----

* container.getKeys (Needs testing)
* container.console (Needs proper testing)
* container.attach (Not implemented)

Building
-----
Compile using SBT with `sbt compile package`.

To test using Scala REPL as root user, in the main directory execute `sbt package` and then just execute

`sudo scala -classpath target/scala-2.10/jliblxc_2.10-0.1.jar`

Distribution
----
`net.magik6k:jliblxc:0.1.0` at the maven central repository

After malual compilation the library is at `target/scala-2.10/jliblxc*.jar`

