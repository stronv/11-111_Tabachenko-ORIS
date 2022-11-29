package Controllers;

import dao.UserDao;
import entity.Usser;
import service.UsserService;
import util.DbException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private UserDao usserDao;
    private UsserService usserService;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        usserDao = (UserDao) getServletContext().getAttribute("UsserDao");
        usserService = (UsserService) getServletContext().getAttribute("UsserService");
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
                Usser usser = new Usser(email, username, password);
                usserDao.insertUser(usser);
                    resp.sendRedirect(getServletContext().getContextPath() + "/profile");
            } catch (DbException e) {
                throw new ServletException(e);
            }
        }
    }
}
