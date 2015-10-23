// Teste.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include "interface.h"
//#include <windows.h>

bool getBit(uInt8 var, int nBit) {

	int result = var & (1 << nBit);
	return (result != 0);
}

/*void setBit(uInt8 &var, uInt8 nBit, int value) {

	uInt8 mask_on = (uInt8)(1 << nBit);
	uInt8 mask_off = (uInt8)0xff - mask_on;

	if (value) {
		var |= mask_on;
	}else {
		var &= mask_off;
	}
}*/


int main()
{
	bool check = TRUE;
	uInt8 read = ReadDigitalU8(1);
	uInt8 motores = ReadDigitalU8(4);
	
	printf("Go?");
	getchar();
	//setBit(motores, 0, 1);
	WriteDigitalU8(4, 1);
	
	while (getBit(read, 3)) {
		read = ReadDigitalU8(1);
	}

	//setBit(motores, 0, 0);
	WriteDigitalU8(4, 0);

	//Sleep(2000);

	//setBit(motores, 1, 1);
	WriteDigitalU8(4, 2);

	read = ReadDigitalU8(0);

	while (getBit(read, 0)) {
		read = ReadDigitalU8(0);
	}
	WriteDigitalU8(4, 0);
	return 0;
}

