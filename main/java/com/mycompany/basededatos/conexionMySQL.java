/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author ErickJimz
 */
public class conexionMySQL {
    // Tu amigo le puso de nombre a la base de datos "TercerParcial"
    public String db = "TercerParcial"; 
    public String url = "jdbc:mysql://localhost:3306/" + db;
    public String usuario = "root";
    public String pass = "Matadorpollo123@_er";
    
    public conexionMySQL() {
    }
    
    public Connection Conectar() {
        Connection enlace = null;
        try {
            // Este es el puente entre Java y MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            enlace = DriverManager.getConnection(this.url, this.usuario, this.pass);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos:\n" + e);
        }
        return enlace;
    }
}