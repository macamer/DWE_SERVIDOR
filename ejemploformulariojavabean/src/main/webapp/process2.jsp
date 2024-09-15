<%-- 
    Document   : process2
    Created on : 15 sept 2024, 20:13:32
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="usuario" scope="request" class="com.mycompany.ejemploformulariojavabean.entities.Usuario" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Información trsportada a través del JavaBean</title>
    </head>
    <body>
            <b>Usted indicó la siguiente información: </b>
            <br>
            <b>Nombre: </b>             
            <jsp:getProperty name="usuario" property="nombre"></jsp:getProperty>
            
            <br>
            <b>Email: </b> 
            <jsp:getProperty name="usuario" property="email"></jsp:getProperty> 
            <p>Este es el segundo JSP</p>
    </body>
</html>
