package storage;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author João
 */
public class Dispatch {
    
    static{
        //C:\SI\Trab2\Storage\Dispatch\Dispatch\Debug\Dispatch.dll
        System.load("C:\\SI\\Trab2\\Storage\\Dispatch\\Dispatch\\x64\\Debug\\Dispatch.dll");
    }
    
    native public void read_ports(int ports[], int last_ports[]);
    native public void move(char c);
    
}
