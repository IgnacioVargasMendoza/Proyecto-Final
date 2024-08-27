/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Juego;

import Pokemon.Pokemon;
import Torneo.ArbolTorneo;
import com.Jugadores.Jugador;

/**
 *
 * @author Ignac
 */
public class VentanaBatalla2 extends javax.swing.JFrame {

    /**
     * Creates new form VentanaBatalla2
     */
    private Pokemon pokemonActualJugador;
    private Pokemon pokemonActualCPU;
    Jugador jugador;
    Jugador cpu;
    ArbolTorneo torneo;

    public VentanaBatalla2(Jugador jugador, Jugador cpu, ArbolTorneo torneo) {
        this.jugador = jugador;
        this.cpu = cpu;
        this.torneo = torneo;
    

        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        panelJugador = new javax.swing.JPanel();
        jPkmJugadorVida = new javax.swing.JLabel();
        jPkmJugadorNombre = new javax.swing.JLabel();
        panelJugador1 = new javax.swing.JPanel();
        jPkmCPUNombre = new javax.swing.JLabel();
        jPkmCPUVida = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabelPkmJugadorNombre = new javax.swing.JLabel();
        JPkmCPUNombre = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setForeground(new java.awt.Color(51, 51, 51));

        panelJugador.setBackground(new java.awt.Color(51, 51, 51));

        jPkmJugadorVida.setText("Vida");

        jPkmJugadorNombre.setText("Nombre: ");

        javax.swing.GroupLayout panelJugadorLayout = new javax.swing.GroupLayout(panelJugador);
        panelJugador.setLayout(panelJugadorLayout);
        panelJugadorLayout.setHorizontalGroup(
            panelJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJugadorLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPkmJugadorNombre)
                    .addComponent(jPkmJugadorVida))
                .addContainerGap(148, Short.MAX_VALUE))
        );
        panelJugadorLayout.setVerticalGroup(
            panelJugadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJugadorLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPkmJugadorNombre)
                .addGap(37, 37, 37)
                .addComponent(jPkmJugadorVida)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPkmCPUNombre.setText("Nombre: ");

        jPkmCPUVida.setText("Vida");

        javax.swing.GroupLayout panelJugador1Layout = new javax.swing.GroupLayout(panelJugador1);
        panelJugador1.setLayout(panelJugador1Layout);
        panelJugador1Layout.setHorizontalGroup(
            panelJugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJugador1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelJugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPkmCPUNombre)
                    .addComponent(jPkmCPUVida))
                .addContainerGap(156, Short.MAX_VALUE))
        );
        panelJugador1Layout.setVerticalGroup(
            panelJugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJugador1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jPkmCPUNombre)
                .addGap(47, 47, 47)
                .addComponent(jPkmCPUVida)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        jButton1.setText("Terminar Turno");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Ataque");

        jButton3.setText("Cambiar Pokemon");

        jButton4.setText("Ataque Especial");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabelPkmJugadorNombre.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPkmJugadorNombre.setText("Pokemon Jugador");

        JPkmCPUNombre.setForeground(new java.awt.Color(0, 0, 0));
        JPkmCPUNombre.setText("Pokemon CPU");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(panelJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(panelJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jLabelPkmJugadorNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JPkmCPUNombre)
                .addGap(117, 117, 117))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(39, 39, 39)
                        .addComponent(jButton4)
                        .addGap(34, 34, 34)
                        .addComponent(jButton1)
                        .addGap(86, 86, 86))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(253, 253, 253))))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPkmJugadorNombre)
                    .addComponent(JPkmCPUNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelJugador1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelJugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaBatalla2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaBatalla2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaBatalla2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaBatalla2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               /* new VentanaBatalla2().setVisible(true);*/
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JPkmCPUNombre;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabelPkmJugadorNombre;
    private javax.swing.JLabel jPkmCPUNombre;
    private javax.swing.JLabel jPkmCPUVida;
    private javax.swing.JLabel jPkmJugadorNombre;
    private javax.swing.JLabel jPkmJugadorVida;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel panelJugador;
    private javax.swing.JPanel panelJugador1;
    // End of variables declaration//GEN-END:variables
}
