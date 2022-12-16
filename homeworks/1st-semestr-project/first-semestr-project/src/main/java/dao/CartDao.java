package dao;

import Models.Game;
import Models.Item;
import util.ConnectionProvider;
import util.DbException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDao {
    private ConnectionProvider connectionProvider;
    public CartDao(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }
    public CartDao() {}

    public Game addToCart(Game game) {
        try {
            PreparedStatement st = this.connectionProvider.getCon().prepareStatement(
                    "insert into cart (id, title, genre, description, price, image_name, image) values (?, ?, ?, ?, ?, ?, ?)");
            st.setInt(1, game.getId());
            st.setString(2, game.getTitle());
            st.setString(3, game.getGenre());
            st.setString(4, game.getDescription());
            st.setInt(5, game.getPrice());
            st.setString(6, game.getImageName());
            st.setBytes(7, game.getImage());

            int row = st.executeUpdate();

            if (row == 0) {
                throw new SQLException();
            }
        } catch (SQLException e){
            throw new IllegalArgumentException(e);
        }
        return game;
    }

    public List<Game> getAllinCart() {
        List<Game> gamesInCart = new ArrayList<>();
        try {
            PreparedStatement st = this.connectionProvider
                    .getCon()
                    .prepareStatement("select distinct * from cart");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String title = rs.getString("title");
                String genre = rs.getString("genre");
                String description = rs.getString("description");
                Integer price = rs.getInt("price");
                String imageName = rs.getString("image_name");
                byte[] image = rs.getBytes("image");
                gamesInCart.add(new Game(id, title, genre, description, price, imageName, image));
            }
            return gamesInCart;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public boolean cleanCart() {
        boolean tableIsClean;
        try {
            PreparedStatement st = this.connectionProvider.getCon().prepareStatement(
                    "delete from cart");
            tableIsClean = st.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
        return tableIsClean;
    }
}
