#pragma once

#include "interface.h"

#ifndef HARDWARE_H
#define HARDWARE_H

void open_channels();

void write_port(uInt32 port, uInt8 value);

int read_port(uInt32 port);

bool get_bit(uInt32 port, int bit);

void set_bit(uInt32 port, int bit, bool value);

#endif