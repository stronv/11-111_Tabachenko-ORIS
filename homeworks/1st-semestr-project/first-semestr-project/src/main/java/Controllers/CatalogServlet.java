package Controllers;

import Models.Game;
import dao.GameDao;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;


@WebServlet("/catalog")
public class CatalogServlet extends HttpServlet {
    private GameDao gameDao;
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        gameDao = (GameDao) getServletContext().getAttribute("GameDao");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("games", gameDao.getAllGames());
        getServletContext().getRequestDispatcher("/WEB-INF/view/catalog.jsp").forward(req, resp);
    }
}
