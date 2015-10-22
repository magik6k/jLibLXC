#include "net_magik6k_jliblxc_natives_NativeLxcContainer.h"
#include <lxc/lxccontainer.h>

/*
  (JNIEnv * env, jobject object, jlong ptr) {
  struct lxc_container* container = (struct lxc_container*) ptr;

}
*/

// getLastError
JNIEXPORT jstring JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer__1getLastError
  (JNIEnv * env, jobject object, jlong ptr) {
  struct lxc_container* container = (struct lxc_container*) ptr;

  return (*env) -> NewStringUTF(env, container -> error_string);
}

// isDefined
JNIEXPORT jboolean JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer__1isDefined
  (JNIEnv * env, jobject object, jlong ptr) {
  struct lxc_container* container = (struct lxc_container*) ptr;

  return container -> is_defined(container);
}

// state
JNIEXPORT jstring JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer__1state
  (JNIEnv * env, jobject object, jlong ptr) {
  struct lxc_container* container = (struct lxc_container*) ptr;

  return (*env) -> NewStringUTF(env, container -> state(container));
}

// isRunning
JNIEXPORT jboolean JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer__1isRunning
  (JNIEnv * env, jobject object, jlong ptr) {
  struct lxc_container* container = (struct lxc_container*) ptr;

  return container -> is_running(container);
}

// initPid
JNIEXPORT jint JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer__1initPid
  (JNIEnv * env, jobject object, jlong ptr) {
  struct lxc_container* container = (struct lxc_container*) ptr;

  return container -> init_pid(container);
}

// mayControl
JNIEXPORT jboolean JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer__1mayControl
  (JNIEnv * env, jobject object, jlong ptr) {
  struct lxc_container* container = (struct lxc_container*) ptr;

  return container -> may_control(container);
}