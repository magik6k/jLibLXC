package net.magik6k.jliblxc.natives

private[jliblxc] class NativeLxcContainer(name: String, configPath: String) {
  private var containerInfo: Long = open(name, configPath)

  ////////////
  // EXPORT //
  ////////////

  // Static
  def free() = {
    if(containerInfo != 0) _free(containerInfo)
    containerInfo = 0
  }

  override def finalize() = free()

  // Non-static
  def isDefined = _isDefined(containerInfo)
  def state() = _state(containerInfo)
  def isRunning = _isRunning(containerInfo)
  def initPid() = _initPid(containerInfo)
  def mayControl() = _mayControl(containerInfo)

  def freeze() = _freeze(containerInfo)
  def unfreeze() = _unfreeze(containerInfo)
  def start() = _start(containerInfo)
  def stop() = _stop(containerInfo)
  def reboot() = _reboot(containerInfo)
  def shutdown() = _shutdown(containerInfo)

  def loadConfig() = _loadConfig(containerInfo)
  def saveConfig() = _saveConfig(containerInfo)
  def getConfigPath = _getConfigPath(containerInfo)
  def setConfigPath() = _setConfigPath(containerInfo)
  def configFileName() = _configFileName(containerInfo)
  def setConfigItem() = _setConfigItem(containerInfo)
  def clearConfig() = _clearConfig(containerInfo)
  def clearConfigItem() = _clearConfigItem(containerInfo)
  def getConfigItem = _getConfigItem(containerInfo)
  def getRunningConfigItem = _getRunningConfigItem(containerInfo)
  def getKeys = _getKeys(containerInfo)

  def wantDaemonize() = _wantDaemonize(containerInfo)
  def wantCloseAllFDs() = _wantCloseAllFDs(containerInfo)

  def waitForState() = _waitForState(containerInfo)

  def create() = _create(containerInfo)
  def cloneContainer() = _cloneContainer(containerInfo)
  def rename() = _rename(containerInfo)
  def destroy() = _destroy(containerInfo)
  def destroyWithSnapshots() = _destroyWithSnapshots(containerInfo)
  def snapshotDestroyAll() = _snapshotDestroyAll(containerInfo)

  def checkpoint() = _checkpoint(containerInfo)
  def restore() = _restore(containerInfo)
  def snapshot() = _snapshot(containerInfo)
  def snapshotList() = _snapshotList(containerInfo)
  def snapshotRestore() = _snapshotRestore(containerInfo)
  def snapshotDestroy() = _snapshotDestroy(containerInfo)

  def getInterfaces = _getInterfaces(containerInfo)
  def getIps = _getIps(containerInfo)
  def attachInterface() = _attachInterface(containerInfo)
  def detachInterface() = _detachInterface(containerInfo)

  def getCgroupItem = _getCgroupItem(containerInfo)
  def setCgroupItem() = _setCgroupItem(containerInfo)

  def consoleGetFD() = _consoleGetFD(containerInfo)
  def console() = _console(containerInfo)
  def attach() = _attach(containerInfo)
  def attachRunWait() = _attachRunWait(containerInfo)

  def addDeviceNode() = _addDeviceNode(containerInfo)
  def removeDeviceNode() = _removeDeviceNode(containerInfo)


  /////////////
  // NATIVES //
  /////////////

  // Static
  @native protected def open(name: String, configPath: String): Long
  @native protected def _free(ptr: Long): Long

  // Non-static
  @native protected def _isDefined(ptr: Long): Unit
  @native protected def _state(ptr: Long): Unit
  @native protected def _isRunning(ptr: Long): Unit
  @native protected def _initPid(ptr: Long): Unit
  @native protected def _mayControl(ptr: Long): Unit

  @native protected def _freeze(ptr: Long): Unit
  @native protected def _unfreeze(ptr: Long): Unit
  @native protected def _start(ptr: Long): Unit
  @native protected def _stop(ptr: Long): Unit
  @native protected def _reboot(ptr: Long): Unit
  @native protected def _shutdown(ptr: Long): Unit

  @native protected def _loadConfig(ptr: Long): Unit
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
}
