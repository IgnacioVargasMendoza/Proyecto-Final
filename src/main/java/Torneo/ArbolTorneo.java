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
    private int nivel;//rondaActual Batalla

    /**
     * Constructor del Arbol. No recibe parametros e inicia 
     *
     */
    public ArbolTorneo() {
        this.raiz = null;
    }

    public NodoArbol getRaiz() {
        return raiz;
    }

    public boolean isVacio() {
        return raiz == null;
    }

    public void crearArbol() {

    }
    /*
    public void inserta(int x) {//inicio inserta
        if (raiz == null) {
            raiz = new NodoArbol();
        } else {
            insertaR(raiz, x);
        }
    }//fin inserta

    private void insertaR(Nodo n, int x) {//inicio insertaR
        if (x <= n.getId()) {
            if (n.getHijoIzq() == null) {
                n.setHijoIzq(new Nodo(x));
            } else {
                insertaR(n.getHijoIzq(), x);
            }
        } else {
            if (n.getHijoDer() == null) {
                n.setHijoDer(new Nodo(x));
            } else {
                insertaR(n.getHijoDer(), x);
            }
        }
    }//Fin insertaR*/

    public void inOrden() {
        if (raiz != null) {
            inOrdenR(raiz);
        } else {
            System.out.println("Arbol vacio...");
        }
    } // Fin inOrden

    private void inOrdenR(NodoArbol n) { // Inicio inOrderR
        if (n != null) {
            inOrdenR(n.getHijoIzq());
            System.out.print(n.getJugador().getNombre() + ", ");
            inOrdenR(n.getHijoDer());
        }
    }

    public void preOrden() {
        if (raiz != null) {
            preOrdenR(raiz);
        } else {
            System.out.println("Arbol vacio...");
        }
    } // Fin preOrden

    private void preOrdenR(NodoArbol n) { // Inicio preOrdenR
        if (n != null) {
            System.out.print(n.getJugador().getNombre() + ", ");
            preOrdenR(n.getHijoIzq());
            preOrdenR(n.getHijoDer());
        }
    }

}
