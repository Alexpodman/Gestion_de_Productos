package com.emergentes.controlador;

import com.emergentes.dao.ProductoDAO;
import com.emergentes.dao.ProductoDAO_implementacion;
import com.emergentes.modelo.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControladorPrincipal", urlPatterns = {"/ControladorPrincipal"})
public class ControladorPrincipal extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String opcion = request.getParameter("opcion");
            ProductoDAO dao = new ProductoDAO_implementacion();
            int id;
            Producto producto = new Producto();
            List<Producto> productos;
            
            if (opcion != null) {
                System.out.println("action: " + opcion);
            } else {
                opcion = "productos";
            }
            
            switch (opcion) {
                case "productos":
                    productos = dao.obtenerProductos();
                    request.setAttribute("productos", productos);
                    request.getRequestDispatcher("productos.jsp").forward(request, response);
                    break;
                case "nuevo":
                    request.getRequestDispatcher("nuevo.jsp").forward(request, response);
                    break;
                case "editar":
                    id = Integer.parseInt(request.getParameter("id"));
                    producto = dao.obtenerProducto(id);
                    request.setAttribute("producto", producto);
                    request.getRequestDispatcher("editar.jsp").forward(request, response);        
                    break;
                case "eliminar":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.Eliminar(id);
                    response.sendRedirect("ControladorPrincipal");
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String descripcion = request.getParameter("descripcion");
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        float precio = Float.parseFloat(request.getParameter("precio"));
        String categoria = request.getParameter("categoria");
        ProductoDAO dao = new ProductoDAO_implementacion();
        Producto producto = new Producto(id, descripcion, cantidad, precio, categoria);
        try {
            if (id == 0) {
                dao.Insertar(producto);
            } else {
                dao.Actualizar(producto);
            }
        } catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        }
        response.sendRedirect("ControladorPrincipal");
    }

}
