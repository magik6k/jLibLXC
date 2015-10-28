#include "net_magik6k_jliblxc_natives_NativeLxcContainer.h"
#include <lxc/lxccontainer.h>

/*
 * Class:     net_magik6k_jliblxc_natives_NativeLxcContainer
 * Method:    _getCgroupItem
 * Signature: (JLjava/lang/String;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer__1getCgroupItem
  (JNIEnv * env, jobject object, jlong ptr, jstring jsubSystem) {
  struct lxc_container* container = (struct lxc_container*) ptr;

  char* subSystem = (char*) (*env) -> GetStringUTFChars(env, jsubSystem, 0);
  int len = container -> get_cgroup_item(container, subSystem, NULL, 0);
  if(len < 0)return NULL;
  char* buf = malloc(len + 1);
  buf[len] = '\0';
  container -> get_cgroup_item(container, subSystem, buf, len);
  (*env) -> ReleaseStringUTFChars(env, jsubSystem, subSystem);
  jstring result = (*env) -> NewStringUTF(env, buf);
  free(buf);
  return result;
}

/*
 * Class:     net_magik6k_jliblxc_natives_NativeLxcContainer
 * Method:    _setCgroupItem
 * Signature: (JLjava/lang/String;Ljava/lang/String;)Z
 */
JNIEXPORT jboolean JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer__1setCgroupItem
  (JNIEnv * env, jobject object, jlong ptr, jstring jsubSystem, jstring jvalue) {
  struct lxc_container* container = (struct lxc_container*) ptr;

  char* subSystem = (char*) (*env) -> GetStringUTFChars(env, jsubSystem, 0);
  char* value = (char*) (*env) -> GetStringUTFChars(env, jvalue, 0);
  bool result = container -> set_cgroup_item(container, subSystem, value);
  (*env) -> ReleaseStringUTFChars(env, jsubSystem, subSystem);
  (*env) -> ReleaseStringUTFChars(env, jvalue, value);
  return result;
}