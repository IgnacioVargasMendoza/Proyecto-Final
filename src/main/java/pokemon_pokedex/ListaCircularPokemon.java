/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemon_pokedex;

import pokemon_dato.Pokemon;

/**
 *
 * @author Ignac
 */
public class ListaCircularPokemon {

    private NodoPokemon cabeza;
    private NodoPokemon ultimo;
    private NodoPokemon actual;
    private int size;

    public ListaCircularPokemon() {
        this.cabeza = null;
        this.ultimo = null;
        this.actual = null;
        this.size = 0;
    }
    
        public boolean vacia() {
        return cabeza == null;
    }

    /*Crea un nuevo nodo e inserta el nuevo pokemon, luego consulta la informacion
    del nuevo nodo y la compara contra los nodos de la lista para insertar el dato*/
    public void inserta(Pokemon pokemon) {
       NodoPokemon nuevo = new NodoPokemon(pokemon);

        if (vacia()) {
            cabeza = nuevo;
            ultimo = nuevo;
            ultimo.setNext(cabeza);
            actual = cabeza;
        } else if (nuevo.getPokemon().getId() <  cabeza.getPokemon().getId() ){
            nuevo.setNext(cabeza);
            cabeza = nuevo;
            ultimo.setNext(nuevo);
        } else if (nuevo.getPokemon().getId() > ultimo.getPokemon().getId() ) {

            ultimo.setNext(nuevo);
            ultimo = ultimo.getNext();
            ultimo.setNext(cabeza);
        } else {

            NodoPokemon aux = cabeza;

            while (aux.getNext().getPokemon().getId() < nuevo.getPokemon().getId()) {
                aux = aux.getNext();
            }

            nuevo.setNext(aux.getNext());
            aux.setNext(nuevo);
        }
        size++;

    }

    public NodoPokemon getCabeza() {
        return cabeza;
    }

    public boolean buscarPokemon(Pokemon pokemon) {
        NodoPokemon temp = cabeza;
        while (temp != null) {
            if (temp.getPokemon().getNombre().equals(pokemon.getNombre())) {
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    public String toString() {
        NodoPokemon aux = cabeza;
        String s = "";
        while (aux != null) {
            s += "ID: " + aux.getPokemon().getId() + " , "
                    + "Nombre: " + aux.getPokemon().getNombre()
                    + "\n";
            aux = aux.getNext();
        }
        return s;
    }

    public Pokemon pokemonActual() {
        return actual != null ? actual.getPokemon() : null;
    }

    public void siguientePokemon() {
             if(this.actual != null){
                 this.actual = actual.getNext();
             }
            
    }
    

        /*
    public Pokemon buscarPorNombre(String nombre) {
        NodoPokemon temp = cabeza;
        while (temp != null) {
            if (temp.getPokemon().getNombre() == nombre) {
                ultimo = temp;
                return PokemonActual();
            }
            temp = temp.getNext();
        }
        return null;
    }*/
    
}
