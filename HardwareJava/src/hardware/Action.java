/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hardware;

/**
 *
 * @author Ralofski
 */

public class Action{

    Hardware h = new Hardware();
    
    
    public void move(String bit){
        
        h.create_channels();
        
        //securityCheck(bit);
        switch (bit) {
            case "up":
                h.set_bit(4,5,1);
                break;
            case "down":
                h.set_bit(4, 6, 1);
                break;
            case "right":
                h.set_bit(4, 0, 1);
                break;
            case "left":
                h.set_bit(4, 1, 1);
                break;
            case "in":
                h.set_bit(4, 4, 1);
                break;
            case "out":
                h.set_bit(4, 3, 1);
                break;
            default:System.out.println("fuck you MOVE");
                break;
        }
    }
    
    public void stop(String bit){
        switch (bit) {
            case "up":
                h.set_bit(4, 5, 0);
                break;
            case "down":
                h.set_bit(4, 6, 0);
                break;
            case "right":
                h.set_bit(4, 0, 0);
                break;
            case "left":
                h.set_bit(4, 1, 0);
                break;
            case "in":
                h.set_bit(4, 4, 0);
                break;
            case "out":
                h.set_bit(4, 3, 0);
                break;
            default: System.out.println("default STOP");
        }
    }
    
    public void station(String stat){
        switch (stat){
            case "left in":
                h.set_bit(4, 7, 1);
                break;
                
            case "left out":
                h.set_bit(5, 0, 1);
                break;
                
            case "right in":
                h.set_bit(5, 2, 1);
                break;
                
            case "right out":
                h.set_bit(5, 1, 1);
                break;
                
            default: System.out.println("default I/O");
               
        }
    }

    //}

    //AuxFunctions----------------
    /*boolean getBit(int var, int nBit) {
        
        int result = var & ( 1 << nBit);
        return (result !=0);//valor !=0 é TRUE
        
    }

    public int setBit(int var, int nBit, int value) {
        
        byte mask_on = (byte) (1<<nBit);
        byte mask_off = (byte) (0xff - mask_on);
        
        if (value !=0){
            return var |= mask_on;
        }else{
            return var &= mask_off;
        }
    }*/
    
    /*boolean securityCheck(String bit){
                
        switch (bit) {
            
            case "up":
                                if (((h.get_bit(1, 4) == 1) && (h.get_bit(1, )))){
                                    
                                }
            case "down":
                if {
                    
                }
                break;
                
            case "right":
            case "left":
                h.write_port(4, setBit(Sensores.p4,1, 0) );
                break;
            
            case "in":
                h.write_port(4, setBit(Sensores.p4,4, 0) );
                break;
            case "out":
                h.write_port(4, setBit(Sensores.p4,3, 0) );
                break;
                
            default:System.out.println("fuck you STOP");
                break;
        
    }*/
    //----------------------------
    
}