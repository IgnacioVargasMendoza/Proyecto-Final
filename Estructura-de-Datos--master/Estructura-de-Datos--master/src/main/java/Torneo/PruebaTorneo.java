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
public class PruebaTorneo {
    
    public static void main(String[] args) {
        
        PilaJugadores pilaJugadores = new PilaJugadores();
        pilaJugadores.apilar(new Jugador("CPU 1"));
        pilaJugadores.apilar(new Jugador("CPU 2"));
        pilaJugadores.apilar(new Jugador("CPU 3"));
        pilaJugadores.apilar(new Jugador("CPU 4"));
        pilaJugadores.apilar(new Jugador("CPU 5"));
        pilaJugadores.apilar(new Jugador("CPU 6"));
        pilaJugadores.apilar(new Jugador("CPU 7"));
        pilaJugadores.apilar(new Jugador("Jugador 1"));
        
        ArbolTorneo pruebaTorneo = new ArbolTorneo();
        pruebaTorneo.crearArbol(pilaJugadores);
        pruebaTorneo.preOrden();
        
        
        
        
    }
    
}
