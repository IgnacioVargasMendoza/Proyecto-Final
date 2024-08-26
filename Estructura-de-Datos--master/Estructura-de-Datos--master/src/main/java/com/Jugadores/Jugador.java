package com.Jugadores;

import Pokedex.ListaPokedex;
import Pokemon.Pokemon;

public class Jugador {

    private String nombre;
    private ListaPokedex pokedex;
    private int Id;
    
     public Jugador(String nombre, int id) {
        this.nombre = nombre;
        this.pokedex = new ListaPokedex();
        this.Id = id;

    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public Jugador() {
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPokedex(ListaPokedex pokedex) {
        this.pokedex = pokedex;
    }

   

    public String getNombre() {
        return nombre;
    }

    public ListaPokedex getPokedex() {
        return pokedex;
    }

    public void elegirPokemon(Pokemon pokemon) {
        pokedex.insertar(pokemon);

    }

    public String mostrarPokedex() {
        return pokedex.toString();
    }

    @Override
    public String toString() {
        return "Jugador{"
                + "nombre='" + nombre + '\''
                + ", pokedex=" + pokedex
                + '}';
    }
}
