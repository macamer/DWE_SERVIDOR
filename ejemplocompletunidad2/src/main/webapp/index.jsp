<%-- 
    Document   : index
    Created on : 18 sept 2024, 15:52:31
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Entrada de datos</title>
    </head>
    <body>
        <h1>Entrada de datos</h1>
        <form action="RecogeDatosServlet" method="POST">
            <h2>Datos de alumnos</h2>
            Nombre: <input type="text" name="nombre"><br>
            Primer Apellido: <input type="text" name="primerApellido"><br>
            Segundo Apellido: <input type="text" name="segundoApellido"><br>
            Edad: <input type="text" name="edad"><br>
            <input type="submit" value="Enviar">
        </form>
    </body>
</html>
