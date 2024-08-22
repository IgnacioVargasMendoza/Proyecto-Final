package Juego;

import javax.swing.*;
import java.awt.*;
import Pokedex.ListaPokemon;
import Pokedex.NodoPokemon;
import Pokemon.Pokemon;
import com.Jugadores.Jugador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPokedex extends JFrame {
    private final Jugador jugador;
    private final ListaPokemon listaPokemon;

    public VentanaPokedex(Jugador jugador, ListaPokemon listaPokemon) {
        this.jugador = jugador;
        this.listaPokemon = listaPokemon;

        setTitle("Ventana Pokédex");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelPokemons = new JPanel();
        panelPokemons.setLayout(new GridLayout(0, 1)); // Una columna para los botones

        // Mostrar todos los Pokémon disponibles
        NodoPokemon nodoActual = listaPokemon.getCabeza();
        if (nodoActual != null) {
            do {
                JButton btnAgregar = new JButton("Agregar " + nodoActual.getPokemon().getNombre());
                btnAgregar.addActionListener(new PokemonButtonListener(nodoActual.getPokemon()));
                panelPokemons.add(btnAgregar);
                nodoActual = nodoActual.getNext();
            } while (nodoActual != listaPokemon.getCabeza());
        }

        add(new JScrollPane(panelPokemons), BorderLayout.CENTER);

        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra la ventana actual
            }
        });
        add(btnVolver, BorderLayout.SOUTH);
    }

    // Clase interna para manejar eventos de botón
    private class PokemonButtonListener implements ActionListener {
        private final Pokemon pokemon;

        public PokemonButtonListener(Pokemon pokemon) {
            this.pokemon = pokemon;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (jugador.getPokedex().contarPokemon() < 4) {
                if (!jugador.getPokedex().existeEnPokedex(pokemon.getId())) {
                    jugador.getPokedex().insertar(pokemon);
                    JOptionPane.showMessageDialog(null, "Pokémon " + pokemon.getNombre() + " agregado a tu Pokédex.");
                } else {
                    JOptionPane.showMessageDialog(null, "Este Pokémon ya está en tu Pokédex.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Tu Pokédex ya tiene 4 Pokémon.");
            }
        }
    }
}
