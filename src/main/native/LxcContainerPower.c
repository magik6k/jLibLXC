#include "net_magik6k_jliblxc_natives_NativeLxcContainer.h"
#include <lxc/lxccontainer.h>

/*
  (JNIEnv * env, jobject object, jlong ptr) {
  struct lxc_container* container = (struct lxc_container*) ptr;

}
*/

/*
 * Class:     net_magik6k_jliblxc_natives_NativeLxcContainer
 * Method:    _freeze
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer__1freeze
  (JNIEnv * env, jobject object, jlong ptr) {
  struct lxc_container* container = (struct lxc_container*) ptr;

  return container -> freeze(container);
}

/*
 * Class:     net_magik6k_jliblxc_natives_NativeLxcContainer
 * Method:    _unfreeze
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer__1unfreeze
  (JNIEnv * env, jobject object, jlong ptr) {
  struct lxc_container* container = (struct lxc_container*) ptr;

  return container -> unfreeze(container);
}
/*
 * Class:     net_magik6k_jliblxc_natives_NativeLxcContainer
 * Method:    _start
 * Signature: (J[Ljava/lang/String;)Z
 */
JNIEXPORT jboolean JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer__1start
  (JNIEnv * env, jobject object, jlong ptr, jobjectArray args) {
  struct lxc_container* container = (struct lxc_container*) ptr;

  int argc = (*env) -> GetArrayLength(env, args);
  char** argv = malloc(sizeof(void*) * (argc + 1));
  jstring *    jargv = malloc(sizeof(void*) * (argc + 1));
  argv[argc] = NULL;

  for (int i = 0; i < argc; i++) {
    jargv[i] = (jstring) (*env) -> GetObjectArrayElement(env, args, i);
    argv[i] = (char*) (*env) -> GetStringUTFChars(env, jargv[i], 0);
  }

  bool state = container -> start(container, 0, argc > 0 ? argv : NULL);

  for (int i = 0; i < argc; i++) {
    (*env) -> ReleaseStringUTFChars(env, jargv[i], argv[i]);
  }
  free(argv);
  free(jargv);
  return state;
}

/*
 * Class:     net_magik6k_jliblxc_natives_NativeLxcContainer
 * Method:    _stop
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer__1stop
  (JNIEnv * env, jobject object, jlong ptr) {
  struct lxc_container* container = (struct lxc_container*) ptr;

  return container -> stop(container);
}
/*
 * Class:     net_magik6k_jliblxc_natives_NativeLxcContainer
 * Method:    _reboot
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer__1reboot
  (JNIEnv * env, jobject object, jlong ptr) {
  struct lxc_container* container = (struct lxc_container*) ptr;

  return container -> reboot(container);
}
/*
 * Class:     net_magik6k_jliblxc_natives_NativeLxcContainer
 * Method:    _shutdown
 * Signature: (JI)Z
 */
JNIEXPORT jboolean JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer__1shutdown
  (JNIEnv * env, jobject object, jlong ptr, jint timeout) {
  struct lxc_container* container = (struct lxc_container*) ptr;

  return container -> shutdown(container, timeout);
}