#include "net_magik6k_jliblxc_natives_NativeLxcContainer.h"
#include <lxc/lxccontainer.h>

/*
  (JNIEnv * env, jobject object, jlong ptr) {
  struct lxc_container* container = (struct lxc_container*) ptr;

}
*/

/*
 * Class:     net_magik6k_jliblxc_natives_NativeLxcContainer
 * Method:    _loadConfig
 * Signature: (JLjava/lang/String;)Z
 */
JNIEXPORT jboolean JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer__1loadConfig
  (JNIEnv * env, jobject object, jlong ptr, jstring jaltFile) {
  struct lxc_container* container = (struct lxc_container*) ptr;

  const char* altFile = NULL;
  if(jaltFile) {
    altFile = (*env) -> GetStringUTFChars(env, jaltFile, 0);
  }

  bool result = container -> load_config(container, altFile);

  if(altFile) {
    (*env) -> ReleaseStringUTFChars(env, jaltFile, altFile);
  }
  return result;
}

/*
 * Class:     net_magik6k_jliblxc_natives_NativeLxcContainer
 * Method:    _saveConfig
 * Signature: (JLjava/lang/String;)Z
 */
JNIEXPORT jboolean JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer__1saveConfig
  (JNIEnv * env, jobject object, jlong ptr, jstring jaltFile) {
  struct lxc_container* container = (struct lxc_container*) ptr;

  const char* altFile = NULL;
  if(jaltFile) {
    altFile = (*env) -> GetStringUTFChars(env, jaltFile, 0);
  }

  bool result = container -> save_config(container, altFile);

  if(altFile) {
    (*env) -> ReleaseStringUTFChars(env, jaltFile, altFile);
  }
  return result;
}

/*
 * Class:     net_magik6k_jliblxc_natives_NativeLxcContainer
 * Method:    _getConfigPath
 * Signature: (J)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer__1getConfigPath
  (JNIEnv * env, jobject object, jlong ptr) {
  struct lxc_container* container = (struct lxc_container*) ptr;

  return (*env) -> NewStringUTF(env, container -> get_config_path(container));
}

/*
 * Class:     net_magik6k_jliblxc_natives_NativeLxcContainer
 * Method:    _setConfigPath
 * Signature: (JLjava/lang/String;)Z
 */
JNIEXPORT jboolean JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer__1setConfigPath
  (JNIEnv * env, jobject object, jlong ptr, jstring jpath) {
  struct lxc_container* container = (struct lxc_container*) ptr;

  const char* path = (*env) -> GetStringUTFChars(env, jpath, 0);
  bool result = container -> set_config_path(container, path);
  (*env) -> ReleaseStringUTFChars(env, jpath, path);
  return result;
}

/*
 * Class:     net_magik6k_jliblxc_natives_NativeLxcContainer
 * Method:    _configFileName
 * Signature: (J)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer__1configFileName
  (JNIEnv * env, jobject object, jlong ptr) {
  struct lxc_container* container = (struct lxc_container*) ptr;

  char* configName = container -> config_file_name(container);
  jstring jconfigName = (*env) -> NewStringUTF(env, configName);
  free(configName);
  return jconfigName;
}

/*
 * Class:     net_magik6k_jliblxc_natives_NativeLxcContainer
 * Method:    _setConfigItem
 * Signature: (JLjava/lang/String;Ljava/lang/String;)Z
 */
JNIEXPORT jboolean JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer__1setConfigItem
  (JNIEnv * env, jobject object, jlong ptr, jstring jkey, jstring jvalue) {
  struct lxc_container* container = (struct lxc_container*) ptr;

  const char* key = (*env) -> GetStringUTFChars(env, jkey, 0);
  const char* value = (*env) -> GetStringUTFChars(env, jvalue, 0);
  bool result = container -> set_config_item(container, key, value);
  (*env) -> ReleaseStringUTFChars(env, jkey, key);
  (*env) -> ReleaseStringUTFChars(env, jvalue, value);
  return result;
}

/*
 * Class:     net_magik6k_jliblxc_natives_NativeLxcContainer
 * Method:    _clearConfig
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer__1clearConfig
  (JNIEnv * env, jobject object, jlong ptr) {
  struct lxc_container* container = (struct lxc_container*) ptr;

  return container -> clear_config(container);
}

/*
 * Class:     net_magik6k_jliblxc_natives_NativeLxcContainer
 * Method:    _clearConfigItem
 * Signature: (JLjava/lang/String;)Z
 */
JNIEXPORT jboolean JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer__1clearConfigItem
  (JNIEnv * env, jobject object, jlong ptr, jstring jkey) {
  struct lxc_container* container = (struct lxc_container*) ptr;

  const char* key = (*env) -> GetStringUTFChars(env, jkey, 0);
  bool result = container -> clear_config_item(container, key);
  (*env) -> ReleaseStringUTFChars(env, jkey, key);
  return result;
}

/*
 * Class:     net_magik6k_jliblxc_natives_NativeLxcContainer
 * Method:    _getConfigItem
 * Signature: (JLjava/lang/String;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer__1getConfigItem
  (JNIEnv * env, jobject object, jlong ptr, jstring jkey) {
  struct lxc_container* container = (struct lxc_container*) ptr;

  const char* key = (*env) -> GetStringUTFChars(env, jkey, 0);
  int len = container -> get_config_item(container, key, NULL, 0);
  if(len < 0) return NULL;
  char* buf = malloc(len + 1);
  container -> get_config_item(container, key, buf, len + 1);
  (*env) -> ReleaseStringUTFChars(env, jkey, key);
  jstring result = (*env) -> NewStringUTF(env, buf);
  free(buf);
  return result;
}

/*
 * Class:     net_magik6k_jliblxc_natives_NativeLxcContainer
 * Method:    _getRunningConfigItem
 * Signature: (JLjava/lang/String;)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer__1getRunningConfigItem
  (JNIEnv * env, jobject object, jlong ptr, jstring jkey) {
  struct lxc_container* container = (struct lxc_container*) ptr;

  const char* key = (*env) -> GetStringUTFChars(env, jkey, 0);
  char* value = container -> get_running_config_item(container, key);
  (*env) -> ReleaseStringUTFChars(env, jkey, key);
  jstring result = (*env) -> NewStringUTF(env, value);
  free(value);
  return result;
}

#include <stdio.h>
/*
 * Class:     net_magik6k_jliblxc_natives_NativeLxcContainer
 * Method:    _getKeys
 * Signature: (JLjava/lang/String;)[Ljava/lang/String;
 */
JNIEXPORT jobjectArray JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer__1getKeys
  (JNIEnv * env, jobject object, jlong ptr, jstring jkey) { //FIXME: It may work or not; probably needs debugging
  struct lxc_container* container = (struct lxc_container*) ptr;

  const char* key = (*env) -> GetStringUTFChars(env, jkey, 0);
  int len = container -> get_keys(container, key, NULL, 0);
  //printf("For key %s -> Len: %d\n", key, len);fflush(stdout);
  if(len < 0) return NULL;
  char* buf = malloc(len + 1);
  container -> get_keys(container, key, buf, len + 1);
  int lines;
  for(lines = 0; buf[lines]; buf[lines] == '\n' ? lines++ : *buf++);
  //printf("lines: %d\n", lines);
  jobjectArray result = (jobjectArray) (*env) -> NewObjectArray(env, lines,
    (*env) -> FindClass(env, "java/lang/String"), (*env) -> NewStringUTF(env, ""));

  int start = 0;
  int n = 0;
  for(int i = 0; 1; i++) {
    //printf("P: %d\n", buf[i]);
    if(buf[i] != '\n' && buf[i]) continue;
    int next = 0;
    if(!buf[i]) next = -1;
    if(buf[i]) next = i + 1;
    buf[i] = '\0';
    //printf("K: %s\n", buf + start);
    (*env) -> SetObjectArrayElement(env, result, n, (*env) -> NewStringUTF(env, buf + start));
    if(next < 0) break;
    start = next;
    n++;
  }
  fflush(stdout);
  free(buf);
  (*env) -> ReleaseStringUTFChars(env, jkey, key);

  return result;
}
