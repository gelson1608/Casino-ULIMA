/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mi.paquete.clases;

/**
 *
 * @author Alvaro
 */
public abstract class JuegosDeAzar {
    
    protected String jugador;
    protected float monedas;

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public float getMonedas() {
        return monedas;
    }

    public void setMonedas(int monedas) {
        this.monedas = monedas;
    }

    public JuegosDeAzar(String jugador, int monedas) {
        this.jugador = jugador;
        this.monedas = monedas;
    }
    
    public abstract void iniciarJuego();
    
    public String verInfo()
    {
        String cad="";
        cad="Jugador: "+this.jugador+"           Numero de mondedas: "+this.monedas;
        return cad;
    }
    
        
    
    
}
