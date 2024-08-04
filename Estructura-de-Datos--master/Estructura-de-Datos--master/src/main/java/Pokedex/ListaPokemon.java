/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pokedex;

import Pokedex.Pokemon;
import Pokedex.Pokemon;



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
        return null; // Si no se encuentra el Pokémon con el id especificado
    }

    public NodoPokemon getCabeza() {
        return cabeza;
    }
}
