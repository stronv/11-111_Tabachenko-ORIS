package dao;

import entity.User;

import java.sql.*;

public class RegisterDao {

    private String dbURL = "jdbc:postgresql://localhost:5432/fourth_hw";
    private String dbName = "postgres";
    private String dbpass = "1337";
    private String dbDriver = "org.postgresql.Driver";

    public void loadDriver(String dbDriver) {
        try {
            Class.forName(dbDriver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbURL, dbName, dbpass);
        } catch (SQLException e) {
            e.getErrorCode();
        }
        return connection;
    }

    public String insert(User user) throws SQLException {

        loadDriver(dbDriver);
        Connection connection = getConnection();

        String result = "Data entered successfuly";
        String sql = "insert into registerusers values (?, ?, ?)";

        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            result = "Data not entered";
        }
        return result;
    }
}

