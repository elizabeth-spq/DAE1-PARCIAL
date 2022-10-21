package pe.isil.parcialappjsp.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import pe.isil.parcialappjsp.user.dao.UserDao;
import pe.isil.parcialappjsp.user.model.User;

@WebServlet(name = "UserSesionServlet", urlPatterns = {"/UserSesionServlet"})
public class UserSesionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        UserDao userSesionDao = new UserDao();
        String mensaje = "";

        String correo = request.getParameter("correo");
        String passwordd = request.getParameter("passwordd");

        User user = new User();

        user.setCorreo(correo);
        user.setPasswordd(passwordd);

        try {
            mensaje = userSesionDao.sesionUser(user);

        } catch (Exception e) {
            mensaje = e.toString();
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
