package Juego;

import javax.swing.*;
import java.awt.*;
import Pokedex.ListaPokemon;
import Torneo.ArbolTorneo;
import com.Jugadores.Jugador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {

    private Jugador jugador;
    private ListaPokemon listaPokemon;
    private ArbolTorneo arbolTorneo;

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
        // Cargar y redimensionar imagen desde recursos
        ImageIcon imagenIcono = new ImageIcon(getClass().getResource("/Img/pokemon.jpeg"));
        Image imagen = imagenIcono.getImage(); // Convertir a Image
        Image imagenRedimensionada = imagen.getScaledInstance(600, 300, Image.SCALE_SMOOTH); // Redimensionar
        ImageIcon imagenRedimensionadaIcono = new ImageIcon(imagenRedimensionada); // Convertir de nuevo a ImageIcon

        JLabel lblImagen = new JLabel(imagenRedimensionadaIcono);
        add(lblImagen, BorderLayout.NORTH);

        // Mostrar nombre del jugador
        JLabel lblNombreJugador = new JLabel("Jugador: " + jugador.getNombre(), SwingConstants.CENTER);
        lblNombreJugador.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblNombreJugador, BorderLayout.CENTER);

        JButton btnPokedex = new JButton("Ver Pokédex");
        JButton btnTorneo = new JButton("Iniciar Torneo");

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnPokedex);
        panelBotones.add(btnTorneo);

        add(panelBotones, BorderLayout.SOUTH);

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
        VentanaPokedex ventanaPokedex = new VentanaPokedex(this.listaPokemon, this.jugador);
        ventanaPokedex.setVisible(true);
    }

    private void iniciarTorneo() {

        // Inicializar el árbol de torneo si aún no existe
        if (arbolTorneo == null) {
            arbolTorneo = new ArbolTorneo();
            arbolTorneo.construirArbolTorneo(jugador);
        }

        VentanaTorneo ventanaTorneo = new VentanaTorneo(jugador, arbolTorneo);
        ventanaTorneo.setVisible(true);
    }

}
