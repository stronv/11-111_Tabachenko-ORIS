package dao;

import Models.Game;
import util.ConnectionProvider;
import util.DbException;

import javax.servlet.http.Part;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GameDao {
    private ConnectionProvider connectionProvider;
    public GameDao(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }
    public GameDao() {}

    public int insertGame(Game game, InputStream file) throws DbException {
        int row = 0;
        try {
            PreparedStatement st = this.connectionProvider.getCon().prepareStatement(
                    "insert into games (title, genre, description, price, image) values (?, ?, ?, ?, ?)");
            st.setString(1, game.getTitle());
            st.setString(2, game.getGenre());
            st.setString(3, game.getDescription());
            st.setString(4, game.getPrice());
            if (file != null) {
                st.setBinaryStream(5, file);
            }
            row = st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException("Can't save new game.", e);
        }
        return row;
    }
}
