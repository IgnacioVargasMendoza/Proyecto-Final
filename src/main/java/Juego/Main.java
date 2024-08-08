package Juego;



public class Main {
    public static void main(String[] args) {
        // Crear e iniciar la ventana inicial
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new VentanaInicial().setVisible(true);
            }
        });
    }
}
