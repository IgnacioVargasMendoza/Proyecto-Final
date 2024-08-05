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

    private Batalla raiz;
    private int nivel;//rondaActual Batalla

    public ArbolTorneo() {
        this.setRaiz(null);
        this.setNivel(4);
    }

    public Batalla getRaiz() {
        return raiz;
    }

    public void setRaiz(Batalla raiz) {
        this.raiz = raiz;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public boolean isVacio() {
        return raiz == null;
    }

    public void crearArbol(PilaJugadores pilaJugadores) {

        Batalla hoja1 = new Batalla(pilaJugadores.desapilar());
        Batalla hoja2 = new Batalla(pilaJugadores.desapilar());
        Batalla hoja3 = new Batalla(pilaJugadores.desapilar());
        Batalla hoja4 = new Batalla(pilaJugadores.desapilar());
        Batalla hoja5 = new Batalla(pilaJugadores.desapilar());
        Batalla hoja6 = new Batalla(pilaJugadores.desapilar());
        Batalla hoja7 = new Batalla(pilaJugadores.desapilar());
        Batalla hoja8 = new Batalla(pilaJugadores.desapilar());

        Batalla cuartosFinalIzq1 = new Batalla(new Jugador("4.1 Ganador por Definir"));
        cuartosFinalIzq1.setHijoIzq(hoja8);
        cuartosFinalIzq1.setHijoDer(hoja7);

        Batalla cuartosFinalIzq2 = new Batalla(new Jugador("4.2 Ganador por Definir"));
        cuartosFinalIzq2.setHijoIzq(hoja6);
        cuartosFinalIzq2.setHijoDer(hoja5);

        Batalla cuartosFinalDer1 = new Batalla(new Jugador("4.3 Ganador por Definir"));
        cuartosFinalDer1.setHijoIzq(hoja4);
        cuartosFinalDer1.setHijoDer(hoja3);

        Batalla cuartosFinalDer2 = new Batalla(new Jugador("4.4 Ganador por Definir"));
        cuartosFinalDer2.setHijoIzq(hoja2);
        cuartosFinalDer2.setHijoDer(hoja1);

        Batalla semiFinalIzq1 = new Batalla(new Jugador("Ganador SemiFinal 1 Por Definir"));
        semiFinalIzq1.setHijoIzq(cuartosFinalIzq1);
        semiFinalIzq1.setHijoDer(cuartosFinalIzq2);

        Batalla semiFinalIzq2 = new Batalla(new Jugador("Ganador SemiFinal 2 por Definir"));
        semiFinalIzq2.setHijoIzq(cuartosFinalDer1);
        semiFinalIzq2.setHijoDer(cuartosFinalDer2);

        raiz = new Batalla(new Jugador("Ganador Batalla Final por Definir"));
        raiz.setHijoIzq(semiFinalIzq1);
        raiz.setHijoDer(semiFinalIzq2);

    }

    public void inOrden() {
        if (raiz != null) {
            inOrdenR(raiz);
        } else {
            System.out.println("Arbol vacio...");
        }
    } // Fin inOrden

    private void inOrdenR(Batalla n) { // Inicio inOrderR
        if (n != null) {
            inOrdenR(n.getHijoIzq());
            System.out.print(n.getGanador().getNombre() + ", ");
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

    private void preOrdenR(Batalla n) { // Inicio preOrdenR
        if (n != null) {
            System.out.print(n.getGanador().getNombre() + ", ");
            preOrdenR(n.getHijoIzq());
            preOrdenR(n.getHijoDer());
        }
    }

}
