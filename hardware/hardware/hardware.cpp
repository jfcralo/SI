// hardware.cpp : Defines the exported functions for the DLL application.
//

#include "stdafx.h"
#include <jni.h>
#include <stdio.h>
#include <interface.h>


extern "C" {
	JNIEXPORT void JNICALL Java_Hardware_create_1channels(JNIEnv *, jobject){
		printf("DLL ON\n");
		create_DI_channel(4);
		create_DI_channel(5);
		create_DI_channel(0);
		create_DI_channel(1);
		create_DI_channel(2);
		create_DI_channel(3);

	}
	JNIEXPORT void JNICALL Java_Hardware_write_1port(JNIEnv *, jobject, jint port, jint value){
		WriteDigitalU8(port, value);
	}
	JNIEXPORT jint JNICALL Java_Hardware_read_1port(JNIEnv *, jobject, jint port){
		int v = ReadDigitalU8(port);
		return (v);
	}
	JNIEXPORT void JNICALL Java_Hardware_set_1bit(JNIEnv *, jobject, jint port, jint bit, jboolean value){
		uInt8 valuePort = ReadDigitalU8(port);
		uInt8 maskTrue = 1 << bit;
		uInt8 maskFalse = 0xff - maskTrue;

		if (value) {
			valuePort = valuePort | maskTrue;
		}
		else {
			valuePort = valuePort & maskFalse;
		}

		WriteDigitalU8(port, valuePort);
	}
	JNIEXPORT jboolean JNICALL Java_Hardware_get_1bit(JNIEnv *, jobject, jint port, jint bit){
		uInt8 value = ReadDigitalU8(port);
		uInt8 mask = 1 << bit;

		if ((mask & value) != 0) {
			return TRUE;
		}
		else {
			return FALSE;
		}
	}
}