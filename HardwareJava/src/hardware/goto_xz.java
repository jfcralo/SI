/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hardware;
//import java.util.Scanner;
/**
 *
 * @author João
 */
public class goto_xz extends Action implements Runnable{
 
    //Interface i= new Interface();
     
    public void run(){
        while(true){
            try{
                if(Constants.x_act != Constants.x_dest) {
                    if(Constants.x_act > Constants.x_dest){
                        if(h.get_bit(Sensores.p4,1)){
                            move("left");
                        }
                        else if(h.get_bit(0,Constants.x_dest) || h.get_bit(1,Constants.x_dest)){
                            stop("left");
                            Constants.x_act=Constants.x_dest;
                        }
                    }else{
                        if(h.get_bit(4,0)){
                            move("right");
                        }
                        else if(h.get_bit(0,Constants.x_dest) || h.get_bit(1,Constants.x_dest)){
                            stop("right");
                            Constants.x_act=Constants.x_dest;
                        }   
                    }            
                }
                if(Constants.z_act != Constants.z_dest){
                    if(Constants.z_act > Constants.z_dest){
                        if(h.get_bit(4,6)){
                            move("down");
                        }
                        else if(h.get_bit(1,Constants.z_dest) || h.get_bit(2,Constants.z_dest)){
                            stop("down");
                            Constants.z_act=Constants.z_dest;
                        }
                    }else{
                        if(h.get_bit(4,5)){
                            move("up");
                        }
                        else if(h.get_bit(1,Constants.z_dest) || h.get_bit(2,Constants.z_dest)){
                            stop("up");
                            Constants.z_act=Constants.z_dest;
                        }   
                    }
                }
                if(Constants.x_act==Constants.x_dest && Constants.z_act==Constants.z_dest){
                    System.out.println("chegou ao destino");
                    return;
                }
                Thread.sleep(150);
            }catch(Exception e){}
        }
    }
    
}
