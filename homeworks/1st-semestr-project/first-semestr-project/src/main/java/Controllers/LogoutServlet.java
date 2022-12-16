package Controllers;

import dao.CartDao;
import dao.GameDao;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/log-out")
public class LogoutServlet extends HttpServlet {

    private CartDao cartDao;


    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        cartDao = (CartDao) getServletContext().getAttribute("CartDao");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("authUser") != null) {
            cartDao.cleanCart();
            req.getSession().removeAttribute("authUser");
            resp.sendRedirect(getServletContext().getContextPath() + "/authorization");
        } else {
            resp.sendRedirect(getServletContext().getContextPath() + "/authorization");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
