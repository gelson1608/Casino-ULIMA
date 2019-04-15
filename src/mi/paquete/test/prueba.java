/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mi.paquete.test;

import javax.swing.JOptionPane;
import mi.paquete.clases.Baraja;
import mi.paquete.clases.CaraSello;
import mi.paquete.clases.Carta;
import mi.paquete.clases.CrashGame;
import mi.paquete.clases.JuegoDeDados;
import mi.paquete.clases.Mano;
import mi.paquete.clases.ruleta;

/**
 *
 * @author Alvaro
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
        
        boolean bucle2=true;
        
        do
        {
            String resp1;
            resp1=JOptionPane.showInputDialog("Que juego desea jugar?");
            if(resp1.equalsIgnoreCase("dados"))
            {
//JUEGO DE DADOS :
                
                String nombre;
                int mon;
                
                nombre=JOptionPane.showInputDialog("Ingrese su nombre: ");
                mon=Integer.parseInt(JOptionPane.showInputDialog("ingrese sus mondas: "));
        
                JuegoDeDados ref1 = new JuegoDeDados(nombre,mon);
                ref1.AsignarPuntaje();
                ref1.SumarPuntaje();
                ref1.MayorPuntaje();
                JOptionPane.showMessageDialog(null, ref1.verInfo());
                bucle2=true;
                break;
            }
            
            else if(resp1.equalsIgnoreCase("crash"))
            {
//JUEGO CRASH        
                int mon;
                String nombre;
                
                nombre=JOptionPane.showInputDialog("Ingrese su nombre: ");
                mon=Integer.parseInt(JOptionPane.showInputDialog("ingrese sus mondas: "));
                
                CrashGame refCG=new CrashGame(nombre,mon);
                refCG.iniciarJuego();
                JOptionPane.showMessageDialog(null, refCG.verInfo());
                bucle2=true;
                break;
            }
        
        
 //JUEGO RULETA :
 
            else if(resp1.equalsIgnoreCase("ruleta"))
            {
                String nombre;
                int mon;
                
                nombre=JOptionPane.showInputDialog("Ingrese su nombre: ");
                mon=Integer.parseInt(JOptionPane.showInputDialog("ingrese sus mondas: "));
                
                JOptionPane.showMessageDialog(null, "Bienvenidos al juego de la Ruleta");
                ruleta refR=new ruleta(nombre,mon);
                refR.generarNumeros();
                refR.iniciarJuego();
                JOptionPane.showMessageDialog(null, refR.verInfo());
                bucle2=true;
                break;
            }    
   
//LANZAR UNA MONEDA :            
             else if(resp1.equalsIgnoreCase("Moneda"))
             {
                 String nombre;
                int mon;
                
                nombre=JOptionPane.showInputDialog("Ingrese su nombre: ");
                mon=Integer.parseInt(JOptionPane.showInputDialog("ingrese sus mondas: "));
                
                CaraSello refCS=new CaraSello(nombre,mon);
                refCS.iniciarJuego();
                JOptionPane.showMessageDialog(null, refCS.verInfo());
                bucle2=true;
                break;

             }
             
             else if(resp1.equalsIgnoreCase("21")){
                 
                 Prueba21.main(args);
                 
             }
                
            
            else
            {
                JOptionPane.showMessageDialog(null, "Ingresa uno de los 5 juegos");
                bucle2=false;

            }
            
            
        }while(bucle2==false);
        
        

        
        
    }
    
    
    
    
    
    
}

