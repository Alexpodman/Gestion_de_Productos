package com.emergentes.dao;

import com.emergentes.modelo.Producto;
import java.util.List;

public interface ProductoDAO {
    public void Insertar(Producto producto) throws Exception;
    public void Actualizar(Producto producto) throws Exception;
    public void Eliminar(int id) throws Exception;
    public Producto obtenerProducto(int id) throws Exception;
    public List<Producto> obtenerProductos() throws Exception;
}
