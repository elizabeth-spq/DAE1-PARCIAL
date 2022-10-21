package pe.isil.parcialappjsp.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pe.isil.parcialappjsp.user.dao.UserDao;
import pe.isil.parcialappjsp.user.model.User;

@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserDao userDao = new UserDao();
        int rowsAffected = 0;
        String mensaje = "";

        String correo = request.getParameter("correo");
        String nombre = request.getParameter("nombre");
        String apePaterno = request.getParameter("apePaterno");
        String apeMaterno = request.getParameter("apeMaterno");
        String direccion = request.getParameter("direccion");
        String passwordd = request.getParameter("passwordd");

        User user = new User();
        user.setCorreo(correo);
        user.setNombre(nombre);
        user.setApePaterno(apePaterno);
        user.setApeMaterno(apeMaterno);
        user.setDireccion(direccion);
        user.setPasswordd(passwordd);

        try {

            rowsAffected = userDao.registerUser(user);

            if (rowsAffected > 0) {
                mensaje = "Se registró satisfactoriamente";
            } else {
                mensaje = "Ocurrio un error";
            }

        } catch (Exception e) {
            mensaje = "Ocurrio un error" + " // " + e.toString();
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/success.jsp");

        request.setAttribute("message", mensaje);

        dispatcher.forward(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
