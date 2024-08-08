package Pokedex;

import Pokemon.Pokemon;

public class ListaPokemonDC {

    private NodoPokemon cabeza;
    private NodoPokemon actual;
    private int tamaño;

    public ListaPokemonDC() {
        this.cabeza = null;
        this.actual = null;
        this.tamaño = 0;
    }
    
    public void agregarPokemon(Pokemon pokemon) {
        NodoPokemon nuevoNodo = new NodoPokemon(pokemon);
        
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cabeza.setSiguiente(cabeza);
            cabeza.setAnterior(cabeza);
            actual = cabeza;
        } else {
            NodoPokemon ultimo = cabeza.getAnterior();
            ultimo.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(ultimo);
            nuevoNodo.setSiguiente(cabeza);
            cabeza.setAnterior(nuevoNodo);
        }
        tamaño++;
    }

    public NodoPokemon elegirActual() {
        return actual;
    }

    public NodoPokemon siguientePokemon() {
        if (actual != null) {
            actual = actual.getSiguiente();
            return actual;
        } else {
            return null; // Si no hay Pokémon, retorna null.
        }
    }

    public NodoPokemon anteriorPokemon() {
        if (actual != null) {
            actual = actual.getAnterior();
            return actual;
        } else {
            return null; // Si no hay Pokémon, retorna null.
        }
    }

    public NodoPokemon getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoPokemon cabeza) {
        this.cabeza = cabeza;
    }

    public NodoPokemon getActual() {
        return actual;
    }

    public void setActual(NodoPokemon actual) {
        this.actual = actual;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }
}