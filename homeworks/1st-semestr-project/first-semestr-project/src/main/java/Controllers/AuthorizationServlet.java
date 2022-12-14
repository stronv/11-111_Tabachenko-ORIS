package Controllers;

import dao.UserDao;
import Models.User;
import service.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/authorization")
public class AuthorizationServlet extends HttpServlet {
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
        getServletContext().getRequestDispatcher("/WEB-INF/view/authorization.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        List<User> users = userDao.selectAllUsers();
        System.out.println(users);

        for (User user: users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                req.getSession().setAttribute("authUser", user);
                resp.sendRedirect(getServletContext().getContextPath() + "/main");
                req.setAttribute("message", "You have successfully registered!");
                return;
            } else {
                req.setAttribute("message", "Wrong pair username-password.");
            }
        }
        resp.sendRedirect(getServletContext().getContextPath() + "/authorization");
    }
}