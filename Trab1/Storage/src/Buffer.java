/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author João
 */
public class Buffer {
    
    public final Hardware hw;
    public boolean bits[][];
    public boolean last_bits[][];
    private final Sensores s;
    
    
    public Buffer(Hardware hw){
        this.hw = new Hardware();
        bits = new boolean[6][8];
        last_bits = new boolean[6][8];
        
        
        s = new Sensores(this, hw);
        (new Thread(s)).start();
    }
    
    public boolean get_bit(int port, int bit) throws Exception {
        
        if(port > 5 || bit > 7){
            Exception e = new Exception();
            
            throw e;            
        }
        System.out.println("port "+port+" bit "+bit+" "+bits[port][bit]);
        
        return bits[port][bit];
    }
    
    //********************************************************************************************************
    //FUNCOES DE COORDENADAS DO ELEVADOR**********************************************
    //********************************************************************************************************
    
    //retornar coordenada horizontal x
    public int get_pos_x(){

        //int i = 0;

        //while(i++<8){
        for(int i =0; i<8; i++){
        if(!bits[0][i]){
                return i;
            }
        }

        int j=0;
        while(j++<2){
            if(!bits[1][j]){
                return j+8;
            }
        }

        return -1;
    }

    //altura z do elevador
    public int get_pos_z(){
        if(!bits[1][5] || !bits[1][6]){  
            return 4;
        }else if(!bits[1][7] || !bits[2][0]){
            return 3;
        }else if(!bits[2][1] || !bits[2][2]){
            return 2;
        }else if(!bits[2][3] || !bits[2][4]){
            return 1;
        }else if(!bits[2][5] || !bits[2][6]){
            return 0;
        }    

        return -1;
    }

    //arranjar outra maneira de verificar a posiçao put ou get do z
    // nao gosto disto assim
    // o get z devia de retornar logo se o elevador está na posição get ou put
    public int getPut(){
         if(!bits[1][6]|| !bits[2][0]|| !bits[2][2]|| !bits[2][4]|| !bits[2][6])
             return 0;
         if(!bits[1][5]|| !bits[1][7]|| !bits[2][1]|| !bits[2][3]|| !bits[2][5])
             return 1;
         return -1;
    }  

    //posiçao y da caixa do elevador
    //retorna de 0 - fora, 1 - meio, 2 - dentro
    public int get_pos_y(){
        int i = 2;

        while(i++<5){
            if(!bits[1][i]){
                return i-2;
            }
        }

        return -1;
    }
    //********************************************************************************************************
    
    //********************************************************************************************************
    //FUNCOES DE MOVIMENTO DO ELEVADOR***************************************************
    //********************************************************************************************************
    
    public void move_x(String dir_x){
        
        switch(dir_x){
                case "right":
                    bits[4][0]=true;
                    bits[4][1]=false;
                    break;
                case "left":
                    bits[4][1]=true;
                    bits[4][0]=false;
                    break;
                default://default is stop
                    bits[4][0]=false;
                    bits[4][1]=false;
        }
    }
    
    public void move_z(String dir_z){
        switch(dir_z){
                case "up":
                    bits[4][5]=true;
                    bits[4][6]=false;
                    break;
                case "down":
                    bits[4][6]=true;
                    bits[4][5]=false;
                    break;
                default://default is stop
                    bits[4][5]=false;
                    bits[4][6]=false;            
        }
    }
    
    public void move_y(String dir_y){
        switch(dir_y){
                case "in":
                    bits[4][4]=true;
                    bits[4][3]=false;
                    break;
                case "out":
                    bits[4][3]=true;
                    bits[4][4]=false;
                    break;
                default://default is stop
                    bits[4][3]=false;
                    bits[4][4]=false;
           
        }
    }
    //********************************************************************************************************
    
    //existe peça numa das estações
    public int station_has_piece(){
        if(!bits[3][0]){
            return 1;
        }else if(!bits[3][1]){
            return 2;
        }
        return 0;
    }
    
    //existe peça no elevador
    public boolean box_has_piece(){
        return bits[2][7];
    }
    
    //************************************************************************************************
    /*Decidir se uso isto ou nao******************************************************************
    //return 0 if elevator isn't in any station
    //return 1 if elevator at left station
    //return 2 if elevator at right station
    public int elevatorInStation(){
        if((get_pos_z() == 0) && (get_pos_x()== 0) && (getPut()==0))
            return 1;
        if((get_pos_z() == 0) && (get_pos_x()== 9) && (getPut()==0))
            return 2;
        return 0;
    }*/
    //************************************************************************************************
      
}
