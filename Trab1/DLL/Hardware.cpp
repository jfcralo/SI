#include "interface.h"
#include "Hardware.h"


 void open_channels() {
	
	create_DO_channel(0);
	create_DO_channel(1);
	create_DO_channel(2);
	create_DO_channel(3);
	create_DI_channel(4);
	create_DI_channel(5);

}

void write_port(int32 port, int8 value) {
	WriteDigitalU8(port, value);
}

int read_port(uInt32 port) {
	uInt8 value = ReadDigitalU8(port);
	return value;
}

bool get_bit(uInt32 port, int bit) {
	uInt8 value = ReadDigitalU8(port);
	uInt8 mask = 1 << bit;

	if ((mask & value) != 0) {
		return TRUE;
	}
	else {
		return FALSE;
	}
}

void set_bit(uInt32 port, int bit, bool value) {

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


