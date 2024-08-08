package Pokedex;

import Pokemon.Pokemon;

public class NodoPokemon {
    private Pokemon pokemon;
    private NodoPokemon siguiente;
    private NodoPokemon anterior;

    public NodoPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
        this.siguiente = null;
        this.anterior = null;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public NodoPokemon getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPokemon siguiente) {
        this.siguiente = siguiente;
    }

    public NodoPokemon getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoPokemon anterior) {
        this.anterior = anterior;
    }


    }
