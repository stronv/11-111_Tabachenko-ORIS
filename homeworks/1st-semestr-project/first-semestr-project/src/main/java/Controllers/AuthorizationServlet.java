package Controllers;

import dao.UserDao;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/authorization")
public class AuthorizationServlet extends HttpServlet {

    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        userDao = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/view/authorization.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            User user = new User(email,username,password);
            boolean result = userDao.validateUser(user);
            if (result == true) {
                HttpSession session = req.getSession();
                session.setAttribute("currentUser", user);
                resp.sendRedirect(getServletContext().getContextPath() + "/profile");
            } else {
                resp.sendRedirect(getServletContext().getContextPath() + "/registration");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}