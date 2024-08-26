/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jugador_dato;

import pokemon_dato.Pokemon;
import pokemon_pokedex.ListaDCPokedex;

/**
 *
 * @author Ignac
 */
public class Jugador {
    
    private String nombreJugador;
    private ListaDCPokedex pokedex;
    private int id;
        
    public Jugador(String nombre, int id){
        this.nombreJugador = nombre;
        this.id =id;
        this.pokedex = new ListaDCPokedex();
    }
    

    public void llenarLista(Pokemon pokemon){
        pokedex.inserta(pokemon);
    }
    
    
    
    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public int getId() {
        return id;
    }
    
    public ListaDCPokedex getPokedex() {
        return pokedex;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
