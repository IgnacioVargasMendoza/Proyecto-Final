package Pokedex;

import Pokemon.Pokemon;

public class NodoPokemon {

    private Pokemon pokemon;
    private NodoPokemon next;

    public NodoPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
        this.next = null;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public NodoPokemon getNext() {
        return next;
    }

    public void setNext(NodoPokemon next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return pokemon.toString();
    }
}
