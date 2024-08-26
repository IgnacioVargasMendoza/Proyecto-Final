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
public class NodoPokemon {
    
    private Pokemon pokemon;
    private NodoPokemon next;
    
    public NodoPokemon(Pokemon pokemon){
        this.pokemon = pokemon;
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
    
    
    
}
