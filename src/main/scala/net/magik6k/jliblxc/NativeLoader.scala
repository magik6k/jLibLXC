package net.magik6k.jliblxc

import java.io.File

import net.magik6k.jliblxc.natives.NativeLxcContainer

 object NativeLoader {
  System.load(new File("target/native/bin/libjlxc.so").getAbsolutePath)

  val nativeContainer: NativeLxcContainer = new NativeLxcContainer

}
