package dao;

import entity.User;

import javax.servlet.http.HttpSession;
import java.sql.*;

public class UserDao {

    private String dbURL = "jdbc:postgresql://localhost:5432/first-semestr-project";
    private String dbName = "postgres";
    private String dbpass = "1337";
    private String dbDriver = "org.postgresql.Driver";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(dbDriver);
            connection = DriverManager.getConnection(dbURL, dbName, dbpass);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private static final String insert_sql = "insert into users (email, username, password) values (?, ?, ?);";

    private static final String update_sql = "update users set email = ?, username = ?, password = ? where id = ?";

    private static final String validate_sql = "select * from users where email = ? and password = ?";

    public void insert(User user) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(insert_sql)) {
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean validateUser(User user) throws SQLException {
        boolean validated = false;
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(validate_sql)) {
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());

            ResultSet rs = ps.executeQuery();

            if (rs.next() == false) {
                validated = false;
            } else {
                validated = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return validated;
    }

    public boolean updateUser(User user) throws SQLException {
        boolean userUpdated;
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(update_sql);) {
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.setInt(4, user.getId());

            userUpdated = ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userUpdated;
    }
}
