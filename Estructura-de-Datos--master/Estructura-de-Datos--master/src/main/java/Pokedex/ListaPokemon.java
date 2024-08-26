
package Pokedex;

import Pokemon.Pokemon;

public class ListaPokemon {
    private NodoPokemon cabeza;
    private NodoPokemon ultimo;

    public ListaPokemon() {
        cabeza = null;
        ultimo = null;
    }

    public void insertar(Pokemon pokemon) {
        NodoPokemon nuevoNodo = new NodoPokemon(pokemon);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            ultimo = nuevoNodo;
            ultimo.setNext(cabeza);
        } else {
            ultimo.setNext(nuevoNodo);
            ultimo = nuevoNodo;
            ultimo.setNext(cabeza);
        }
    }
    
    
    
    public Pokemon obtenerPokemonPorId(int id) {
        NodoPokemon actual = cabeza;
        if (actual != null) {
            do {
                if (actual.getPokemon().getId() == id) {
                    return actual.getPokemon();
                }
                actual = actual.getNext();
            } while (actual != cabeza);
        }
        return null;
    }

    public NodoPokemon getCabeza() {
        return cabeza;
    }
}
