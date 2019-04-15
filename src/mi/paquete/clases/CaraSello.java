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
public class CaraSello extends JuegosDeAzar
{
    private String monedacs;
    private String eleccion;
    

    public String getMonedacs() {
        return monedacs;
    }

    public void setMonedacs(String monedacs) {
        this.monedacs = monedacs;
    }

    public String getEleccion() {
        return eleccion;
    }

    public void setEleccion(String eleccion) {
        this.eleccion = eleccion;
    }
    

    public String getMoneda() {
        return monedacs;
    }

    public void setMoneda(String moneda) {
        this.monedacs = monedacs;
    }

    public CaraSello(String jugador, int monedas) {
        super(jugador, monedas);
    }

    @Override
    public void iniciarJuego() 
    {
        
        int ref=0;
        Random randito=new Random();
        ref=randito.nextInt(3)+1;
        if(ref==1)
        {
            monedacs="Cara";
        }
        else if(ref==2)
        {
            monedacs="Sello";
        }
        do
        {
            eleccion=JOptionPane.showInputDialog(null, "Que desea elegir, cara o sello?");
            if(!(eleccion.equalsIgnoreCase("cara")||eleccion.equalsIgnoreCase("sello")))
            {
                JOptionPane.showMessageDialog(null,"Error, solo puede escribir cara o sello");
            }
            
        }while(!(eleccion.equalsIgnoreCase("cara")||eleccion.equalsIgnoreCase("sello")));
        
        
        
        
        if(monedacs.equalsIgnoreCase(eleccion))
        {
            super.monedas=super.monedas*2;
        }
        else
        {
            super.monedas=super.monedas*0;
        }
        
    }

    @Override
    public String verInfo() {
         String cad;
         cad=super.verInfo() + "\nEleccion: "+ eleccion + "\nEl lado de la moneda que salio es: "+ monedacs;
         return cad;
    }
    
    
    
    
}
