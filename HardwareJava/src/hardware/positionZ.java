/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hardware;

/**
 *
 * @author João
 */
public class positionZ extends Sensores{
    Hardware h = new Hardware();
    public int posZ;
    
    public void run() {
        while(true){
            try{
                if(!h.get_bit(p1,5)){
                    posZ = 02;
                }
                if(!h.get_bit(p1,6)){
                    posZ = 01;
                }
                if(!h.get_bit(p1,7)){
                    posZ = 12;
                }
                if(!h.get_bit(p2,0)){
                    posZ = 11;
                }
                if(!h.get_bit(p2,1)){
                    posZ = 22;
                }
                if(!h.get_bit(p2,2)){
                    posZ = 21;
                }
                if(!h.get_bit(p2,3)){
                    posZ = 32;
                }
                if(!h.get_bit(p2,4)){
                    posZ = 31;
                }
                if(!h.get_bit(p2,5)){
                    posZ = 42;
                }
                if(!h.get_bit(p2,6)){
                    posZ = 41;
                }
                else{
                    posZ = 99;
                }
   
              
            } catch(Exception e){}
        }
            
    }   
}