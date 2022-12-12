package dao;

import Models.User;
import service.UserService;
import util.ConnectionProvider;
import util.DbException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UserDao {
    private User user;
    private UserService userService;
    private ConnectionProvider connectionProvider;
    public UserDao(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }
    public UserDao() {}
    public User getUserByEmailAndPassword(String email, String password) throws DbException {
        try {
            PreparedStatement st = this.connectionProvider.getCon().prepareStatement(
                    "select * from users where email = ? and password = ?");
            st.setString(1, email);
            st.setString(2, password);
            ResultSet result = st.executeQuery();
            boolean hashOne = result.next();
            if (hashOne) {
                return new User(
                        result.getInt("id"),
                        result.getString("email"),
                        null
                );
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new DbException("User didn't exists.", e);
        }
    }
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
                users.add(new User(id, email, username, password));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }
}
