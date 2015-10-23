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
public class Initialize_y extends Action implements Runnable {
    
    //@Override
    public void run(){
        while(true){
            try {
                if( !(h.get_bit(1, 3)) ){ 
                    if( h.get_bit(1, 4) ){
                        if( h.get_bit(4,3) ){
                            stop("in");
                            move("out");
                            System.out.println("go y out "+h.get_bit(Sensores.p4,3));
                        }
                    }else if( h.get_bit(1, 2)){
                        if(h.get_bit(4,4)){
                            stop("out");
                            move("in");
                            System.out.println("go y in "+h.get_bit(4,3));
                        }
                    }else{
                        if(h.get_bit(4,3) && h.get_bit(4,4)){
                            System.out.println("break out");
                            move("out");
                         
                        }else{
                            if( !(h.get_bit(4,3) && h.get_bit(4,4)) ){
                                System.out.println("break");
                            }
                        }
                    }                   
                }else{
                    System.out.println("no meio");
                    if(!(h.get_bit(4,3) && h.get_bit(4,4))){
                        stop("in");
                        stop("out");
                        System.out.println("stop y"+h.get_bit(4,3));
                        Constants.y_act=2;
                        return;
                    }
                }
                
                Thread.sleep(100);
            }catch(InterruptedException ex){}   
        }
    }
}
