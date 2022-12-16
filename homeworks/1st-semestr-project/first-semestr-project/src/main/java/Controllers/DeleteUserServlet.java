package Controllers;

import Models.User;
import dao.UserDao;
import util.DbException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {
    private UserDao userDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userDao = (UserDao) getServletContext().getAttribute("UserDao");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("authUser");
        try {
            userDao.deleteUser(user.getId());
            req.getSession().removeAttribute("authUser");
        } catch (DbException e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect(getServletContext().getContextPath() + "/mainPage");
    }
}
