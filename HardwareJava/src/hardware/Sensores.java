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
public class Sensores implements Runnable{
    
    Hardware h = new Hardware();
    
    public static int p0;
    public static int p1;
    public static int p2;
    public static int p3;
    public static int p4;
    public static int p5;
    
    //@Override
    public void run(){
        while(true){
            try{
                p0 = h.read_port(0);
                p1 = h.read_port(1);
                p2 = h.read_port(2);
                p3 = h.read_port(3);
                p4 = h.read_port(4);
                p5 = h.read_port(5);
                //System.out.println(p4);
                Thread.sleep(50);
            }catch(Exception e){}
        }
    }
}
    
    

