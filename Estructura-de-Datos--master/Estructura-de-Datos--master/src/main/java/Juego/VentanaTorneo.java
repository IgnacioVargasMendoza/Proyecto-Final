package Juego;

import javax.swing.*;
import java.awt.*;
import com.Jugadores.Jugador;
import Pokedex.ArbolTorneo;
import Torneo.NodoArbol;

public class VentanaTorneo extends JFrame {
    private ArbolTorneo arbolTorneo;
    private JPanel panelTorneo;

    public VentanaTorneo(Jugador jugadorPrincipal) {
        arbolTorneo = new ArbolTorneo();
        inicializarArbol(jugadorPrincipal);

        // Configuración de la ventana
        configurarVentana();

        // Crear y agregar componentes
        crearComponentes();
    }

    private void configurarVentana() {
        setTitle("Torneo Pokémon");
        setSize(1200, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }

    private void inicializarArbol(Jugador jugadorPrincipal) {
        arbolTorneo.inserta(jugadorPrincipal);

        // Crear y añadir jugadores CPU con nombres de maestros Pokémon
        insertarJugador(new Jugador("Brock"));
        insertarJugador(new Jugador("Misty"));
        insertarJugador(new Jugador("Erika"));
        insertarJugador(new Jugador("Koga"));
        insertarJugador(new Jugador("Sabrina"));
        insertarJugador(new Jugador("Blaine"));
        insertarJugador(new Jugador("Giovanni"));
    }

    private void insertarJugador(Jugador jugador) {
        arbolTorneo.inserta(jugador);
    }

    private void crearComponentes() {
        panelTorneo = new JPanel();
        panelTorneo.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Espaciado entre los componentes
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Crear paneles para cada ronda
        JPanel panelCuartos = new JPanel();
        JPanel panelSemis = new JPanel();
        JPanel panelFinal = new JPanel();
        JPanel panelCampeon = new JPanel();

        panelCuartos.setLayout(new GridLayout(1, 8, 10, 10)); // 1 fila y 8 columnas
        panelSemis.setLayout(new GridLayout(1, 4, 10, 10)); // 1 fila y 4 columnas
        panelFinal.setLayout(new GridLayout(1, 2, 10, 10)); // 1 fila y 2 columnas
        panelCampeon.setLayout(new GridLayout(1, 1, 10, 10)); // 1 fila y 1 columna para el campeón

        // Crear y agregar etiquetas para los cuartos de final
        agregarJugadoresPanel(panelCuartos);

        // Crear y agregar etiquetas para semifinales
        crearEtiquetas(panelSemis, 4, "Ganador Cuartos");

        // Crear y agregar etiquetas para la final
        JLabel finalista1 = new JLabel("Ganador Semifinal 1", SwingConstants.CENTER);
        JLabel finalista2 = new JLabel("Ganador Semifinal 2", SwingConstants.CENTER);
        finalista1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        finalista2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        panelFinal.add(finalista1);
        panelFinal.add(finalista2);

        // Crear y agregar etiqueta para el campeón
        JLabel campeon = new JLabel("Campeón", SwingConstants.CENTER);
        campeon.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        campeon.setPreferredSize(new Dimension(200, 30)); // Ajusta el tamaño
        panelCampeon.add(campeon);

        // Añadir paneles de ronda al panel principal
        gbc.gridy = 3;
        gbc.gridx = 0;
        panelTorneo.add(panelCuartos, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        panelTorneo.add(panelSemis, gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        panelTorneo.add(panelFinal, gbc);

        gbc.gridy = 0;
        gbc.gridx = 0;
        panelTorneo.add(panelCampeon, gbc);

        // Añadir el panel de torneo a la ventana
        JScrollPane scrollPane = new JScrollPane(panelTorneo);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void agregarJugadoresPanel(JPanel panel) {
        // Recorrer el árbol en orden y agregar etiquetas a los paneles
        inOrdenYAgregarEtiquetas(panel, arbolTorneo.getRaiz());
    }

    private void inOrdenYAgregarEtiquetas(JPanel panel, NodoArbol nodo) {
        if (nodo != null) {
            inOrdenYAgregarEtiquetas(panel, nodo.getIzq());

            JLabel etiqueta = new JLabel(nodo.getJugador().getNombre(), SwingConstants.CENTER);
            etiqueta.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            etiqueta.setPreferredSize(new Dimension(100, 30)); // Ajusta el tamaño
            panel.add(etiqueta);

            inOrdenYAgregarEtiquetas(panel, nodo.getDer());
        }
    }

    private void crearEtiquetas(JPanel panel, int cantidad, String textoBase) {
        // Crear y agregar etiquetas con texto personalizado
        for (int i = 0; i < cantidad; i++) {
            JLabel etiqueta = new JLabel(textoBase + " " + (i + 1), SwingConstants.CENTER);
            etiqueta.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            etiqueta.setPreferredSize(new Dimension(100, 30)); // Ajusta el tamaño
            panel.add(etiqueta);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Jugador jugadorPrincipal = new Jugador("Jugador 1");
            new VentanaTorneo(jugadorPrincipal).setVisible(true);
        });
    }
}
