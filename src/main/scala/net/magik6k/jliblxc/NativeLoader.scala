package net.magik6k.jliblxc

import java.io.{FileOutputStream, File}

import net.magik6k.jliblxc.natives.NativeLxcContainer

private[jliblxc] object NativeLoader {
  val input = getClass.getResourceAsStream("/libjlxc.so")
  val dest = File.createTempFile("libjlxc", ".so")
  val output = new FileOutputStream(dest)
  CopyUtil.copy(input, output)

  System.load(dest.getAbsolutePath)
  dest.delete()

  def getNativeContainer(name: String, configPath: String) = new NativeLxcContainer(name, configPath)
}
