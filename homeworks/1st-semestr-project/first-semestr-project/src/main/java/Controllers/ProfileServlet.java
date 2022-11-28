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

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    private UserDao userDao;
    @Override
    public void init() throws ServletException {
        userDao = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/WEB-INF/view/profile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String email = req.getParameter("email");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user  = new User(id, email, username, password);
        try {
            boolean result = userDao.updateUser(user);
            if (result == true) {
                resp.getWriter().println("Your info was changed");
            } else {
                resp.getWriter().println("Your info did not changed");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
