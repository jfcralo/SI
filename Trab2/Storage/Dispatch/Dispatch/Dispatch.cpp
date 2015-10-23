// Dispatch.cpp : Defines the exported functions for the DLL application.
//

#include "stdafx.h"
#include <jni.h>
/* Header for class Dispatch */

#ifndef _Included_Dispatch
#define _Included_Dispatch
#ifdef __cplusplus
extern "C" {
#endif
	/*
	* Class:     Dispatch
	* Method:    read_ports
	* Signature: ([I[I)V
	*/
	JNIEXPORT void JNICALL Java_Dispatch_read_1ports(JNIEnv *, jobject, jintArray ports, jintArray last_ports) {
		printf("lendo no spacho\n");
	}

	/*
	* Class:     Dispatch
	* Method:    move
	* Signature: (C)V
	*/
	JNIEXPORT void JNICALL Java_Dispatch_move(JNIEnv *, jobject, jchar c) {
		printf("movendo no despacho");
	}

#ifdef __cplusplus
}
#endif
#endif