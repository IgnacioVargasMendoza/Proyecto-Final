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
     this.pokedexJugador=jugadorPrincipal.getPokedex();
        // Configuración de la ventana
        configurarVentana();

        // Crear y agregar componentes
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
        gbc.insets = new Insets(5, 5, 5, 5); // Espaciado entre los componentes
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Inicializar los paneles
        panelCuartos = new JPanel();
        panelSemis = new JPanel();
        panelFinal = new JPanel();
        panelCampeon = new JPanel();

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

        // Añadir el panel de torneo a la ventana
        JScrollPane scrollPane = new JScrollPane(panelTorneo);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void agregarJugadoresPanel(JPanel panel) {
        // Limpiar el panel antes de agregar jugadores
        panel.removeAll();

        // Recorrer el árbol para agregar etiquetas solo para los 8 jugadores de cuartos de final
        agregarEtiquetasCuartos(panel, arbolTorneo.getRaiz());

        // Revalidar y repintar el panel
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

        // Limpiar los paneles
        panelCuartos.removeAll();
        panelSemis.removeAll();
        panelFinal.removeAll();
        panelCampeon.removeAll();

        // Volver a agregar los jugadores y etiquetas
        agregarJugadoresPanel(panelCuartos);
        actualizarPanelSemis();
        actualizarPanelFinal();
        actualizarPanelCampeon();

        // Actualizar la interfaz gráfica
        panelTorneo.revalidate();
        panelTorneo.repaint();
    }

    private void actualizarPanelSemis() {
        // Limpiar el panel de semifinales
        panelSemis.removeAll();

        // Agregar etiquetas para los ganadores de cuartos
        agregarEtiquetasSemis(panelSemis, arbolTorneo.getRaiz());

        // Revalidar y repintar el panel
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
        // Limpiar el panel final
        panelFinal.removeAll();

        // Extraer los finalistas directamente del árbol
        agregarEtiquetaFinal(panelFinal, arbolTorneo.getRaiz());

        // Revalidar y repintar el panel
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
        // Limpiar el panel del campeón
        panelCampeon.removeAll();

        // Obtener el campeón directamente desde la raíz
        if (arbolTorneo.getRaiz() != null) {
            JLabel campeon = new JLabel(arbolTorneo.getRaiz().getJugador().getNombre(), SwingConstants.CENTER);
            campeon.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            campeon.setPreferredSize(new Dimension(200, 30));
            panelCampeon.add(campeon);
        }

        // Revalidar y repintar el panel
        panelCampeon.revalidate();
        panelCampeon.repaint();
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

  private void iniciarBatalla() {
    imprimirArbol(arbolTorneo.getRaiz(), "");

    Jugador jugadorCPU = buscarJugadorCPU();

    if (jugadorCPU != null) {
        if (pokedexJugador == null) {
            JOptionPane.showMessageDialog(this, "La Pokédex del jugador es nula.");
            return;
        }
        VentanaBatalla ventanaBatalla = new VentanaBatalla(
                jugadorPrincipal,
                pokedexJugador, // Asegúrate de que esto no sea nulo
                jugadorPrincipal.getNombre(),
                jugadorCPU.getNombre(),
                arbolTorneo
        );
        ventanaBatalla.setVisible(true);
        this.dispose(); // Asegúrate de que esta acción sea apropiada
    } else {
        JOptionPane.showMessageDialog(this, "No se pudo encontrar un oponente CPU para la batalla.");
    }
}


    private Jugador buscarJugadorCPU() {
        // Obtener el nodo raíz del árbol
        NodoArbol raiz = arbolTorneo.getRaiz();

        // Buscar el rival recorriendo todo el árbol
        return buscarRival(raiz, jugadorPrincipal);
    }

    private Jugador buscarRival(NodoArbol nodo, Jugador jugador) {
        if (nodo == null) {
            return null;
        }

        // Verificar si el jugador principal es el hijo izquierdo o derecho
        if (nodo.getIzq() != null && nodo.getIzq().getJugador().equals(jugador)) {
            System.out.println("Rival encontrado: " + nodo.getDer().getJugador().getNombre());
            return nodo.getDer().getJugador();
        } else if (nodo.getDer() != null && nodo.getDer().getJugador().equals(jugador)) {
            System.out.println("Rival encontrado: " + nodo.getIzq().getJugador().getNombre());
            return nodo.getIzq().getJugador();
        }

        // Recorrer el subárbol izquierdo
        Jugador rival = buscarRival(nodo.getIzq(), jugador);
        if (rival != null) {
            return rival;
        }

        // Recorrer el subárbol derecho
        return buscarRival(nodo.getDer(), jugador);
    }

    private NodoArbol buscarNodoConJugador(NodoArbol nodo, Jugador jugador) {
        if (nodo == null) {
            return null;
        }

        // Verificar si el nodo actual contiene el jugador buscado
        if (nodo.getJugador().equals(jugador)) {
            return nodo;
        }

        // Buscar en el subárbol izquierdo
        NodoArbol resultado = buscarNodoConJugador(nodo.getIzq(), jugador);
        if (resultado != null) {
            return resultado;
        }

        // Buscar en el subárbol derecho
        return buscarNodoConJugador(nodo.getDer(), jugador);
    }

    public void imprimirArbol(NodoArbol nodo, String prefijo) {
        if (nodo == null) {
            return;
        }
        System.out.println(prefijo + nodo.getJugador().getNombre());
        imprimirArbol(nodo.getIzq(), prefijo + "  ");
        imprimirArbol(nodo.getDer(), prefijo + "  ");
    }

}
