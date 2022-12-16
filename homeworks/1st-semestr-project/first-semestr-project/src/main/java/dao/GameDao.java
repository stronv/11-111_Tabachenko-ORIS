package dao;

import Models.Game;
import util.ConnectionProvider;
import util.DbException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameDao {
    private ConnectionProvider connectionProvider;
    public GameDao(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }
    public GameDao() {}

    public Game saveGame(Game game) {
        try {
            PreparedStatement st = this.connectionProvider.getCon().prepareStatement(
                    "insert into addedgames (title, genre, description, price, image_name, image) values (?, ?, ?, ?, ?, ?)");
            st.setString(1, game.getTitle());
            st.setString(2, game.getGenre());
            st.setString(3, game.getDescription());
            st.setInt(4, game.getPrice());
            st.setString(5, game.getImageName());
            st.setBytes(6, game.getImage());

            int row = st.executeUpdate();

            if (row == 0) {
                throw new SQLException();
            }
        } catch (SQLException e){
            throw new IllegalArgumentException(e);
        }
        return game;
    }

    public Game getGameById(Integer id) {
        try {
            PreparedStatement st = this.connectionProvider
                    .getCon()
                    .prepareStatement("select * from addedgames where id = ?");

            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            rs.next();
            String title = rs.getString("title");
            String genre = rs.getString("genre");
            String description = rs.getString("description");
            Integer price = rs.getInt("price");
            String imageName = rs.getString("image_name");
            byte[] image = rs.getBytes("image");

            return new Game(id, title, genre, description, price, imageName, image);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteGame(int id) throws DbException {
        boolean rowDeleted;
        try {
            PreparedStatement st = this.connectionProvider.getCon().prepareStatement(
                    "delete from games where id = ?");
            st.setInt(1, id);
            rowDeleted = st.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new DbException("Can't delete game.", e);
        }
        return rowDeleted;
    }


    public List<Game> getAllGames() {
        List<Game> games = new ArrayList<>();
        try {
            PreparedStatement st = this.connectionProvider
                    .getCon()
                    .prepareStatement("select * from addedgames");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String title = rs.getString("title");
                String genre = rs.getString("genre");
                String description = rs.getString("description");
                Integer price = rs.getInt("price");
                String imageName = rs.getString("image_name");
                byte[] image = rs.getBytes("image");
            games.add(new Game(id, title, genre, description, price, imageName, image));
            }
            return games;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public List<Game> getActionGames() {
        List<Game> games = new ArrayList<>();
        try {
            PreparedStatement st = this.connectionProvider
                    .getCon()
                    .prepareStatement("select * from addedgames where genre = 'Action' ");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String title = rs.getString("title");
                String genre = rs.getString("genre");
                String description = rs.getString("description");
                Integer price = rs.getInt("price");
                String imageName = rs.getString("image_name");
                byte[] image = rs.getBytes("image");
                games.add(new Game(id, title, genre, description, price, imageName, image));
            }
            return games;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public List<Game> getAdventureGames() {
        List<Game> games = new ArrayList<>();
        try {
            PreparedStatement st = this.connectionProvider
                    .getCon()
                    .prepareStatement("select * from addedgames where genre = 'Adventure'");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String title = rs.getString("title");
                String genre = rs.getString("genre");
                String description = rs.getString("description");
                Integer price = rs.getInt("price");
                String imageName = rs.getString("image_name");
                byte[] image = rs.getBytes("image");
                games.add(new Game(id, title, genre, description, price, imageName, image));
            }
            return games;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
    public List<Game> getRPGGames() {
        List<Game> games = new ArrayList<>();
        try {
            PreparedStatement st = this.connectionProvider
                    .getCon()
                    .prepareStatement("select * from addedgames where genre = 'RPG'");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String title = rs.getString("title");
                String genre = rs.getString("genre");
                String description = rs.getString("description");
                Integer price = rs.getInt("price");
                String imageName = rs.getString("image_name");
                byte[] image = rs.getBytes("image");
                games.add(new Game(id, title, genre, description, price, imageName, image));
            }
            return games;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
