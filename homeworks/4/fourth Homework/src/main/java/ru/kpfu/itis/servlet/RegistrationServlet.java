package ru.kpfu.itis.servlet;

import dao.RegisterDao;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/view/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if (!email.contains("@") || email.isEmpty()) {
            req.setAttribute("message", "Email must content @ character or should be fill.");
            resp.sendRedirect(getServletContext().getContextPath() + "/registration");
        } else if(username.isEmpty() || password.isEmpty()) {
            req.setAttribute("message", "All field should be fill.");
            resp.sendRedirect(getServletContext().getContextPath() + "/registration");
        } else {
            User user = new User(username, email, password);
            RegisterDao registerDao = new RegisterDao();
            String result = null;
            try {
                result = registerDao.insert(user);
                resp.sendRedirect(getServletContext().getContextPath() + "/profile");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
