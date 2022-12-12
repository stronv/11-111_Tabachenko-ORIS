import dao.GameDao;
import dao.UserDao;
import Models.User;
import service.UserService;
import util.ConnectionProvider;
import util.DbException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@WebListener
public class InitListener implements ServletContextListener {

    private static HttpSession session;

    public static Optional<User> getAuthUser() {
        User user = (User) session.getAttribute("authUser");
        if (user != null) {
            return Optional.of(user);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            ConnectionProvider connectionProvider = ConnectionProvider.getInstance();
            sce.getServletContext().setAttribute("UserDao", new UserDao(connectionProvider));
            sce.getServletContext().setAttribute("GameDao", new GameDao(connectionProvider));
            sce.getServletContext().setAttribute("UserService", new UserService());
        } catch (DbException e) {
            throw new RuntimeException(e);
        }
    }
}
