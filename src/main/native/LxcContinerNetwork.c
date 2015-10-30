#include "net_magik6k_jliblxc_natives_NativeLxcContainer.h"
#include <lxc/lxccontainer.h>

/*
  (JNIEnv * env, jobject object, jlong ptr) {
  struct lxc_container* container = (struct lxc_container*) ptr;

}
*/

/*
 * Class:     net_magik6k_jliblxc_natives_NativeLxcContainer
 * Method:    _getInterfaces
 * Signature: (J)[Ljava/lang/String;
 */
JNIEXPORT jobjectArray JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer__1getInterfaces
  (JNIEnv * env, jobject object, jlong ptr) {
  struct lxc_container* container = (struct lxc_container*) ptr;

  char** interfaces = container -> get_interfaces(container);
  if(!interfaces) return NULL;

  int n;
  for(n = 0; interfaces[n]; n++);

  jobjectArray result = (jobjectArray) (*env) -> NewObjectArray(env, n,
    (*env) -> FindClass(env, "java/lang/String"), (*env) -> NewStringUTF(env, ""));

  for(int i = 0; i < n; i++) {
    (*env) -> SetObjectArrayElement(env, result, i, (*env) -> NewStringUTF(env, interfaces[i]));
  }

  free(interfaces);
  return result;
}

/*
 * Class:     net_magik6k_jliblxc_natives_NativeLxcContainer
 * Method:    _getIps
 * Signature: (JLjava/lang/String;Ljava/lang/String;I)[Ljava/lang/String;
 */
JNIEXPORT jobjectArray JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer__1getIps
  (JNIEnv * env, jobject object, jlong ptr, jstring jinterface, jstring jfamily, jint scope) {
  struct lxc_container* container = (struct lxc_container*) ptr;

  char* interface = (char*) (*env) -> GetStringUTFChars(env, jinterface, 0);
  char* family = (char*) (*env) -> GetStringUTFChars(env, jfamily, 0);
  char** ips = container -> get_ips(container, interface, family, scope);
  (*env) -> ReleaseStringUTFChars(env, jinterface, interface);
  (*env) -> ReleaseStringUTFChars(env, jfamily, family);
  if(!ips) return NULL;

  int n;
  for(n = 0; ips[n]; n++);

  jobjectArray result = (jobjectArray) (*env) -> NewObjectArray(env, n,
    (*env) -> FindClass(env, "java/lang/String"), (*env) -> NewStringUTF(env, ""));

  for(int i = 0; i < n; i++) {
    (*env) -> SetObjectArrayElement(env, result, i, (*env) -> NewStringUTF(env, ips[i]));
  }

  free(ips);
  return result;
}

/*
 * Class:     net_magik6k_jliblxc_natives_NativeLxcContainer
 * Method:    _attachInterface
 * Signature: (JLjava/lang/String;Ljava/lang/String;)Z
 */
JNIEXPORT jboolean JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer__1attachInterface
  (JNIEnv * env, jobject object, jlong ptr, jstring jdevice, jstring jdstDevice) {
  struct lxc_container* container = (struct lxc_container*) ptr;

  char* device = (char*) (*env) -> GetStringUTFChars(env, jdevice, 0);
  char* dstDevice = (char*) (*env) -> GetStringUTFChars(env, jdstDevice, 0);
  bool result = container -> attach_interface(container, device, dstDevice);
  (*env) -> ReleaseStringUTFChars(env, jdevice, device);
  (*env) -> ReleaseStringUTFChars(env, jdstDevice, dstDevice);
  return result;
}

/*
 * Class:     net_magik6k_jliblxc_natives_NativeLxcContainer
 * Method:    _detachInterface
 * Signature: (JLjava/lang/String;Ljava/lang/String;)Z
 */
JNIEXPORT jboolean JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer__1detachInterface
  (JNIEnv * env, jobject object, jlong ptr, jstring jdevice, jstring jdstDevice) {
  struct lxc_container* container = (struct lxc_container*) ptr;

  char* device = (char*) (*env) -> GetStringUTFChars(env, jdevice, 0);
  char* dstDevice = (char*) (*env) -> GetStringUTFChars(env, jdstDevice, 0);
  bool result = container -> detach_interface(container, device, dstDevice);
  (*env) -> ReleaseStringUTFChars(env, jdevice, device);
  (*env) -> ReleaseStringUTFChars(env, jdstDevice, dstDevice);
  return result;
}
