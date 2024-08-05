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
public class Batalla {

    private Jugador ganador;
    private Batalla hijoIzq;
    private Batalla hijoDer;

    public Batalla(Jugador ganador) {
        this.setGanador(ganador);
    }


    public Jugador getGanador() {
        return ganador;
    }

    public void setGanador(Jugador ganador) {
        this.ganador = ganador;
    }


    public Batalla getHijoIzq() {
        return hijoIzq;
    }

    public void setHijoIzq(Batalla hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public Batalla getHijoDer() {
        return hijoDer;
    }

    public void setHijoDer(Batalla hijoDer) {
        this.hijoDer = hijoDer;
    }
}
