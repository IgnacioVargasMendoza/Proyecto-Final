
package Pokedex;

import Pokemon.Pokemon;

public class NodoPokedex {
    private Pokemon datoPokemon; 
    
    private NodoPokedex siguiente;

    public NodoPokedex(Pokemon datoPokemon) {
        this.datoPokemon = datoPokemon;
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

    @Override
    public String toString() {
        return datoPokemon.toString();
    }
}
