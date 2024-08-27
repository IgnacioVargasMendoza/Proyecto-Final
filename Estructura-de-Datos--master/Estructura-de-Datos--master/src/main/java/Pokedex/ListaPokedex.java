package Pokedex;

import Pokemon.Pokemon;

public class ListaPokedex {
    private NodoPokedex cabeza;
    private NodoPokedex ultimo;
    private int size;

    public NodoPokedex getUltimo() {
        return ultimo;
    }


    public ListaPokedex() {
        cabeza = null;
        ultimo = null;
        this.size = 0;
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
           
        }
        size++;
    }
    
    public void eliminarPorNombre(String nombre) {
        if (cabeza == null) return; 

        NodoPokedex actual = cabeza;
        NodoPokedex anterior = ultimo;

        do {
            if (actual.getDatoPokemon().getNombre().equals(nombre)) {
                if (actual == cabeza && actual == ultimo) {
                  
                    cabeza = null;
                    ultimo = null;
                } else if (actual == cabeza) {
                  
                    cabeza = cabeza.getSiguiente();
                    ultimo.setSiguiente(cabeza);
                    cabeza.setAnterior(ultimo);
                } else if (actual == ultimo) {
                 
                    ultimo = anterior;
                    ultimo.setSiguiente(cabeza);
                    cabeza.setAnterior(ultimo);
                } else {
                
                    anterior.setSiguiente(actual.getSiguiente());
                    actual.getSiguiente().setAnterior(anterior);
                }
                return; 
            }
            anterior = actual;
            actual = actual.getSiguiente();
        } while (actual != cabeza);
        size--;
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
        return null; 
    }

    public boolean existeEnPokedex(int id) {
        NodoPokedex actual = cabeza;
        if (actual != null) {
            do {
                if (actual.getDatoPokemon().getId() == id) {
                    return true;  
                }
                actual = actual.getSiguiente();
            } while (actual != cabeza);
        }
        return false;  
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
        return contador;  
    }

    public NodoPokedex getCabeza() {
        return cabeza;
    }
    
    
    public void setUltimo(NodoPokedex ultimo) {
        this.ultimo = ultimo;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
}
