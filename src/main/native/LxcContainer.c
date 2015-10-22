#include "net_magik6k_jliblxc_natives_NativeLxcContainer.h"
#include <lxc/lxccontainer.h>

JNIEXPORT jlong JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer_open
  (JNIEnv* env, jobject object, jstring jname, jstring jconfigPath) {
  const char* name = (*env) -> GetStringUTFChars(env, jname, 0);
  const char* configPath = (*env) -> GetStringUTFChars(env, jconfigPath, 0);

  struct lxc_container* container = lxc_container_new(name, configPath);

  (*env) -> ReleaseStringUTFChars(env, jname, name);
  (*env) -> ReleaseStringUTFChars(env, jconfigPath, configPath);
  return (long) container;
}

JNIEXPORT jlong JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer__1free
  (JNIEnv* env, jobject object, jlong ptr) {
  lxc_container_put((struct lxc_container*) ptr);
}
