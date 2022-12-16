package Controllers;

import Models.Game;
import Models.User;
import dao.GameDao;
import dao.UserDao;
import service.UserService;
import util.DbException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


@MultipartConfig(maxFileSize = 16177215)
@WebServlet("/addGame")
public class AddGameServlet extends HttpServlet {

    private GameDao gameDao;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        gameDao = (GameDao) getServletContext().getAttribute("GameDao");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/view/addGamePage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String title = req.getParameter("title");
        String genre = req.getParameter("genre");
        String description = req.getParameter("description");
        Integer price = Integer.parseInt(req.getParameter("price"));
        Part image = req.getPart("image");
        String imageName = image.getSubmittedFileName();

        if (title != null && genre != null && description != null) {
            Game game = new Game(title, genre, description, price, image.getInputStream().readAllBytes(), imageName);
            gameDao.saveGame(game);
        } else {
            req.setAttribute("message", "All fields should be fill!.");
        }
        resp.sendRedirect(getServletContext().getContextPath() + "/catalog");
    }
}
