package juego_ui;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.swing.*;
import java.awt.*;

public class TorneoPokemonGUI {

    public static void main(String[] args) {
        // Configuración del JFrame
        JFrame frame = new JFrame("Torneo Pokémon");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout());

        // Crear el JLabel en la parte superior
        JLabel headerLabel = new JLabel("Torneo Pokémon", JLabel.CENTER);
        frame.add(headerLabel, BorderLayout.NORTH);

        // Crear un panel para contener los 9 paneles rectangulares
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 3, 10, 10));

        // Crear los 9 paneles con labels
        for (int i = 1; i <= 9; i++) {
            JPanel panel = new JPanel();
            panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            panel.setPreferredSize(new Dimension(100, 50));
            panel.setLayout(new BorderLayout());
            JLabel panelLabel = new JLabel("Panel " + i, JLabel.CENTER);
            panel.add(panelLabel, BorderLayout.CENTER);
            centerPanel.add(panel);
        }

        // Añadir el panel central al JFrame
        frame.add(centerPanel, BorderLayout.CENTER);

        // Crear el botón "COMBATIR"
        JButton combatButton = new JButton("COMBATIR");
        frame.add(combatButton, BorderLayout.SOUTH);

        // Hacer visible el JFrame
        frame.setVisible(true);
    }
}
