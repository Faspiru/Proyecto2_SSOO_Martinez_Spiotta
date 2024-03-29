/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Clases.ArtificialIntelligence;
import Clases.OS;

/**
 *
 * @author fabriziospiotta
 */
public class winnersInterface extends javax.swing.JFrame {

    static OS so;
    static ArtificialIntelligence ai;
    
    /**
     * Creates new form winnersInterface
     */
    public winnersInterface(OS so, ArtificialIntelligence ai) {
        initComponents();
        so = so;
        ai = ai;
        ai.setGanadoresTextArea(colaGanadores);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        listaLabel = new javax.swing.JLabel();
        colaGanadores = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listaLabel.setFont(new java.awt.Font("Phosphate", 0, 18)); // NOI18N
        listaLabel.setForeground(new java.awt.Color(0, 0, 0));
        listaLabel.setText("LISTA DE GANADORES");
        jPanel1.add(listaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 170, 70));

        colaGanadores.setEditable(false);
        colaGanadores.setBackground(new java.awt.Color(204, 204, 204));
        colaGanadores.setColumns(20);
        colaGanadores.setFont(new java.awt.Font("PT Sans", 1, 12)); // NOI18N
        colaGanadores.setForeground(new java.awt.Color(0, 0, 0));
        colaGanadores.setLineWrap(true);
        colaGanadores.setRows(5);
        colaGanadores.setWrapStyleWord(true);
        colaGanadores.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(colaGanadores, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 650, 60));

        jPanel2.setBackground(new java.awt.Color(153, 102, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon("/Users/fabriziospiotta/Documents/Sistemas Operativos/Proyecto2_SSOO_Martinez_Spiotta/Proyecto2_SSOO_Martinez_Spiotta/src/Imagenes/avatarPosterFondo.png")); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 430));

        jPanel3.setBackground(new java.awt.Color(102, 102, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon("/Users/fabriziospiotta/Documents/Sistemas Operativos/Proyecto2_SSOO_Martinez_Spiotta/Proyecto2_SSOO_Martinez_Spiotta/src/Imagenes/posterRigby.png")); // NOI18N
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 350, 430));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea colaGanadores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel listaLabel;
    // End of variables declaration//GEN-END:variables
}
