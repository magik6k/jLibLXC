#include "net_magik6k_jliblxc_natives_NativeLxcContainer.h"
#include <lxc/lxccontainer.h>

/*
  (JNIEnv * env, jobject object, jlong ptr) {
  struct lxc_container* container = (struct lxc_container*) ptr;

}
*/

/*
 * Class:     net_magik6k_jliblxc_natives_NativeLxcContainer
 * Method:    _checkpoint
 * Signature: (JLjava/lang/String;ZZ)Z
 */
JNIEXPORT jboolean JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer__1checkpoint
  (JNIEnv * env, jobject object, jlong ptr, jstring jdirectory, jboolean stop, jboolean verbose) {
  struct lxc_container* container = (struct lxc_container*) ptr;

  char* directory = (char*) (*env) -> GetStringUTFChars(env, jdirectory, 0);
  bool result = container -> checkpoint(container, directory, stop, verbose);
  (*env) -> ReleaseStringUTFChars(env, jdirectory, directory);
  return result;
}

/*
 * Class:     net_magik6k_jliblxc_natives_NativeLxcContainer
 * Method:    _restore
 * Signature: (JLjava/lang/String;Z)Z
 */
JNIEXPORT jboolean JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer__1restore
  (JNIEnv * env, jobject object, jlong ptr, jstring jdirectory, jboolean verbose) {
  struct lxc_container* container = (struct lxc_container*) ptr;

  char* directory = (char*) (*env) -> GetStringUTFChars(env, jdirectory, 0);
  bool result = container -> restore(container, directory, verbose);
  (*env) -> ReleaseStringUTFChars(env, jdirectory, directory);
  return result;
}

/*
 * Class:     net_magik6k_jliblxc_natives_NativeLxcContainer
 * Method:    _snapshot
 * Signature: (JLjava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer__1snapshot
  (JNIEnv * env, jobject object, jlong ptr, jstring jcommetFile) {
  struct lxc_container* container = (struct lxc_container*) ptr;

  const char* commetFile = commetFile ? (*env) -> GetStringUTFChars(env, jcommetFile, 0) : NULL;
  int result = container -> snapshot(container, commetFile);
  if(commetFile) (*env) -> ReleaseStringUTFChars(env, jcommetFile, commetFile);
  return result;
}

/*
 * Class:     net_magik6k_jliblxc_natives_NativeLxcContainer
 * Method:    _snapshotList
 * Signature: (J)[Lnet/magik6k/jliblxc/Snapshot;
 */
JNIEXPORT jobjectArray JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer__1snapshotList
  (JNIEnv * env, jobject object, jlong ptr) {
  struct lxc_container* container = (struct lxc_container*) ptr;

  struct lxc_snapshot *snapshots;
  int n = container -> snapshot_list(container, &snapshots);

  jclass snapClass = (*env) -> FindClass(env, "net/magik6k/jliblxc/Snapshot");

  jobjectArray result = (jobjectArray) (*env) -> NewObjectArray(env, n, snapClass, NULL);

  for(int i = 0; i < n; i++) {
    (*env) -> SetObjectArrayElement(env, result, n, (*env) -> NewObject(env, snapClass,
      (*env)->GetMethodID(env, snapClass, "<init>", "void(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)"),
      (*env) -> NewStringUTF(env, snapshots[i].name), (*env) -> NewStringUTF(env, snapshots[i].comment_pathname),
      (*env) -> NewStringUTF(env, snapshots[i].timestamp), (*env) -> NewStringUTF(env, snapshots[i].lxcpath)));
    snapshots[i].free(&snapshots[i]);
  }
  free(snapshots);
  return result;
}

/*
 * Class:     net_magik6k_jliblxc_natives_NativeLxcContainer
 * Method:    _snapshotRestore
 * Signature: (JLjava/lang/String;Ljava/lang/String;)Z
 */
JNIEXPORT jboolean JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer__1snapshotRestore
  (JNIEnv * env, jobject object, jlong ptr, jstring jsnapName, jstring jnewName) {
  struct lxc_container* container = (struct lxc_container*) ptr;

  const char* snapName = (*env) -> GetStringUTFChars(env, jsnapName, 0);
  const char* newName = (*env) -> GetStringUTFChars(env, jnewName, 0);
  bool result = container -> snapshot_restore(container, snapName, newName);
  (*env) -> ReleaseStringUTFChars(env, jsnapName, snapName);
  (*env) -> ReleaseStringUTFChars(env, jnewName, newName);
  return result;
}

/*
 * Class:     net_magik6k_jliblxc_natives_NativeLxcContainer
 * Method:    _snapshotDestroy
 * Signature: (JLjava/lang/String;)Z
 */
JNIEXPORT jboolean JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer__1snapshotDestroy
  (JNIEnv * env, jobject object, jlong ptr, jstring jsnapName) {
  struct lxc_container* container = (struct lxc_container*) ptr;

  const char* snapName = (*env) -> GetStringUTFChars(env, jsnapName, 0);
  bool result = container -> snapshot_destroy(container, snapName);
  (*env) -> ReleaseStringUTFChars(env, jsnapName, snapName);
  return result;
}