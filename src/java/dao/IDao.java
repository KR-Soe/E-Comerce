/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.util.List;
import model.Productos;

/**
 *
 * @author Soe
 */
public interface IDao<T, KEY> {
    public int Insertar (T product);
    public int Actualizar (T product);
    public List<T> Seleccionar();
    public T SeleccionarUno(KEY id);
    public int Eliminar (KEY id);
}
