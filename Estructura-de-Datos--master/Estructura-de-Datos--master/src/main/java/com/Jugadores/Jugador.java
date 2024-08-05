package com.Jugadores;

import Pokedex.ListaPokedex;
import Pokemon.Pokemon;
import Pokedex.NodoPokedex;


public class Jugador {
    
    private String nombre;
    private ListaPokedex pokedex;

    public Jugador(){};

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPokedex(ListaPokedex pokedex) {
        this.pokedex = pokedex;
    }
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.pokedex = new ListaPokedex(); // Inicializa una nueva ListaPokedex vacía para el jugador
    }

    public String getNombre() {
        return nombre;
    }

    public ListaPokedex getPokedex() {
        return pokedex;
    }

    public void elegirPokemon(Pokemon pokemon) {
        pokedex.insertar(pokemon);
        System.out.println("Se ha elegido a " + pokemon.getNombre() + " para la Pokédex.");
    }

    public Pokemon obtenerPokemonPorId(int id) {
        NodoPokedex nodo = pokedex.buscarPorId(id);
        if (nodo != null) {
            return nodo.getDatoPokemon();
        }
        return null; // Si no se encuentra el Pokémon con ese id
    }
    public String mostrarPokedex() {
        return pokedex.toString(); // Llama al método toString de ListaPokedex
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", pokedex=" + pokedex +
                '}';
    }
}



