package dao;

import Models.Game;
import Models.User;

import util.ConnectionProvider;
import util.DbException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UserDao {
    private User user;
    private ConnectionProvider connectionProvider;
    public UserDao(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }
    public UserDao() {}
    public void insertUser(User user) throws DbException {
        try {
            PreparedStatement st = this.connectionProvider.getCon().prepareStatement(
                    "insert into users (email, username, password) values (?, ?, ?)");
            st.setString(1, user.getEmail());
            st.setString(2, user.getUsername());
            st.setString(3, user.getPassword());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException("Can't register user.", e);
        }
    }

    public boolean deleteUser(int id) throws DbException {
        boolean rowDeleted;
        try {
            PreparedStatement st = this.connectionProvider.getCon().prepareStatement(
                    "delete from users where id = ?");
            st.setInt(1, id);
            rowDeleted = st.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new DbException("Can't delete user.", e);
        }
        return rowDeleted;
    }

    public void updateUser(User user) {
        try {
            PreparedStatement st = this.connectionProvider.getCon().prepareStatement(
                    "update users set email = ?, username = ?, password = ? where id = ?");
            st.setString(1, user.getEmail());
            st.setString(2, user.getUsername());
            st.setString(3, user.getPassword());
            st.setInt(4, user.getId());
            st.execute();

        } catch (SQLException e) {
            throw new IllegalArgumentException( e);
        }
    }

    public List<User> selectAllUsers() {
        List<User> users = new LinkedList<>();
        try {
            PreparedStatement st = this.connectionProvider.getCon().prepareStatement(
                    "select * from users");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String role = rs.getString("role");
                users.add(new User(id, email, username, password, role));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }
}
