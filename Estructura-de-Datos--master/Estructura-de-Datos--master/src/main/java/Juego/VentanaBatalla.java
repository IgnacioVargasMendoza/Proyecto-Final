package Juego;

import Pokedex.ListaPokedex;
import Pokedex.ListaPokemon;
import Pokedex.NodoPokedex;
import Pokedex.NodoPokemon;
import Pokemon.InicializadorPokemon;
import Pokemon.Pokemon;
import Torneo.ArbolTorneo;
import Torneo.NodoArbol;
import com.Jugadores.Jugador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class VentanaBatalla extends JFrame {

    private Pokemon pokemonActualJugador;
    private Pokemon pokemonActualCPU;
    private Jugador jugador;
    private Jugador cpu;
    private VentanaTorneo ventanaTorneo;
    private ArbolTorneo arbolTorneo;
    private NodoArbol nodoCuartos1;
    private NodoArbol nodoRaiz;
    private JTextArea areaPokemonDisponiblesJugador, areaPokemonDisponiblesCPU;
    private JTextArea areaPokemonCentro;
    private JLabel etiquetaNombreJugador;
    private JLabel etiquetaNombreCPU;
    private JLabel etiquetaPokemonJugador;
    private JLabel etiquetaPokemonCPU;
    private JLabel etiquetaVidaJugador;
    private JLabel etiquetaVidaCPU;
    private JTextArea areaMensajes;
    private JButton botonAtacar;
    private JButton botonCambiar;
    private JButton botonTerminarTurno;
    private JButton botonAtaqueEspecial;
    private boolean ataqueRealizado;
    private JLabel etiquetaRecargaEspecial;
    private JLabel etiquetaTurnosRecargaEspecial; // Asegúrate de definir esta etiqueta
    private String nombreCPU;
    private JLabel etiquetaPokedexJugador;
    private JLabel etiquetaPokedexCPU;
    private boolean turnoAtacado;
    private ListaPokedex jugadorPokedex;

    public VentanaBatalla(Jugador jugador, ListaPokedex pokedexJugador, String nombreJugador, String nombreCPU, ArbolTorneo arbolTorneo) {
       if (jugador == null) {
        throw new IllegalArgumentException("El jugador no puede ser nulo");
    }
    if (pokedexJugador == null) {
        throw new IllegalArgumentException("La Pokédex del jugador no puede ser nula");
    }
    if (arbolTorneo == null) {
        throw new IllegalArgumentException("El árbol de torneo no puede ser nulo");
    }

    this.jugador = jugador; // Asegúrate de asignar el jugador aquí
        this.arbolTorneo = arbolTorneo;
        areaMensajes = new JTextArea();
        // Obtener el jugador y el CPU
        this.jugadorPokedex = jugador.getPokedex();
        System.out.println("Pokédex del Jugador inicializada con: " + obtenerTextoPokedex(jugadorPokedex));

        this.cpu = obtenerCPU(arbolTorneo);

        this.nodoCuartos1 = arbolTorneo.getRaiz().getIzq();
        this.nodoRaiz = arbolTorneo.getRaiz();
        ListaPokemon listaPokemonPrincipal = InicializadorPokemon.crearListaPokemon();
        inicializarCPU(listaPokemonPrincipal);

        this.pokemonActualJugador = obtenerProximoPokemon(jugador.getPokedex());
        this.pokemonActualCPU = obtenerProximoPokemon(cpu.getPokedex());

        this.nombreCPU = nombreCPU;

        inicializarInterfaz(nombreJugador, nombreCPU);
        ventanaTorneo = new VentanaTorneo(jugador, arbolTorneo);
        setLocationRelativeTo(null);
    }

    private void inicializarInterfaz(String nombreJugador, String nombreCPU) {
        setTitle("Batalla Pokémon");
        setSize(1000, 500);
        setLayout(new BorderLayout());

        // Panel Superior con nombres
        JPanel panelSuperior = new JPanel(new GridLayout(1, 2));
        etiquetaNombreJugador = new JLabel(nombreJugador, SwingConstants.CENTER);
        etiquetaNombreCPU = new JLabel(nombreCPU, SwingConstants.CENTER);

        // Ajustar el tamaño de fuente para los nombres de los jugadores
        etiquetaNombreJugador.setFont(new Font("Arial", Font.BOLD, 24));
        etiquetaNombreCPU.setFont(new Font("Arial", Font.BOLD, 24));

        panelSuperior.add(etiquetaNombreJugador);
        panelSuperior.add(etiquetaNombreCPU);

        // Panel Izquierdo para Pokémon disponibles del jugador
        JPanel panelIzquierdo = new JPanel(new BorderLayout());
        JLabel etiquetaPokemonDisponiblesJugador = new JLabel("Pokémon disponibles:");
        etiquetaPokemonDisponiblesJugador.setFont(new Font("Arial", Font.PLAIN, 18));

        areaPokemonDisponiblesJugador = new JTextArea(15, 20);
        areaPokemonDisponiblesJugador.setEditable(false);
        JScrollPane scrollPaneJugador = new JScrollPane(areaPokemonDisponiblesJugador);

        panelIzquierdo.add(etiquetaPokemonDisponiblesJugador, BorderLayout.NORTH);
        panelIzquierdo.add(scrollPaneJugador, BorderLayout.CENTER);

        // Panel Derecho para Pokémon disponibles del oponente
        JPanel panelDerecho = new JPanel(new BorderLayout());
        JLabel etiquetaPokemonDisponiblesCPU = new JLabel("Pokémon disponibles:");
        etiquetaPokemonDisponiblesCPU.setFont(new Font("Arial", Font.PLAIN, 18));

        areaPokemonDisponiblesCPU = new JTextArea(15, 20);
        areaPokemonDisponiblesCPU.setEditable(false);
        JScrollPane scrollPaneCPU = new JScrollPane(areaPokemonDisponiblesCPU);

        panelDerecho.add(etiquetaPokemonDisponiblesCPU, BorderLayout.NORTH);
        panelDerecho.add(scrollPaneCPU, BorderLayout.CENTER);

        // Panel Central para Pokémon en combate
        JPanel panelCentral = new JPanel(new GridLayout(1, 2)); // Cambiado a GridLayout con 2 columnas

        JPanel panelPokemonJugador = new JPanel(new GridLayout(2, 1));
        JPanel panelPokemonCPU = new JPanel(new GridLayout(2, 1));

        etiquetaPokemonJugador = new JLabel("Pokémon: " + pokemonActualJugador.getNombre());
        etiquetaVidaJugador = new JLabel("Vida: " + pokemonActualJugador.getVida());
        etiquetaPokemonCPU = new JLabel("Pokémon: " + pokemonActualCPU.getNombre());
        etiquetaVidaCPU = new JLabel("Vida: " + pokemonActualCPU.getVida());

        panelPokemonJugador.add(etiquetaPokemonJugador);
        panelPokemonJugador.add(etiquetaVidaJugador);

        panelPokemonCPU.add(etiquetaPokemonCPU);
        panelPokemonCPU.add(etiquetaVidaCPU);

        panelCentral.add(panelPokemonJugador);
        panelCentral.add(panelPokemonCPU);

        // Panel Inferior para los botones y etiquetas
        JPanel panelInferior = new JPanel(new FlowLayout());
        botonAtacar = new JButton("Atacar");
        botonAtaqueEspecial = new JButton("Ataque Especial");
        botonCambiar = new JButton("Cambiar Pokémon");
        botonTerminarTurno = new JButton("Terminar Turno");

        etiquetaRecargaEspecial = new JLabel("Recarga Especial: 0 turnos");

        panelInferior.add(botonAtacar);
        panelInferior.add(botonAtaqueEspecial);
        panelInferior.add(botonCambiar);
        panelInferior.add(botonTerminarTurno);
        panelInferior.add(etiquetaRecargaEspecial);

        // Configurar los botones
        botonAtacar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarAtaqueNormal();
            }
        });

        botonAtaqueEspecial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarAtaqueEspecial();
            }
        });

        botonCambiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarPokemon();
            }
        });

        botonTerminarTurno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                terminarTurno();
            }
        });

        // Agregar paneles a la ventana
        add(panelSuperior, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);
        add(panelIzquierdo, BorderLayout.WEST);
        add(panelDerecho, BorderLayout.EAST);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Actualizar los textos de Pokémon disponibles
        actualizarPokedex();
        System.out.println("Pokédex del Jugador antes de actualizar: " + obtenerTextoPokedex(jugador.getPokedex()));

    }

    private boolean verificarDerrota(Jugador jugador) {
        NodoPokedex nodoActual = jugador.getPokedex().getCabeza();
        if (nodoActual != null) {
            NodoPokedex nodoInicio = nodoActual;
            do {
                if (nodoActual.getDatoPokemon().getVida() > 0) {
                    return false; // Aún queda un Pokémon con vida
                }
                nodoActual = nodoActual.getSiguiente();
            } while (nodoActual != nodoInicio);
        }
        return true; // Todos los Pokémon están derrotados
    }

    private void finalizarBatalla(String mensajeFinal) {
        // Mostrar el mensaje final de la batalla
        JOptionPane.showMessageDialog(this, mensajeFinal);

        if (mensajeFinal.contains("Has ganado")) {
            // El jugador ha ganado la batalla, avanza en el torneo
            avanzarTorneo();

            // Redirigir a la ventana del torneo actualizada
            VentanaTorneo ventanaTorneoActualizada = new VentanaTorneo(jugador, arbolTorneo);
            ventanaTorneoActualizada.setVisible(true);
        } else {
            // El jugador ha perdido, regresar a la pantalla principal
            JOptionPane.showMessageDialog(this, "Has perdido el torneo. Volviendo a la pantalla principal.");
            // Aquí puedes reiniciar el torneo si es necesario
            arbolTorneo.resetear();
            ListaPokemon listaPokemon = InicializadorPokemon.crearListaPokemon();
            VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(jugador, listaPokemon);
            ventanaPrincipal.setVisible(true);
        }

        // Cerrar la ventana actual de la batalla
        this.dispose();
    }

    private void actualizarInformacion() {
        // Actualizar la información del Pokémon del jugador
        if (pokemonActualJugador != null) {
            etiquetaPokemonJugador.setText("Pokémon: " + pokemonActualJugador.getNombre());
            etiquetaVidaJugador.setText("Vida: " + pokemonActualJugador.getVida());
        } else {
            etiquetaPokemonJugador.setText("Pokémon: N/A");
            etiquetaVidaJugador.setText("Vida: N/A");
        }

        // Actualizar la información del Pokémon del CPU
        if (pokemonActualCPU != null) {
            etiquetaPokemonCPU.setText("Pokémon: " + pokemonActualCPU.getNombre());
            etiquetaVidaCPU.setText("Vida: " + pokemonActualCPU.getVida());
        } else {
            etiquetaPokemonCPU.setText("Pokémon: N/A");
            etiquetaVidaCPU.setText("Vida: N/A");
        }

        // Actualizar la lista de Pokémon disponibles
        areaPokemonDisponiblesJugador.setText(generarListaPokemonDisponibles(jugador));
        areaPokemonDisponiblesCPU.setText(generarListaPokemonDisponibles(cpu));
    }

    private String generarListaPokemonDisponibles(Jugador jugador) {
        StringBuilder lista = new StringBuilder();

        NodoPokedex nodoActual = jugador.getPokedex().getCabeza();
        if (nodoActual != null) {
            NodoPokedex nodoInicio = nodoActual;
            do {
                Pokemon pokemon = nodoActual.getDatoPokemon();
                if (pokemon.getVida() > 0) {
                    lista.append(pokemon.getNombre()).append(" - Vida: ").append(pokemon.getVida()).append("\n");
                } else {
                    lista.append(pokemon.getNombre()).append(" - Vida: Derrotado\n");
                }
                nodoActual = nodoActual.getSiguiente();
            } while (nodoActual != nodoInicio); // Asumiendo lista circular
        } else {
            lista.append("El Pokedex está vacío.");
        }

        // Mensaje de depuración para mostrar la lista en la consola
        System.out.println("Pokédex del Jugador:\n" + lista.toString());

        return lista.toString();
    }



    private Jugador obtenerCPU(ArbolTorneo arbolTorneo) {
        NodoArbol raiz = arbolTorneo.getRaiz();
        if (raiz != null && raiz.getDer() != null) {
            return raiz.getDer().getJugador();
        } else {
            throw new IllegalStateException("El nodo raíz no tiene un hijo derecho.");
        }
    }

    private String obtenerTextoPokedex(ListaPokedex pokedex) {
        StringBuilder sb = new StringBuilder();
        NodoPokedex nodoActual = pokedex.getCabeza();

        if (nodoActual != null) {
            NodoPokedex nodoInicio = nodoActual;
            do {
                Pokemon pokemon = nodoActual.getDatoPokemon();
                if (pokemon != null) {
                    sb.append(pokemon.getNombre()).append(" - Vida: ").append(pokemon.getVida()).append("\n");
                }
                nodoActual = nodoActual.getSiguiente();
            } while (nodoActual != nodoInicio && nodoActual != null);
        } else {
            sb.append("Pokédex vacía\n");
        }
        return sb.toString();
    }

    private void actualizarPokedex() {
      if (this.jugador == null) {
        System.err.println("El jugador es nulo en actualizarPokedex.");
        return;
    }
        
        
        System.out.println("Actualizando Pokédex...");
        System.out.println("Pokédex del Jugador antes de actualizar: " + obtenerTextoPokedex(jugador.getPokedex()));
        areaPokemonDisponiblesJugador.setText(obtenerTextoPokedex(jugador.getPokedex()));

        System.out.println("Pokédex del CPU antes de actualizar: " + obtenerTextoPokedex(cpu.getPokedex()));
        areaPokemonDisponiblesCPU.setText(obtenerTextoPokedex(cpu.getPokedex()));
        areaPokemonDisponiblesJugador.setText(obtenerTextoPokedex(jugador.getPokedex()));
        areaPokemonDisponiblesCPU.setText(obtenerTextoPokedex(cpu.getPokedex()));
    }

    private void inicializarCPU(ListaPokemon listaPokemonPrincipal) {
        System.out.println("Hash de la Pokédex del CPU al iniciar la inicialización: " + System.identityHashCode(cpu.getPokedex()));
        if (cpu.getPokedex().getCabeza() == null) {
            NodoPokemon nodoActual = listaPokemonPrincipal.getCabeza();
            if (nodoActual == null) {
                throw new IllegalStateException("La lista de Pokémon está vacía.");
            }

            Random random = new Random();
            Set<Pokemon> seleccionados = new HashSet<>();
            int tamañoLista = contarPokemons(listaPokemonPrincipal);

            while (seleccionados.size() < 4 && tamañoLista > 0) {
                int index = random.nextInt(tamañoLista);
                NodoPokemon nodoSeleccionado = nodoActual;
                for (int i = 0; i < index; i++) {
                    nodoSeleccionado = nodoSeleccionado.getNext();
                }
                seleccionados.add(nodoSeleccionado.getPokemon());

                // Mensaje de depuración
                System.out.println("Pokémon seleccionado: " + nodoSeleccionado.getPokemon().getNombre());
            }

            for (Pokemon pokemon : seleccionados) {
                cpu.getPokedex().insertar(pokemon);
                // Mensaje de depuración
                System.out.println("Pokémon insertado en Pokédex CPU: " + pokemon.getNombre());
            }

            // Verificar la Pokédex del CPU
            NodoPokedex nodoPokedex = cpu.getPokedex().getCabeza();
            if (nodoPokedex == null) {
                System.out.println("Error: La Pokédex del CPU sigue vacía después de la inicialización.");
            } else {
                do {
                    System.out.println("Pokémon en Pokédex CPU: " + nodoPokedex.getDatoPokemon().getNombre());
                    nodoPokedex = nodoPokedex.getSiguiente();
                } while (nodoPokedex != null && nodoPokedex != cpu.getPokedex().getCabeza());
            }
        } else {
            System.out.println("La Pokédex del CPU ya está inicializada.");
            System.out.println("Hash de la Pokédex del CPUspués de la inicialización: \" + System.identityHashCode(pokedexCPU));\n"
                    + "    } después de la inicialización: " + System.identityHashCode(cpu.getPokedex()));
        }
    }

    private int contarPokemons(ListaPokemon listaPokemonPrincipal) {
        NodoPokemon temp = listaPokemonPrincipal.getCabeza();
        int total = 0;
        if (temp != null) {
            do {
                total++;
                temp = temp.getNext();
            } while (temp != listaPokemonPrincipal.getCabeza());
        }
        return total;
    }

    private Pokemon obtenerProximoPokemon(Pokedex.ListaPokedex pokedex) {
        NodoPokedex nodoActual = pokedex.getCabeza();
        if (nodoActual != null) {
            NodoPokedex nodoInicio = nodoActual;
            do {
                Pokemon pokemon = nodoActual.getDatoPokemon();
                if (pokemon.getVida() > 0) {
                    return pokemon;
                }
                nodoActual = nodoActual.getSiguiente();
            } while (nodoActual != nodoInicio);
        }
        return null; // No hay Pokémon disponible
    }

    private void realizarAtaqueNormal() {
        if (pokemonActualCPU != null && pokemonActualCPU.getVida() <= 0) {
            areaMensajes.append(pokemonActualCPU.getNombre() + " ha sido derrotado.\n");
            pokemonActualCPU = obtenerProximoPokemon(cpu.getPokedex());
            if (pokemonActualCPU == null) {
                areaMensajes.append("¡Has ganado la batalla!\n");
                finalizarBatalla("¡Has ganado la batalla!");
                return;
            }
            etiquetaPokemonCPU.setText("Pokémon: " + pokemonActualCPU.getNombre());
            etiquetaVidaCPU.setText("Vida: " + pokemonActualCPU.getVida());
        }

        if (verificarDerrota(jugador)) {
            areaMensajes.append("¡El CPU ha ganado la batalla!\n");
            finalizarBatalla("¡El CPU ha ganado la batalla!");
            return;
        }

        if (jugador.getPokedex() == null || cpu.getPokedex() == null) {
            areaMensajes.append("Las Pokédex no están inicializadas.\n");
            return;
        }

        if (ataqueRealizado) {
            areaMensajes.append("Ya has atacado en este turno.\n");
            return;
        }

        if (pokemonActualJugador != null && pokemonActualCPU != null) {
            int dano = pokemonActualJugador.atacar(pokemonActualCPU);
            if (dano > 0) {
                pokemonActualCPU.recibirDaño(dano);
            }

            etiquetaVidaCPU.setText("Vida: " + pokemonActualCPU.getVida());

            if (pokemonActualCPU.getVida() <= 0) {
                areaMensajes.append(pokemonActualCPU.getNombre() + " ha sido derrotado.\n");
                pokemonActualCPU = obtenerProximoPokemon(cpu.getPokedex());
                if (pokemonActualCPU == null) {
                    areaMensajes.append("¡Has ganado la batalla!\n");
                    avanzarTorneo();
                    return;
                }
                etiquetaPokemonCPU.setText("Pokémon: " + pokemonActualCPU.getNombre());
                etiquetaVidaCPU.setText("Vida: " + pokemonActualCPU.getVida());
            }

            ataqueRealizado = true;
            botonAtacar.setEnabled(false);
            botonAtaqueEspecial.setEnabled(false);
            actualizarInformacion();
        }
    }

    private void realizarAtaqueEspecial() {
        if (pokemonActualCPU != null && pokemonActualCPU.getVida() <= 0) {
            areaMensajes.append(pokemonActualCPU.getNombre() + " ha sido derrotado.\n");
            pokemonActualCPU = obtenerProximoPokemon(cpu.getPokedex());
            if (pokemonActualCPU == null) {
                areaMensajes.append("¡Has ganado la batalla!\n");
                finalizarBatalla("¡Has ganado la batalla!");
                return;
            }
            etiquetaPokemonCPU.setText("Pokémon: " + pokemonActualCPU.getNombre());
            etiquetaVidaCPU.setText("Vida: " + pokemonActualCPU.getVida());
        }

        if (verificarDerrota(jugador)) {
            areaMensajes.append("¡El CPU ha ganado la batalla!\n");
            finalizarBatalla("¡El CPU ha ganado la batalla!");
            return;
        }

        if (ataqueRealizado) {
            areaMensajes.append("Ya has realizado un ataque especial en este turno.\n");
            return;
        }

        if (pokemonActualJugador != null && pokemonActualCPU != null) {
            if (pokemonActualJugador.getTurnosRecargaEspecial() > 0) {
                areaMensajes.append("El ataque especial está en recarga. Debes esperar más turnos.\n");
                return;
            }

            pokemonActualJugador.atacarEspecial(pokemonActualCPU);
            etiquetaVidaCPU.setText("Vida: " + pokemonActualCPU.getVida());

            if (pokemonActualCPU.getVida() <= 0) {
                areaMensajes.append(pokemonActualCPU.getNombre() + " ha sido derrotado.\n");
                pokemonActualCPU = obtenerProximoPokemon(cpu.getPokedex());
                if (pokemonActualCPU == null) {
                    areaMensajes.append("¡Has ganado la batalla!\n");
                    avanzarTorneo();
                    return;
                }
                etiquetaPokemonCPU.setText("Pokémon: " + pokemonActualCPU.getNombre());
                etiquetaVidaCPU.setText("Vida: " + pokemonActualCPU.getVida());
            }

            ataqueRealizado = true;
            botonAtacar.setEnabled(false);
            botonAtaqueEspecial.setEnabled(false);
            actualizarInformacion();
        }
    }

    public void terminarTurno() {
        if (pokemonActualJugador != null && pokemonActualJugador.getVida() <= 0) {
            areaMensajes.append(pokemonActualJugador.getNombre() + " ha sido derrotado.\n");
            pokemonActualJugador = obtenerProximoPokemon(jugador.getPokedex());
            if (pokemonActualJugador == null) {
                areaMensajes.append("¡El CPU ha ganado la batalla!\n");
                finalizarBatalla("¡El CPU ha ganado la batalla!");
                return;
            }
            etiquetaPokemonJugador.setText("Pokémon: " + pokemonActualJugador.getNombre());
            etiquetaVidaJugador.setText("Vida: " + pokemonActualJugador.getVida());
        }

        if (verificarDerrota(cpu)) {
            areaMensajes.append("¡Has ganado la batalla!\n");
            finalizarBatalla("¡Has ganado la batalla!");
            return;
        }

        if (!ataqueRealizado) {
            areaMensajes.append("Debes atacar antes de terminar el turno.\n");
            return;
        }

        if (pokemonActualCPU != null) {
            int dano = pokemonActualCPU.atacar(pokemonActualJugador);
            if (dano > 0) {
                pokemonActualJugador.recibirDaño(dano);
            }

            etiquetaVidaJugador.setText("Vida: " + pokemonActualJugador.getVida());

            if (pokemonActualJugador.getVida() <= 0) {
                areaMensajes.append(pokemonActualJugador.getNombre() + " ha sido derrotado.\n");
                pokemonActualJugador = obtenerProximoPokemon(jugador.getPokedex());
                if (pokemonActualJugador == null) {
                    areaMensajes.append("¡El CPU ha ganado la batalla!\n");
                    avanzarTorneo();
                    return;
                }
                etiquetaPokemonJugador.setText("Pokémon: " + pokemonActualJugador.getNombre());
                etiquetaVidaJugador.setText("Vida: " + pokemonActualJugador.getVida());
            }

            ataqueRealizado = false;
            pokemonActualJugador.terminarTurno();
            pokemonActualCPU.terminarTurno();
            botonAtacar.setEnabled(true);
            botonAtaqueEspecial.setEnabled(pokemonActualJugador.getTurnosRecargaEspecial() == 0);
            actualizarInformacion();
        }
    }

    private void cambiarPokemon() {
        if (jugador.getPokedex().getCabeza() != null) {
            String[] opciones = new String[4];
            NodoPokedex temp = jugador.getPokedex().getCabeza();
            for (int i = 0; i < 4 && temp != null; i++) {
                opciones[i] = temp.getDatoPokemon().getNombre();
                temp = temp.getSiguiente();
            }

            String seleccionado = (String) JOptionPane.showInputDialog(
                    this, "Selecciona un Pokémon:", "Cambiar Pokémon",
                    JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            if (seleccionado != null) {
                NodoPokedex nodoSeleccionado = jugador.getPokedex().getCabeza();
                while (nodoSeleccionado != null) {
                    if (nodoSeleccionado.getDatoPokemon().getNombre().equals(seleccionado)) {
                        pokemonActualJugador = nodoSeleccionado.getDatoPokemon();
                        etiquetaPokemonJugador.setText("Pokémon: " + pokemonActualJugador.getNombre());
                        etiquetaVidaJugador.setText("Vida: " + pokemonActualJugador.getVida());
                        turnoAtacado = false;
                        areaMensajes.append("Has cambiado a " + pokemonActualJugador.getNombre() + ".\n");
                        return;
                    }
                    nodoSeleccionado = nodoSeleccionado.getSiguiente();
                }
            }
        } else {
            areaMensajes.append("No tienes Pokémon en tu Pokédex.\n");
        }

    }

    private void avanzarTorneo() {
        if (nodoRaiz == null) {
            areaMensajes.append("El árbol de torneo no está inicializado.\n");
            return;
        }

        // Verificar si el nodo actual es una hoja (es decir, ya no puede avanzar más)
        if (nodoRaiz.esHoja()) {
            areaMensajes.append("El torneo ha terminado.\n");
            return;
        }

        // Determinar el ganador entre los nodos hijos (si aplica)
        Jugador ganador = determinarGanador(nodoRaiz);

        if (ganador != null) {
            // Asignar el ganador al nodo actual
            nodoRaiz.setGanador(ganador);
            areaMensajes.append("El ganador del nodo actual es: " + ganador.getNombre() + ".\n");

            // Si el ganador es el jugador, avanzar el nodo
            if (ganador.equals(jugador)) {
                // Avanzar el nodo a la raíz y enfrentarse al siguiente nodo derecho
                NodoArbol siguienteNodo = obtenerSiguienteNodo(nodoRaiz);

                if (siguienteNodo != null) {
                    // Reemplazar la raíz con el nodo ganador
                    NodoArbol nuevoNodo = siguienteNodo;
                    nuevoNodo.setIzq(nodoRaiz);
                    nuevoNodo.setDer(siguienteNodo.getDer());

                    nodoRaiz = nuevoNodo; // Actualizar la raíz

                    areaMensajes.append("Avanzando al siguiente nodo del torneo.\n");
                } else {
                    areaMensajes.append("El torneo ha terminado.\n");
                }
            }
        } else {
            areaMensajes.append("No se pudo determinar un ganador en el nodo actual.\n");
        }

        // Actualizar la ventana del torneo
        if (ventanaTorneo != null) {
            ventanaTorneo.actualizarPaneles();
        }
    }

    private Jugador determinarGanador(NodoArbol nodoActual) {
        Jugador ganadorIzq = nodoActual.getIzq() != null ? nodoActual.getIzq().getGanador() : null;
        Jugador ganadorDer = nodoActual.getDer() != null ? nodoActual.getDer().getGanador() : null;

        // Aquí decides quién es el ganador, en este caso se asume que el ganador es el nodo que tiene un jugador asignado
        if (ganadorIzq != null) {
            return ganadorIzq; // Puede ser que quieras comparar en lugar de solo asignar
        } else if (ganadorDer != null) {
            return ganadorDer;
        } else {
            return null; // Si ninguno tiene un ganador
        }
    }

    private NodoArbol obtenerSiguienteNodo(NodoArbol nodoActual) {
        if (nodoActual.getIzq() != null && nodoActual.getIzq().getGanador() != null) {
            return nodoActual.getIzq();
        } else if (nodoActual.getDer() != null && nodoActual.getDer().getGanador() != null) {
            return nodoActual.getDer();
        }
        return null;
    }
}
