
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
public class Sensores implements Runnable {
    
   private final Hardware h;
   private final Buffer buf;
   private boolean running;
   private int i,j,port;
   
   public Sensores(Buffer buffer, Hardware hardware){
       this.h = hardware;
       this.buf = buffer;
   }
   
    public void run(){
        running = true;
        System.out.println("entrou sensores");
        while (running){
            
            for(i=0;i<6;i++){
                    boolean write = false;
                    for(j=0;j<8;j++){
                        if(buf.bits[i][j] != buf.last_bits[i][j]){
                            write = true;
                        }
                    }

                    if(write){
                        port = get_byte(buf.bits[i]);
                        h.write_port(i, port);
                    }
            }
            
            for (i = 0; i < 6; i++) {
                int porto=h.read_port(i);
                for (j = 0; j < 8 ; j++) {
                    buf.bits[i][j]=get_bit(porto,j);
                    buf.last_bits[i][j]=buf.bits[i][j];
                }
            }
            
            try {
                  Thread.sleep(100);
            } catch (InterruptedException ex) {
               Logger.getLogger(Sensores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private int get_byte(boolean[] port){
        
        int value = 0;
        
        for(i=0;i<8;i++){
            if(port[i]){
                value = set_bit(value, i);
            }
        }
        
        return value;
    }
    
    private int set_bit(int value, int bit){
        
        int mask = 1 << bit;
        
        value = value | mask;
        
        return value;
    }
    
    private boolean get_bit(int value, int bit){
        
        int mask = 1 << bit;
        
        return (value & mask) !=0;
    }
}
