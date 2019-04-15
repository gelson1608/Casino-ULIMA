/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mi.paquete.test;

import javax.swing.JOptionPane;
import mi.paquete.clases.Baraja;
import mi.paquete.clases.Carta;
import mi.paquete.clases.Mano;

/**
 *
 * @author AlssiadPC
 */
public class Prueba21 {

    public static void main(String[] args) {
        
        
        int saldo;
        int[] resultados;
        int[] saldos;
        int numero, i;
        Mano manoJugador[];
        boolean primera = true;
        boolean bancarrota[];

        JOptionPane.showMessageDialog(null, "Bienvenido al juego de Blackjack.");
       
        do{
            numero = Integer.parseInt(JOptionPane.showInputDialog("Numero de jugadores:"));
            saldo = Integer.parseInt(JOptionPane.showInputDialog("Con que cantidad empezara cada jugador(soles)?"));
            if(numero<0 || saldo<0){
                JOptionPane.showMessageDialog(null, "Numero de jugadores o saldo inaceptable");
            }
        }while(numero<0 || saldo<0);
        
// Inicializamos los arrays que vamos a utilizar
        saldos = new int[numero];
        manoJugador = new Mano[numero];
        resultados = new int[numero + 1];
        bancarrota = new boolean[numero];
        for (i = 0; i < numero; i++) {
            saldos[i] = saldo;
            bancarrota[i] = false;
        }

        while (true) {
            for (int j = 0; j < numero; j++) {
                manoJugador[j] = new Mano();
                if (saldos[j] <= 0) {
                    bancarrota[j] = true;
                }
                JOptionPane.showMessageDialog(null, "JUGADOR NUMERO " + (j + 1) + ". Tiene " + saldos[j]
                        + " soles");
                if (!bancarrota[j]) {
                    do {
                        manoJugador[j].apuesta = Integer.parseInt(JOptionPane.showInputDialog("Cuantos quiere apostar? (0=Salir)"));

                        if (manoJugador[j].apuesta < 0 || manoJugador[j].apuesta
                                > saldos[j]) {
                            JOptionPane.showMessageDialog(null, "Su apuesta debe estar entre 0 y " + saldos[j]);
                        }

                        if (manoJugador[j].apuesta == 0) {

                            JOptionPane.showMessageDialog(null, "Sale del juego el jugador " + (j + 1));
                            bancarrota[j] = true;
                        }
                    } while (manoJugador[j].apuesta < 0
                            || manoJugador[j].apuesta > saldos[j]);
                }
            }

            if (!queda_alguno(bancarrota, numero)) {
                resultados =
                        jugar(numero, manoJugador, bancarrota);
            } else {

                JOptionPane.showMessageDialog(null, "Todos los jugadores se han quedado sin dinero o no hay mas jugadores");
                JOptionPane.showMessageDialog(null, "Vuelva Pronto");
                System.exit(-1);
            }

            for (int j = 0; j < numero; j++) {
                if ((resultados[0] == 2) || (resultados[0] == 1)) {
                    saldos[j] = saldos[j] - manoJugador[j].apuesta;
                } 
                else {
                    switch (resultados[j + 1]) {
                        case -1:
                            saldos[j] = saldos[j]
                                    - manoJugador[j].apuesta;
                            break;
                        case 1:
                            saldos[j] = saldos[j]
                                    + manoJugador[j].apuesta;
                            break;
                        case 2:
                            saldos[j] = saldos[j]
                                    + 2 * manoJugador[j].apuesta;
                            break;
                        default:
                            saldos[j] = saldos[j] - manoJugador[j].apuesta;
                    }
                }
            }
        }
    }
    
// Metodo jugar que lleva el desarrollo principal de la partida
    static int[] jugar(int jugadores, Mano[] manoJugador, boolean[] bancarrota) {
        Baraja baraja;
        Mano manoBanca;
        boolean fin = false;
        int i, j;

        int resultados[];
        resultados = new int[jugadores + 1];
        for (int m = 0; m <= jugadores; m++) {
            resultados[m] = 0;
        }
        baraja = new Baraja();
// Barajamos y repartimos
        baraja.barajar();
// La banca roba sus cartas
        manoBanca = new Mano();
        manoBanca.cogerCarta(baraja.robar());
        manoBanca.cogerCarta(baraja.robar());

        for (i = 0; i < jugadores; i++) {
            manoJugador[i].cogerCarta(baraja.robar());
            manoJugador[i].cogerCarta(baraja.robar());
            
// En caso de que el usuario consiga Blackjack (21 a la primera)
//gana el doble de la apuesta
// y se acaba la ronda

            if ((manoJugador[i].getBlackjackValor() == 21) && (!bancarrota[i])) {
                JOptionPane.showMessageDialog(null, "La banca tiene "
                        + manoBanca.obtenerCarta(0)
                        + " y " + manoBanca.obtenerCarta(1) + ".");
                JOptionPane.showMessageDialog(null, "El jugador " + (i + 1) + " tiene "
                        + manoJugador[i].obtenerCarta(0)
                        + " y " + manoJugador[i].obtenerCarta(1) + ".");
                JOptionPane.showMessageDialog(null, "El jugador " + (i + 1) + " tiene Blackjack y gana");
                resultados[i + 1] = 2;
                fin = true;
            }
        }
// Si la banca tiene BJ gana y se acaba la partida

        if (manoBanca.getBlackjackValor() == 21) {
            JOptionPane.showMessageDialog(null, "La banca tiene " + manoBanca.obtenerCarta(0)
                    + " y " + manoBanca.obtenerCarta(1) + ".");
            JOptionPane.showMessageDialog(null, "La banca tiene Blackjack y gana.");
            resultados[0] = 2;
            fin = true;
        }
        if (fin) {
            return resultados;
        }
        
// Si ninguno de los 2 tiene BJ seguimos con el juego
// Comienza la iteracion para cada uno de los jugadores
        for (j = 0; j < jugadores; j++) {
// Mostramos las cartas de los jugadores y una de las cartas de la
//banca
            JOptionPane.showMessageDialog(null, "--------- JUGADOR " + (j + 1) + " ---------");

            fin = false;
            while (!bancarrota[j]) {

                JOptionPane.showMessageDialog(null, "Jugador " + (j + 1) + ".Sus cartas son:");
                for (i = 0; i < manoJugador[j].contar(); i++) {
                    JOptionPane.showMessageDialog(null, " " + manoJugador[j].obtenerCarta(i));
                }
                JOptionPane.showMessageDialog(null, "Y suman un total de "
                        + manoJugador[j].getBlackjackValor() + " puntos.");
                JOptionPane.showMessageDialog(null, "La banca muestra "
                        + manoBanca.obtenerCarta(0));

// Carta o se planta?

                int accion;
                do {
                    accion = Integer.parseInt(JOptionPane.showInputDialog("Carta (1) o se Planta (2)? "));
                    if (accion != 1 && accion != 2) {
                        accion = Integer.parseInt(JOptionPane.showInputDialog("Por favor responda C o P: "));
                    }
                } while (accion != 1 && accion != 2);
// Si se planta salimos del bucle
                if (accion == 2) {

                    JOptionPane.showMessageDialog(null, "El jugador " + (j + 1) + " se planta.");

                    break;
                } // Si no se planta seguimos con una nueva carta
                else {
                    Carta newCarta = baraja.robar();
                    manoJugador[j].cogerCarta(newCarta);

                    JOptionPane.showMessageDialog(null, "Usted roba carta.");
                    JOptionPane.showMessageDialog(null, "Su carta es " + newCarta);
                    JOptionPane.showMessageDialog(null, "Y usted tiene "
                            + manoJugador[j].getBlackjackValor() + " puntos");
// Si se pasa de 21 puntos pierde y pone su resultado a -1
                    if (manoJugador[j].getBlackjackValor() > 21) {
                        JOptionPane.showMessageDialog(null, "El jugador " + (j + 1) + " se ha pasado de 21. Ha perdido");

                        resultados[j + 1] = -1;
                        fin = true;
                    }
                }
                if (fin) {
                    break;
                }
            }
        }
// Ahora le toca jugar a la banca
        JOptionPane.showMessageDialog(null, "Las cartas de la banca son ");
        JOptionPane.showMessageDialog(null, " " + manoBanca.obtenerCarta(0));
        JOptionPane.showMessageDialog(null, " " + manoBanca.obtenerCarta(1));
        while (true) {
            float beneficio = 0;
            float beneficio_hip = 0;
            float beneficio_aux = 0;
            float probabilidad = 0;
// Primero comprobamos el beneficio que obtendriamos en la
//situacion actual
            for (i = 0; i < jugadores; i++) {
                if (manoBanca.getBlackjackValor() >= manoJugador[i].getBlackjackValor()) {
                    beneficio = beneficio + manoJugador[i].apuesta;
                } else if (resultados[i + 1] != -1) {
                    beneficio = beneficio + manoJugador[i].apuesta;
                }
            }

// Sabiendo las cartas que hay en la mesa calcularemos la
//esperanza de sacar cada una de las
// posibles cartas y en funcion de eso el beneficio hipotetico que
//obtendriamos.
            for (j = 1; j < 14; j++) {
                Carta aux = new Carta(j, 0);
                manoBanca.cogerCarta(aux);
                probabilidad = baraja.vistas[j - 1] / baraja.restantes();
                for (i = 0; i < jugadores; i++) {
                    if (manoBanca.getBlackjackValor() >= manoJugador[i].getBlackjackValor()) {
                        beneficio_aux = beneficio_aux + manoJugador[i].apuesta;
                    } else if (resultados[i + 1] != -1) {
                        beneficio_aux = beneficio_aux - manoJugador[i].apuesta;
                    }
                }
                beneficio_hip = beneficio_hip + beneficio_aux * probabilidad;
                beneficio_aux = 0;
                manoBanca.dejarCarta(manoBanca.contar() - 1);
            }
// Si el beneficio hipotetico es mayor que el actual robamos carta
            if (beneficio_hip > beneficio) {
                Carta newCarta = baraja.robar();
                JOptionPane.showMessageDialog(null, "La banca roba " + newCarta);
                manoBanca.cogerCarta(newCarta);
                if (manoBanca.getBlackjackValor() > 21) {
                    resultados[0] = -1;
                    break;
                }
            } else {
                break;
            }
        }
// Repetimos esto hasta que nos pasemos o decidamos no coger nueva
//carta
        JOptionPane.showMessageDialog(null, "El total de la banca es de "
                + manoBanca.getBlackjackValor() + " puntos");

        for (i = 0; i < jugadores; i++) {
            if ((resultados[i + 1] == -1) || (bancarrota[i])) {
                continue;
            }
            if (resultados[0] == -1) {
                resultados[i + 1] = 1;
                continue;
            }
            if (manoJugador[i].getBlackjackValor() > manoBanca.getBlackjackValor()) {
                resultados[i + 1] = 1;
            } else {
                resultados[i + 1] = -1;
            }
        }

// Imprimimos por pantalla quien ha ganado a quien
        for (i = 1; i <= jugadores; i++) {
            if (!bancarrota[i - 1]) {
                if (resultados[i] > resultados[0]) {
                    JOptionPane.showMessageDialog(null, "Jugador " + i + " gana a la banca.");
                } else {
                    JOptionPane.showMessageDialog(null, "La banca gana al jugador " + i + ".");
                }
            }
        }
        return resultados;
    }
// Este metodo comprueba si todos los jugadores se han quedado sin
//dinero
    static boolean queda_alguno(boolean bancarrota[], int numero) {
        boolean bancarrota_total = true;
        for (int p = 0; (p < numero) && bancarrota_total; p++) {
            if (!bancarrota[p]) {
                bancarrota_total = false;
                break;
            }
        }
        return bancarrota_total;


    }
}

