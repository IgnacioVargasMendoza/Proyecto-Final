package Juego;

import Pokedex.ListaPokedex;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.Jugadores.Jugador;

import Torneo.ArbolTorneo;
import Torneo.NodoArbol;

public class VentanaTorneo extends JFrame {

    private ArbolTorneo arbolTorneo;
    private JPanel panelTorneo;
    private Jugador jugadorPrincipal;
    private ListaPokedex pokedexJugador;
    private JPanel panelCuartos;
    private JPanel panelSemis;
    private JPanel panelFinal;
    private JPanel panelCampeon;

    public VentanaTorneo(Jugador jugadorPrincipal, ArbolTorneo arbolTorneoExistente) {
        this.jugadorPrincipal = jugadorPrincipal;
        this.arbolTorneo = arbolTorneoExistente != null ? arbolTorneoExistente : new ArbolTorneo();
        this.pokedexJugador = jugadorPrincipal.getPokedex();

        configurarVentana();

        crearComponentes();

    }

    private void configurarVentana() {
        setTitle("Torneo Pokémon");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }

    private void crearComponentes() {
        panelTorneo = new JPanel();
        panelTorneo.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        panelCuartos = new JPanel();
        panelSemis = new JPanel();
        panelFinal = new JPanel();
        panelCampeon = new JPanel();

        panelCuartos.setLayout(new GridLayout(1, 8, 10, 10));
        panelSemis.setLayout(new GridLayout(1, 4, 10, 10));
        panelFinal.setLayout(new GridLayout(1, 2, 10, 10));
        panelCampeon.setLayout(new GridLayout(1, 1, 10, 10));

        agregarJugadoresPanel(panelCuartos);

        crearEtiquetas(panelSemis, 4, "Ganador Cuartos");

        JLabel finalista1 = new JLabel("Ganador Semifinal 1", SwingConstants.CENTER);
        JLabel finalista2 = new JLabel("Ganador Semifinal 2", SwingConstants.CENTER);
        finalista1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        finalista2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        panelFinal.add(finalista1);
        panelFinal.add(finalista2);

        JLabel campeon = new JLabel("Campeón", SwingConstants.CENTER);
        campeon.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        campeon.setPreferredSize(new Dimension(200, 30)); // Ajusta el tamaño
        panelCampeon.add(campeon);

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

        // Botón para comenzar la batalla
        JButton btnComenzarBatalla = new JButton("Comenzar Batalla");
        btnComenzarBatalla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarBatalla();
            }
        });

        gbc.gridy = 4;
        gbc.gridx = 0;
        panelTorneo.add(btnComenzarBatalla, gbc);

        JScrollPane scrollPane = new JScrollPane(panelTorneo);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void agregarJugadoresPanel(JPanel panel) {

        panel.removeAll();

        agregarEtiquetasCuartos(panel, arbolTorneo.getRaiz());

        panel.revalidate();
        panel.repaint();
    }

    private void agregarEtiquetasCuartos(JPanel panel, NodoArbol nodo) {
        if (nodo == null) {
            return;
        }

        agregarEtiquetasCuartos(panel, nodo.getIzq());

        int id = nodo.getJugador().getId();
        if (id >= 8 && id <= 20) {
            JLabel etiqueta = new JLabel(nodo.getJugador().getNombre(), SwingConstants.CENTER);
            etiqueta.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            etiqueta.setPreferredSize(new Dimension(100, 30));
            panel.add(etiqueta);
        }

        agregarEtiquetasCuartos(panel, nodo.getDer());
    }

    public void actualizarPaneles() {
        System.out.println("Actualizando paneles..."); // Debug

        panelSemis.removeAll();
        panelFinal.removeAll();
        panelCampeon.removeAll();

        actualizarPanelSemis();
        actualizarPanelFinal();
        actualizarPanelCampeon();

        panelTorneo.revalidate();
        panelTorneo.repaint();
    }

    private void actualizarPanelSemis() {

        panelSemis.removeAll();

        agregarEtiquetasSemis(panelSemis, arbolTorneo.getRaiz());

        panelSemis.revalidate();
        panelSemis.repaint();
    }

    private void agregarEtiquetasSemis(JPanel panel, NodoArbol nodo) {
        if (nodo == null) {
            return;
        }

        agregarEtiquetasSemis(panel, nodo.getIzq());

        int id = nodo.getJugador().getId();
        if (id >= 4 && id <= 7) {
            JLabel etiqueta = new JLabel(nodo.getJugador().getNombre(), SwingConstants.CENTER);
            etiqueta.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            etiqueta.setPreferredSize(new Dimension(100, 30)); // Ajusta el tamaño
            panel.add(etiqueta);
        }

        agregarEtiquetasSemis(panel, nodo.getDer());
    }

    private void actualizarPanelFinal() {

        panelFinal.removeAll();

        agregarEtiquetaFinal(panelFinal, arbolTorneo.getRaiz());

        panelFinal.revalidate();
        panelFinal.repaint();
    }

    private void agregarEtiquetaFinal(JPanel panel, NodoArbol nodo) {
        if (nodo == null) {
            return;
        }

        agregarEtiquetaFinal(panel, nodo.getIzq());

        int id = nodo.getJugador().getId();
        if (id == 2 || id == 3) {
            JLabel etiqueta = new JLabel(nodo.getJugador().getNombre(), SwingConstants.CENTER);
            etiqueta.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            etiqueta.setPreferredSize(new Dimension(100, 30)); // Ajusta el tamaño
            panel.add(etiqueta);
        }

        agregarEtiquetaFinal(panel, nodo.getDer());
    }

    private void actualizarPanelCampeon() {

        panelCampeon.removeAll();

        if (arbolTorneo.getRaiz() != null) {
            JLabel campeon = new JLabel(arbolTorneo.getRaiz().getJugador().getNombre(), SwingConstants.CENTER);
            campeon.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            campeon.setPreferredSize(new Dimension(200, 30));
            panelCampeon.add(campeon);
        }

        panelCampeon.revalidate();
        panelCampeon.repaint();
    }

    private void crearEtiquetas(JPanel panel, int cantidad, String textoBase) {

        for (int i = 0; i < cantidad; i++) {
            JLabel etiqueta = new JLabel(textoBase + " " + (i + 1), SwingConstants.CENTER);
            etiqueta.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            etiqueta.setPreferredSize(new Dimension(100, 30)); // Ajusta el tamaño
            panel.add(etiqueta);
        }
    }

    private void iniciarBatalla() {

        Jugador jugadorCPU = buscarJugadorCPU();

        if (jugadorCPU != null) {
            if (pokedexJugador == null) {
                JOptionPane.showMessageDialog(this, "La Pokédex del jugador es nula.");
                return;
            }
            VentanaBatalla ventanaBatalla = new VentanaBatalla(
                    jugadorPrincipal,
                    pokedexJugador,
                    jugadorPrincipal.getNombre(),
                    jugadorCPU.getNombre(),
                    arbolTorneo
            );
            ventanaBatalla.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo encontrar un oponente CPU para la batalla.");
        }
    }

    private Jugador buscarJugadorCPU() {

        NodoArbol raiz = arbolTorneo.getRaiz();

        return buscarRival(raiz, jugadorPrincipal);
    }

    private Jugador buscarRival(NodoArbol nodo, Jugador jugador) {
        if (nodo == null) {
            return null;
        }

        if (nodo.getIzq() != null && nodo.getIzq().getJugador().equals(jugador)) {

            return nodo.getDer().getJugador();
        } else if (nodo.getDer() != null && nodo.getDer().getJugador().equals(jugador)) {

            return nodo.getIzq().getJugador();
        }

        Jugador rival = buscarRival(nodo.getIzq(), jugador);
        if (rival != null) {
            return rival;
        }

        return buscarRival(nodo.getDer(), jugador);
    }

}
