package com.mycompany.basededatos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author ErickJimz
 */
public class myDesktop extends javax.swing.JFrame {

    // Declaración de los componentes de diseño de tu amigo
    private javax.swing.JDesktopPane DesktopPanel;
    private javax.swing.JButton btnConsulta;
    private javax.swing.JButton btnToolRegistro;
    private javax.swing.JToolBar jToolBar2;
 
    public myDesktop() {
        // Inicialización manual de los componentes de diseño
        jToolBar2 = new javax.swing.JToolBar();
        btnToolRegistro = new javax.swing.JButton();
        btnConsulta = new javax.swing.JButton();
        DesktopPanel = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventana Principal");

        jToolBar2.setRollover(true);

        // Configuración del botón Add
        btnToolRegistro.setText("Add");
        btnToolRegistro.setFocusable(false);
        btnToolRegistro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnToolRegistro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnToolRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnToolRegistroActionPerformed(evt);
            }
        });
        jToolBar2.add(btnToolRegistro);

        // Configuración del botón Query
        btnConsulta.setText("Query");
        btnConsulta.setFocusable(false);
        btnConsulta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnConsulta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnConsulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnConsultaActionPerformed(evt);
            }
        });
        jToolBar2.add(btnConsulta);

        // Configuración del Layout del panel interno
        javax.swing.GroupLayout DesktopPanelLayout = new javax.swing.GroupLayout(DesktopPanel);
        DesktopPanel.setLayout(DesktopPanelLayout);
        DesktopPanelLayout.setHorizontalGroup(
            DesktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        DesktopPanelLayout.setVerticalGroup(
            DesktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 297, Short.MAX_VALUE)
        );

        // Configuración del Layout de la ventana principal
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DesktopPanel)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DesktopPanel)
                .addContainerGap())
        );

        pack();
        this.setLocationRelativeTo(null);
        this.setExtendedState(myDesktop.MAXIMIZED_BOTH); // Pantalla completa
    }

    // Acción para abrir tu ventana de Registro
    private void btnToolRegistroActionPerformed(java.awt.event.ActionEvent evt) {                                                
        BaseDeDatos rg = new BaseDeDatos();
        this.DesktopPanel.add(rg);
        rg.show();
    }                                               

    // Acción para abrir tu ventana de Consulta
    private void btnConsultaActionPerformed(java.awt.event.ActionEvent evt) {                                            
        MyQuery mq = new MyQuery();
        this.DesktopPanel.add(mq);
        mq.show();
    }                                           

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(myDesktop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new myDesktop().setVisible(true));
    }
}