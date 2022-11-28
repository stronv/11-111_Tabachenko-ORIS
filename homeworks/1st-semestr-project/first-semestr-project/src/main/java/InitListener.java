import dao.UserDao;
import util.ConnectionProvider;
import util.Dbexception;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class InitListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            ConnectionProvider connectionProvider = ConnectionProvider.getInstance();
            sce.getServletContext().setAttribute("userDao", new UserDao(connectionProvider));
        } catch (Dbexception e) {
            throw new RuntimeException(e);
        }
    }
}
