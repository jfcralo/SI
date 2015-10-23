/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author João
 */
public class Thread1 extends Thread {
    public Thread1(){
        super();
    }
    Hardware h = new Hardware();
    
    public void run(){
        while(true){
            try{
                System.out.println("-->Thread1 is running");
                h.set_bit(4, 3, true);
                Thread.sleep(2000);
            }catch(Exception e){}
        }
    }
    
}
