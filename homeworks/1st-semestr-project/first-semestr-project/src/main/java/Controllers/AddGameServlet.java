package Controllers;

import Models.Game;
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

        String tittle = req.getParameter("title");
        String genre = req.getParameter("genre");
        String description = req.getParameter("description");
        String price = req.getParameter("price");

        Game game = new Game(tittle, genre, description, price);

        InputStream inputStream = null;
        String message = null;
        Part filePart = req.getPart("image");

        if (filePart != null) {
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());

            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }

        int row = 0;
        try {
            row = gameDao.insertGame(game, inputStream);
        } catch (DbException e) {
            throw new RuntimeException(e);
        }
        if (row > 0) {
            message = "File uploaded and saved into database";
            System.out.println(message);
        }
    }
}
