
package Torneo;

import com.Jugadores.Jugador;

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

  
    public boolean tieneGanador() {
        return ganador != null;
    }

    public boolean esHoja() {
        return izq == null && der == null;
    }


    public NodoArbol avanzar(NodoArbol ganador) {
        if (this.izq == null && this.der == null) {
          
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
