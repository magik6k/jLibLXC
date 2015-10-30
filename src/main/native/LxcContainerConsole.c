#include "net_magik6k_jliblxc_natives_NativeLxcContainer.h"
#include <lxc/lxccontainer.h>
#include <fcntl.h>

/*
 * Class:     net_magik6k_jliblxc_natives_NativeLxcContainer
 * Method:    _console
 * Signature: (J)Ljava/io/FileDescriptor;
 */
JNIEXPORT jobject JNICALL Java_net_magik6k_jliblxc_natives_NativeLxcContainer__1console
  (JNIEnv * env, jobject object, jlong ptr) {
  struct lxc_container* container = (struct lxc_container*) ptr;

  int ttynum, master;
  int ttyfd = container -> console_getfd(container, &ttynum, &master);

  if(ttyfd < 0) return NULL;
  if(master < 0) return NULL;

  // Causes JVM crash
  //int flags = fcntl(master, F_GETFL, 0);
  //fcntl(master, F_SETFL, flags | O_NONBLOCK);

  jclass classFD = (*env) -> FindClass(env, "java/io/FileDescriptor");
  jobject result = (*env) -> NewObject(env, classFD, (*env) -> GetMethodID(env, classFD, "<init>", "()V"));
  (*env) -> SetIntField(env, result, (*env) -> GetFieldID(env, classFD, "fd", "I"), master);
  return result;
}
