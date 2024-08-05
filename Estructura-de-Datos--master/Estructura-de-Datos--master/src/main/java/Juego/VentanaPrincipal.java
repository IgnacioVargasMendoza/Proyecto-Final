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

        setTitle("Ventana Principal");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JButton btnPokedex = new JButton("Ver Pokédex");
        JButton btnBatalla = new JButton("Iniciar Batalla");

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnPokedex);
        panelBotones.add(btnBatalla);

        add(panelBotones, BorderLayout.SOUTH);

        btnPokedex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaPokedex(jugador.getPokedex()).setVisible(true);
            }
        });

        btnBatalla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Jugador cpu = new Jugador("CPU", crearPokedexCPU());
                new VentanaBatalla(jugador, cpu).setVisible(true);
            }
        });
    }

    private ListaPokedex crearPokedexCPU() {
        ListaPokedex pokedexCPU = new ListaPokedex();
        ListaPokedex listaPokemon = this.listaPokemon.obtenerListaPokemon();
        NodoPokemon actual = listaPokemon.getCabeza();
        if (actual != null) {
            int count = 0;
            do {
                if (count >= 6) break; // Asignar solo 6 Pokémon para la CPU
                Pokemon pokemon = actual.getPokemon();
                pokedexCPU.agregarPokemon(pokemon);
                count++;
                actual = actual.getNext();
            } while (actual != listaPokemon.getCabeza());
        }
        return pokedexCPU;
    }
}
