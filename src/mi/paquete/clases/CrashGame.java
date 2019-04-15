/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mi.paquete.clases;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author ARTURO
 */
public class CrashGame extends JuegosDeAzar
{
    private float[] arrayC;
    private int cantObj;
    private float eleccion;
    private int monedasref;

    public int getCantObj() {
        return cantObj;
    }

    public void setCantObj(int cantObj) {
        this.cantObj = cantObj;
    }

    public float getEleccion() {
        return eleccion;
    }

    public void setEleccion(float eleccion) {
        this.eleccion = eleccion;
    }

    public float[] getNumcrash() {
        return arrayC;
    }

    public void setNumcrash(int[] numcrash) {
        this.arrayC = arrayC;
    }

    

    public CrashGame(String jugador, int monedas) {
        super(jugador, monedas);
        
        arrayC= new float[100];
        
    }

    
    
    

    @Override
    public void iniciarJuego() 
    {
        float ent=1.0f;
       float num=0.10f;
        do
        {
            eleccion=Float.parseFloat(JOptionPane.showInputDialog(null, "ELegir limite de crash (No se puede elegir un numero mayor a 5) "));
                   if(eleccion>5)
                   {
                       JOptionPane.showMessageDialog(null,"No se puede elegir un numero mayor a 5");
                   }
        }while(eleccion>5);

        
        Random randito=new Random();
        cantObj=randito.nextInt(51);
             for(int i=0;i<cantObj;i++)
            {
                this.arrayC[i]=ent/10;
                ent++;
                
            }
             if(eleccion<=arrayC[cantObj-1])
             {
                 super.monedas=super.monedas*eleccion;
             }
             else if(eleccion>arrayC[cantObj-1])
             {
                 super.monedas=super.monedas*0;
             }
           
 
    }

    

    
    @Override
    public String verInfo() {
        String cad="";
        cad+=super.verInfo() + "\n";
        cad=cad+ "------------------------------------";
        cad+="\nGenerando el numero de crash:" + "\n";
        
        for(int i=0;i<cantObj;i++)
        {
            cad=cad +"  " + arrayC[i];
        }
        cad=cad+"\n-------------------------------";
        cad=cad+ "\nCrasheo en: "+ arrayC[cantObj-1];
        
        return cad;
    }
        
    
    
    
    
    
    }

    
    
    

