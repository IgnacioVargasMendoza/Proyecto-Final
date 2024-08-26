/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Torneo;

import com.Jugadores.Jugador;

/**
 * Representa un nodo en el árbol de torneos.
 */
public class NodoArbol {

    private Jugador jugador;
    private NodoArbol izq;
    private NodoArbol der;
    private Jugador ganador;

    public NodoArbol(Jugador jugador) {
        this.jugador = jugador;
        this.ganador = null;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public NodoArbol getIzq() {
        return izq;
    }

    public void setIzq(NodoArbol izq) {
        this.izq = izq;
    }

    public NodoArbol getDer() {
        return der;
    }

    public void setDer(NodoArbol der) {
        this.der = der;
    }

    public Jugador getGanador() {
        return ganador;
    }

    public void setGanador(Jugador ganador) {
        this.ganador = ganador;
    }

    /**
     * Determina si el nodo tiene un ganador.
     * @return true si el nodo tiene un ganador, false de lo contrario.
     */
    public boolean tieneGanador() {
        return ganador != null;
    }

    /**
     * Verifica si el nodo es una hoja (sin hijos).
     * @return true si el nodo no tiene hijos, false de lo contrario.
     */
    public boolean esHoja() {
        return izq == null && der == null;
    }

    /**
     * Devuelve el siguiente nodo en el árbol basado en el resultado del partido.
     * @param ganador el jugador que ganó el partido.
     * @return el siguiente nodo en el árbol.
     */
    public NodoArbol avanzar(NodoArbol ganador) {
        if (this.izq == null && this.der == null) {
            // Si es una hoja, no hay nodos a los que avanzar.
            return null;
        }
        if (this.izq != null && this.izq.getGanador() != null) {
            return this.izq;
        } else if (this.der != null && this.der.getGanador() != null) {
            return this.der;
        }
        return null;
    }
}
