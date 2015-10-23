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
public class positionX extends Sensores{
    
    Hardware h = new Hardware();
    public int posX;
    
    public void run() {
        while(true){
            try{
                if(!h.get_bit(p0,0)){
                    posX = 0;
                }
                if(!h.get_bit(p0,1)){
                    posX = 1;
                }
                if(!h.get_bit(p0,2)){
                    posX = 2;
                }
                if(!h.get_bit(p0,3)){
                    posX = 3;
                }
                if(!h.get_bit(p0,4)){
                    posX = 4;
                }
                if(!h.get_bit(p0,5)){
                    posX = 5;
                }
                if(!h.get_bit(p0,6)){
                    posX = 6;
                }
                if(!h.get_bit(p0,7)){
                    posX = 7;
                }
                if(!h.get_bit(p1,0)){
                    posX = 8;
                }
                if(!h.get_bit(p1,1)){
                    posX = 9;
                }
                else{
                    posX = 99;
                } 
            } catch(Exception e){}
        }
            
    }   
}