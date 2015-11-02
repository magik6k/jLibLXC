import com.github.joprice.Jni
import Jni.Keys._

version := "0.1.0"
organization := "net.magik6k"
name := "jliblxc"
crossPaths := false

Jni.settings
libraryName := "libjlxc"
nativeCompiler := "gcc"
gccFlags -= "-std=c++11"
gccFlags += "-llxc"

jniClasses := Seq(
  "net.magik6k.jliblxc.natives.NativeLxcContainer",
  "net.magik6k.jliblxc.natives.NativeLxcContainerStatic"
)

unmanagedResourceDirectories in Compile += baseDirectory.value / "target/native/bin"

//baseDirectory in run := file("target/native/bin")

pomIncludeRepository := { _ => false }
pomExtra := (
  <url>https://github.com/magik6k/jLibLXC/</url>
  <licenses>
    <license>
      <name>MIT</name>
      <url>https://opensource.org/licenses/MIT</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>https://github.com/magik6k/jLibLXC.git</url>
    <connection>scm:git:git@github.com:magik6k/jLibLXC.git</connection>
  </scm>
  <developers>
    <developer>
      <id>Magik6k</id>
      <name>Łukasz Magiera</name>
      <url>http://magik6k.net</url>
    </developer>
  </developers>)
