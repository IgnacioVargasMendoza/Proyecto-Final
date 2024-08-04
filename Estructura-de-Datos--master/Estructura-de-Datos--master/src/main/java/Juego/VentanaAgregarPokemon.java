package Juego;

import Pokedex.ListaPokedex;
import Pokedex.ListaPokemon;
import Pokedex.NodoPokemon;
import Pokedex.Pokemon;
import com.Jugadores.Jugador;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaAgregarPokemon extends JFrame {
    private ListaPokemon listaPokemon;
    private ListaPokedex pokedex;
    private Jugador jugador;

    public VentanaAgregarPokemon(ListaPokemon listaPokemon, Jugador jugador) {
        this.listaPokemon = listaPokemon;
        this.jugador = jugador;
        this.pokedex = jugador.getPokedex();

        setTitle("Agregar Pokémon a la Pokédex");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panelPokemon = new JPanel();
        panelPokemon.setLayout(new GridLayout(0, 2)); // Filas dinámicas, 2 columnas

        NodoPokemon actual = listaPokemon.getCabeza();
        if (actual != null) {
            do {
                Pokemon pokemon = actual.getPokemon();
                JPanel panelIndividual = new JPanel(new BorderLayout());
                JLabel etiquetaPokemon = new JLabel(pokemon.getNombre());
                JButton botonAgregar = new JButton("Agregar");

                botonAgregar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        pokedex.agregarPokemon(pokemon);
                        JOptionPane.showMessageDialog(null, pokemon.getNombre() + " ha sido agregado a la Pokédex.");
                    }
                });

                panelIndividual.add(etiquetaPokemon, BorderLayout.CENTER);
                panelIndividual.add(botonAgregar, BorderLayout.SOUTH);
                panelPokemon.add(panelIndividual);

                actual = actual.getNext();
            } while (actual != listaPokemon.getCabeza());
        }

        JScrollPane scrollPane = new JScrollPane(panelPokemon);
        add(scrollPane, BorderLayout.CENTER);
    }
}
