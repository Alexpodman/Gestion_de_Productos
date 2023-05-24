<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar</title>
    </head>
    <body>
        <header>
            <h1>Editar Producto</h1>
        </header>
        <main>
            <form action="ControladorPrincipal" method="post">
                <input type="hidden" name="id" value="${producto.id}">
                <table>
                    <tr>
                        <td>Descripcion</td>
                        <td><input type="text" name="descripcion" value="${producto.descripcion}"></td>
                    </tr>
                    <tr>
                        <td>Cantidad</td>
                        <td>
                            <input type="text" name="cantidad" value="${producto.cantidad}">
                        </td>
                    </tr>
                    <tr>
                        <td>Precio</td>
                        <td>
                            <input type="text" name="precio" value="${producto.precio}">
                        </td>
                    </tr>
                    <tr>
                        <td>Categoria</td>
                        <td>
                            <input type="text" name="categoria" value="${producto.categoria}">
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Guardar"></td>
                    </tr>
                </table>
            </form>
        </main>
    </body>
</html>
