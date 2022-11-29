package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionProvider {
    private static ConnectionProvider _instance;
    public static ConnectionProvider getInstance() throws DbException {
        if (_instance == null) {
            _instance = new ConnectionProvider();
        }
        return _instance;
    }
    private Connection con;
    private ConnectionProvider() throws DbException {
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/first-semestr-project",
                    "postgres", "1337");
        } catch (SQLException | ClassNotFoundException | InstantiationException |IllegalAccessException e) {
            throw new DbException("Can't connect to Data Base.", e);
        }
    }
    public Connection getCon() {
        return con;
    }
}
