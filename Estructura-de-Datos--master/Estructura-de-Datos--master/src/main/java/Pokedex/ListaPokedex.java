
package Pokedex;




import Pokemon.Pokemon;

public class ListaPokedex {
    private NodoPokemon cabeza;
    private NodoPokemon ultimo;

    public ListaPokedex() {
        cabeza = null;
        ultimo = null;
    }

    public void insertar(Pokemon pokemon) {
        if (!existeEnPokedex(pokemon.getId())) {  // Verifica si el Pokémon ya está en la Pokédex
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
        } else {
            System.out.println("El Pokémon " + pokemon.getNombre() + " ya está en la Pokédex.");
        }
    }
    
    public Pokemon buscarPorId(int id) {
        NodoPokemon actual = cabeza;
        if (actual != null) {
            do {
                if (actual.getPokemon().getId() == id) {
                    return actual.getPokemon();
                }
                actual = actual.getNext();
            } while (actual != cabeza);
        }
        return null; // Si no se encuentra el Pokémon con el id especificado
    }

    public boolean existeEnPokedex(int id) {
        NodoPokemon actual = cabeza;
        if (actual != null) {
            do {
                if (actual.getPokemon().getId() == id) {
                    return true;  // Si encuentra un Pokémon con el mismo ID, retorna verdadero
                }
                actual = actual.getNext();
            } while (actual != cabeza);
        }
        return false;  // Retorna falso si no encuentra el Pokémon en la Pokédex
    }

    public int contarPokemon() {
        int contador = 0;
        NodoPokemon actual = cabeza;
        if (actual != null) {
            do {
                contador++;
                actual = actual.getNext();
            } while (actual != cabeza);
        }
        return contador;  // Retorna el número de Pokémon en la Pokédex
    }

    public NodoPokemon getCabeza() {
        return cabeza;
    }



    
}