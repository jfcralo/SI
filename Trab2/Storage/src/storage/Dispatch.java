/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

/**
 *
 * @author João
 */
public class Dispatch {
    
   static{
        //C:\Users\João\Documents\GitHub\SI\Trab2\Dispatch\x64\Debug\Dispatch.dll
        System.load("C:\\Users\\João\\Documents\\GitHub\\SI\\Trab2\\Dispatch\\x64\\Debug\\Dispatch.dll");
    }
    
    native public void read_ports(int ports[], int last_ports[]);
    native public void move(char c);
    
}

