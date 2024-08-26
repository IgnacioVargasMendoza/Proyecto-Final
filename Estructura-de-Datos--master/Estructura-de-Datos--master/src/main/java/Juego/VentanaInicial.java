package Juego;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import javax.swing.JFrame;

public class VentanaInicial extends JFrame {

    public VentanaInicial() {
        setTitle("Pokémon Battle");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JButton iniciarJuegoButton = new JButton("Iniciar Juego");
        add(iniciarJuegoButton, BorderLayout.CENTER);

        iniciarJuegoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaConfiguracion().setVisible(true);
                dispose(); 
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaInicial().setVisible(true);
            }
        });
    }
}
