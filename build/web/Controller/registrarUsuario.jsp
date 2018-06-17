<%-- 
    Document   : registrarUsuario
    Created on : 15-06-2018, 11:14:32
    Author     : Soe
--%>
<%@page import="conexion.Conection"%>
<%@page import="java.sql.Connection"%>
<%@page import="model.Usuario"%>
<%@page import="dao.UsuariosDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Usuario user = new Usuario();
    Conection conn = new Conection();
    UsuariosDao userDao = new UsuariosDao(conn.getConnection());
    
    user.setNombre(request.getParameter("nombre"));
    user.setClave(request.getParameter("clave"));
    user.setEmail(request.getParameter("email"));
    
    int r=userDao.Insertar(user); 
    
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuarios</title>
    </head>
    <body>
        <h1>REGISTRO USUARIOS</h1>
        <%= user.getNombre() %>
        <%= user.getEmail() %>
        <%= user.getClave() %>
    </body>
</html>
