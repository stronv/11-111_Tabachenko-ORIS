package Controllers;

import Models.Game;
import dao.CartDao;
import dao.GameDao;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

@WebServlet("/add-to-cart")
public class AddToCartServlet extends HttpServlet {
    private CartDao cartDao;
    private GameDao gameDao;


    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        cartDao = (CartDao) getServletContext().getAttribute("CartDao");
        gameDao = (GameDao) getServletContext().getAttribute("GameDao");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        Game game = gameDao.getGameById(id);
        cartDao.addToCart(game);
        resp.sendRedirect("gamePage");
    }
}
