package Pokedex;

import Torneo.NodoArbol;
import com.Jugadores.Jugador;

public class ArbolTorneo {
    private NodoArbol raiz;

    // Método para insertar un jugador en el árbol
    public void inserta(Jugador jugador) {
        raiz = insertaRec(raiz, jugador);
    }

    private NodoArbol insertaRec(NodoArbol nodo, Jugador jugador) {
        if (nodo == null) {
            nodo = new NodoArbol(jugador);
            return nodo;
        }

        // Asumir que el árbol está ordenado por ID
        if (jugador.getId() < nodo.getJugador().getId()) {
            nodo.setIzq(insertaRec(nodo.getIzq(), jugador));
        } else {
            nodo.setDer(insertaRec(nodo.getDer(), jugador));
        }
        return nodo;
    }

    // Método para buscar un jugador por ID
    public Jugador buscarPorId(int id) {
        return buscarPorIdRec(raiz, id);
    }

    private Jugador buscarPorIdRec(NodoArbol nodo, int id) {
        if (nodo == null) {
            return null;
        }

        if (nodo.getJugador().getId() == id) {
            return nodo.getJugador();
        } else if (id < nodo.getJugador().getId()) {
            return buscarPorIdRec(nodo.getIzq(), id);
        } else {
            return buscarPorIdRec(nodo.getDer(), id);
        }
    }
    
    public NodoArbol getRaiz() {
        return raiz;
    }

}


    
