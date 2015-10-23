#include "net_magik6k_jliblxc_natives_NativeLxcContainer.h"
#include <lxc/lxccontainer.h>

/*
 * Class:     net_magik6k_jliblxc_natives_NativeLxcContainer
 * Method:    open
 * Signature: (Ljava/lang/String;Ljava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer_open
  (JNIEnv* env, jobject object, jstring jname, jstring jconfigPath) {
  const char* name = (*env) -> GetStringUTFChars(env, jname, 0);
  const char* configPath = jconfigPath ? (*env) -> GetStringUTFChars(env, jconfigPath, 0) : NULL;

  struct lxc_container* container = lxc_container_new(name, configPath);

  (*env) -> ReleaseStringUTFChars(env, jname, name);
  if(configPath) {(*env) -> ReleaseStringUTFChars(env, jconfigPath, configPath);}
  return (long) container;
}

/*
 * Class:     net_magik6k_jliblxc_natives_NativeLxcContainer
 * Method:    _free
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer__1free
  (JNIEnv* env, jobject object, jlong ptr) {
  lxc_container_put((struct lxc_container*) ptr);
}
