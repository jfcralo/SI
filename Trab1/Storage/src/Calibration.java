
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author João
 */
public class Calibration implements Runnable{
    
    private Buffer buf;
    private int x,y,z;
    
    public Calibration(Buffer b){
       buf = b; 
    }
     
    @Override
    public void run(){
        
        
        while(true){
            try {
                
               
                
                x=buf.get_pos_x();
                y=buf.get_pos_y();
                z=buf.get_pos_z();
                
                System.out.println(x);
                System.out.println(y);
                System.out.println(z);
                
                if(y == 1){
                    if(buf.get_bit(4, 3) || buf.get_bit(4, 3)){
                        buf.move_y("stop");
                    }
                    if((x == 0) && (z == 0)){
                        System.out.println("Calibrated");
                        buf.move_x("stop");
                        buf.move_z("stop");
                        return;
                    }else{
                        if((x != 0) && !buf.get_bit(4, 1)){
                            buf.move_x("left");
                        }
                        if( (z!=0) && !buf.get_bit(4, 6) ){
                            buf.move_z("down");
                        }        
                         
                    }
                
                }else{
                    if((y==0 || y==-1) && buf.get_bit(4,4)){
                        buf.move_y("out");
                    }else if(y==2 && buf.get_bit(4, 3)){
                        buf.move_y("in");
                    }
                } 
                Thread.sleep(100);
            }catch (Exception ex) {
                Logger.getLogger(Calibration.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }  
    }
}
