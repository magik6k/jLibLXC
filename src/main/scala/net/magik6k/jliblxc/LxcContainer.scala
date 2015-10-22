package net.magik6k.jliblxc

class LxcContainer(name: String, configPath: String) {
  val native = NativeLoader.getNativeContainer(name, configPath)


}
