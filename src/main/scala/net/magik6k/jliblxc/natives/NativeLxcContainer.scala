package net.magik6k.jliblxc.natives

private[jliblxc] class NativeLxcContainer(name: String, configPath: String) {
  private var containerInfo: Long = open(name, configPath)

  @native protected def open(name: String, configPath: String): Long
  @native protected def _free(ptr: Long): Long

  def free() = {
    if(containerInfo != 0) _free(containerInfo)
    containerInfo = 0
  }

  override def finalize() = free()
}
