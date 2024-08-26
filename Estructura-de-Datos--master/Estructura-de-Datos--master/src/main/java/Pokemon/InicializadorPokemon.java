
package Pokemon;

import Pokedex.ListaPokemon;


public class InicializadorPokemon {

    public static ListaPokemon crearListaPokemon() {
        ListaPokemon listaPokemon = new ListaPokemon();


        listaPokemon.insertar(new Agua("Squirtle"));
        listaPokemon.insertar(new Agua("Totodile"));
        listaPokemon.insertar(new Agua("Mudkip"));

    
        listaPokemon.insertar(new Fuego("Charmander"));
        listaPokemon.insertar(new Fuego("Vulpix"));
        listaPokemon.insertar(new Fuego("Growlithe"));

  
        listaPokemon.insertar(new Normal("Pidgey"));
        listaPokemon.insertar(new Normal("Rattata"));
        listaPokemon.insertar(new Normal("Meowth"));

        return listaPokemon;
    }
}
