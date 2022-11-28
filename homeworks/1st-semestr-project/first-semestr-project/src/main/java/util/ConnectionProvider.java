package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
    private static ConnectionProvider _instance;
    public static ConnectionProvider getInstance() throws Dbexception {
        if (_instance == null) {
            _instance = new ConnectionProvider();
        }
        return _instance;
    }
    private Connection connection;
    private ConnectionProvider() throws Dbexception {
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/first-semestr-project", "postgres", "1337");
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new Dbexception("Can't connect to DB.",e);
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
