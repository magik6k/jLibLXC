#include "net_magik6k_jliblxc_natives_NativeLxcContainer.h"
#include <lxc/lxccontainer.h>

/*
  (JNIEnv * env, jobject object, jlong ptr) {
  struct lxc_container* container = (struct lxc_container*) ptr;

}
*/

/*
 * Class:     net_magik6k_jliblxc_natives_NativeLxcContainer
 * Method:    _create
 * Signature: (JLjava/lang/String;Ljava/lang/String;Lnet/magik6k/jliblxc/BdevSpecs;I[Ljava/lang/String;)V
 */
JNIEXPORT jboolean JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer__1create
  (JNIEnv * env, jobject object, jlong ptr, jstring jtemplate, jstring jbdType, jobject bdSpecs, jint flags, jobjectArray args) {
  struct lxc_container* container = (struct lxc_container*) ptr;

  const char* template  = (*env) -> GetStringUTFChars(env, jtemplate, 0);
  const char* bdType  = (*env) -> GetStringUTFChars(env, jbdType, 0);

  int argc = args ? (*env) -> GetArrayLength(env, args) : 0;
  char**    argv  = argc ? malloc(sizeof(void*) * (argc + 1)) : NULL;
  jstring * jargv = argc ? malloc(sizeof(void*) * (argc + 1)) : NULL;
  if(args) {
    argv[argc] = NULL;

    for (int i = 0; i < argc; i++) {
      jargv[i] = (jstring) (*env) -> GetObjectArrayElement(env, args, i);
      argv[i] = (char*) (*env) -> GetStringUTFChars(env, jargv[i], 0);
    }
  }

  struct bdev_specs bdSpecData;
  jclass bdSpecClass, bdLVMClass, bdZFSClass;
  jstring fstype;
  jint fssize;
  jstring dir;

  jobject lvm;
  jstring lv, vg, thinpool;

  jobject zfs;
  jstring zfsroot;

  if(bdSpecs) {
    bdSpecClass = (*env) -> FindClass(env, "net.magik6k.jliblxc.BdevSpecs");

    fstype = (*env) -> GetObjectField(env, bdSpecs, (*env) -> GetFieldID(env, bdSpecClass, "fstype" , "Ljava/lang/String;"));
    fssize = (*env) -> GetIntField(env, bdSpecs, (*env) -> GetFieldID(env, bdSpecClass, "fssize" , "J"));
    dir = (*env) -> GetObjectField(env, bdSpecs, (*env) -> GetFieldID(env, bdSpecClass, "dir" , "Ljava/lang/String;"));

    bdSpecData.fstype = (char*) (*env) -> GetStringUTFChars(env, fstype, 0);
    bdSpecData.fssize = fssize;
    bdSpecData.dir = (char*) (*env) -> GetStringUTFChars(env, dir, 0);

    bdSpecData.lvm.vg = NULL;
    bdSpecData.lvm.lv = NULL;
    bdSpecData.lvm.thinpool = NULL;
    bdSpecData.zfs.zfsroot = NULL;

    lvm = (*env) -> GetObjectField(env, bdSpecs, (*env) -> GetFieldID(env, bdSpecClass, "lvm" , "Lnet/magik6k/jliblxc/BdevLVM;"));
    zfs = (*env) -> GetObjectField(env, bdSpecs, (*env) -> GetFieldID(env, bdSpecClass, "zfs" , "Lnet/magik6k/jliblxc/BdevZFS;"));

    if(lvm) {
      bdLVMClass = (*env) -> FindClass(env, "net.magik6k.jliblxc.BdevLVM");
      lv = (*env) -> GetObjectField(env, lvm, (*env) -> GetFieldID(env, bdLVMClass, "lv" , "Ljava/lang/String;"));
      vg = (*env) -> GetObjectField(env, lvm, (*env) -> GetFieldID(env, bdLVMClass, "vg" , "Ljava/lang/String;"));
      thinpool = (*env) -> GetObjectField(env, lvm, (*env) -> GetFieldID(env, bdLVMClass, "thinpool" , "Ljava/lang/String;"));

      bdSpecData.lvm.lv = (char*) (*env) -> GetStringUTFChars(env, lv, 0);
      bdSpecData.lvm.vg = (char*) (*env) -> GetStringUTFChars(env, lv, 0);
      bdSpecData.lvm.thinpool = (char*) (*env) -> GetStringUTFChars(env, thinpool, 0);
    }

    if(zfs) {
      bdZFSClass = (*env) -> FindClass(env, "net.magik6k.jliblxc.BdevZFS");
      zfsroot = (*env) -> GetObjectField(env, zfs, (*env) -> GetFieldID(env, bdZFSClass, "zfsroot" , "Ljava/lang/String;"));

      bdSpecData.zfs.zfsroot = (char*) (*env) -> GetStringUTFChars(env, zfsroot, 0);
    }
  }

  bool result = container -> create(container, template, bdType, bdSpecs ? &bdSpecData : NULL, flags, argv);

  if(bdSpecs) {
    (*env) -> ReleaseStringUTFChars(env, fstype, bdSpecData.fstype);
    (*env) -> ReleaseStringUTFChars(env, dir, bdSpecData.dir);

    if(lvm) {
      (*env) -> ReleaseStringUTFChars(env, lv, bdSpecData.lvm.lv);
      (*env) -> ReleaseStringUTFChars(env, vg, bdSpecData.lvm.vg);
      (*env) -> ReleaseStringUTFChars(env, thinpool, bdSpecData.lvm.thinpool);
    }

    if(zfs) {
      (*env) -> ReleaseStringUTFChars(env, zfsroot, bdSpecData.zfs.zfsroot);
    }
  }

  if(args) {
    for (int i = 0; i < argc; i++) {
      (*env) -> ReleaseStringUTFChars(env, jargv[i], argv[i]);
    }
    free(argv);
    free(jargv);
  }
  (*env) -> ReleaseStringUTFChars(env, jtemplate, template);
  (*env) -> ReleaseStringUTFChars(env, jbdType, bdType);

  return result;
}

/*
 * Class:     net_magik6k_jliblxc_natives_NativeLxcContainer
 * Method:    _cloneContainer
 * Signature: (JLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;J[Ljava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer__1cloneContainer
  (JNIEnv * env, jobject object, jlong ptr, jstring jnewName, jstring jlxcPath, jint flags, jstring jbDevType, jstring jbDevData, jlong newSize, jobjectArray args) {
  struct lxc_container* container = (struct lxc_container*) ptr;

  const char* newName = jnewName ? (*env) -> GetStringUTFChars(env, jnewName, 0) : NULL;
  const char* lxcPath = jlxcPath ? (*env) -> GetStringUTFChars(env, jlxcPath, 0) : NULL;
  const char* bDevType = jbDevType ? (*env) -> GetStringUTFChars(env, jbDevType, 0) : NULL;
  const char* bDevData = jbDevData ? (*env) -> GetStringUTFChars(env, jbDevData, 0) : NULL;

  int argc = args ? (*env) -> GetArrayLength(env, args) : 0;
  char**     argv  = argc ? malloc(sizeof(void*) * (argc + 1)) : NULL;
  jstring * jargv = argc ? malloc(sizeof(void*) * (argc + 1)) : NULL;
  if(args) {
    argv[argc] = NULL;
    for (int i = 0; i < argc; i++) {
      jargv[i] = (jstring) (*env) -> GetObjectArrayElement(env, args, i);
      argv[i] = (char*) (*env) -> GetStringUTFChars(env, jargv[i], 0);
    }
  }

  long result = (long) container -> clone(container, newName, lxcPath, flags, bDevType, bDevData, newSize, argv);

  if(args) {
    for (int i = 0; i < argc; i++) {
      (*env) -> ReleaseStringUTFChars(env, jargv[i], argv[i]);
    }
    free(argv);
    free(jargv);
  }
  if(newName) (*env) -> ReleaseStringUTFChars(env, jnewName, newName);
  if(lxcPath) (*env) -> ReleaseStringUTFChars(env, jlxcPath, lxcPath);
  if(bDevType) (*env) -> ReleaseStringUTFChars(env, jbDevType, bDevType);
  if(bDevData) (*env) -> ReleaseStringUTFChars(env, jbDevData, bDevData);

  return result;
}

/*
 * Class:     net_magik6k_jliblxc_natives_NativeLxcContainer
 * Method:    _rename
 * Signature: (JLjava/lang/String;)Z
 */
JNIEXPORT jboolean JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer__1rename
  (JNIEnv * env, jobject object, jlong ptr, jstring jnewName) {
  struct lxc_container* container = (struct lxc_container*) ptr;

  const char* newName = (*env) -> GetStringUTFChars(env, jnewName, 0);
  bool result = container -> rename(container, newName);
  (*env) -> ReleaseStringUTFChars(env, jnewName, newName);
  return result;
}

/*
 * Class:     net_magik6k_jliblxc_natives_NativeLxcContainer
 * Method:    _destroy
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer__1destroy
  (JNIEnv * env, jobject object, jlong ptr) {
  struct lxc_container* container = (struct lxc_container*) ptr;

  return container -> destroy(container);
}

/*
 * Class:     net_magik6k_jliblxc_natives_NativeLxcContainer
 * Method:    _destroyWithSnapshots
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer__1destroyWithSnapshots
  (JNIEnv * env, jobject object, jlong ptr) {
  struct lxc_container* container = (struct lxc_container*) ptr;

  return container -> destroy_with_snapshots(container);
}

/*
 * Class:     net_magik6k_jliblxc_natives_NativeLxcContainer
 * Method:    _snapshotDestroyAll
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer__1snapshotDestroyAll
  (JNIEnv * env, jobject object, jlong ptr) {
  struct lxc_container* container = (struct lxc_container*) ptr;

  return container -> snapshot_destroy_all(container);
}