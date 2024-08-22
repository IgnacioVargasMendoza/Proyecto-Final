package Pokedex;

import Pokemon.Pokemon;

public class ListaPokedex {
    private NodoPokedex cabeza;
    private NodoPokedex ultimo;

    public ListaPokedex() {
        cabeza = null;
        ultimo = null;
    }

    public void insertar(Pokemon pokemon) {
        if (!existeEnPokedex(pokemon.getId())) {
            NodoPokedex nuevoNodo = new NodoPokedex(pokemon);
            if (cabeza == null) {
                cabeza = nuevoNodo;
                ultimo = nuevoNodo;
                cabeza.setSiguiente(cabeza);
                cabeza.setAnterior(cabeza);
            } else {
                ultimo.setSiguiente(nuevoNodo);
                nuevoNodo.setAnterior(ultimo);
                nuevoNodo.setSiguiente(cabeza);
                cabeza.setAnterior(nuevoNodo);
                ultimo = nuevoNodo;
            }
        } else {
            System.out.println("El Pokémon " + pokemon.getNombre() + " ya está en la Pokédex.");
        }
    }
    
    public void eliminarPorNombre(String nombre) {
        if (cabeza == null) return; // Lista vacía, no hacer nada

        NodoPokedex actual = cabeza;
        NodoPokedex anterior = ultimo;

        do {
            if (actual.getDatoPokemon().getNombre().equals(nombre)) {
                if (actual == cabeza && actual == ultimo) {
                    // Si es el único nodo en la lista
                    cabeza = null;
                    ultimo = null;
                } else if (actual == cabeza) {
                    // Si es la cabeza de la lista
                    cabeza = cabeza.getSiguiente();
                    ultimo.setSiguiente(cabeza);
                    cabeza.setAnterior(ultimo);
                } else if (actual == ultimo) {
                    // Si es el último nodo de la lista
                    ultimo = anterior;
                    ultimo.setSiguiente(cabeza);
                    cabeza.setAnterior(ultimo);
                } else {
                    // Si está en medio de la lista
                    anterior.setSiguiente(actual.getSiguiente());
                    actual.getSiguiente().setAnterior(anterior);
                }
                return; // Salir después de la eliminación
            }
            anterior = actual;
            actual = actual.getSiguiente();
        } while (actual != cabeza);
    }
    
    public Pokemon buscarPorId(int id) {
        NodoPokedex actual = cabeza;
        if (actual != null) {
            do {
                if (actual.getDatoPokemon().getId() == id) {
                    return actual.getDatoPokemon();
                }
                actual = actual.getSiguiente();
            } while (actual != cabeza);
        }
        return null; // Si no se encuentra el Pokémon con el id especificado
    }

    public boolean existeEnPokedex(int id) {
        NodoPokedex actual = cabeza;
        if (actual != null) {
            do {
                if (actual.getDatoPokemon().getId() == id) {
                    return true;  // Si encuentra un Pokémon con el mismo ID, retorna verdadero
                }
                actual = actual.getSiguiente();
            } while (actual != cabeza);
        }
        return false;  // Retorna falso si no encuentra el Pokémon en la Pokédex
    }

    public int contarPokemon() {
        int contador = 0;
        NodoPokedex actual = cabeza;
        if (actual != null) {
            do {
                contador++;
                actual = actual.getSiguiente();
            } while (actual != cabeza);
        }
        return contador;  // Retorna el número de Pokémon en la Pokédex
    }

    public NodoPokedex getCabeza() {
        return cabeza;
    }
}
