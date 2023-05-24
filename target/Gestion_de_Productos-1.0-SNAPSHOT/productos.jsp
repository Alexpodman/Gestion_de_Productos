<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Productos</title>
    </head>
    <body>
        <header>
            <div>
                <table border="1" cellspacing="0">
                    <tr>
                        <td>
                            <p>SEGUNDO PARCIAL TEM-742</p>
                            <p><b>Nombre Completo:</b> Freddy Alejandro Ticona Alanoca</p>
                            <p><b>Carnet:</b> 12699774 LP</p>
                        </td>
                    </tr>
                </table>
            </div>
            <div>
                <h1><b>Gestión de Productos</b></h1>
            </div>
        </header>
        <nav>
            <form action="ControladorPrincipal" method="get">
                <input type="hidden" name="opcion" value="nuevo">
                <input type="submit" value="Nuevo Producto">
            </form>
        </nav>
        <main>
            <div>
                <table border="1" cellspacing="0">
                    <tr>
                        <th>Id</th>
                        <th>Descripción</th>
                        <th>Cantidad</th>
                        <th>Precio</th>
                        <th>Categoría</th>
                        <th colspan="2">Modificar</th>
                    </tr>
                    <c:forEach var="item" items="${productos}">
                        <tr>
                            <th>${item.id}</th>
                            <th>${item.descripcion}</th>
                            <th>${item.cantidad}</th>
                            <th>${item.precio}</th>
                            <th>${item.categoria}</th>
                            <th>
                                <form action="ControladorPrincipal" method="get">
                                    <input type="hidden" name="opcion" value="editar">
                                    <input type="hidden" name="id" value="${item.id}">
                                    <input type="submit" value="Editar">
                                </form>
                            </th>
                            <th>
                                <form action="ControladorPrincipal" method="get">
                                    <input type="hidden" name="opcion" value="eliminar">
                                    <input type="hidden" name="id" value="${item.id}">
                                    <input type="submit" value="Eliminar">
                                </form>
                            </th>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </main>
    </body>
</html>
