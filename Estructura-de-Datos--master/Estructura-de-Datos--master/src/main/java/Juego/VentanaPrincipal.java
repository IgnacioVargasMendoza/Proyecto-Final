package Juego;



import Pokedex.ListaPokedex;
import Pokedex.ListaPokemon;
import Pokedex.NodoPokemon;
import Pokemon.Pokemon;
import com.Jugadores.Jugador;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {
    private Jugador jugador;
    private ListaPokemon listaPokemon; // Lista de todos los Pokémon

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
        JButton btnPokedex = new JButton("Ver Pokédex");
        JButton btnBatalla = new JButton("Iniciar Batalla");

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnPokedex);
        panelBotones.add(btnBatalla);

        add(panelBotones, BorderLayout.SOUTH);

        btnPokedex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVentanaPokedex();
            }
        });

        btnBatalla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarBatalla();
            }
        });
    }

    private void abrirVentanaPokedex() {
        VentanaPokedex ventanaPokedex = new VentanaPokedex(this.jugador, this.listaPokemon);
        ventanaPokedex.setVisible(true);
    }

    private void iniciarBatalla() {
        Jugador cpu = new Jugador("CPU");
        VentanaBatalla ventanaBatalla = new VentanaBatalla(jugador, cpu);
        ventanaBatalla.setVisible(true);
    }

    private ListaPokedex crearPokedexCPU() {
        ListaPokedex pokedexCPU = new ListaPokedex();
        NodoPokemon actual = listaPokemon.getCabeza();

        for (int count = 0; actual != null && count < 6; count++) {
            Pokemon pokemon = actual.getPokemon();
            pokedexCPU.insertar(pokemon);
            actual = actual.getNext();
        }

        return pokedexCPU;
    }
}

