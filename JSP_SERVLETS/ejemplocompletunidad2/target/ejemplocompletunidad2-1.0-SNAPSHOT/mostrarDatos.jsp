<%-- 
    Document   : mostrarDatos
    Created on : 18 sept 2024, 16:12:17
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="alumnoAtrib" scope="request" class="com.mycompany.ejemplocompletunidad2.entities.Alumno" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Muestra de datos</title>
    </head>
    <body>
        <h1>El alumno introducido es: </h1>
        Nombre: <jsp:getProperty name="alumnoAtrib" property="nombre" /> <br>
        Primer Apellido:  <jsp:getProperty name="alumnoAtrib" property="primerApellido" /> <br>
        Segundo Apellido:  <jsp:getProperty name="alumnoAtrib" property="segundoApellido" /> <br>
        Edad: <jsp:getProperty name="alumnoAtrib" property="edad" />
    </body>
</html>
