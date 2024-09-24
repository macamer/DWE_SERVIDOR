<%-- 
    Document   : process
    Created on : 15 sept 2024, 19:20:57
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- JavaBean -->
<jsp:useBean id="usuario" scope="request" class="com.mycompany.ejemploformulariojavabean.entities.Usuario" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Prueba de formualrios JavaBeans con JSP</title>
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
        <!-- Scriptlet JSP -->
            <%String nombre, email;
            nombre = request.getParameter("nombre");
            email = request.getParameter("email");
            %>
            <jsp:setProperty name="usuario" property="nombre" value="<%=nombre%>"></jsp:setProperty>
            <jsp:setProperty name="usuario" property="email" value="<%=email%>"></jsp:setProperty>
            <jsp:forward page="/process2.jsp"></jsp:forward>

        <%}%>
    </body>
</html>
