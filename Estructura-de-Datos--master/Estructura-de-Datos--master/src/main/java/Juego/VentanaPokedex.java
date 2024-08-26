package Juego;

import Pokedex.ListaPokemon;
import Pokedex.NodoPokedex;
import Pokedex.NodoPokemon;
import Pokemon.Pokemon;
import com.Jugadores.Jugador;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPokedex extends JFrame {
    private ListaPokemon listaPokemon;
    private NodoPokemon nodoActual;
    private Jugador jugador;
    private JLabel lblNombrePokemon;
    private JLabel lblTipoPokemon;
    private JLabel lblVidaPokemon;
    private JLabel lblAtaquePokemon;
    private JLabel lblDefensaPokemon;
    private JList<String> listaVisualPokemon; // Lista visual para mostrar nombres de Pokémon
    private DefaultListModel<String> modeloLista; // Modelo de la lista
    private JList<String> listaPokedex; // Lista visual para mostrar la Pokédex del jugador
    private DefaultListModel<String> modeloPokedex; // Modelo de la Pokédex
    private JButton btnEstoyListo;

    public VentanaPokedex(ListaPokemon listaPokemon, Jugador jugador) {
        this.listaPokemon = listaPokemon;
        this.jugador = jugador;
        this.nodoActual = listaPokemon.getCabeza();

        configurarVentana();
        crearComponentes();
    }

    private void configurarVentana() {
        setTitle("Pokédex");
        setSize(900, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }

    private void crearComponentes() {
        // Panel para mostrar la información del Pokémon
        JPanel panelInfo = new JPanel();
        panelInfo.setLayout(new GridLayout(5, 1));
        panelInfo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        lblNombrePokemon = new JLabel("", SwingConstants.CENTER);
        lblNombrePokemon.setFont(new Font("Arial", Font.BOLD, 24));

        lblTipoPokemon = new JLabel("", SwingConstants.CENTER);
        lblTipoPokemon.setFont(new Font("Arial", Font.PLAIN, 18));

        lblVidaPokemon = new JLabel("", SwingConstants.CENTER);
        lblVidaPokemon.setFont(new Font("Arial", Font.PLAIN, 18));

        lblAtaquePokemon = new JLabel("", SwingConstants.CENTER);
        lblAtaquePokemon.setFont(new Font("Arial", Font.PLAIN, 18));

        lblDefensaPokemon = new JLabel("", SwingConstants.CENTER);
        lblDefensaPokemon.setFont(new Font("Arial", Font.PLAIN, 18));

        panelInfo.add(lblNombrePokemon);
        panelInfo.add(lblTipoPokemon);
        panelInfo.add(lblVidaPokemon);
        panelInfo.add(lblAtaquePokemon);
        panelInfo.add(lblDefensaPokemon);

        add(panelInfo, BorderLayout.CENTER);

        // Modelo y lista visual para mostrar los nombres de los Pokémon
        modeloLista = new DefaultListModel<>();
        listaVisualPokemon = new JList<>(modeloLista);
        listaVisualPokemon.setFont(new Font("Arial", Font.PLAIN, 18));
        listaVisualPokemon.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        NodoPokemon nodo = listaPokemon.getCabeza();
        do {
            modeloLista.addElement(nodo.getPokemon().getNombre());
            nodo = nodo.getNext();
        } while (nodo != listaPokemon.getCabeza());

        JPanel panelListaPokemon = new JPanel(new BorderLayout());
        JLabel lblTituloPokemonDisponibles = new JLabel("Pokémon Disponibles", SwingConstants.CENTER);
        lblTituloPokemonDisponibles.setFont(new Font("Arial", Font.BOLD, 18));
        panelListaPokemon.add(lblTituloPokemonDisponibles, BorderLayout.NORTH);
        panelListaPokemon.add(new JScrollPane(listaVisualPokemon), BorderLayout.CENTER);
        panelListaPokemon.setPreferredSize(new Dimension(250, 0));

        add(panelListaPokemon, BorderLayout.WEST);

        // Modelo y lista visual para mostrar la Pokédex del jugador
        modeloPokedex = new DefaultListModel<>();
        listaPokedex = new JList<>(modeloPokedex);
        listaPokedex.setFont(new Font("Arial", Font.PLAIN, 18));
        listaPokedex.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JPanel panelPokedex = new JPanel(new BorderLayout());
        JLabel lblTituloPokedex = new JLabel("Pokédex", SwingConstants.CENTER);
        lblTituloPokedex.setFont(new Font("Arial", Font.BOLD, 18));
        panelPokedex.add(lblTituloPokedex, BorderLayout.NORTH);
        panelPokedex.add(new JScrollPane(listaPokedex), BorderLayout.CENTER);
        panelPokedex.setPreferredSize(new Dimension(250, 0));

        add(panelPokedex, BorderLayout.EAST);

        // Botones
        JButton btnAnterior = new JButton("Anterior", new ImageIcon("ruta/a/icono/anterior.png"));
        JButton btnSiguiente = new JButton("Siguiente", new ImageIcon("ruta/a/icono/siguiente.png"));
        JButton btnElegir = new JButton("Elegir", new ImageIcon("ruta/a/icono/elegir.png"));
        JButton btnQuitar = new JButton("Quitar", new ImageIcon("ruta/a/icono/quitar.png"));
        btnEstoyListo = new JButton("Estoy Listo");

        JPanel panelBotones = new JPanel(new FlowLayout());
        panelBotones.add(btnAnterior);
        panelBotones.add(btnSiguiente);
        panelBotones.add(btnElegir);
        panelBotones.add(btnQuitar);
        panelBotones.add(btnEstoyListo);

        add(panelBotones, BorderLayout.SOUTH);

        // Cargar la Pokédex del jugador
        cargarPokedex();

        // Acciones para los botones
        btnAnterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPokemonAnterior();
            }
        });

        btnSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPokemonSiguiente();
            }
        });

        btnElegir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarPokemonAPokedex();
            }
        });

        btnQuitar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quitarPokemonDePokedex();
            }
        });

        btnEstoyListo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                 imprimirPokedex();

                JOptionPane.showMessageDialog(VentanaPokedex.this, "¡Estás listo para la batalla!");
                // Cerrar la ventana
                dispose();
                
            }
        });

        // Mostrar el primer Pokémon al abrir la ventana
        actualizarVista();
    }
    
    private void imprimirPokedex() {
    System.out.println("Pokédex del Jugador:");
    NodoPokedex nodoActual = jugador.getPokedex().getCabeza();
    
    if (nodoActual != null) {
        NodoPokedex nodoInicio = nodoActual; // Guardar el nodo de inicio para evitar el loop infinito
        do {
            Pokemon pokemon = nodoActual.getDatoPokemon();
            System.out.println(pokemon.getNombre() + " - Vida: " + pokemon.getVida());
            nodoActual = nodoActual.getSiguiente();
        } while (nodoActual != nodoInicio);
    }
}


    private void mostrarPokemonAnterior() {
        if (nodoActual != null) {
            NodoPokemon previo = nodoActual;
            NodoPokemon actual = listaPokemon.getCabeza();

            while (actual.getNext() != nodoActual && actual.getNext() != listaPokemon.getCabeza()) {
                actual = actual.getNext();
            }

            nodoActual = actual;
            actualizarVista();
        }
    }

    private void mostrarPokemonSiguiente() {
        if (nodoActual != null) {
            nodoActual = nodoActual.getNext();
            actualizarVista();
        }
    }

    private void agregarPokemonAPokedex() {
        if (nodoActual != null) {
            Pokemon pokemon = nodoActual.getPokemon();

            if (modeloPokedex.getSize() >= 4) {
                JOptionPane.showMessageDialog(this, "Tu Pokédex ya está llena. No puedes agregar más Pokémon.");
                return;
            }

            if (modeloPokedex.contains(pokemon.getNombre())) {
                JOptionPane.showMessageDialog(this, "Este Pokémon ya está en tu Pokédex.");
                return;
            }

            jugador.getPokedex().insertar(pokemon);
            modeloPokedex.addElement(pokemon.getNombre());
            JOptionPane.showMessageDialog(this, pokemon.getNombre() + " ha sido añadido a tu Pokédex.");
        }
    }

    private void quitarPokemonDePokedex() {
        int selectedIndex = listaPokedex.getSelectedIndex();
        if (selectedIndex != -1) {
            String pokemonNombre = modeloPokedex.getElementAt(selectedIndex);
            modeloPokedex.removeElementAt(selectedIndex);
            jugador.getPokedex().eliminarPorNombre(pokemonNombre);
            JOptionPane.showMessageDialog(this, pokemonNombre + " ha sido eliminado de tu Pokédex.");
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona un Pokémon de la Pokédex para quitar.");
        }
    }

    private void actualizarVista() {
        if (nodoActual != null) {
            Pokemon pokemon = nodoActual.getPokemon();
            lblNombrePokemon.setText("Nombre: " + pokemon.getNombre());
            lblTipoPokemon.setText("Tipo: " + pokemon.getTipo());
            lblVidaPokemon.setText("Vida: " + pokemon.getVida());
            lblAtaquePokemon.setText("Ataque: " + pokemon.getAtaque());
            lblDefensaPokemon.setText("Defensa: " + pokemon.getDefensa());

            // Actualizar la selección en la lista visual
            listaVisualPokemon.setSelectedIndex(obtenerIndicePokemon(nodoActual));
            listaVisualPokemon.ensureIndexIsVisible(obtenerIndicePokemon(nodoActual));
        }
    }

    private int obtenerIndicePokemon(NodoPokemon nodo) {
        NodoPokemon temp = listaPokemon.getCabeza();
        int index = 0;
        while (temp != null && temp != nodo) {
            temp = temp.getNext();
            index++;
            if (temp == listaPokemon.getCabeza()) break;
        }
        return index;
    }

  private void cargarPokedex() {
    modeloPokedex.clear(); // Limpiar la lista de Pokédex existente

    NodoPokedex nodoActual = jugador.getPokedex().getCabeza();
    
    if (nodoActual != null) {
        NodoPokedex nodoInicio = nodoActual; 
        do {
            Pokemon pokemon = nodoActual.getDatoPokemon();
            modeloPokedex.addElement(pokemon.getNombre());
            nodoActual = nodoActual.getSiguiente();
        } while (nodoActual != nodoInicio);
    }
}



}
