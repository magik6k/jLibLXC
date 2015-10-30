#include "net_magik6k_jliblxc_natives_NativeLxcContainer.h"
#include "net_magik6k_jliblxc_natives_NativeLxcContainerStatic.h"
#include <lxc/lxccontainer.h>

/*
 * Class:     net_magik6k_jliblxc_natives_NativeLxcContainerStatic
 * Method:    list
 * Signature: (Ljava/lang/String;)[Ljava/lang/String;
 */
JNIEXPORT jobjectArray JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainerStatic_list
  (JNIEnv* env, jobject object, jstring jlxcPath) {
  const char* lxcPath = (*env) -> GetStringUTFChars(env, jlxcPath, 0);
  char** containers = NULL;
  int n = list_all_containers(lxcPath, &containers, NULL);
  jobjectArray result = (jobjectArray) (*env) -> NewObjectArray(env, n,
      (*env) -> FindClass(env, "java/lang/String"), (*env) -> NewStringUTF(env, ""));
  for(int i = 0; i < n; i++) {
    (*env) -> SetObjectArrayElement(env, result, i, (*env) -> NewStringUTF(env, containers[i]));
  }

  (*env) -> ReleaseStringUTFChars(env, jlxcPath, lxcPath);
  free(containers);
  return result;
}

/*
 * Class:     net_magik6k_jliblxc_natives_NativeLxcContainerStatic
 * Method:    listActive
 * Signature: (Ljava/lang/String;)[Ljava/lang/String;
 */
JNIEXPORT jobjectArray JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainerStatic_listActive
  (JNIEnv* env, jobject object, jstring jlxcPath) {
  const char* lxcPath = (*env) -> GetStringUTFChars(env, jlxcPath, 0);
  char** containers = NULL;
  int n = list_active_containers(lxcPath, &containers, NULL);
  jobjectArray result = (jobjectArray) (*env) -> NewObjectArray(env, n,
      (*env) -> FindClass(env, "java/lang/String"), (*env) -> NewStringUTF(env, ""));
  for(int i = 0; i < n; i++) {
    (*env) -> SetObjectArrayElement(env, result, i, (*env) -> NewStringUTF(env, containers[i]));
  }

  (*env) -> ReleaseStringUTFChars(env, jlxcPath, lxcPath);
  free(containers);
  return result;
}

/*
 * Class:     net_magik6k_jliblxc_natives_NativeLxcContainer
 * Method:    open
 * Signature: (Ljava/lang/String;Ljava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainerStatic_open
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
