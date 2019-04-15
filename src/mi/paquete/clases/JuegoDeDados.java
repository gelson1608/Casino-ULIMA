/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mi.paquete.clases;

import java.util.Random;

/**
 *
 * @author Bruno
 */
public class JuegoDeDados extends JuegosDeAzar
{
  private int[][] puntaje;
    private int[] total;
    private int mayorValor;

    

    public int[][] getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int[][] puntaje) {
        this.puntaje = puntaje;
    }

    public int[] getTotal() {
        return total;
    }

    public void setTotal(int[] total) {
        this.total = total;
    }

    public JuegoDeDados(String jugador, int monedas) {
        super(jugador, monedas);
        puntaje = new int[2][2];
        total = new int[2];
    }
    

    
    

    @Override
    public void iniciarJuego() 
    {
        Random rand = new Random();
        for(int i=0;i<2;i++)
        {
            for(int j=0;j<2;j++)
            {
                puntaje[i][j]=rand.nextInt(6-1+1)+1;
            }
        }
    }

    
    public void AsignarPuntaje()
    {
        Random rand = new Random();
        for(int i=0;i<2;i++)
        {
            for(int j=0;j<2;j++)
            {
                puntaje[i][j]=rand.nextInt(6-1+1)+1;
            }
        }
    }
    
    public void SumarPuntaje()
    {
        int suma=0;
        for(int i=0;i<2;i++)
        {
            suma=0;
            for(int j=0;j<2;j++)
            {
                suma+=puntaje[i][j];                
            }
            total[i]=suma;
        }        
    }
    
    public void MayorPuntaje()
    {
        mayorValor=total[0];
        for(int i=0;i<total.length;i++)
        {
            if(total[i]>mayorValor)
            {
                mayorValor=total[i];
            }
        }
    }
    
    public String Ganador()
    {
        String cad="";
        int ganador=0;
        for(int i=0;i<total.length;i++)
        {
            if(total[i]==mayorValor)
            {
                ganador++;                
            }
        }
        cad="El ganador es: " + ganador;
        return cad;
   
    }
    
    public String verInfo()
    {
        String cad="",cad1="";
        cad="N°     1er          2da          Total";
        cad=cad+"\n------------------------";
        for(int i=0;i<2;i++)
        {
            cad1=cad1+"\n" + (i+1);
            for(int j=0;j<2;j++)
            {
                cad1=cad1 + "             " + puntaje[i][j];
            }
            cad1=cad1 + "=====>" + total[i];
        }
        
        cad=cad+ cad1+ "\n" +Ganador();
        return cad;
    }
    
}
