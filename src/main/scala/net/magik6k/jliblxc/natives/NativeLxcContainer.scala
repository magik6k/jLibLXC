package net.magik6k.jliblxc.natives

private[jliblxc] class NativeLxcContainer(name: String, configPath: String) {
  private var containerPtr: Long = open(name, configPath)

  if(containerPtr == 0)
    throw new NullPointerException("Cannot open container")
  ////////////
  // EXPORT //
  ////////////

  // Static
  def free() = {
    if(containerPtr != 0) _free(containerPtr)
    containerPtr = 0
  }

  override def finalize() = free()

  // Non-static
  def getLastError = _getLastError(containerPtr)
  def isDefined = _isDefined(containerPtr)
  def state() = _state(containerPtr)
  def isRunning = _isRunning(containerPtr)
  def initPid() = _initPid(containerPtr)
  def mayControl() = _mayControl(containerPtr)

  def freeze() = _freeze(containerPtr)
  def unfreeze() = _unfreeze(containerPtr)
  def start(args: Array[String]) = _start(containerPtr, args)
  def stop() = _stop(containerPtr)
  def reboot() = _reboot(containerPtr)
  def shutdown(timeout: Int) = _shutdown(containerPtr, timeout)

  def loadConfig() = _loadConfig(containerPtr)
  def saveConfig() = _saveConfig(containerPtr)
  def getConfigPath = _getConfigPath(containerPtr)
  def setConfigPath() = _setConfigPath(containerPtr)
  def configFileName() = _configFileName(containerPtr)
  def setConfigItem() = _setConfigItem(containerPtr)
  def clearConfig() = _clearConfig(containerPtr)
  def clearConfigItem() = _clearConfigItem(containerPtr)
  def getConfigItem = _getConfigItem(containerPtr)
  def getRunningConfigItem = _getRunningConfigItem(containerPtr)
  def getKeys = _getKeys(containerPtr)

  def wantDaemonize() = _wantDaemonize(containerPtr)
  def wantCloseAllFDs() = _wantCloseAllFDs(containerPtr)

  def waitForState() = _waitForState(containerPtr)

  def create() = _create(containerPtr)
  def cloneContainer() = _cloneContainer(containerPtr)
  def rename() = _rename(containerPtr)
  def destroy() = _destroy(containerPtr)
  def destroyWithSnapshots() = _destroyWithSnapshots(containerPtr)
  def snapshotDestroyAll() = _snapshotDestroyAll(containerPtr)

  def checkpoint() = _checkpoint(containerPtr)
  def restore() = _restore(containerPtr)
  def snapshot() = _snapshot(containerPtr)
  def snapshotList() = _snapshotList(containerPtr)
  def snapshotRestore() = _snapshotRestore(containerPtr)
  def snapshotDestroy() = _snapshotDestroy(containerPtr)

  def getInterfaces = _getInterfaces(containerPtr)
  def getIps = _getIps(containerPtr)
  def attachInterface() = _attachInterface(containerPtr)
  def detachInterface() = _detachInterface(containerPtr)

  def getCgroupItem = _getCgroupItem(containerPtr)
  def setCgroupItem() = _setCgroupItem(containerPtr)

  def consoleGetFD() = _consoleGetFD(containerPtr)
  def console() = _console(containerPtr)
  def attach() = _attach(containerPtr)
  def attachRunWait() = _attachRunWait(containerPtr)

  def addDeviceNode() = _addDeviceNode(containerPtr)
  def removeDeviceNode() = _removeDeviceNode(containerPtr)


  /////////////
  // NATIVES //
  /////////////

  // Static
  // Native: LxcContainer.c
  @native protected def open(name: String, configPath: String): Long
  @native protected def _free(ptr: Long): Long

  // Non-static

  // Native: LxcContainerInfo.c
  @native protected def _getLastError(ptr: Long): String
  @native protected def _isDefined(ptr: Long): Boolean
  @native protected def _state(ptr: Long): String
  @native protected def _isRunning(ptr: Long): Boolean
  @native protected def _initPid(ptr: Long): Int
  @native protected def _mayControl(ptr: Long): Boolean

  // Native: LxcContainerPower.c
  @native protected def _freeze(ptr: Long): Boolean
  @native protected def _unfreeze(ptr: Long): Boolean
  @native protected def _start(ptr: Long, args: Array[String]): Boolean
  @native protected def _stop(ptr: Long): Boolean
  @native protected def _reboot(ptr: Long): Boolean
  @native protected def _shutdown(ptr: Long, timeout: Int): Boolean

  @native protected def _loadConfig(ptr: Long): Boolean /*
  @native protected def _saveConfig(ptr: Long): Unit
  @native protected def _getConfigPath(ptr: Long): Unit
  @native protected def _setConfigPath(ptr: Long): Unit
  @native protected def _configFileName(ptr: Long): Unit
  @native protected def _setConfigItem(ptr: Long): Unit
  @native protected def _clearConfig(ptr: Long): Unit
  @native protected def _clearConfigItem(ptr: Long): Unit
  @native protected def _getConfigItem(ptr: Long): Unit
  @native protected def _getRunningConfigItem(ptr: Long): Unit
  @native protected def _getKeys(ptr: Long): Unit

  @native protected def _wantDaemonize(ptr: Long): Unit
  @native protected def _wantCloseAllFDs(ptr: Long): Unit

  @native protected def _waitForState(ptr: Long): Unit

  @native protected def _create(ptr: Long): Unit
  @native protected def _cloneContainer(ptr: Long): Unit
  @native protected def _rename(ptr: Long): Unit
  @native protected def _destroy(ptr: Long): Unit
  @native protected def _destroyWithSnapshots(ptr: Long): Unit
  @native protected def _snapshotDestroyAll(ptr: Long): Unit

  @native protected def _checkpoint(ptr: Long): Unit
  @native protected def _restore(ptr: Long): Unit
  @native protected def _snapshot(ptr: Long): Unit
  @native protected def _snapshotList(ptr: Long): Unit
  @native protected def _snapshotRestore(ptr: Long): Unit
  @native protected def _snapshotDestroy(ptr: Long): Unit

  @native protected def _getInterfaces(ptr: Long): Unit
  @native protected def _getIps(ptr: Long): Unit
  @native protected def _attachInterface(ptr: Long): Unit
  @native protected def _detachInterface(ptr: Long): Unit

  @native protected def _getCgroupItem(ptr: Long): Unit
  @native protected def _setCgroupItem(ptr: Long): Unit

  @native protected def _consoleGetFD(ptr: Long): Unit
  @native protected def _console(ptr: Long): Unit
  @native protected def _attach(ptr: Long): Unit
  @native protected def _attachRunWait(ptr: Long): Unit

  @native protected def _addDeviceNode(ptr: Long): Unit
  @native protected def _removeDeviceNode(ptr: Long): Unit
  */

  ///////////
  // STUBS //
  ///////////

  protected def _saveConfig(ptr: Long) = ???
  protected def _getConfigPath(ptr: Long) = ???
  protected def _setConfigPath(ptr: Long) = ???
  protected def _configFileName(ptr: Long) = ???
  protected def _setConfigItem(ptr: Long) = ???
  protected def _clearConfig(ptr: Long) = ???
  protected def _clearConfigItem(ptr: Long) = ???
  protected def _getConfigItem(ptr: Long) = ???
  protected def _getRunningConfigItem(ptr: Long) = ???
  protected def _getKeys(ptr: Long) = ???

  protected def _wantDaemonize(ptr: Long) = ???
  protected def _wantCloseAllFDs(ptr: Long) = ???

  protected def _waitForState(ptr: Long) = ???

  protected def _create(ptr: Long) = ???
  protected def _cloneContainer(ptr: Long) = ???
  protected def _rename(ptr: Long) = ???
  protected def _destroy(ptr: Long) = ???
  protected def _destroyWithSnapshots(ptr: Long) = ???
  protected def _snapshotDestroyAll(ptr: Long) = ???

  protected def _checkpoint(ptr: Long) = ???
  protected def _restore(ptr: Long) = ???
  protected def _snapshot(ptr: Long) = ???
  protected def _snapshotList(ptr: Long) = ???
  protected def _snapshotRestore(ptr: Long) = ???
  protected def _snapshotDestroy(ptr: Long) = ???

  protected def _getInterfaces(ptr: Long) = ???
  protected def _getIps(ptr: Long) = ???
  protected def _attachInterface(ptr: Long) = ???
  protected def _detachInterface(ptr: Long) = ???

  protected def _getCgroupItem(ptr: Long) = ???
  protected def _setCgroupItem(ptr: Long) = ???

  protected def _consoleGetFD(ptr: Long) = ???
  protected def _console(ptr: Long) = ???
  protected def _attach(ptr: Long) = ???
  protected def _attachRunWait(ptr: Long) = ???

  protected def _addDeviceNode(ptr: Long) = ???
  protected def _removeDeviceNode(ptr: Long) = ???

}
