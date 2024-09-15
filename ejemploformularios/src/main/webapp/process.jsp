<%-- 
    Document   : process
    Created on : 15 sept 2024, 19:20:57
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Prueba de formualrios co JSP</title>
    </head>
    <body bgcolor="#ffffcc">
        <% if (
                (request.getParameter("nombre")==null) &&
                (request.getParameter("email")==null) ||
                (request.getParameter("nombre").equals("")) &&
                (request.getParameter("email").equals(""))
              ) { %>
           Complete este formulario
           <br>
           <form action="process.jsp" method="POST">
               Su nombre: <input type="text" name="nombre" size="30">
               <br>
               Su email: <input type="text" name="email" size="30">
               <br>
               <input type="submit" value="Enviar">
           </form>
        <%} else { %>
        No hace falta
        <%}%>
    </body>
</html>
