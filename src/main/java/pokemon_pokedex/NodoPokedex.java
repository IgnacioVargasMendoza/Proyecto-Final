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
public class NodoPokedex {
    
    private Pokemon pokemon;
    private NodoPokedex next;
    private NodoPokedex back;
    
    public NodoPokedex(Pokemon pokemon){
        this.pokemon = pokemon;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public NodoPokedex getNext() {
        return next;
    }

    public void setNext(NodoPokedex next) {
        this.next = next;
    }

    public NodoPokedex getBack() {
        return back;
    }

    public void setBack(NodoPokedex back) {
        this.back = back;
    }
    
    


}
