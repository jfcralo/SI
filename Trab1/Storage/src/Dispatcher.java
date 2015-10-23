/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author João
 */
public class Dispatcher implements Runnable{
   
   public Buffer buf;
   private final String cmd;
   private Calibration cal;
   //private Hardware hw;
   
   public Dispatcher(Buffer b, String _cmd){
       buf = b;
       cmd = _cmd;
       //this.hw = new Hardware();
   }
    
    public void run(){
        try{
            switch(cmd){
                case "calibrar":
                    //hw.write_port(4, 4);
                    cal = new Calibration(buf);
                    (new Thread(cal)).start();
                    break;
                default:
                     System.out.println("Comando Invalido");
            }
        }catch(Exception e){
            System.out.println("erro dispachador\n");
        }
    }
    
}
