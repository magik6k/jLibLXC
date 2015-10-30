package net.magik6k.jliblxc.natives

import java.io.FileDescriptor

import net.magik6k.jliblxc.{Snapshot, BdevSpecs}

private class NativeLxcContainerStatic {
  @native def open(name: String, configPath: String): Long
}

private object NativeLxcContainer extends NativeLxcContainerStatic

private[jliblxc] class NativeLxcContainer(private var containerPtr: Long) {

  def this(name: String, configPath: String) {this(NativeLxcContainer.open(name, configPath))}
  //def this(containerPtr: Long) {this(); this.containerPtr = containerPtr}

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

  def loadConfig(altFile: String) = _loadConfig(containerPtr, altFile)
  def saveConfig(altFile: String) = _saveConfig(containerPtr, altFile)
  def getConfigPath = _getConfigPath(containerPtr)
  def setConfigPath(path: String) = _setConfigPath(containerPtr, path)
  def configFileName() = _configFileName(containerPtr)
  def setConfigItem(key: String, value: String) = _setConfigItem(containerPtr, key, value)
  def clearConfig() = _clearConfig(containerPtr)
  def clearConfigItem(key: String) = _clearConfigItem(containerPtr, key)
  def getConfigItem(key: String) = _getConfigItem(containerPtr, key)
  def getRunningConfigItem(key: String) = _getRunningConfigItem(containerPtr, key)
  def getKeys(key: String) = _getKeys(containerPtr, key)

  def wantDaemonize(state: Boolean) = _wantDaemonize(containerPtr, state)
  def wantCloseAllFDs(state: Boolean) = _wantCloseAllFDs(containerPtr, state)

  def waitForState(state: String, timeout: Int) = _waitForState(containerPtr, state, timeout)

  def create(template: String, bdType: String, bdSpecs: BdevSpecs, flags: Int, args: Array[String]) = _create(containerPtr, template, bdType, bdSpecs, flags, args)
  def cloneContainer(newName: String, lxcPath: String, flags: Int, bDevType: String, bDevData: String, newSize: Long, hookArgs: Array[String])
    = new NativeLxcContainer(_cloneContainer(containerPtr, newName, lxcPath, flags, bDevType, bDevData, newSize, hookArgs))
  def rename(newName: String) = _rename(containerPtr, newName)
  def destroy() = _destroy(containerPtr)
  def destroyWithSnapshots() = _destroyWithSnapshots(containerPtr)
  def snapshotDestroyAll() = _snapshotDestroyAll(containerPtr)

  def checkpoint(directory: String, stop: Boolean, verbose: Boolean) = _checkpoint(containerPtr, directory, stop, verbose)
  def restore(directory: String, verbose: Boolean) = _restore(containerPtr, directory, verbose)
  def snapshot(commentFile: String) = _snapshot(containerPtr, commentFile)
  def snapshotList() = _snapshotList(containerPtr)
  def snapshotRestore(snapName: String, newName: String) = _snapshotRestore(containerPtr, snapName, newName)
  def snapshotDestroy(snapName: String) = _snapshotDestroy(containerPtr, snapName)

  def getInterfaces = _getInterfaces(containerPtr)
  def getIps(interface: String, family: String, scope: Int) = _getIps(containerPtr, interface, family, scope)
  def attachInterface(device: String, dstDevice: String) = _attachInterface(containerPtr, device, dstDevice)
  def detachInterface(device: String, dstDevice: String) = _detachInterface(containerPtr, device, dstDevice)

  def getCgroupItem(subSystem: String) = _getCgroupItem(containerPtr, subSystem)
  def setCgroupItem(subSystem: String, value: String) = _setCgroupItem(containerPtr, subSystem, value)

  def console() = _console(containerPtr)
  def attach() = _attach(containerPtr)
  def attachRunWait() = _attachRunWait(containerPtr)

  def addDeviceNode(srcPath: String, dstPath: String) = _addDeviceNode(containerPtr, srcPath, dstPath)
  def removeDeviceNode(srcPath: String, dstPath: String) = _removeDeviceNode(containerPtr, srcPath, dstPath)


  /////////////
  // NATIVES //
  /////////////

  // Static
  // Native: LxcContainer.c
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

  // Native: LxcContainerConfig.c
  @native protected def _loadConfig(ptr: Long, altFile: String): Boolean
  @native protected def _saveConfig(ptr: Long, altFile: String): Boolean
  @native protected def _getConfigPath(ptr: Long): String
  @native protected def _setConfigPath(ptr: Long, filePath: String): Boolean
  @native protected def _configFileName(ptr: Long): String
  @native protected def _setConfigItem(ptr: Long, key: String, value: String): Boolean
  @native protected def _clearConfig(ptr: Long): Unit
  @native protected def _clearConfigItem(ptr: Long, key: String): Boolean
  @native protected def _getConfigItem(ptr: Long, key: String): String
  @native protected def _getRunningConfigItem(ptr: Long, key: String): String
  @native protected def _getKeys(ptr: Long, key: String): Array[String]

  // Native: LxcContainerState.c
  @native protected def _wantDaemonize(ptr: Long, state: Boolean): Boolean
  @native protected def _wantCloseAllFDs(ptr: Long, state: Boolean): Boolean
  @native protected def _waitForState(ptr: Long, state: String, timeout: Int): Boolean

  // Native: LxcContainerManage.c
  @native protected def _create(ptr: Long, template: String, bdType: String, bdSpecs: BdevSpecs, flags: Int, args: Array[String]): Boolean
  @native protected def _cloneContainer(ptr: Long, newName: String, lxcPath: String, flags: Int, bDevType: String, bDevData: String, newSize: Long, hookArgs: Array[String]): Long
  @native protected def _rename(ptr: Long, newName: String): Boolean
  @native protected def _destroy(ptr: Long): Boolean
  @native protected def _destroyWithSnapshots(ptr: Long): Boolean
  @native protected def _snapshotDestroyAll(ptr: Long): Boolean

  // Native: LxcContainerSnapshot.c
  @native protected def _checkpoint(ptr: Long, directory: String, stop: Boolean, verbose: Boolean): Boolean
  @native protected def _restore(ptr: Long, directory: String, verbose: Boolean): Boolean
  @native protected def _snapshot(ptr: Long, commentFile: String): Int
  @native protected def _snapshotList(ptr: Long): Array[Snapshot]
  @native protected def _snapshotRestore(ptr: Long, snapName: String, newName: String): Boolean
  @native protected def _snapshotDestroy(ptr: Long, snapName: String): Boolean

  // Native: LxcContainerNetwork.c
  @native protected def _getInterfaces(ptr: Long): Array[String]
  @native protected def _getIps(ptr: Long, interface: String, family: String, scope: Int): Array[String]
  @native protected def _attachInterface(ptr: Long, device: String, dstDevice: String): Boolean
  @native protected def _detachInterface(ptr: Long, device: String, dstDevice: String): Boolean

  // Native: LxcContainerCgroup.c
  @native protected def _getCgroupItem(ptr: Long, subSystem: String): String
  @native protected def _setCgroupItem(ptr: Long, subSystem: String, value: String): Boolean

  // Native: LxcContainerConsole.c
  @native protected def _console(ptr: Long): FileDescriptor
  @native protected def _attach(ptr: Long): Process
  @native protected def _attachRunWait(ptr: Long): Int

  // Native: LxcContainerDevice.c
  @native protected def _addDeviceNode(ptr: Long, srcPath: String, dstPath: String): Boolean
  @native protected def _removeDeviceNode(ptr: Long, srcPath: String, dstPath: String): Boolean
}
