package Controllers;

import dao.UserDao;
import entity.Usser;
import util.DbException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    private UserDao usserDao;
    @Override
    public void init() throws ServletException {
        usserDao = (UserDao) getServletContext().getAttribute("UsserDao");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/WEB-INF/view/profile.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String email = req.getParameter("email");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Usser usser = new Usser(id, email, username, password);
        try {
            usserDao.updateUsser(usser);
        } catch (DbException e) {
            throw new RuntimeException(e);
        }
    }
}
