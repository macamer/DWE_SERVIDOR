<%-- 
    Document   : prueba_error
    Created on : 14 sept 2024, 9:39:57
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página JSP con error</title>
    </head>
    <body>
        <%= 0/0 %>
    </body>
</html>
