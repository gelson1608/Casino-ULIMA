/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mi.paquete.clases;

/**
 *
 * @author AlssiadPC
 */
public class Carta {
    public final static int ESPADAS = 0,CORAZONES = 1,DIAMANTES = 2,PICAS = 3;
    public final static int AS = 1,JACK = 11,QUEEN = 12,KING = 13;
    private final int palo;
    private final int valor;

    public Carta(int val, int pal) {
        valor = val;
        palo = pal;
    }

    public int getPalo() {
        return palo;
    }

    public int getValor() {
        return valor;
    }

    public String getPaloString() {
        switch ( palo ) {
            case ESPADAS: 
                return "Espadas";
            case CORAZONES: 
                return "Corazones";
            case DIAMANTES: 
                return "Diamantes";
            case PICAS: 
                return "Picas";
            default: return "??";
        }
    }


    public String getValorString() {
        switch ( valor ) {
            case 1: return "As";
            case 2: return "2";
            case 3: return "3";
            case 4: return "4";
            case 5: return "5";
            case 6: return "6";
            case 7: return "7";
            case 8: return "8";
            case 9: return "9";
            case 10: return "10";
            case 11: return "J";
            case 12: return "Q";
            case 13: return "K";
            default: return "??";
        }
    }

    public String toString() {
        return getValorString() + " de " + getPaloString();
    }
    
}
