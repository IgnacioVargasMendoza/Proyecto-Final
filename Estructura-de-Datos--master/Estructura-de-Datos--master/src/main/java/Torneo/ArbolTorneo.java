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
public class ArbolTorneo {

    private NodoArbol raiz;

    public ArbolTorneo() {
        this.raiz = null;
    }

    public void inserta(Jugador jugador) {
        if (raiz == null) {
            raiz = new NodoArbol(jugador);
        } else {
            insertaR(raiz, jugador);
        }
    }

    private void insertaR(NodoArbol n, Jugador jugador) {
        if (jugador.getId() <= n.getJugador().getId()) {
            if (n.getIzq() == null) {
                n.setIzq(new NodoArbol(jugador));
            } else {
                insertaR(n.getIzq(), jugador);
            }
        } else {
            if (n.getDer() == null) {
                n.setDer(new NodoArbol(jugador));
            } else {
                insertaR(n.getDer(), jugador);
            }
        }
    }

    public void inOrden() {
        if (raiz != null) {
            inOrdenR(raiz);
        } else {
            System.out.println("Arbol vacio...");
        }
    }//Fin inOrden

    private void inOrdenR(NodoArbol n) {//Inicio inOrderR
        if (n != null) {
            inOrdenR(n.getIzq());
            System.out.printf("Nombre: %s, ID: %s", n.getJugador().getNombre(), n.getJugador().getId() + "\n");
            inOrdenR(n.getDer());
        }
    }

}
