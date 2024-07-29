package com.main;

import Pokedex.NodoPokedex;
import Pokemon.Pokemon;
import com.Jugadores.Jugador;

public class Main {
  public static void main(String[] args) {
    // Crear 9 Pokémon
   /* Pokemon pokemon1 = new Pokemon(1, "Poliwag", Pokemon.Tipo.AGUA);
    Pokemon pokemon2 = new Pokemon(2, "Psyduck", Pokemon.Tipo.AGUA);
    Pokemon pokemon3 = new Pokemon(3, "Squirtle", Pokemon.Tipo.AGUA);
    Pokemon pokemon4 = new Pokemon(4, "Growlithe", Pokemon.Tipo.FUEGO);
    Pokemon pokemon5 = new Pokemon(5, "Vulpix", Pokemon.Tipo.FUEGO);
    Pokemon pokemon6 = new Pokemon(6, "Charmander", Pokemon.Tipo.FUEGO);
    Pokemon pokemon7 = new Pokemon(7, "Rattata", Pokemon.Tipo.NORMAL);
    Pokemon pokemon8 = new Pokemon(8, "Pidgey", Pokemon.Tipo.NORMAL);
    Pokemon pokemon9 = new Pokemon(9, "Snorlax", Pokemon.Tipo.NORMAL);*/

    // Crear jugadores
    Jugador jugador1 = new Jugador("Ash");
    Jugador jugador2 = new Jugador("Gary");

    // Asignar 3 Pokémon a la Pokédex del jugador 1
    /*jugador1.elegirPokemon(pokemon1);
    jugador1.elegirPokemon(pokemon2);
    jugador1.elegirPokemon(pokemon3);

    // Asignar 3 Pokémon a la Pokédex del jugador 2
    jugador2.elegirPokemon(pokemon4);
    jugador2.elegirPokemon(pokemon5);
    jugador2.elegirPokemon(pokemon6);*/

    // Mostrar la Pokédex de ambos jugadores
    System.out.println("Pokédex del jugador " + jugador1.getNombre() + ":");
    System.out.println(jugador1.mostrarPokedex());
    System.out.println();

    System.out.println("Pokédex del jugador " + jugador2.getNombre() + ":");
    System.out.println(jugador2.mostrarPokedex());
    System.out.println();

    // Obtener Pokémon por id para jugador 1
int idPokemonJugador1 = 2; // Ejemplo de id
Pokemon pokemonJugador1 = jugador1.obtenerPokemonPorId(idPokemonJugador1);

// Obtener Pokémon por id para jugador 2
int idPokemonJugador2 = 5; // Ejemplo de id
Pokemon pokemonJugador2 = jugador2.obtenerPokemonPorId(idPokemonJugador2);

    System.out.println("¡Batalla Pokémon!");
    System.out.println(jugador1.getNombre() + " envía a " + pokemonJugador1.getNombre());
    System.out.println(jugador2.getNombre() + " envía a " + pokemonJugador2.getNombre());
    System.out.println();

    // Simular la batalla
    pokemonJugador1.atacar(pokemonJugador2);
    pokemonJugador2.atacar(pokemonJugador1);
}


}

