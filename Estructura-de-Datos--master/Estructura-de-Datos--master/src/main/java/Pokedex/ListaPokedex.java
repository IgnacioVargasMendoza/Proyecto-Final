package Pokedex;

import Pokemon.Pokemon;

public class ListaPokedex {

    private NodoPokedex cabeza;
    private NodoPokedex ultimo;
    private NodoPokedex princial;

    public ListaPokedex() {
        cabeza = null;
        ultimo = null;
    }

    public void insertar(Pokemon pokemon) {
        NodoPokedex nuevo = new NodoPokedex(pokemon);

        if (cabeza == null) { // Si la lista está vacía
            cabeza = nuevo;
            ultimo = nuevo;
            ultimo.setSiguiente(cabeza); // Hacemos que el último apunte al primero en una lista circular
        } else if (pokemon.getId() < cabeza.getDatoPokemon().getId()) { // Si el nuevo Pokémon va antes de la cabeza
            nuevo.setSiguiente(cabeza);
            cabeza = nuevo;
            ultimo.setSiguiente(cabeza); // Actualizamos el último para mantener la circularidad
        } else if (pokemon.getId() >= ultimo.getDatoPokemon().getId()) { // Si el nuevo Pokémon va después del último
            nuevo.setSiguiente(cabeza);
            ultimo.setSiguiente(nuevo);
            ultimo = nuevo;
        } else { // Caso general, insertar en medio de la lista
            NodoPokedex aux = cabeza;
            while (pokemon.getId() > aux.getSiguiente().getDatoPokemon().getId()) {
                aux = aux.getSiguiente();
            }
            nuevo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevo);
        }
    }

    public NodoPokedex getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoPokedex cabeza) {
        this.cabeza = cabeza;
    }

    public NodoPokedex getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoPokedex ultimo) {
        this.ultimo = ultimo;
    }

    public NodoPokedex getPrincial() {
        return princial;
    }

    public void setPrincial(NodoPokedex princial) {
        this.princial = princial;
    }

    public NodoPokedex buscarPorId(int id) {
        NodoPokedex actual = cabeza;
        do {
            if (actual.getDatoPokemon().getId() == id) {
                return actual;
            }
            actual = actual.getSiguiente();
        } while (actual != cabeza);
        return null; // Si no se encuentra el Pokémon con ese id
    }

    @Override
    public String toString() {
        NodoPokedex aux = cabeza;
        StringBuilder sb = new StringBuilder("Pokédex del jugador:\n");
        if (aux != null) {
            sb.append(aux.getDatoPokemon()).append("\n");
            aux = aux.getSiguiente();

            while (aux != cabeza) {
                sb.append(aux.getDatoPokemon()).append("\n");
                aux = aux.getSiguiente();
            }
        } else {
            sb.append("Pokédex vacía.");
        }
        return sb.toString();
    }

}

/*@Override
    public String toString() {
        NodoPokedex aux = cabeza;
        String s = "Lista:";
        if (aux != null) {
            s += aux + ",";
            aux = aux.getSiguiente();

            while (aux != cabeza) {
                s += aux + ",";
                aux = aux.getSiguiente();
            }
        } else {
            s += "vacia";
        }
        return s;
    }*/
