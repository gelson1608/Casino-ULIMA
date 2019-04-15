/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mi.paquete.clases;

import java.util.Vector;

/**
 *
 * @author AlssiadPC
 */
public class Mano {
    private Vector mano;
    public int apuesta;

    public Mano() {
        mano = new Vector();
    }

    public void soltar() {
        mano.removeAllElements();
    }

    public void cogerCarta(Carta c) {
        if (c != null)
        mano.addElement(c);
    }

    public void dejarCarta(Carta c) {
        mano.removeElement(c);
    }

    public void dejarCarta(int pos) {
        if (pos >= 0 && pos < mano.size())
        mano.removeElementAt(pos);
    }

    public int contar() {
        return mano.size();
    }

    public Carta obtenerCarta(int pos) {
        if (pos >= 0 && pos < mano.size())
        return (Carta)mano.elementAt(pos);
        else
        return null;
    }
    
// Cuenta los puntos que suman las cartas de nuestra mano
    public int getBlackjackValor() {
        int val;
        boolean as;
        int cartas;
        val = 0;
        as = false;
        cartas = contar();
        for ( int i = 0; i < cartas; i++ ) {
            Carta carta;
            int cartaVal;
            carta = obtenerCarta(i);
            cartaVal = carta.getValor();
            if (cartaVal > 10) {
                cartaVal = 10;
            }
            if (cartaVal == 1) {
                as = true;
            }
            val = val + cartaVal;
        }
    
        if ( as == true && val + 10 <= 21 )
        val = val + 10;
        return val;
    } 
    
}
