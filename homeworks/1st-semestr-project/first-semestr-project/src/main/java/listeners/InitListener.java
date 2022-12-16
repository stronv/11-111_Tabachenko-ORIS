package listeners;

import dao.CartDao;
import dao.GameDao;
import dao.UserDao;
import service.UserService;
import util.ConnectionProvider;
import util.DbException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;

@WebListener
public class InitListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            ConnectionProvider connectionProvider = ConnectionProvider.getInstance();
            sce.getServletContext().setAttribute("UserDao", new UserDao(connectionProvider));
            sce.getServletContext().setAttribute("GameDao", new GameDao(connectionProvider));
            sce.getServletContext().setAttribute("CartDao", new CartDao(connectionProvider));
            sce.getServletContext().setAttribute("UserService", new UserService());
        } catch (DbException e) {
            throw new RuntimeException(e);
        }
    }
}
