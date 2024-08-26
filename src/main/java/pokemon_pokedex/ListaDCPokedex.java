/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemon_pokedex;

import javax.swing.JOptionPane;
import pokemon_dato.Pokemon;

/**
 *
 * @author Ignac
 */
public class ListaDCPokedex {

    private NodoPokedex cabeza;
    private NodoPokedex ultimo;
    private int size;

    public ListaDCPokedex() {
        this.cabeza = null;
        this.ultimo = null;
    }

    public void inserta(Pokemon pokemon) {

            NodoPokedex nuevo = new NodoPokedex(pokemon);

            if (cabeza == null) {  // La lista está vacía
                cabeza = nuevo;
                ultimo = cabeza;
                ultimo.setBack(cabeza);
                cabeza.setNext(ultimo);
            } else if (nuevo.getPokemon().getId() < cabeza.getPokemon().getId()) {  // Insertar al principio
                nuevo.setNext(cabeza);
                cabeza.setBack(nuevo);
                cabeza = nuevo;
                ultimo.setNext(cabeza);
                cabeza.setBack(ultimo);
            } else if (ultimo.getPokemon().getId() <= pokemon.getId()) {  // Insertar al final
                ultimo.setNext(nuevo);
                nuevo.setBack(ultimo);
                ultimo = nuevo;  // Actualizar correctamente el último nodo
                ultimo.setNext(cabeza);
                cabeza.setBack(ultimo);
            } else {  // Insertar en medio
                NodoPokedex aux = cabeza;
                while (aux.getNext().getPokemon().getId() < pokemon.getId()) {
                    aux = aux.getNext();
                }
                nuevo.setNext(aux.getNext());
                nuevo.setBack(aux);
                aux.getNext().setBack(nuevo);
                aux.setNext(nuevo);
            }
            this.size++;

        
    }

    public boolean buscarPokemon(String nombre) {

        if (cabeza == null) {  // La lista está vacía
            return false;
        }
        NodoPokedex temp = cabeza;
        do {
            if (temp.getPokemon().getNombre().equals(nombre)) {
                return true;
            }
            temp = temp.getNext();
        } while (temp != cabeza);  // Continuar hasta que vuelva al inicio de la lista

        return false;  // No se encontró el Pokémon
    }

    public boolean eliminarPokemon(String nombre) {
        if (cabeza == null) {  // La lista está vacía
            return false;
        }
        NodoPokedex actual = cabeza;
        do {
            if (actual.getPokemon().getNombre().equals(nombre)) {
                if (actual == cabeza && actual == ultimo) {  // Solo hay un elemento en la lista
                    cabeza = null;
                    ultimo = null;
                } else if (actual == cabeza) {  // Eliminar el primer nodo
                    cabeza = cabeza.getNext();
                    cabeza.setBack(ultimo);
                    ultimo.setNext(cabeza);
                } else if (actual == ultimo) {  // Eliminar el último nodo
                    ultimo = ultimo.getBack();
                    ultimo.setNext(cabeza);
                    cabeza.setBack(ultimo);
                } else {  // Eliminar un nodo en medio
                    actual.getBack().setNext(actual.getNext());
                    actual.getNext().setBack(actual.getBack());
                }

                size--;  // Reducir el tamaño de la lista
                return true;
            }
            actual = actual.getNext();
        } while (actual != cabeza);

        return false;  // No se encontró el Pokémon
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String toString() {

        NodoPokedex aux = cabeza;
        String s = "";
        if (aux != null) {
            do {
                s += aux.getPokemon().getId()
                        + ": " + aux.getPokemon().getNombre()
                        + "\n";
                aux = aux.getNext();
            } while (aux != cabeza);
        }
        return s;
    }
}
