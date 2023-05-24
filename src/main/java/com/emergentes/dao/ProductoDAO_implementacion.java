package com.emergentes.dao;

import com.emergentes.modelo.Producto;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO_implementacion extends ConexionBD implements ProductoDAO {

    @Override
    public void Insertar(Producto producto) throws Exception {
        this.Conectar();
        String insertar = "INSERT INTO productos(descripcion, cantidad, precio, categoria) values(?, ?, ?, ?)";
        try ( PreparedStatement ps = this.connection.prepareStatement(insertar)) {
            ps.setString(1, producto.getDescripcion());
            ps.setInt(2, producto.getCantidad());
            ps.setFloat(3, producto.getPrecio());
            ps.setString(4, producto.getCategoria());
            ps.executeUpdate();
        }
    }

    @Override
    public void Actualizar(Producto producto) throws Exception {
        this.Conectar();
        String actualizar = "UPDATE productos SET descripcion = ?, cantidad = ?, precio = ?, categoria = ? where id = ?";
        try ( PreparedStatement ps = this.connection.prepareStatement(actualizar)) {
            ps.setString(1, producto.getDescripcion());
            ps.setInt(2, producto.getCantidad());
            ps.setFloat(3, producto.getPrecio());
            ps.setString(4, producto.getCategoria());
            ps.setInt(5, producto.getId());
            ps.executeUpdate();
        }
    }

    @Override
    public void Eliminar(int id) throws Exception {
        this.Conectar();
        String eliminar = "DELETE FROM productos WHERE id = ?";
        try ( PreparedStatement ps = this.connection.prepareStatement(eliminar)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public Producto obtenerProducto(int id) throws Exception {
        this.Conectar();
        String obtener = "SELECT * FROM productos WHERE id = ?";
        Producto producto;
        try ( PreparedStatement ps = this.connection.prepareStatement(obtener)) {
            ps.setInt(1, id);
            try ( ResultSet rs = ps.executeQuery()) {
                producto = new Producto();
                if (rs.next()) {
                    producto.setId(rs.getInt("id"));
                    producto.setDescripcion(rs.getString("descripcion"));
                    producto.setCantidad(rs.getInt("cantidad"));
                    producto.setPrecio(rs.getFloat("precio"));
                    producto.setCategoria(rs.getString("categoria"));
                } else {
                    System.out.println("No se encontro registro");
                }
            }
        }
        return producto;
    }

    @Override
    public List<Producto> obtenerProductos() throws Exception {
        this.Conectar();
        String sql = "SELECT * FROM productos";
        ArrayList<Producto> productos;
        try ( PreparedStatement ps = this.connection.prepareStatement(sql);  ResultSet rs = ps.executeQuery()) {
            productos = new ArrayList<>();
            while (rs.next()) {
                Producto producto = new Producto(
                    rs.getInt("id"),
                    rs.getString("descripcion"),
                    rs.getInt("cantidad"),
                    rs.getFloat("precio"),
                    rs.getString("categoria")
                );
                productos.add(producto);
            }
        }
        return productos;
    }
    
}
