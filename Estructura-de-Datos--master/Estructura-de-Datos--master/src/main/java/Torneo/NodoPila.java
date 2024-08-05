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
public class NodoPila {
    
    private Jugador jugador;
    private NodoPila siguiente;
    
    public NodoPila(Jugador jugador){
        this.jugador = jugador;
        this.siguiente = null;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public NodoPila getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPila siguiente) {
        this.siguiente = siguiente;
    }
    
        
}
