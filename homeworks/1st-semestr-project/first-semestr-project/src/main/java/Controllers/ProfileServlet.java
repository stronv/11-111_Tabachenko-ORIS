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

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    private UserDao userDao;
    private UserService userService;
    private User user;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userDao = (UserDao) getServletContext().getAttribute("UserDao");
        userService = (UserService) getServletContext().getAttribute("UserService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.user = userService.getUser(req, resp);
        req.getServletContext().getContextPath();
        getServletContext().getRequestDispatcher("/WEB-INF/view/profile.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("authUser");

        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);

        userDao.updateUser(user);

        resp.sendRedirect(req.getContextPath() + "/profile");
    }
}
