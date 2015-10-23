/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hardware;

/**
 *
 * @author Goncalo
 */
public class Planner_GetAt extends Action implements Runnable
{
    Constants c = new Constants();
    
    @Override
     public void run(){
        while(true)
        {
            try
            {
                if((c.x_act == c.x_dest))
            {
                System.out.println("esta certo");
                return;
            }
            else
            {
                if(c.x_act>c.x_dest)
                {
                    if(c.x_dest == 8)
                    {
                        if(h.get_bit(1,0))
                        {
                            if(h.get_bit(4,1))
                            {
                            move("left");
                            }
                        }
                        else
                        {
                            stop("left");
                            c.x_act = 8;
                        }
                    }
                    else
                    {
                        if(!h.get_bit(0,c.x_dest))
                        {
                            if(h.get_bit(4,1))
                            {
                            move("left");
                            }
                        }
                        else
                        {
                            stop("left");
                            c.x_act = c.x_dest;
                        }
                    }
                    
                }
                 
            }
            if(c.x_act<c.x_dest)
            {
                if(c.x_dest == 8)
                    {
                        if(!h.get_bit(1,0))
                        {
                            if(h.get_bit(4,0))
                            {
                            move("right");
                            }
                        }
                        else
                        {
                            stop("right");
                            c.x_act = 8;
                        }
                    }
                    else if(c.x_dest == 9)
                    {
                        if(!h.get_bit(1,1))
                        {
                            if(h.get_bit(4,0))
                            {
                            move("right");
                            }
                        }
                        else
                        {
                            stop("right");
                            c.x_act = 9;
                        }
                    } 
                    else if(c.x_dest<8)
                    {   System.out.println("krl");
                        if(!h.get_bit(Sensores.p0,c.x_dest))
                        {   
                            if(h.get_bit(Sensores.p4,0))
                            {
                            System.out.println("move");
                            move("right");
                            }
                        }
                        else
                        {
                            stop("right");
                            c.x_act = c.x_dest;
                            return;
                        }
                    }
                    
                }Thread.sleep(100);
                   
            }catch (InterruptedException ex) {} 
        }
    }
}
     
            