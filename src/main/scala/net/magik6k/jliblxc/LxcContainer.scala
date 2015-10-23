package net.magik6k.jliblxc

/** LXC Container instance
  *
  * @param name Name to use for container.
  * @param configPath Full path to configuration file to use.
  */
class LxcContainer(name: String, configPath: String) {
  val native = NativeLoader.getNativeContainer(name, configPath)

  def this(name: String) = this(name, null)

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

  /** Determine if the caller may control the container.
    *
    * @return false if there is a control socket for the
    *  container monitor and the caller may not access it, otherwise
    *  returns true.
    */
  def mayControl() = native.mayControl()


  /** Freeze running container.
    *
    * @return true on success, else false.
    */
  def freeze() = native.freeze()

  /** Thaw a frozen container.
    *
    * @return true on success, else false.
    */
  def unfreeze() = native.unfreeze()

  /** Start the container.
    *
    * @param args Optional arguments to be passed to init.
    * @return true on success, else false.
    */
  def start(args: String*) = native.start(args.toArray)

  /** Stop the container.
    *
    * @return true on success, else false.
    */
  def stop() = native.stop()

  /** Request the container reboot by sending it SIGINT.
    *
    * @return true if reboot request successful, else false.
    */
  def reboot() = native.reboot()

  /** Request the container shutdown by sending it SIGPWR.
    *
    * @param timeout Seconds to wait before returning false.
    *  (-1 to wait forever, 0 to avoid waiting).
    *
    * @return true if the container was shutdown successfully, else false.
    */
  def shutdown(timeout: Int = 5) = native.shutdown(timeout)


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
