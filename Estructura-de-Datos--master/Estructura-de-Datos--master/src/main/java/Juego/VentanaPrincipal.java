package Juego;

import javax.swing.*;
import java.awt.*;
import Pokedex.NodoPokemon;
import Pokedex.ListaPokedex;
import Pokedex.ListaPokemon;
import Pokemon.Pokemon;
import com.Jugadores.Jugador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {
    private Jugador jugador;
    private ListaPokemon listaPokemon;

    public VentanaPrincipal(Jugador jugador, ListaPokemon listaPokemon) {
        this.jugador = jugador;
        this.listaPokemon = listaPokemon;

        // Configuración de la ventana
        configurarVentana();

        // Crear y agregar componentes
        crearComponentes();
    }

    private void configurarVentana() {
        setTitle("Ventana Principal");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }

    private void crearComponentes() {
        // Mostrar nombre del jugador
        JLabel lblNombreJugador = new JLabel("Jugador: " + jugador.getNombre(), SwingConstants.CENTER);
        lblNombreJugador.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblNombreJugador, BorderLayout.NORTH);

        JButton btnPokedex = new JButton("Ver Pokédex");
        JButton btnTorneo = new JButton("Iniciar Torneo");

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnPokedex);
        panelBotones.add(btnTorneo);

        add(panelBotones, BorderLayout.CENTER);

        btnPokedex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVentanaPokedex();
            }
        });

        btnTorneo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarTorneo();
            }
        });
    }

    private void abrirVentanaPokedex() {
        VentanaPokedex ventanaPokedex = new VentanaPokedex(this.jugador, this.listaPokemon);
        ventanaPokedex.setVisible(true);
    }

    private void iniciarTorneo() {
        Jugador cpu = new Jugador("CPU");
        ListaPokedex pokedexCPU = crearPokedexCPU();
        cpu.setPokedex(pokedexCPU);

        VentanaTorneo ventanaTorneo = new VentanaTorneo(jugador, cpu);
        ventanaTorneo.setVisible(true);
    }

    private ListaPokedex crearPokedexCPU() {
        ListaPokedex pokedexCPU = new ListaPokedex();
        NodoPokemon actual = listaPokemon.getCabeza();

        while (actual != null && pokedexCPU.contarPokemon() < 4) {
            Pokemon pokemon = actual.getPokemon();
            if (!pokedexCPU.existeEnPokedex(pokemon.getId())) {  // Corregido para pasar el ID
                pokedexCPU.insertar(pokemon);
            }
            actual = actual.getNext();
        }

        return pokedexCPU;
    }
}
