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

  /** Returns last error
    *
    * @return Last error that occurred
    */
  def getLastError = native.getLastError

  /** Determine if /var/lib/lxc/[name]/config exists.
    *
    * @return true if container is defined, else false.
    */
  def isDefined = native.isDefined

  /** Determine state of container.
    *
    * @return Static upper-case string representing state of container.
    */
  def state() = native.state()

  /** Determine if container is running.
    *
    * @return true if running, else false.
    */
  def isRunning = native.isRunning

  /** Determine process ID of the containers init process.
    *
    * @return pid of init process as seen from outside the container.
    */
  def initPid() = native.initPid()

  /** This method is not implemented yet
    *
    */
  def mayControl() = native.mayControl()


  /** This method is not implemented yet
    *
    */
  def freeze() = native.freeze()

  /** This method is not implemented yet
    *
    */
  def unfreeze() = native.unfreeze()

  /** This method is not implemented yet
    *
    */
  def start() = native.start()

  /** This method is not implemented yet
    *
    */
  def stop() = native.stop()

  /** This method is not implemented yet
    *
    */
  def reboot() = native.reboot()

  /** This method is not implemented yet
    *
    */
  def shutdown() = native.shutdown()


  /** This method is not implemented yet
    *
    */
  def loadConfig() = native.loadConfig()

  /** This method is not implemented yet
    *
    */
  def saveConfig() = native.saveConfig()

  /** This method is not implemented yet
    *
    */
  def getConfigPath() = native.getConfigPath

  /** This method is not implemented yet
    *
    */
  def setConfigPath() = native.setConfigPath()

  /** This method is not implemented yet
    *
    */
  def configFileName() = native.configFileName()

  /** This method is not implemented yet
    *
    */
  def setConfigItem() = native.setConfigItem()

  /** This method is not implemented yet
    *
    */
  def clearConfig() = native.clearConfig()

  /** This method is not implemented yet
    *
    */
  def clearConfigItem() = native.clearConfigItem()

  /** This method is not implemented yet
    *
    */
  def getConfigItem() = native.getConfigItem

  /** This method is not implemented yet
    *
    */
  def getRunningConfigItem() = native.getRunningConfigItem

  /** This method is not implemented yet
    *
    */
  def getKeys() = native.getKeys


  /** This method is not implemented yet
    *
    */
  def wantDaemonize() = native.wantDaemonize()

  /** This method is not implemented yet
    *
    */
  def wantCloseAllFDs() = native.wantCloseAllFDs()


  /** This method is not implemented yet
    *
    */
  def waitForState() = native.waitForState()


  /** This method is not implemented yet
    *
    */
  def create() = native.create()

  /** This method is not implemented yet
    *
    */
  def cloneContainer() = native.cloneContainer()

  /** This method is not implemented yet
    *
    */
  def rename() = native.rename()

  /** This method is not implemented yet
    *
    */
  def destroy() = native.destroy()

  /** This method is not implemented yet
    *
    */
  def destroyWithSnapshots() = native.destroyWithSnapshots()

  /** This method is not implemented yet
    *
    */
  def snapshotDestroyAll() = native.snapshotDestroyAll()


  /** This method is not implemented yet
    *
    */
  def checkpoint() = native.checkpoint()

  /** This method is not implemented yet
    *
    */
  def restore() = native.restore()

  /** This method is not implemented yet
    *
    */
  def snapshot() = native.snapshot()

  /** This method is not implemented yet
    *
    */
  def snapshotList() = native.snapshotList()

  /** This method is not implemented yet
    *
    */
  def snapshotRestore() = native.snapshotRestore()

  /** This method is not implemented yet
    *
    */
  def snapshotDestroy() = native.snapshotDestroy()


  /** This method is not implemented yet
    *
    */
  def getInterfaces() = native.getInterfaces

  /** This method is not implemented yet
    *
    */
  def getIps() = native.getIps

  /** This method is not implemented yet
    *
    */
  def attachInterface() = native.attachInterface()

  /** This method is not implemented yet
    *
    */
  def detachInterface() = native.detachInterface()


  /** This method is not implemented yet
    *
    */
  def getCgroupItem() = native.getCgroupItem

  /** This method is not implemented yet
    *
    */
  def setCgroupItem() = native.setCgroupItem()


  /** This method is not implemented yet
    *
    */
  def consoleGetFD() = native.consoleGetFD()

  /** This method is not implemented yet
    *
    */
  def console() = native.console()

  /** This method is not implemented yet
    *
    */
  def attach() = native.attach()

  /** This method is not implemented yet
    *
    */
  def attachRunWait() = native.attachRunWait()


  /** This method is not implemented yet
    *
    */
  def addDeviceNode() = native.addDeviceNode()

  /** This method is not implemented yet
    *
    */
  def removeDeviceNode() = native.removeDeviceNode()



}
