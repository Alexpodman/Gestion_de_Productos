<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo</title>
    </head>
    <body>
        <header>
            <h1>Nuevo Producto</h1>
        </header>
        <main>
            <form action="ControladorPrincipal" method="post">
                <input type="hidden" name="id" value="0">
                <table>
                    <tr>
                        <td>Descripcion</td>
                        <td><input type="text" name="descripcion"></td>
                    </tr>
                    <tr>
                        <td>Cantidad</td>
                        <td>
                            <input type="text" name="cantidad">
                        </td>
                    </tr>
                    <tr>
                        <td>Precio</td>
                        <td>
                            <input type="text" name="precio">
                        </td>
                    </tr>
                    <tr>
                        <td>Categoria</td>
                        <td>
                            <input type="text" name="categoria">
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Agregar"></td>
                    </tr>
                </table>
            </form>
        </main>
    </body>
</html>
