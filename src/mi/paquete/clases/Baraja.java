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
public class Baraja {
    private static Carta[] baraja;
    public int[] vistas;
    private int robadas;

    public Baraja() {
        baraja = new Carta[52];
        vistas = new int[13];
        int creadas = 0;
        for ( int palo = 0; palo <= 3; palo++ ) {
            for ( int valor = 1; valor <= 13; valor++ ) {
                baraja[creadas] = new Carta(valor,palo);
                creadas++;
            }
        }
        robadas = 0;
    }

    public void barajar() {
        for ( int i = 51; i > 0; i-- ) {
            int rand = (int)(Math.random()*(i+1));
            Carta temp = baraja[i];
            baraja[i] = baraja[rand];
            baraja[rand] = temp;
        }
        robadas = 0;
    }

    public int restantes() {
        return 52 - robadas;
    }

    public Carta robar() {
        if (robadas == 52)
        barajar();
        robadas++;
        vistas[((baraja[robadas-1]).getValor())-1]++;
        return baraja[robadas - 1];
    }
 
}
