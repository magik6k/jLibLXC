#include "net_magik6k_jliblxc_natives_NativeLxcContainer.h"
#include <lxc/lxccontainer.h>

/*
  (JNIEnv * env, jobject object, jlong ptr) {
  struct lxc_container* container = (struct lxc_container*) ptr;

}
*/

/*
 * Class:     net_magik6k_jliblxc_natives_NativeLxcContainer
 * Method:    _wantDaemonize
 * Signature: (JZ)Z
 */
JNIEXPORT jboolean JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer__1wantDaemonize
  (JNIEnv * env, jobject object, jlong ptr, jboolean state) {
  struct lxc_container* container = (struct lxc_container*) ptr;

  return container -> want_daemonize(container, state);
}

/*
 * Class:     net_magik6k_jliblxc_natives_NativeLxcContainer
 * Method:    _wantCloseAllFDs
 * Signature: (JZ)Z
 */
JNIEXPORT jboolean JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer__1wantCloseAllFDs
  (JNIEnv * env, jobject object, jlong ptr, jboolean state) {
  struct lxc_container* container = (struct lxc_container*) ptr;

  return container -> want_close_all_fds(container, state);
}

/*
 * Class:     net_magik6k_jliblxc_natives_NativeLxcContainer
 * Method:    _waitForState
 * Signature: (JLjava/lang/String;I)Z
 */
JNIEXPORT jboolean JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer__1waitForState
  (JNIEnv * env, jobject object, jlong ptr, jstring jstate, jint timeout) {
  struct lxc_container* container = (struct lxc_container*) ptr;
  const char* state = (*env) -> GetStringUTFChars(env, jstate, 0);
  bool result = container -> wait(container, state, timeout);
  (*env) -> ReleaseStringUTFChars(env, jstate, state);
  return result;
}