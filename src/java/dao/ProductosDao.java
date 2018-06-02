/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import model.Productos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Soe
 */
public class ProductosDao implements IDao<Productos, Integer>{
    final String INSERT="INSERT INTO PRODUCTOS(nombre, precio, stock) VALUES(?,?,?)";
    final String UPDATE="UPDATE PRODUCTOS SET(nombre=?, precio=?, stock=?) where id=?";
    final String SELECT="SELECT * FROM PRODUCTOS";
    final String SELECTIONE="SELECT * FROM PRODUCTOS WHERE id=?";
    final String DELETE="DELETE FROM PRODUCTOS WHERE id=?";
    Connection conexion=null;
    
        public ProductosDao(Connection connect){
            this.conexion= conexion;
    }
        public int Insert(Productos product) throws SQLException{
            com.mysql.jdbc.PreparedStatement stat=null;
            try{
                stat=(com.mysql.jdbc.PreparedStatement)conexion.prepareStatement(INSERT);
                stat.setString(1, product.getNombre());
                stat.setInt(2, product.getPrecio());
                stat.setInt(3, product.getStock());
                return stat.executeUpdate();
            }catch(SQLException ex){
                Logger.getLogger(UsuariosDao.class.getName()).log(Level.SEVERE, null, ex);
                return 0;
            }
            
        }
        public int Update(Productos product) throws SQLException{
            com.mysql.jdbc.PreparedStatement stat=null;
            try{
                stat=(com.mysql.jdbc.PreparedStatement)conexion.prepareStatement(UPDATE);
                stat.setString(1, product.getNombre());
                stat.setInt(2, product.getPrecio());
                stat.setInt(3, product.getStock());
                stat.setInt(4, product.getId());
                return stat.executeUpdate();
            }catch(SQLException ex){
                Logger.getLogger(ProductosDao.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(ProductosDao.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
        public Productos SelectOne(int id){
            com.mysql.jdbc.PreparedStatement stat=null;
            Productos product= new Productos();
            try{
                stat=(com.mysql.jdbc.PreparedStatement)conexion.prepareStatement(SELECTIONE);
                stat.setInt(1, id);
                ResultSet result=stat.executeQuery();
            }catch(SQLException ex){
                Logger.getLogger(ProductosDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return product;
        }
        public int Delete(int id) throws SQLException{
            com.mysql.jdbc.PreparedStatement stat=null;
            try{
            stat=(com.mysql.jdbc.PreparedStatement) conexion.prepareStatement(DELETE);
            stat.setInt(1, id);
            return stat.executeUpdate();
            }catch(SQLException ex){
                Logger.getLogger(ProductosDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return 0;
        }

    @Override
    public int Insertar(Productos product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int Actualizar(Productos product) {
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


