package Juego;

import Pokedex.ListaPokemon;
import Pokemon.InicializadorPokemon;
import com.Jugadores.Jugador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaConfiguracion extends JFrame {

    private JTextField txtNombreJugador;
    private JButton btnGuardar;
    private JButton btnCancelar;

    private Jugador jugador;

    public VentanaConfiguracion() {

        setTitle("Configuración del Juego");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2));

        inicializarComponentes();

        configurarAcciones();
    }

    private void inicializarComponentes() {

        JLabel lblNombreJugador = new JLabel("Nombre del Jugador:");
        txtNombreJugador = new JTextField();

        btnGuardar = new JButton("Guardar");
        btnCancelar = new JButton("Cancelar");

        add(lblNombreJugador);
        add(txtNombreJugador);
        add(btnGuardar);
        add(btnCancelar);
    }

    private void configurarAcciones() {

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarCambios();
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarVentana();
            }
        });
    }

    private void guardarCambios() {

        String nombre = txtNombreJugador.getText().trim();
        if (!nombre.isEmpty()) {

            Jugador jugador = new Jugador(nombre, 15);

            ListaPokemon listaPokemon = InicializadorPokemon.crearListaPokemon();

            VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(jugador, listaPokemon);
            ventanaPrincipal.setVisible(true);

            dispose();
        } else {

            JOptionPane.showMessageDialog(this, "El nombre no puede estar vacío.");
        }
    }

    private void cerrarVentana() {
        dispose();
    }
}