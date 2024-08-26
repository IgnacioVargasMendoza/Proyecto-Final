package Torneo;


import com.Jugadores.Jugador;

public class ArbolTorneo {
    private NodoArbol raiz;

 
    public ArbolTorneo() {
        this.raiz = null;
    }

  
    public void inserta(Jugador jugador) {
       
        if (buscarNodoPorId(jugador.getId()) == null) {
            raiz = insertaRec(raiz, jugador);
        } else {
           
        }
    }

    private NodoArbol insertaRec(NodoArbol nodo, Jugador jugador) {
        if (nodo == null) {
            nodo = new NodoArbol(jugador);
            return nodo;
        }

     
        if (jugador.getId() < nodo.getJugador().getId()) {
            nodo.setIzq(insertaRec(nodo.getIzq(), jugador));
        } else {
            nodo.setDer(insertaRec(nodo.getDer(), jugador));
        }
        return nodo;
    }

  
    public void construirArbolTorneo(Jugador jugadorPrincipal) {

    resetear();

  
    Jugador campeon = new Jugador("Campeón", 1);
    Jugador semifinalista1 = new Jugador("Ganador Semifinal 1", 2);
    Jugador semifinalista2 = new Jugador("Ganador Semifinal 2", 3);

 
    Jugador cuartos1 = new Jugador("Ganador Cuartos 1", 4);
    Jugador cuartos2 = new Jugador("Ganador Cuartos 2", 5);
    Jugador cuartos3 = new Jugador("Ganador Cuartos 3", 6);
    Jugador cuartos4 = new Jugador("Ganador Cuartos 4", 7);


    Jugador jugador1 = new Jugador("Brock", 8);
    Jugador jugador2 = new Jugador("Misty", 9);
    Jugador jugador3 = new Jugador("Erika", 10);
    Jugador jugador4 = new Jugador("Koga", 11);
    Jugador jugador5 = new Jugador("Sabrina", 12);
    Jugador jugador6 = new Jugador("Blaine", 13);
    Jugador jugador7 = new Jugador("Giovanni", 14);
    Jugador jugador8 = jugadorPrincipal; 

   
    NodoArbol nodoCampeon = new NodoArbol(campeon);
    raiz = nodoCampeon;

    NodoArbol nodoSemifinalista1 = new NodoArbol(semifinalista1);
    nodoCampeon.setIzq(nodoSemifinalista1);

    NodoArbol nodoSemifinalista2 = new NodoArbol(semifinalista2);
    nodoCampeon.setDer(nodoSemifinalista2);

    NodoArbol nodoCuartos1 = new NodoArbol(cuartos1);
    nodoSemifinalista1.setIzq(nodoCuartos1);

    NodoArbol nodoCuartos2 = new NodoArbol(cuartos2);
    nodoSemifinalista1.setDer(nodoCuartos2);

    NodoArbol nodoCuartos3 = new NodoArbol(cuartos3);
    nodoSemifinalista2.setIzq(nodoCuartos3);

    NodoArbol nodoCuartos4 = new NodoArbol(cuartos4);
    nodoSemifinalista2.setDer(nodoCuartos4);

    nodoCuartos1.setIzq(new NodoArbol(jugador1));
    nodoCuartos1.setDer(new NodoArbol(jugador2));

    nodoCuartos2.setIzq(new NodoArbol(jugador3));
    nodoCuartos2.setDer(new NodoArbol(jugador4));

    nodoCuartos3.setIzq(new NodoArbol(jugador5));
    nodoCuartos3.setDer(new NodoArbol(jugador6));

    nodoCuartos4.setIzq(new NodoArbol(jugador7));
    nodoCuartos4.setDer(new NodoArbol(jugador8));
}



   
    private NodoArbol buscarNodoPorId(int id) {
        return buscarNodoPorIdRec(raiz, id);
    }

    private NodoArbol buscarNodoPorIdRec(NodoArbol nodo, int id) {
        if (nodo == null) {
            return null;
        }

        if (nodo.getJugador().getId() == id) {
            return nodo;
        } else if (id < nodo.getJugador().getId()) {
            return buscarNodoPorIdRec(nodo.getIzq(), id);
        } else {
            return buscarNodoPorIdRec(nodo.getDer(), id);
        }
    }

 
    public void resetear() {
        raiz = null;
    }

  
    public NodoArbol getRaiz() {
        return raiz;
    }
}



    
