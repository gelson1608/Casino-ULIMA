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
 * @author Alvaro
 */
public class ruleta extends JuegosDeAzar{

    private int numeros[][];
    private String eleccion;
    private int resultado;
    private int num;
    
    public ruleta(String jugador, int monedas) {
        super(jugador, monedas);
        numeros = new int[3][12];
    }
    public void generarNumeros()
    {
        int k=0;
        for(int i=0;i<12;i++)
        {
            for(int j=0;j<3;j++)
            {
                k++;
                numeros[j][i]=k;
            }
        }
    }
    
    
    @Override
    public void iniciarJuego() {
        
        Random rand=new Random();
        this.resultado=rand.nextInt(37);
        boolean bucle=true;
        
        do
        {
        
            String mesa="",cad1="";

            for(int i=0;i<3;i++)
            {
                cad1=cad1+"\n"+"FILA "+(i+1)+" |";
                for(int j=0;j<12;j++)
                {
                    cad1=cad1 + "             " + numeros[i][j];
                }
            }
            mesa=cad1+ "\n"+"--------------------------------------------------------------------------------------------------------------------"
                    + "------------------------------------------------"+
                    "\n            |                            1a Docena"+"                       |                        2a Docena"+
                    "                         |                        3a Docena"+"\n\n\n                                                 "
                    + "                   ROJO→PARES          NEGRO→IMPARES"+"\n\n\n"
                    + "°Apuesta   → |  Rojo/Negro  |   Par/Impar  |   Docena   |   Fila   |     Numero"+
                    "\n°Premio     → |   x2                 |   x2"+"                |   x3"+"             |   x3     |     x35"+
                    "\n\nDonde deseas colocar tus fichas?";

            this.eleccion=JOptionPane.showInputDialog(mesa);    

            if(eleccion.equalsIgnoreCase("par")||eleccion.equalsIgnoreCase("rojo"))
            {
                if(resultado%2==0)
                {
                    super.monedas=super.monedas*2;
                }
                else
                {
                    super.monedas=super.monedas*0;
                }
                 bucle=true;
                 break;
            }
            else if(eleccion.equalsIgnoreCase("impar")||eleccion.equalsIgnoreCase("negro"))
            {
                if(!(resultado%2==0))
                {
                    super.monedas=super.monedas*2;
                }
                else
                {
                    super.monedas=super.monedas*0;
                }
                bucle=true;
                break;
            }
            else if(eleccion.equalsIgnoreCase("1a docena"))
            {
                if(resultado>=1&&resultado<=12)
                {
                    super.monedas=super.monedas*3;
                }
                else
                {
                    super.monedas=super.monedas*0;
                }
                bucle=true;
                break;
            }
            else if(eleccion.equalsIgnoreCase("2a docena"))
            {
                if(resultado>=13&&resultado<=24)
                {
                    super.monedas=super.monedas*3;
                }
                else
                {
                    super.monedas=super.monedas*0;
                }
                bucle=true;
                break;
            }
            else if(eleccion.equalsIgnoreCase("3a docena"))
            {
                if(resultado>=25&&resultado<=36)
                {
                    super.monedas=super.monedas*3;
                }
                else
                {
                    super.monedas=super.monedas*0;
                }
                bucle=true;
                break;
            }
            else if(eleccion.equalsIgnoreCase("fila 1"))
            {
                if(resultado==1||resultado==4||resultado==7||resultado==10||resultado==13||resultado==16||resultado==19||resultado==22||resultado==25||resultado==28||resultado==31||resultado==34)
                {
                    super.monedas=super.monedas*3;
                }
                else
                {
                    super.monedas=super.monedas*0;
                }
                bucle=true;
                break;
            }
            else if(eleccion.equalsIgnoreCase("fila 2"))
            {
                if(resultado==2||resultado==5||resultado==8||resultado==11||resultado==14||resultado==17||resultado==20||resultado==23||resultado==26||resultado==29||resultado==32||resultado==35)
                {
                    super.monedas=super.monedas*3;
                }
                else
                {
                    super.monedas=super.monedas*0;
                }
                bucle=true;
                break;
            }
            else if(eleccion.equalsIgnoreCase("fila 3"))
            {
                if(resultado==3||resultado==6||resultado==9||resultado==12||resultado==15||resultado==18||resultado==21||resultado==24||resultado==27||resultado==30||resultado==33||resultado==36)
                {
                    super.monedas=super.monedas*3;
                }
                else
                {
                    super.monedas=super.monedas*0;
                }
                bucle=true;
                break;
            }
            else if(eleccion.equalsIgnoreCase("numero"))
            {
                num=Integer.parseInt(JOptionPane.showInputDialog("Que numero escoges?"));
                if(resultado==num)
                {
                    super.monedas=super.monedas*35;
                }
                else
                {
                    super.monedas=super.monedas*0;
                }
                eleccion="numero "+num;
                bucle=true;
                break;

            }
            else
            {
                JOptionPane.showMessageDialog(null, "Ingresa uno de los valores mostrados en la mesa");
                bucle=false;

            }
        
        }while(true);
    }

    @Override
    public String verInfo() {
        
        String mesa="",cad1="";

            for(int i=0;i<3;i++)
            {
                cad1=cad1+"\n"+"FILA "+(i+1)+" |";
                for(int j=0;j<12;j++)
                {
                    cad1=cad1 + "             " + numeros[i][j];
                }
            }
            mesa=cad1+ "\n"+"--------------------------------------------------------------------------------------------------------------------"
                    + "------------------------------------------------"+
                    "\n            |                            1a Docena"+"                       |                        2a Docena"+
                    "                         |                        3a Docena"+"\n\n\n                                                 "
                    + "                   ROJO→PARES          NEGRO→IMPARES"+"\n\n\n"
                    + "°Apuesta   → |  Rojo/Negro  |   Par/Impar  |   Docena   |   Fila   |     Numero"+
                    "\n°Premio     → |   x2                 |   x2"+"                |   x3"+"             |   x3     |     x35"
                    ;
        
        String cad="";
        cad=mesa+"\n\n\n"+super.verInfo()+"\nEleccion: "+this.eleccion+"                 Resultado: "+this.resultado;
        return cad;
    }
    
    
    
    
    
}
