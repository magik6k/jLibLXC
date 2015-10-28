#include "net_magik6k_jliblxc_natives_NativeLxcContainer.h"
#include <lxc/lxccontainer.h>

/*
 * Class:     net_magik6k_jliblxc_natives_NativeLxcContainer
 * Method:    _addDeviceNode
 * Signature: (JLjava/lang/String;Ljava/lang/String;)Z
 */
JNIEXPORT jboolean JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer__1addDeviceNode
  (JNIEnv * env, jobject object, jlong ptr, jstring jsrcPath, jstring jdstPath) {
  struct lxc_container* container = (struct lxc_container*) ptr;

  char* srcPath = (char*) (*env) -> GetStringUTFChars(env, jsrcPath, 0);
  char* dstPath = jdstPath ? (char*) (*env) -> GetStringUTFChars(env, jdstPath, 0) : NULL;
  bool result = container -> add_device_node(container, srcPath, dstPath);
  (*env) -> ReleaseStringUTFChars(env, jsrcPath, srcPath);
  if(dstPath) (*env) -> ReleaseStringUTFChars(env, jdstPath, dstPath);
  return result;
}

/*
 * Class:     net_magik6k_jliblxc_natives_NativeLxcContainer
 * Method:    _removeDeviceNode
 * Signature: (JLjava/lang/String;Ljava/lang/String;)Z
 */
JNIEXPORT jboolean JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer__1removeDeviceNode
  (JNIEnv * env, jobject object, jlong ptr, jstring jsrcPath, jstring jdstPath) {
  struct lxc_container* container = (struct lxc_container*) ptr;

  char* srcPath = (char*) (*env) -> GetStringUTFChars(env, jsrcPath, 0);
  char* dstPath = jdstPath ? (char*) (*env) -> GetStringUTFChars(env, jdstPath, 0) : NULL;
  bool result = container -> remove_device_node(container, srcPath, dstPath);
  (*env) -> ReleaseStringUTFChars(env, jsrcPath, srcPath);
  if(dstPath) (*env) -> ReleaseStringUTFChars(env, jdstPath, dstPath);
  return result;
}