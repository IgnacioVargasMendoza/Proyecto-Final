package Juego;

import Pokedex.ListaPokedex;
import Pokedex.NodoPokedex;
import Pokemon.Pokemon;
import com.Jugadores.Jugador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VentanaBatalla extends JFrame {
    private Jugador jugador1;
    private Jugador jugador2;
    private Pokemon pokemonActualJugador1;
    private Pokemon pokemonActualJugador2;
    private JTextArea resultArea;
    private JLabel vidaJugador1;
    private JLabel vidaJugador2;

    public VentanaBatalla(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.pokemonActualJugador1 = jugador1.getPokedex().getPrincial().getDatoPokemon(); // Selección inicial correcta
        this.pokemonActualJugador2 = jugador2.getPokedex().getPrincial().getDatoPokemon(); // Selección inicial correcta

        setTitle("Batalla Pokémon");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(2, 2));

        JButton atacarButton = new JButton("Atacar");
        JButton cambiarPokemonButton1 = new JButton("Cambiar Pokémon Jugador 1");
        JButton cambiarPokemonButton2 = new JButton("Cambiar Pokémon Jugador 2");
        JButton finalizarBatallaButton = new JButton("Finalizar Batalla");

        vidaJugador1 = new JLabel("Vida Jugador 1: " + pokemonActualJugador1.getVida());
        vidaJugador2 = new JLabel("Vida Jugador 2: " + pokemonActualJugador2.getVida());

        JPanel panelVida = new JPanel();
        panelVida.setLayout(new GridLayout(2, 1));
        panelVida.add(vidaJugador1);
        panelVida.add(vidaJugador2);

        panelBotones.add(atacarButton);
        panelBotones.add(cambiarPokemonButton1);
        panelBotones.add(cambiarPokemonButton2);
        panelBotones.add(finalizarBatallaButton);

        add(scrollPane, BorderLayout.CENTER);
        add(panelVida, BorderLayout.NORTH);
        add(panelBotones, BorderLayout.SOUTH);

        atacarButton.addActionListener(e -> atacar());

        cambiarPokemonButton1.addActionListener(e -> cambiarPokemon(jugador1));
        cambiarPokemonButton2.addActionListener(e -> cambiarPokemon(jugador2));

        finalizarBatallaButton.addActionListener(e -> dispose());
    }

    private void atacar() {
        // Lógica de ataque
        int dañoJugador1 = calcularDaño(pokemonActualJugador1);
        int dañoJugador2 = calcularDaño(pokemonActualJugador2);

        pokemonActualJugador2.setVida(pokemonActualJugador2.getVida() - dañoJugador1);
        pokemonActualJugador1.setVida(pokemonActualJugador1.getVida() - dañoJugador2);

        resultArea.append(pokemonActualJugador1.getNombre() + " hizo " + dañoJugador1 + " de daño a " + pokemonActualJugador2.getNombre() + "\n");
        resultArea.append(pokemonActualJugador2.getNombre() + " hizo " + dañoJugador2 + " de daño a " + pokemonActualJugador1.getNombre() + "\n");

        vidaJugador1.setText("Vida Jugador 1: " + pokemonActualJugador1.getVida());
        vidaJugador2.setText("Vida Jugador 2: " + pokemonActualJugador2.getVida());

        if (pokemonActualJugador1.getVida() <= 0) {
            resultArea.append(pokemonActualJugador1.getNombre() + " ha sido derrotado!\n");
            cambiarPokemon(jugador1);
        }
        if (pokemonActualJugador2.getVida() <= 0) {
            resultArea.append(pokemonActualJugador2.getNombre() + " ha sido derrotado!\n");
            cambiarPokemon(jugador2);
        }
    }

    private int calcularDaño(Pokemon pokemon) {
        // Lógica para calcular el daño de un ataque
        return (int) (Math.random() * 20); // Daño aleatorio entre 0 y 20
    }

    private void cambiarPokemon(Jugador jugador) {
        ListaPokedex pokedex = jugador.getPokedex();
        NodoPokedex nodoActual = pokedex.getCabeza();
        while (nodoActual != null) {
            Pokemon pokemon = nodoActual.getDatoPokemon();
            if (pokemon.getVida() > 0) {
                if (jugador == jugador1) {
                    pokemonActualJugador1 = pokemon;
                    vidaJugador1.setText("Vida Jugador 1: " + pokemonActualJugador1.getVida());
                    resultArea.append("Jugador 1 cambia a " + pokemonActualJugador1.getNombre() + "\n");
                } else {
                    pokemonActualJugador2 = pokemon;
                    vidaJugador2.setText("Vida Jugador 2: " + pokemonActualJugador2.getVida());
                    resultArea.append("Jugador 2 cambia a " + pokemonActualJugador2.getNombre() + "\n");
                }
                return;
            }
            nodoActual = nodoActual.getSiguiente();
            if (nodoActual == pokedex.getCabeza()) {
                break;  // Evitar bucles infinitos
            }
        }
        resultArea.append("No hay más Pokémon disponibles para cambiar.\n");
    }
}

