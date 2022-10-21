<%-- 
    Document   : register
    Created on : 01/10/2022, 05:10:23 PM
    Author     : NModem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Update form</title>
    </head>
    <body>
        <h1>Complete the fields</h1>

        <form action="<%= request.getContextPath()%>/UserUpdateServlet" method="post">
            <table style="width:80%">
                <tr>

                    <td>Correo</td>
                    <td><input type="text" name="correo" /></td>
                </tr>
                <tr>
                    <td>Contraseña</td>
                    <td><input type="password" name="passwordd" /></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Recuperar" /></td>
                </tr>
            </table>
        </form>
        <ol>
            <a href="<%= request.getContextPath()%>/UserSesionServlet">Volver</a>
            <br>
        </ol>
    </body>
</html>
