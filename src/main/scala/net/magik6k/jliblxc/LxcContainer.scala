package net.magik6k.jliblxc

import java.io.{FileDescriptor, InputStream, File}

import sun.nio.ch.FileChannelImpl

/** LXC Container instance
  *
  * @param name Name to use for container.
  * @param configPath Optional full path to configuration file to use,
  *                   by default /var/lib/lxc
  */
class LxcContainer(name: String, configPath: String = null) {
  private val native = NativeLoader.getNativeContainer(name, configPath)

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

  /** Returns last error.
    *
    * @return Last error that occurred.
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


  /** Load the specified configuration for the container.
    *
    * @param altFile Optional alternative configuration file.
    * @return true on success, else false.
    */
  def loadConfig(altFile: File = null) = native.loadConfig(if(altFile != null) altFile.getAbsolutePath else null)

  /** Save configuration to a file.
    *
    * @param altFile Optional alternative configuration file.
    * @return true on success, else false.
    */
  def saveConfig(altFile: File = null) = native.saveConfig(if(altFile != null) altFile.getAbsolutePath else null)

  /** Determine full path to the containers configuration file.
    *
    * Each container can have a custom configuration path. However
    * by default it will be set to either the LXCPATH configure
    * variable, or the lxcpath value in the LXC_GLOBAL_CONF configuration
    * file (i.e. /etc/lxc/lxc.conf).
    * The value for a specific container can be changed using
    * #setConfigPath. There is no other way to specify this in general at the moment.
    *
    * @return string representing full path to configuration file.
    */
  def getConfigPath = native.getConfigPath

  /** Set the full path to the containers configuration file.
    *
    * @param path Path to configuration file.
    * @return true on success, else false.
    */
  def setConfigPath(path: File) = native.setConfigPath(path.getAbsolutePath)

  /** Return current config file name.
    *
    * @return config file name, or null on error.
    */
  def configFileName = native.configFileName()

  /** Set a key/value configuration option.
    *
    * @param key Name of option to set.
    * @param value Value to be set.
    *
    * @return true on success, else false.
    */
  def setConfigItem(key: String, value: String) = native.setConfigItem(key, value)

  /** Completely clear the containers in-memory configuration.
    *
    */
  def clearConfig() = native.clearConfig()

  /** Clear a configuration item.
    *
    * @param key Name of option to clear.
    * @return true on success, else false.
    */
  def clearConfigItem(key: String) = native.clearConfigItem(key)

  /** Retrieve the value of a config item.
    *
    * @param key Name of option to get.
    * @return the item or null on error.
    */
  def getConfigItem(key: String) = native.getConfigItem(key)

  /** Retrieve the value of a config item from running container.
    *
    * @param key Name of option to get.
    * @return the item or null on error.
    */
  def getRunningConfigItem(key: String) = native.getRunningConfigItem(key)

  /** Retrieve a list of config item keys given a key prefix.
    *
    * @param key Name of option to get.
    * @return List of items for a given key or null on error.
    */
  def getKeys(key: String) = native.getKeys(key)


  /** Determine if the container wants to run disconnected from the terminal.
    *
    * @param state Value for the daemonize bit (0 or 1).
    * @return true if container wants to be daemonised, else false.
    */
  def wantDaemonize(state: Boolean) = native.wantDaemonize(state)

  /** Determine whether container wishes all file descriptors to be closed on startup.
    *
    * @param state Value for the close_all_fds bit (0 or 1).
    * @return true if container wants all file descriptors closed, else \c false.
    */
  def wantCloseAllFDs(state: Boolean) = native.wantCloseAllFDs(state)


  /** Wait for container to reach a particular state.
    *
    * @param state State to wait for.
    * @param timeout Timeout in seconds.
    * @return true if state reached within timeout, else false.
    * @note A timeout of -1 means wait forever. A timeout
    *       of 0 means do not wait.
    */
  def waitForState(state: String, timeout: Int) = native.waitForState(state, timeout)


  /** Create a container.
    *
    * @param template Template to execute to instantiate the root
    *  filesystem and adjust the configuration.
    * @param bdType Backing store type to use (if \c NULL, \c dir will be used).
    * @param bdSpecs Additional parameters for the backing store (for
    *  example LVM volume group to use).
    * @param flags LXC_CREATE_* options (currently only \ref
    *  LXC_CREATE_QUIET is supported).
    * @param args Arguments to pass to the template
    *
    * @return true on success, else false.
    */
  def create(template: String, bdType: String, bdSpecs: BdevSpecs = null, flags: Int = 0, args: Array[String] = null)
    = native.create(template, bdType, bdSpecs, flags, args)

  /** Copy a stopped container.
    *
    * @param newName New name for the container. If NULL, the same
    *                name is used and a new lxcPath MUST be specified.
    * @param bDevType Optionally force the cloned bdevtype to a specified plugin.
    *                 By default the original is used (subject to snapshot requirements).
    * @param flags Additional \c LXC_CLONE* flags to change the cloning behaviour:
    *              - LXC_CLONE_KEEPNAME
    *              - LXC_CLONE_KEEPMACADDR
    *              - LXC_CLONE_SNAPSHOT
    * @param lxcPath lxcpath in which to create the new container. If
    *                NULL, the original container's lxcpath will be used.
    * @param bDevData Information about how to create the new storage
    *                 (i.e. fstype and fsdata).
    * @param newSize In case of a block device backing store, an
    *                optional size. If \c 0, the original backing store's size will
    *                be used if possible. Note this only applies to the rootfs. For
    *                any other filesystems, the original size will be duplicated.
    * @param hookArgs Additional arguments to pass to the clone hook script.
    * @return Newly-allocated copy of container, or NULL on error.
    */
  def cloneContainer(newName: String, bDevType: String = null, flags: Int = 0, lxcPath: String = null
                     , bDevData: String = null, newSize: Long = 0, hookArgs: Array[String] = null)
    = native.cloneContainer(newName, lxcPath, flags, bDevType, bDevData, newSize, hookArgs)

  /** Rename a container
    *
    * @param newName New name to be used for the container.
    * @return true on success, else false.
    */
  def rename(newName: String) = native.rename(newName)

  /** Delete the container.
    *
    * @return true on success, else false.
    * @note Container must be stopped and have no dependent snapshots.
    */
  def destroy() = native.destroy()

  /** Delete the container and all its snapshots.
    *
    * @return true on success, else false.
    * @note Container must be stopped.
    */
  def destroyWithSnapshots() = native.destroyWithSnapshots()

  /** Destroy all the container's snapshot.
    *
    * @return true on success, else false.
    */
  def snapshotDestroyAll() = native.snapshotDestroyAll()


  /** Checkpoint a container.
    *
    * @param directory The directory to dump the container to.
    * @param stop Whether or not to stop the container after checkpointing.
    * @param verbose Enable criu's verbose logs.
    * @return true on success, else false.
    */
  def checkpoint(directory: String, stop: Boolean, verbose: Boolean) = native.checkpoint(directory, stop, verbose)

  /** Restore a container from a checkpoint.
    *
    * @param directory The directory to dump the container to.
    * @param verbose Enable criu's verbose logs.
    * @return true on success, else false.
    */
  def restore(directory: String, verbose: Boolean) = native.restore(directory, verbose)

  /** Create a container snapshot.
    *
    * Assuming default paths, snapshots will be created as
    * /var/lib/lxc/\<c\>/snaps/snap\
    * where \<c\> represents the container name and
    * represents the zero-based snapshot number.
    *
    * @param commentFile Full path to file containing a description
    *  of the snapshot.
    * @return -1 on error, or zero-based snapshot number.
    *
    * @note commentfile may be NULL but this is discouraged.
    */
  def snapshot(commentFile: String = null) = native.snapshot(commentFile)

  /** Obtain a list of container snapshots.
    *
    * @return List of snapshots.
    */
  def snapshotList() = native.snapshotList()

  /** Create a new container based on a snapshot.
    *
    * The restored container will be a copy (not snapshot) of the snapshot,
    * and restored in the lxcpath of the original container.
    * @param snapName Name of snapshot.
    * @param newName Name to be used for the restored snapshot.
    * @return true on success, else false.
    * @note If newname is the same as the current container
    *  name, the container will be destroyed. However, this will
    *  fail if the  snapshot is overlay-based, since the snapshots
    *  will pin the original container.
    * @note As an example, if the container exists as /var/lib/lxc/c1, snapname might be 'snap0'
    *  (representing /var/lib/lxc/c1/snaps/snap0). If newname is c2,
    *  then snap0 will be copied to /var/lib/lxc/c2.
    */
  def snapshotRestore(snapName: String, newName: String) = native.snapshotRestore(snapName, newName)

  /** Destroy the specified snapshot.
    *
    * @param snapName Name of snapshot.
    * @return true on success, else false.
    */
  def snapshotDestroy(snapName: String) = native.snapshotDestroy(snapName)


  /** Obtain a list of network interfaces.
    *
    * @return Array of network interfaces, or null on error.
    */
  def getInterfaces = native.getInterfaces

  /** Determine the list of container IP addresses.
    *
    * @param interface Network interface name to consider.
    * @param family Network family (for example "inet", "inet6").
    * @param scope IPv6 scope id (ignored if family is not "inet6").
    *
    * @return Array of network interface addresses, or null on error.
    */
  def getIps(interface: String, family: String, scope: Int) = native.getIps(interface, family, scope)

  /** Add specified netdev to the container.
    *
    * @param device name of the net device.
    * @param dstDevice name of the  other net device.
    * @return true on success, else false.
    * @todo FIX THIS DOCS IN LIBLXC AND PUT HERE
    */
  def attachInterface(ptr: Long, device: String, dstDevice: String) = native.attachInterface(device, dstDevice)

  /** Remove specified device from the container.
    *
    * @param device name of the net device.
    * @param dstDevice name of the  other net device.
    * @return true on success, else false.
    * @todo FIX THIS DOCS IN LIBLXC AND PUT HERE
    */
  def detachInterface(ptr: Long, device: String, dstDevice: String) = native.detachInterface(device, dstDevice)

  /** Retrieve the specified cgroup subsystem value for the container.
    *
    * @param subSystem cgroup subsystem to consider, like 'blkio.time'.
    * @return subSystem value or null on error.
    */
  def getCgroupItem(subSystem: String) = native.getCgroupItem(subSystem)

  /** Set the specified cgroup subsystem value for the container.
    *
    * @param subSystem cgroup subsystem to consider, like 'blkio.time'.
    * @param value Value to set for subSystem.
    * @return true on success, else false.
    */
  def setCgroupItem(subSystem: String, value: String) = native.setCgroupItem(subSystem, value)

  /** This method is not implemented yet
    *
    */
  def console() = {
    FileChannelImpl.open(native.console(), null, true, true, true, null)
  }

  /** This method is not implemented yet
    *
    */
  def attach() = native.attach()

  /** This method is not implemented yet
    *
    */
  def attachRunWait() = native.attachRunWait()


  /** Add specified device to the container.
    *
    * @param srcPath Full path of the device.
    * @param dstPath Alternate path in the container (or \p NULL
    *  to use src_path).
    * @return true on success, else false.
    */
  def addDeviceNode(srcPath: String, dstPath: String) = native.addDeviceNode(srcPath, dstPath)

  /** Remove specified device from the container.
    *
    * @param srcPath Full path of the device.
    * @param dstPath Alternate path in the container (or \p NULL
    *  to use src_path).
    * @return true on success, else false.
    */
  def removeDeviceNode(srcPath: String, dstPath: String) = native.removeDeviceNode(srcPath, dstPath)

}
