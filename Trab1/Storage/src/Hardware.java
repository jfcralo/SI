/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author João
 */
public class Hardware {
    
    static{
        //C:\SI\Trab1\Storage\dist\hardware.dll
        System.load("C:\\Hardware\\x64\\Debug\\Hardware.dll");
    }
        
    native public void create_channels();
    native public void write_port(int port, int value);
    native public int read_port(int port);
    native public void set_bit(int port, int bit, boolean value);
    native public boolean get_bit(int port, int bit);    
        
}
