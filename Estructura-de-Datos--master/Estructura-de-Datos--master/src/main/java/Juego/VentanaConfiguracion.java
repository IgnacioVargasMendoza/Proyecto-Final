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
        // Configuración de la ventana
        setTitle("Configuración del Juego");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2));

        // Inicialización de componentes
        inicializarComponentes();

        // Configuración de acciones
        configurarAcciones();
    }

    private void inicializarComponentes() {
        // Etiquetas y campos de texto
        JLabel lblNombreJugador = new JLabel("Nombre del Jugador:");
        txtNombreJugador = new JTextField();

        btnGuardar = new JButton("Guardar");
        btnCancelar = new JButton("Cancelar");

        // Añadir componentes al panel
        add(lblNombreJugador);
        add(txtNombreJugador);
        add(btnGuardar);
        add(btnCancelar);
    }

    private void configurarAcciones() {
        // Acción para guardar cambios
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarCambios();
            }
        });

        // Acción para cancelar y cerrar la ventana
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarVentana();
            }
        });
    }

    private void guardarCambios() {
        // Validar y guardar cambios
        String nombre = txtNombreJugador.getText().trim();
        if (!nombre.isEmpty()) {
            // Crear nuevo Jugador con el nombre ingresado
            Jugador jugador = new Jugador(nombre,15);

            // Inicializar ListaPokemon usando el método de InicializadorPokemon
            ListaPokemon listaPokemon = InicializadorPokemon.crearListaPokemon();

            // Crear y mostrar la VentanaPrincipal con el Jugador y la ListaPokemon
            VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(jugador, listaPokemon);
            ventanaPrincipal.setVisible(true);

            // Cerrar la ventana de configuración actual
            dispose();
        } else {
            // Mostrar mensaje de error si el nombre está vacío
            JOptionPane.showMessageDialog(this, "El nombre no puede estar vacío.");
        }
    }

    private void cerrarVentana() {
        dispose(); // Cierra la ventana sin guardar cambios
    }
}
