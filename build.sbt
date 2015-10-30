import com.github.joprice.Jni
import Jni.Keys._

version := "0.1"
organization := "net.magik6k"

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
