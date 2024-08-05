/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Torneo;

import com.Jugadores.Jugador;

/**
 *
 * @author Ignac
 */
public class PilaJugadores {

    private NodoPila cima;
    private int size;

    public PilaJugadores() {
        this.cima = null;
        this.size = 0;
    }

    public boolean esVacia() {
        return cima == null;
    }

    public void apilar(Jugador jugador) {
        NodoPila nuevo = new NodoPila(jugador);
        if (esVacia()) {
            cima = nuevo;
        } else {
            nuevo.setSiguiente(cima);
            cima = nuevo;
        }
        setSize(size++);
    }

    public Jugador desapilar() {
        if (!esVacia()) {
            Jugador jugador = cima.getJugador();
            cima = cima.getSiguiente();
            System.out.printf("El jugador %s ha sido extraido%n", jugador.getNombre());
            setSize(size--);
            return jugador;
        }
        return null; 
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String toString() {
        String s = "";
        if (!esVacia()) {
            NodoPila aux = cima;
            while (aux != null) {
                s = s + aux + "\n";
                aux = aux.getSiguiente();
            }
        }
        return s;
    }

}
