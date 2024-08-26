/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package juego_main;

import juego_ui.VentanaElegirPokedex;
import jugador_dato.Jugador;
import pokemon_dato.Agua;
import pokemon_dato.Fuego;
import pokemon_dato.Normal;
import pokemon_dato.Pokemon;
import pokemon_pokedex.ListaDCPokedex;
import pokemon_pokedex.ListaCircularPokemon;

import pokemon_pokedex.NodoPokedex;
import pokemon_pokedex.NodoPokemon;
import pokemon_torneo.ArbolTorneo;

/**
 *
 * @author Ignac
 */
public class Main {// Inicio Clase Main

    public static void main(String[] args) {//Inicio Main

        /**
         * *Prueba Creacion de objeto Pokemon
         *
         * Agua agua = new Agua("Agua"); Fuego fuego = new Fuego("Fuego");
         * Normal normal = new Normal("Normal ");
         *
         * System.out.printf("Nuevo Pokemon creado\n Nombre: %s\n ID: %s\n",
         * agua.getNombre(),agua.getId()); System.out.printf("Nuevo Pokemon
         * creado\n Nombre: %s\n ID: %s\n", fuego.getNombre(),fuego.getId());
         * System.out.printf("Nuevo Pokemon creado\n Nombre: %s\n ID: %s\n",
         * normal.getNombre(),normal.getId()); *
         */
       // Agua agua = new Agua("Agua");
       // Fuego fuego = new Fuego("Fuego");
        //Normal normal = new Normal("Normal");
        /*
        ListaSimplePokemon listaPokemon = new ListaSimplePokemon();
        try {
            listaPokemon.inserta(agua);
            listaPokemon.inserta(fuego);
            listaPokemon.inserta(normal);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(listaPokemon.toString());*/

 /* 
        ListaDCPokedex listaPokedex = new ListaDCPokedex();
        try{
        listaPokedex.inserta(normal);
        listaPokedex.inserta(agua);
        listaPokedex.inserta(fuego);}catch(Exception e){
            e.getMessage();

        System.out.println("Lista Pokedex:\n" + listaPokedex.toString());
        }*/
        //Jugador cpuCampeon = new Jugador("Maestro Pokemon Absoluto", 10);
        //Jugador cpu1 = new Jugador("Maestro Pokemon", 6);
        //Jugador cpu2 = new Jugador("Maestro Pokemon", 12);
        //Jugador cpu3 = new Jugador("Maestro Pokemon", 8);
        //Jugador cpu4 = new Jugador("Maestro Pokemon", 5);
        //Jugador cpu5 = new Jugador("Maestro Pokemon", 11);
        //Jugador cpu6 = new Jugador("Maestro Pokemon", 13);
        //cpu1.setPokedex();
        //Metodo para llenar pokedex del jugador
        /* Prueba clase arbol
        * Se crea un nuevo arbol y se insertan los jugadores al arbol.
        * y se imprime el arbol de izquierda a derecha y se muestra la raiz en medio de las 2 ramas.
         */
 /* -------
        ArbolTorneo torneo = new ArbolTorneo();
        torneo.inserta(cpuCampeon);
        torneo.inserta(cpu1);
        torneo.inserta(cpu2);
        torneo.inserta(cpu3);
        torneo.inserta(cpu4);
        torneo.inserta(cpu5);
        torneo.inserta(cpu6);
        torneo.inOrden();------*/
 /*cpu1.llenarLista(normal);
        cpu1.llenarLista(agua);
        cpu1.llenarLista(fuego);
               
        System.out.printf("Lista: %s\n%s", cpu1.getNombreJugador(), cpu1.getPokedex());*/
 /*Prueba movimiento ataque y defensa de Pokemones*/
 /*
        agua.ataqueEspecial(fuego, false);
        System.out.println("");
        agua.atacar(fuego, true);
        System.out.println("");
        fuego.atacar(agua, true);
        System.out.println("");
        fuego.ataqueEspecial(agua, !agua.defensaEspecial());*/
        Jugador nacho = new Jugador("Nacho", 1);
        
    
            new VentanaElegirPokedex(nacho);
  
       
        
         


        //manejoListaPokemon.agregarPokemon(prueba);
        //System.out.println(prueba.getPokedex().toString());
    }//Fin metodo Main

}// Fin Clase Main
