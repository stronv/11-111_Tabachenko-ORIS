package dao;

import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao extends RegisterDao {
    private String dbDriver = "org.postgresql.Driver";

    public boolean validateUser(User user) throws SQLException {
        loadDriver(dbDriver);
        boolean found = false;
        try {
            Connection connection = getConnection();
            String sql = "select * from registerusers where email = ? and password = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();

            if (rs.next() == false) {
                found = false;
            } else {
                found = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return found;
    }
}
