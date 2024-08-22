package Pokedex;

import Pokemon.Pokemon;

public class NodoPokedex {
    private Pokemon datoPokemon; 
    private NodoPokedex siguiente;
    private NodoPokedex anterior;

    public NodoPokedex(Pokemon datoPokemon) {
        this.datoPokemon = datoPokemon;
        this.siguiente = null;
        this.anterior = null;
    }

    public Pokemon getDatoPokemon() {
        return datoPokemon;
    }

    public void setDatoPokemon(Pokemon datoPokemon) {
        this.datoPokemon = datoPokemon;
    }

    public NodoPokedex getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPokedex siguiente) {
        this.siguiente = siguiente;
    }

    public NodoPokedex getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoPokedex anterior) {
        this.anterior = anterior;
    }

    @Override
    public String toString() {
        return datoPokemon.toString();
    }
}
