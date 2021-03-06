/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class Hardware */

#ifndef _Included_Hardware
#define _Included_Hardware
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     Hardware
 * Method:    create_channels
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_Hardware_create_1channels
  (JNIEnv *, jobject);

/*
 * Class:     Hardware
 * Method:    write_port
 * Signature: (II)V
 */
JNIEXPORT void JNICALL Java_Hardware_write_1port
  (JNIEnv *, jobject, jint, jint);

/*
 * Class:     Hardware
 * Method:    read_port
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_Hardware_read_1port
  (JNIEnv *, jobject, jint);

/*
 * Class:     Hardware
 * Method:    set_bit
 * Signature: (IIZ)V
 */
JNIEXPORT void JNICALL Java_Hardware_set_1bit
  (JNIEnv *, jobject, jint, jint, jboolean);

/*
 * Class:     Hardware
 * Method:    get_bit
 * Signature: (II)Z
 */
JNIEXPORT jboolean JNICALL Java_Hardware_get_1bit
  (JNIEnv *, jobject, jint, jint);

#ifdef __cplusplus
}
#endif
#endif
