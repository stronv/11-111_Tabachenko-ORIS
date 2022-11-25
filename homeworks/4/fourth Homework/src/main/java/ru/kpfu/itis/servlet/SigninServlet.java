package ru.kpfu.itis.servlet;

import dao.LoginDao;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/signin")
public class SigninServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/view/signin.jsp").forward(req, resp);;
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

//        User user = new User(username, email, password);

        LoginDao loginDao = new LoginDao();

        try {
            User user = new User(username, email, password);
            boolean result = loginDao.validateUser(user);
            if (result == true) {
                resp.sendRedirect(getServletContext().getContextPath() + "/profile");
            } else {
                resp.sendRedirect(getServletContext().getContextPath() + "/signin");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
