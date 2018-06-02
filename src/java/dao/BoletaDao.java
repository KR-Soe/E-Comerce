/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Boleta;
import model.Usuario;

/**
 *
 * @author Soe
 */
public class BoletaDao {
    final String INSERT="INSERT INTO BOLETA(fecha, montototal) VALUES(?,?)";
    final String UPDATE="UPDATE BOLETA SET(fecha=?, montototal=?) where id=?";
    final String SELECT="SELECT * FROM BOLETA";
    final String SELECTIONE="SELECT * FROM BOLETA WHERE id=?";
    final String DELETE="DELETE FROM BOLETA WHERE id=?";
    Connection conexion=null;
    
        public BoletaDao(Connection connect){
            this.conexion= conexion;
    }
        public int Insert(Boleta bole) throws SQLException{
            com.mysql.jdbc.PreparedStatement stat=null;
            try{
                stat=(com.mysql.jdbc.PreparedStatement)conexion.prepareStatement(INSERT);
                stat.setString(1, bole.getFecha());
                stat.setInt(2, bole.getMontoTotal());
                return stat.executeUpdate();
            }catch(SQLException ex){
                Logger.getLogger(BoletaDao.class.getName()).log(Level.SEVERE, null, ex);
                return 0;
            }
            
        }
        public int Update(Boleta bole) throws SQLException{
            com.mysql.jdbc.PreparedStatement stat=null;
            try{
                stat=(com.mysql.jdbc.PreparedStatement)conexion.prepareStatement(UPDATE);
                stat.setString(1, bole.getFecha());
                stat.setInt(2, bole.getMontoTotal());
                return stat.executeUpdate();
            }catch(SQLException ex){
                Logger.getLogger(BoletaDao.class.getName()).log(Level.SEVERE, null, ex);
                return 0;
            }
        }
        public ResultSet Select() {
            com.mysql.jdbc.PreparedStatement stat=null;     
            try {
                ResultSet result=stat.executeQuery();
                stat=(com.mysql.jdbc.PreparedStatement)conexion.prepareStatement(SELECT);
                return result;
            } catch (SQLException ex) {
                Logger.getLogger(BoletaDao.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
        public Boleta SelectOne(int id){
            com.mysql.jdbc.PreparedStatement stat=null;
            Boleta bole=new Boleta();
            try{
                stat=(com.mysql.jdbc.PreparedStatement)conexion.prepareStatement(SELECTIONE);
                stat.setInt(1, id);
                ResultSet result=stat.executeQuery();
            }catch(SQLException ex){
                Logger.getLogger(UsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return bole;
        }
        public void Delete(int id) throws SQLException{
            com.mysql.jdbc.PreparedStatement stat=null;
            stat=(com.mysql.jdbc.PreparedStatement) conexion.prepareStatement(DELETE);
            stat.setInt(1, id);
            stat.executeUpdate();
        }
}
