/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pokemon;

import Pokedex.ListaPokemon;

/**
 *
 * @author Edwin Pardo
 */
public class InicializadorPokemon {

    public static ListaPokemon crearListaPokemon() {
        ListaPokemon listaPokemon = new ListaPokemon();

        // Crear 3 Pokémon de tipo Agua
        listaPokemon.insertar(new Agua("Squirtle"));
        listaPokemon.insertar(new Agua("Totodile"));
        listaPokemon.insertar(new Agua("Mudkip"));

        // Crear 3 Pokémon de tipo Fuego
        listaPokemon.insertar(new Fuego("Charmander"));
        listaPokemon.insertar(new Fuego("Vulpix"));
        listaPokemon.insertar(new Fuego("Growlithe"));

        // Crear 3 Pokémon de tipo Normal
        listaPokemon.insertar(new Normal("Pidgey"));
        listaPokemon.insertar(new Normal("Rattata"));
        listaPokemon.insertar(new Normal("Meowth"));

        return listaPokemon;
    }
}
