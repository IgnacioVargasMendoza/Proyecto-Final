package Juego;

import Pokedex.ListaPokedex;
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
                dispose(); // Cierra la ventana sin guardar cambios
            }
        });
    }

    private void guardarCambios() {
        // Validar y guardar cambios
        String nombre = txtNombreJugador.getText().trim();
        if (!nombre.isEmpty()) {
            jugador = new Jugador(nombre);
            // Abre la ventana principal con el jugador creado
            /*VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(jugador, jugador.mostrarPokedex());*/
            /*ventanaPrincipal.setVisible(true);*/
            //dispose(); // Cierra la ventana de configuración después de guardar
        } else {
            JOptionPane.showMessageDialog(this, "El nombre no puede estar vacío.");
        }
    }
}
