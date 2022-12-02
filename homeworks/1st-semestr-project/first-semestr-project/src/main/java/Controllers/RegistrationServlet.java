package Controllers;

import dao.UserDao;
import entity.User;
import service.UserService;
import util.DbException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private UserDao userDao;
    private UserService userService;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userDao = (UserDao) getServletContext().getAttribute("UserDao");
        userService = (UserService) getServletContext().getAttribute("UserService");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/view/registration.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (email != null && username != null && password != null) {
            try {
                User user = new User(email, username, password);
                userDao.insertUser(user);
                req.getSession().setAttribute("authUser", user);
                    resp.sendRedirect(getServletContext().getContextPath() + "/authorization");
            } catch (DbException e) {
                throw new ServletException(e);
            }
        }
    }
}
