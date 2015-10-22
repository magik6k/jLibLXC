package net.magik6k.jliblxc

import java.io.File

import net.magik6k.jliblxc.natives.NativeLxcContainer

private[jliblxc] object NativeLoader {
  System.load(new File("target/native/bin/libjlxc.so").getAbsolutePath)

  def getNativeContainer(name: String, configPath: String) = new NativeLxcContainer(name, configPath)
}
