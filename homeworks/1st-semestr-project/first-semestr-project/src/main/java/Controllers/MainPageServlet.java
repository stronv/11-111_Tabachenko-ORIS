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

@WebServlet("/mainPage")
public class MainPageServlet extends HttpServlet {
    private GameDao gameDao;
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        gameDao = (GameDao) getServletContext().getAttribute("GameDao");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("actionGames", gameDao.getActionGames());
        req.setAttribute("adventureGames", gameDao.getAdventureGames());
        req.setAttribute("rpgGames", gameDao.getRPGGames());
        getServletContext().getRequestDispatcher("/WEB-INF/view/mainPage.jsp").forward(req, resp);
    }
}
