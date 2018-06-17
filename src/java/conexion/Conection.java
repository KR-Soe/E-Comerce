/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Productos;

/**
 *
 * @author Soe
 */
public class Conection {
    Productos product= new Productos();
    String host="jdbc:mysql://localhost:3306/";
    String db="ventabebidas";
    String user="root";
    String clave="";
    private Connection conexion=null;
    
    public Conection(){
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        } catch (SQLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Cerrar() throws SQLException{
        conexion.close();
    }
    
    public Connection getConnection(){
        return conexion;
    }
}
