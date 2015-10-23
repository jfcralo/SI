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
public class Initialize_xz extends Action implements Runnable{
    
    @Override
    public void run(){
        while(true){
            try {
                if(Constants.y_act == 2){
                    if( !h.get_bit(0,0) ){
                        if( h.get_bit(4,1) ){
                            move("left");
                            System.out.println("go x left "+h.get_bit(4,1));
                        }
                    }else{
                        if( !h.get_bit(4,1) ){
                            stop("left");
                            System.out.println("stop x left "+h.get_bit(4,1));
                            Constants.x_act = 0;

                        }else{
                            if( !h.get_bit(2,6) ){
                                if( (h.get_bit(4,6) && h.get_bit(4,1)) ){
                                    move("down");
                                    System.out.println("go z down "+h.get_bit(4, 6));
                                }        

                            }else{
                                stop("down");
                                System.out.println("stop z down "+h.get_bit(4, 6));
                                Constants.z_act = 0;
                                return;
                            }
                        }
                    }
                }Thread.sleep(100);
            }catch(InterruptedException ex){} 
        }  
    }
}


