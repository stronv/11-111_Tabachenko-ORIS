import dao.UserDao;
import service.UsserService;
import util.ConnectionProvider;
import util.DbException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            ConnectionProvider connectionProvider = ConnectionProvider.getInstance();
            sce.getServletContext().setAttribute("UsserDao", new UserDao(connectionProvider));
            sce.getServletContext().setAttribute("UsserService", new UsserService());
        } catch (DbException e) {
            throw new RuntimeException(e);
        }
    }
}
