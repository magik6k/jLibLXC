package net.magik6k.jliblxc

class BdevSpecs(var fstype: String, var fssize: Long, var dir: String) {
  var zfs: BdevZFS = null
  var lvm: BdevLVM = null

  def this(fstype: String, fssize: Long, dir: String, zfs: BdevZFS) = { this(fstype, fssize, dir); this.zfs = zfs }
  def this(fstype: String, fssize: Long, dir: String, lvm: BdevLVM) = { this(fstype, fssize, dir); this.lvm = lvm }
}

class BdevZFS(var zfsroot: String)
class BdevLVM(var vg: String, var lv: String, var thinpool: String)
