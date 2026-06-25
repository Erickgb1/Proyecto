package com.mycompany.basededatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author ErickJimz
 */ 
public class MyQuery extends javax.swing.JInternalFrame {
    DefaultTableModel tabla; //

    /**
     * Creates new form MyQuery
     */
    public MyQuery() {
        initComponents();
        
        // REQUISITO 2 DEL PDF: Asignación manual del clic a la tabla en tu JClass
        tblRegistros.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRegistrosMouseClicked(evt);
            }
        });
    }

    // REQUISITO 1 DEL PDF: Método para consultar y filtrar datos en la tabla
    void ConsultarDatos(String dato){
        String[] encabezado = {"Nombre", "Dirección", "Email"}; //
        String[] filas = new String[3]; //
        String senSQL = "";
        
        // CORRECCIÓN SOLUCIÓN: Inicializar tabla para evitar NullPointerException
        tabla = new DefaultTableModel(null, encabezado); //
        
        conexionMySQL cmysql = new conexionMySQL();
        Connection conec = cmysql.Conectar(); //
        
        // CORRECCIÓN SQL: Se quitó la coma rota de tu SELECT original y se cerró el CONCAT
        senSQL = "SELECT Nombre, Direccion, Email FROM agenda " +
                 "WHERE CONCAT(Nombre, ' ', Direccion, ' ', Email) LIKE '%" + dato + "%'"; //
        
        try{
            Statement st = conec.createStatement(); //
            ResultSet rs = st.executeQuery(senSQL); //
            
            while(rs.next()){
                filas[0] = rs.getString("Nombre"); //
                filas[1] = rs.getString("Direccion"); //
                filas[2] = rs.getString("Email"); //
                
                tabla.addRow(filas); //
            }
            this.tblRegistros.setModel(tabla); //
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex); //
        }
    }
    
    // REQUISITO 2 DEL PDF: Evento que captura el renglón seleccionado y abre la edición (Pág 4)
    private void tblRegistrosMouseClicked(java.awt.event.MouseEvent evt) {                                          
        int registro = tblRegistros.getSelectedRow(); //
        try {
            tabla = (DefaultTableModel) tblRegistros.getModel(); //
            String ids = (String) tabla.getValueAt(registro, 0); //
            
            VentanaEdicion edicion = new VentanaEdicion(this); //
            edicion.EditarDatos(ids); //
            edicion.setVisible(true); //
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex); //
        }
    }                                         
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        panConsulta = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtDato = new javax.swing.JTextField();
        btnBusqueda = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegistros = new javax.swing.JTable();

        jLabel1.setText("Ingrese Busqueda");

        btnBusqueda.setText("Search"); //
        btnBusqueda.addActionListener(this::btnBusquedaActionPerformed);

        btnMostrar.setText("Show All"); //
        btnMostrar.addActionListener(this::btnMostrarActionPerformed);

        tblRegistros.setForeground(new java.awt.Color(0, 204, 0));
        tblRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblRegistros.setShowHorizontalLines(true);
        jScrollPane1.setViewportView(tblRegistros);

        javax.swing.GroupLayout panConsultaLayout = new javax.swing.GroupLayout(panConsulta);
        panConsulta.setLayout(panConsultaLayout);
        panConsultaLayout.setHorizontalGroup(
            panConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panConsultaLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDato, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBusqueda)
                        .addGap(35, 35, 35)
                        .addComponent(btnMostrar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        panConsultaLayout.setVerticalGroup(
            panConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBusqueda)
                    .addComponent(btnMostrar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(183, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(297, 297, 297))
        );

        pack();
    }// </editor-fold>                        

    private void btnBusquedaActionPerformed(java.awt.event.ActionEvent evt) {                                            
        String d = this.txtDato.getText(); //
        ConsultarDatos(d); //
    }                                           

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        String d = ""; //
        ConsultarDatos(d); //
    }                                          

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnBusqueda;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panConsulta;
    private javax.swing.JTable tblRegistros;
    private javax.swing.JTextField txtDato;
    // End of variables declaration                   
}

// REQUISITO 3 DEL PDF: La clase VentanaEdicion implementada por puro código para tu JClass (Págs 2-3)
class VentanaEdicion extends javax.swing.JFrame {
    private javax.swing.JTextField txtNom_up, txtDir_up, txtEmail_up; //
    private javax.swing.JButton btnActualizar, btnCancelar, btnEliminar; //
    private String id_actual = ""; //
    private MyQuery framePadre;

    public VentanaEdicion(MyQuery padre) {
        this.framePadre = padre;
        setTitle("Editar usuario seleccionado"); //
        setSize(450, 250); //
        setLocationRelativeTo(null); //
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);

        javax.swing.JPanel panelFormulario = new javax.swing.JPanel(new java.awt.GridLayout(3, 2, 10, 10)); //
        
        panelFormulario.add(new javax.swing.JLabel(" Nombre:")); //
        txtNom_up = new javax.swing.JTextField(); //
        panelFormulario.add(txtNom_up);

        panelFormulario.add(new javax.swing.JLabel(" Dirección:")); //
        txtDir_up = new javax.swing.JTextField(); //
        panelFormulario.add(txtDir_up);

        panelFormulario.add(new javax.swing.JLabel(" Email:")); //
        txtEmail_up = new javax.swing.JTextField(); //
        panelFormulario.add(txtEmail_up);

        btnActualizar = new javax.swing.JButton("Actualizar"); //
        btnEliminar = new javax.swing.JButton("Eliminar"); //
        btnCancelar = new javax.swing.JButton("Cancelar"); //

        javax.swing.JPanel panelBotones = new javax.swing.JPanel(); //
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnCancelar);

        this.setLayout(new java.awt.BorderLayout(10, 10));
        this.add(panelFormulario, java.awt.BorderLayout.CENTER);
        this.add(panelBotones, java.awt.BorderLayout.SOUTH);

        // Listeners vinculados por código
        btnActualizar.addActionListener(e -> btnActualizarActionPerformed()); //
        btnCancelar.addActionListener(e -> this.setVisible(false)); //
        btnEliminar.addActionListener(e -> btnEliminarActionPerformed()); //
    }

    // REQUISITO 4 DEL PDF: Método para buscar y cargar los datos del renglón clicado (Pág 5)
    public void EditarDatos(String ids) {
        String senSQL = "SELECT Nombre, Direccion, Email FROM agenda WHERE Nombre='" + ids + "'"; //
        conexionMySQL cmysql = new conexionMySQL();
        Connection conec = cmysql.Conectar(); //
        try {
            Statement st = conec.createStatement(); //
            ResultSet rs = st.executeQuery(senSQL); //
            if(rs.next()){
                this.txtNom_up.setText(rs.getString("Nombre")); //
                this.txtDir_up.setText(rs.getString("Direccion")); //
                this.txtEmail_up.setText(rs.getString("Email")); //
                id_actual = ids; //
            }
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex); //
        }
    }

    // REQUISITO 5 DEL PDF: Método de Modificación (UPDATE SQL - Pág 6)
    private void btnActualizarActionPerformed() {
        conexionMySQL cn = new conexionMySQL();
        Connection conec = cn.Conectar(); //
        String nom = this.txtNom_up.getText(); //
        String dir = this.txtDir_up.getText(); //
        String email = this.txtEmail_up.getText(); //
        
        String senSQL = "UPDATE agenda SET Nombre=?, Direccion=?, Email=? WHERE Nombre='" + this.id_actual + "'"; //
        try {
            PreparedStatement ps = conec.prepareStatement(senSQL); //
            ps.setString(1, nom); //
            ps.setString(2, dir); //
            ps.setString(3, email); //
            int n = ps.executeUpdate(); //
            if(n > 0){
                JOptionPane.showMessageDialog(null, "Los datos se han Modificado en la Base de Datos"); //
                framePadre.ConsultarDatos(""); // Refresca la tabla automáticamente
            }
            this.dispose(); //
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex); //
        }
    }

    // REQUISITO 6 DEL PDF: Método de Borrado (DELETE SQL - Pág 7)
    private void btnEliminarActionPerformed() {
        conexionMySQL cmysql = new conexionMySQL();
        Connection conec = cmysql.Conectar(); //
        int sale = JOptionPane.showConfirmDialog(this,
                "¿Desea Eliminar el registro seleccionado?",
                "Confirmar Eliminar Registro", JOptionPane.OK_CANCEL_OPTION); //
        if(sale == 0) { //
            String senSQL = "DELETE FROM agenda WHERE Nombre='" + id_actual + "'"; //
            try {
                PreparedStatement ps = conec.prepareStatement(senSQL); //
                int n = ps.executeUpdate(); //
                this.txtNom_up.setText(""); //
                this.txtDir_up.setText(""); //
                this.txtEmail_up.setText(""); //
                JOptionPane.showMessageDialog(null, "Los datos se han Eliminado Satisfactoriamente"); //
                this.dispose(); //
                framePadre.ConsultarDatos(""); // Refresca la tabla automáticamente
            } catch(SQLException ex) {
                JOptionPane.showMessageDialog(null, ex); //
            }
        }
    }
}