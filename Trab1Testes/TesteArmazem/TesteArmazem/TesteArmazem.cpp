#include "stdafx.h"
#include "interface.h"
#include "conio.h"
#include <windows.h>
#include <iostream>
#include <cstdlib>

//------------------------------------------------------------------------------
//FUNÇOES AUXILIARES------------------------------------------------------------
//------------------------------------------------------------------------------
int getBit(int var, int nBit) {


	int result = var & (1 << nBit);
	if(result != 0){
		return 1;
	}
	else {
		return 0;
	}
}

void setBit(int &var, int nBit, bool value) {

	int mask_on = 1 << nBit;
	int mask_off = 0xff - mask_on;

	if (value == TRUE) {
		var = var | mask_on;
	}else {
		var = var & mask_off;
	}
}

void menu() {
	printf("\n\n");
	printf(" left\t left\t right\t right \n");
	printf("staion\tstation\tstation\tstation\n");
	printf("  in  \t  out  \t  in  \t  out  \n");
	printf("  |\t  |\t  |\t  |");
	printf("\n ___ \t ___ \t ___ \t ___\n");
	printf("|   |\t|   |\t|   |\t|   |\n");
	printf("| 1 |\t| 2 |\t| 3 |\t| 4 |\n");
	printf("|___|\t|___|\t|___|\t|___|\n");
	printf("\t ___ \t\t\t ___ \n");
	printf("\t|   |\t\t\t|   |\n");
	printf("\t| w | - up\t\t| i | - in\n");
	printf("\t|___|\t\t\t|___|\n");
	printf(" ___ \t ___ \t ___ \t\t ___ \n");
	printf("|   |\t|   |\t|   |\t\t|   |\n");
	printf("| a |\t| s |\t| d |\t\t| o | - out\n");
	printf("|___|\t|___|\t|___|\t\t|___|\n");
	printf("  |\t  |\t  |\n");
	printf(" left\t down\tright\n");
	printf("\nPress 0 to stop movement\n");
	printf("Press spacebar to clear screen\n");
}

//------------------------------------------------------------------------------
//ESTADO DO MUNDO---------------------------------------------------------------
//------------------------------------------------------------------------------
void read_ports(int ports[6], int last_ports[6]) {

	int i;

	for (i = 0;i < 6;i++) {
	//ve se ha diferenças entre o estado actual e o estado prévio---
	//se houver diferenças escreve-as no hardware-------------------
		if (ports[i] != last_ports[i]) {
			out_port(i, ports[i]);
		}

	//actualiza o estado do mundo-----------------------------------
		ports[i] = ReadDigitalU8(i);
		last_ports[i] = ports[i];
	}
}

//------------------------------------------------------------------------------
//ACÇÕES------------------------------------------------------------------------
//------------------------------------------------------------------------------
void move(int ports[6], char aux) {

	switch (aux) {

	case 'w'://cima
		setBit(ports[4], 6, FALSE);
		if (getBit(ports[4], 5)) {
			setBit(ports[4], 5, FALSE);
		}
		else {
			setBit(ports[4], 5, TRUE);
		}
		break;

	case 's'://baixo
		setBit(ports[4], 5, FALSE);
		if (getBit(ports[4], 6)) {
			setBit(ports[4], 6, FALSE);
		}
		else {
			setBit(ports[4], 6, TRUE);
		}
		break;

	case 'a'://esquerda
		setBit(ports[4], 0, FALSE);
		if (getBit(ports[4], 1)) {
			setBit(ports[4], 1, FALSE);
		}
		else {
			setBit(ports[4], 1, TRUE);
		}
		break;

	case 'd'://direita
		setBit(ports[4], 1, FALSE);
		if (getBit(ports[4], 0)) {
			setBit(ports[4], 0, FALSE);
		}
		else {
			setBit(ports[4], 0, TRUE);
		}
		break;

	case 'i'://in
		setBit(ports[4], 3, FALSE);
		if (getBit(ports[4], 4)) {
			setBit(ports[4], 4, FALSE);
		}
		else {
			setBit(ports[4], 4, TRUE);
		}
		break;

	case 'o'://out
		setBit(ports[4], 4, FALSE);
		if (getBit(ports[4], 3)) {
			setBit(ports[4], 3, FALSE);
		}
		else {
			setBit(ports[4], 3, TRUE);
		}
		break;

	case '1'://left station in
		if (getBit(ports[4], 7)) {
			setBit(ports[4], 7, FALSE);
		}
		else {
			setBit(ports[4], 7, TRUE);
		}
		break;

	case '2'://left station out
		if (getBit(ports[5], 0)) {
			setBit(ports[5], 0, FALSE);
		}
		else {
			setBit(ports[5], 0, TRUE);
		}
		break;

	case '3'://right station in
		if (getBit(ports[5], 1)) {
			setBit(ports[5], 1, FALSE);
		}
		else {
			setBit(ports[5], 1, TRUE);
		}
		break;

	case '4'://right station out
		if (getBit(ports[5], 2)) {
			setBit(ports[5], 2, FALSE);
		}
		else {
			setBit(ports[5], 2, TRUE);
		}
		break;

	case '0'://parar tudo
		ports[4] = 0;
		ports[5] = 0;
		break;

	case 27://sair
		exit(1);
		break;

	case 32://apagar consola
		system("cls");
		menu();
		break;

	case NULL: //verificações de segurança
		break;

	default:
		printf("1-Check if CAPSLOCK is off\n");
		printf("2-Get your finger out of the SHIFT key\n");
		printf("3-Check if you pressed the right key\n");
	}
}

//------------------------------------------------------------------------------
//VERIFICAÇÕES DE SEGURANÇA-----------------------------------------------------
//------------------------------------------------------------------------------
void security(int ports[6]) {
	//protege fora
	if (getBit(ports[1], 2) == 0) {
		setBit(ports[4], 3, FALSE);
	}
	//protege dentro
	if (getBit(ports[1], 4) == 0) {
		setBit(ports[4], 4, FALSE);
	}
	//protege esquerda
	if (getBit(ports[0], 0) == 0) {
		setBit(ports[4], 1, FALSE);
	}
	//protege direita
	if (getBit(ports[1], 1) == 0) {
		setBit(ports[4], 0, FALSE);
	}
	//protege cima
	if (getBit(ports[1], 5) == 0) {
		setBit(ports[4], 5, FALSE);
	}
	//protege baixo
	if (getBit(ports[2], 6) == 0) {
		setBit(ports[4], 6, FALSE);
	}
}


int main()
{
	char c = NULL;

	//estado actual do "mundo"
	int ports[6];
	//estado anterior do "mundo"
	int last_ports[6];


	create_DO_channel(0);
	create_DO_channel(1);
	create_DO_channel(2);
	create_DO_channel(3);
	create_DI_channel(4);
	create_DI_channel(5);
	
	menu();
	
	while (1){

		read_ports(ports, last_ports);
					
		if (_kbhit() > 0) {
			c = _getch();
		}
		move(ports, c);
		c = NULL;
		security(ports);
		
	Sleep(100);
	}
	return 0;
}

