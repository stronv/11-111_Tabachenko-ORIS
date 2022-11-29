package dao;

import entity.Usser;
import service.UsserService;
import util.ConnectionProvider;
import util.DbException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private UsserService usserService;
    private ConnectionProvider connectionProvider;
    public UserDao(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }

    public Usser getUserByEmailAndPassword(String email, String password) throws DbException {
        try {
            PreparedStatement st = this.connectionProvider.getCon().prepareStatement(
                    "select * from users where email = ? and password = ?");
            st.setString(1, email);
            st.setString(2, password);
            ResultSet result = st.executeQuery();
            boolean hashOne = result.next();
            if (hashOne) {
                return new Usser(
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
    public void insertUser(Usser usser) throws DbException {
        try {
            PreparedStatement st = this.connectionProvider.getCon().prepareStatement(
                    "insert into users (email, username, password) values (?, ?, ?)");
            st.setString(1, usser.getEmail());
            st.setString(2, usser.getUsername());
            st.setString(3, usser.getPassword());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException("Can't register user.", e);
        }
    }
    public void updateUsser(Usser usser) throws DbException {
        boolean rowUpdated;
        try {

            PreparedStatement st = this.connectionProvider.getCon().prepareStatement(
                    "update users set email = ?, username = ?, password = ? where id = ?");
            st.setString(1, usser.getUsername());
            st.setString(2, usser.getEmail());
            st.setString(3, usser.getPassword());
            st.setInt(4, usser.getId());
            st.execute();

        } catch (SQLException e) {
            throw new DbException("Can't find user.", e);
        }
    }
}
