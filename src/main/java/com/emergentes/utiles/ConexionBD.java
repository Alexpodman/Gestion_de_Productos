package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionBD {
    static public String driver = "com.mysql.jdbc.Driver";
    static public String url = "jdbc:mysql://localhost:3306/bd_almacen";
    static public String user = "root";
    static public String pass = "19990809";
    
    protected Connection connection = null;
    
    public ConexionBD() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Conector listo");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error del controlador");
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error de conexión");
        }
    }
    
    public Connection Conectar() {
        return connection;
    }
    
    public void Desconectar() {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al cerrar conexión");
        }
    }
}
