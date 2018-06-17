/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Productos;
import model.Usuario;

/**
 *
 * @author Soe
 */
public class UsuariosDao implements IDao<Usuario, Integer>{
    final String INSERT="INSERT INTO CLIENTE(nombre, email, clave) VALUES(?,?,?)";
    final String UPDATE="UPDATE CLIENTE SET(nombre=?, email=?, clave=?) where id=?";
    final String SELECT="SELECT * FROM CLIENTE";
    final String SELECTIONE="SELECT * FROM CLIENTE WHERE id=?";
    final String DELETE="DELETE FROM CLIENTE WHERE id=?";
    Connection conectate=null;
    
        public UsuariosDao(Connection connect){
            this.conectate= connect;
    }
        public int Insertar(Usuario usser) throws SQLException{
            com.mysql.jdbc.PreparedStatement stat=null;
            try{
                stat=(com.mysql.jdbc.PreparedStatement)conectate.prepareStatement(INSERT);
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
        public int Actualizar(Usuario usser) throws SQLException{
            com.mysql.jdbc.PreparedStatement stat=null;
            try{
                stat=(com.mysql.jdbc.PreparedStatement)conectate.prepareStatement(UPDATE);
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
        public List<Usuario> Seleccionar() {
            com.mysql.jdbc.PreparedStatement stat=null;     
            try {
                ResultSet result=stat.executeQuery();
                stat=(com.mysql.jdbc.PreparedStatement)conectate.prepareStatement(SELECT);
                List<Usuario> LUsuario = new ArrayList<Usuario>();
                while(result.next()){
                    Usuario ussu = new Usuario();
                    ussu.setClave(result.getString("password"));
                    ussu.setNombre(result.getString("nombre"));
                    ussu.setEmail(result.getString("mail"));
                    LUsuario.add(ussu);
                }
                return LUsuario;
            } catch (SQLException ex) {
                Logger.getLogger(UsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
        public Usuario SeleccionarUno(int id){
            com.mysql.jdbc.PreparedStatement stat=null;
            Usuario usser=new Usuario();
            try{
                stat=(com.mysql.jdbc.PreparedStatement)conectate.prepareStatement(SELECTIONE);
                stat.setInt(1, id);
                ResultSet result=stat.executeQuery();
            }catch(SQLException ex){
                Logger.getLogger(UsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return usser;
        }
        public void Eliminar(int id) throws SQLException{
            com.mysql.jdbc.PreparedStatement stat=null;
            stat=(com.mysql.jdbc.PreparedStatement) conectate.prepareStatement(DELETE);
            stat.setInt(1, id);
            stat.executeUpdate();
        }
}
