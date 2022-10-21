<%-- 
    Document   : index
    Created on : 09/10/2022, 02:21:38 PM
    Author     : NModem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Iniciar Sesión</h1>

        <form action="<%= request.getContextPath()%>/UserSesionServlet" method="post">
            <table style="width:80%">
                <tr>
                    <td>Correo Electrónico</td>
                    <td><input type="text" name="correo" /></td>
                </tr>
                <tr>
                    <td>Contraseña</td>
                    <td><input type="password" name="passwordd" /></td>
                </tr>
                
                <tr>
                    <td><input type="submit" value="Ingresar" /></td>
                </tr>
            </table>
        </form>


        <ol>
            <a href="<%= request.getContextPath()%>/UserServlet">Registrar Usuario</a>
            <br>
            <a href="<%= request.getContextPath()%>/UserUpdateServlet">Recuperar Contraseña</a> 

        </ol>
    </body>
</html>
