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
import model.Productos;
import model.Usuario;

/**
 *
 * @author Soe
 */
public class UsuariosDao implements IDao<Usuario, Integer>{
    final String INSERT="INSERT INTO USUARIOS(nombre, precio, stock) VALUES(?,?,?)";
    final String UPDATE="UPDATE USUARIOS SET(nombre=?, precio=?, stock=?) where id=?";
    final String SELECT="SELECT * FROM USUARIOS";
    final String SELECTIONE="SELECT * FROM USUARIOS WHERE id=?";
    final String DELETE="DELETE FROM USUARIOS WHERE id=?";
    Connection conexion=null;
    
        public UsuariosDao(Connection connect){
            this.conexion= conexion;
    }
        public int Insert(Usuario usser) throws SQLException{
            com.mysql.jdbc.PreparedStatement stat=null;
            try{
                stat=(com.mysql.jdbc.PreparedStatement)conexion.prepareStatement(INSERT);
                stat.setString(1, usser.getNombre());
                stat.setString(2, usser.getEmail());
                stat.setString(3, usser.getClave());
                stat.setInt(4, usser.getId());
                return stat.executeUpdate();
            }catch(SQLException ex){
                Logger.getLogger(UsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
                return 0;
            }
            
        }
        public int Update(Usuario usser) throws SQLException{
            com.mysql.jdbc.PreparedStatement stat=null;
            try{
                stat=(com.mysql.jdbc.PreparedStatement)conexion.prepareStatement(UPDATE);
                stat.setString(1, usser.getNombre());
                stat.setString(2, usser.getClave());
                stat.setString(3, usser.getEmail());
                stat.setInt(4, usser.getId());
                return stat.executeUpdate();
            }catch(SQLException ex){
                Logger.getLogger(UsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(UsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
        public Usuario SelectOne(int id){
            com.mysql.jdbc.PreparedStatement stat=null;
            Usuario usser=new Usuario();
            try{
                stat=(com.mysql.jdbc.PreparedStatement)conexion.prepareStatement(SELECTIONE);
                stat.setInt(1, id);
                ResultSet result=stat.executeQuery();
            }catch(SQLException ex){
                Logger.getLogger(UsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return usser;
        }
        public void Delete(int id) throws SQLException{
            com.mysql.jdbc.PreparedStatement stat=null;
            stat=(com.mysql.jdbc.PreparedStatement) conexion.prepareStatement(DELETE);
            stat.setInt(1, id);
            stat.executeUpdate();
        }

    @Override
    public int Insertar(Usuario product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int Actualizar(Usuario product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Seleccionar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void SeleccionarUno(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int Eliminar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
