package net.magik6k.jliblxc

import java.io.{FileOutputStream, File}

import net.magik6k.jliblxc.natives.NativeLxcContainer

private[jliblxc] object NativeLoader {
  private val input = getClass.getResourceAsStream("/libjlxc.so")
  private val dest = File.createTempFile("libjlxc", ".so")
  private val output = new FileOutputStream(dest)
  CopyUtil.copy(input, output)

  System.load(dest.getAbsolutePath)
  dest.delete()

  def init() {}
  def getNativeContainer(name: String, configPath: String) = new NativeLxcContainer(name, configPath)
}
