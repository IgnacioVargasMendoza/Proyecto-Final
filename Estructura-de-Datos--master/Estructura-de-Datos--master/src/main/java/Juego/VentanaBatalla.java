/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.Jugadores.Jugador;
import Pokemon.Pokemon;

public class VentanaBatalla extends JFrame {
    private Jugador jugador1;
    private Jugador jugador2;
    private Pokemon pokemonActivo1;
    private Pokemon pokemonActivo2;

    private JLabel lblPokemonJugador1;
    private JLabel lblPokemonJugador2;
    private JTextArea txaLog;
    private JButton btnAtacar;
    private JButton btnCambiarPokemon;

    public VentanaBatalla(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;

        // Configuración de la ventana
        configurarVentana();

        // Inicializar Pokémon activos
        pokemonActivo1 = jugador1.getPokedex().getCabeza().getDatoPokemon(); // Asume que el primer Pokémon es el activo
        pokemonActivo2 = jugador2.getPokedex().getCabeza().getDatoPokemon(); // Asume que el primer Pokémon es el activo

        // Crear y agregar componentes
        crearComponentes();
    }

    private void configurarVentana() {
        setTitle("Batalla Pokémon");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }

    private void crearComponentes() {
        // Panel de información de Pokémon
        JPanel panelInfo = new JPanel(new GridLayout(2, 1));
        lblPokemonJugador1 = new JLabel("Pokémon del Jugador 1: " + pokemonActivo1.toString(), SwingConstants.CENTER);
        lblPokemonJugador2 = new JLabel("Pokémon del Jugador 2: " + pokemonActivo2.toString(), SwingConstants.CENTER);
        panelInfo.add(lblPokemonJugador1);
        panelInfo.add(lblPokemonJugador2);
        add(panelInfo, BorderLayout.NORTH);

        // Área de registro de la batalla
        txaLog = new JTextArea(10, 30);
        txaLog.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txaLog);
        add(scrollPane, BorderLayout.CENTER);

        // Panel de botones
        JPanel panelBotones = new JPanel();
        btnAtacar = new JButton("Atacar");
        btnCambiarPokemon = new JButton("Cambiar Pokémon");

        panelBotones.add(btnAtacar);
        panelBotones.add(btnCambiarPokemon);

        add(panelBotones, BorderLayout.SOUTH);

        // Agregar listeners a los botones
        btnAtacar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atacar();
            }
        });

        btnCambiarPokemon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarPokemon();
            }
        });
    }

    private void atacar() {
        // Lógica para el ataque
        // Aquí puedes implementar la lógica de ataque, considerando las características del Pokémon
        // y actualizando el área de registro (txaLog) con el resultado

        // Ejemplo simple de ataque
        txaLog.append("El Pokémon " + pokemonActivo1.getNombre() + " ataca a " + pokemonActivo2.getNombre() + "!\n");

        // Actualizar la vida del Pokémon enemigo, verificar si ha sido derrotado, etc.
        // Actualizar la interfaz y manejar el cambio de turnos
    }

    private void cambiarPokemon() {
        // Lógica para cambiar el Pokémon activo
        // Mostrar un diálogo para seleccionar un nuevo Pokémon del jugador activo
        Pokemon nuevoPokemon = seleccionarNuevoPokemon();
        if (nuevoPokemon != null) {
            pokemonActivo1 = nuevoPokemon;
            lblPokemonJugador1.setText("Pokémon del Jugador 1: " + pokemonActivo1.toString());
            txaLog.append("El jugador 1 ha cambiado a " + pokemonActivo1.getNombre() + ".\n");
        }
    }

    private Pokemon seleccionarNuevoPokemon() {
        // Mostrar un diálogo para seleccionar un nuevo Pokémon
        // Aquí se asume que el jugador puede cambiar al Pokémon activo
        // Puedes implementar una ventana de selección o simplemente elegir de la lista actual

        return jugador1.getPokedex().getCabeza().getDatoPokemon(); // Ejemplo para seleccionar el primer Pokémon
    }
}
