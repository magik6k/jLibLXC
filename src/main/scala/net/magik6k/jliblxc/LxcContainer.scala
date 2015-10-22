package net.magik6k.jliblxc

/** LXC Container instance
  *
  * @param name Name to use for container.
  * @param configPath Full path to configuration file to use.
  */
class LxcContainer(name: String, configPath: String) {
  val native = NativeLoader.getNativeContainer(name, configPath)

  /* Raw list of methods

  isDefined
  state
  isRunning
  initPid
  mayControl

  freeze
  unfreeze
  start
  stop
  reboot
  shutdown

  loadConfig
  saveConfig
  getConfigPath
  setConfigPath
  configFileName
  setConfigItem
  clearConfig
  clearConfigItem
  getConfigItem
  getRunningConfigItem
  getKeys

  wantDaemonize
  wantCloseAllFDs

  waitForState

  create
  cloneContainer
  rename
  destroy
  destroyWithSnapshots
  snapshotDestroyAll

  checkpoint
  restore
  snapshot
  snapshotList
  snapshotRestore
  snapshotDestroy

  getInterfaces
  getIps
  attachInterface
  detachInterface

  getCgroupItem
  setCgroupItem

  consoleGetFD
  console
  attach
  attachRunWait

  addDeviceNode
  removeDeviceNode

  */

  def isDefined = ???
  def state = ???
  def isRunning = ???
  def initPid = ???
  def mayControl = ???

  def freeze() = ???
  def unfreeze() = ???
  def start() = ???
  def stop() = ???
  def reboot() = ???
  def shutdown() = ???

  def loadConfig() = ???
  def saveConfig() = ???
  def getConfigPath = ???
  def setConfigPath() = ???
  def configFileName = ???
  def setConfigItem() = ???
  def clearConfig() = ???
  def clearConfigItem() = ???
  def getConfigItem = ???
  def getRunningConfigItem = ???
  def getKeys = ???

  def wantDaemonize = ???
  def wantCloseAllFDs = ???

  def waitForState = ???

  def create() = ???
  def cloneContainer() = ???
  def rename() = ???
  def destroy() = ???
  def destroyWithSnapshots() = ???
  def snapshotDestroyAll() = ???

  def checkpoint() = ???
  def restore() = ???
  def snapshot() = ???
  def snapshotList() = ???
  def snapshotRestore() = ???
  def snapshotDestroy() = ???

  def getInterfaces = ???
  def getIps = ???
  def attachInterface() = ???
  def detachInterface() = ???

  def getCgroupItem = ???
  def setCgroupItem() = ???

  def consoleGetFD = ???
  def console = ???
  def attach = ???
  def attachRunWait = ???

  def addDeviceNode() = ???
  def removeDeviceNode() = ???


}
