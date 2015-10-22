import com.github.joprice.Jni
import Jni.Keys._

Jni.settings

// this will be the name that you call `System.loadLibrary` with, prefixed with "lib"
libraryName := "libjlxc"

nativeCompiler := "gcc"

gccFlags -= "-std=c++11"

jniClasses := Seq(
  "net.magik6k.jliblxc.natives.NativeLxcContainer"
)

baseDirectory in run := file("target/native/bin")
