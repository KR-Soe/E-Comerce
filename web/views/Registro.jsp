<%-- 
    Document   : Registro
    Created on : 15-06-2018, 11:38:22
    Author     : Soe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuarios</title>
    </head>
    <body>
        <h1>REGISTRO DE USUARIO</h1>
        <div> Formulario:
            <form action="/VentaBebidas/Controller/registrarUsuario.jsp" method="POST">
                <ul>
                    <li>Nombre Usuario: <input placeholder="Username" type="text" name="user"</li>
                    <li>Clave: <input placeholder="Contraseña" type="password" name="clave"</li>
                    <li>Email: <input placeholder="Email" type="text" name="email"</li>
                    <button>Aceptar</button>
                </ul>
            </form>
        </div>
    </body>
</html>
