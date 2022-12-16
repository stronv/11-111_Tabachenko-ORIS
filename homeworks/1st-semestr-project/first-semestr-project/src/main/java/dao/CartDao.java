package dao;

import Models.Cart;
import util.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CartDao {
    private ConnectionProvider connectionProvider;
    public CartDao(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }
    public CartDao() {}

    public List<Cart> getCartGames(ArrayList<Cart> cartList) {
        List<Cart> gamesInCart = new ArrayList<Cart>();
        try {
            if(cartList.size() > 0) {
                for(Cart i:cartList) {
                    PreparedStatement st = this.connectionProvider.getCon().prepareStatement(
                            "select * from addedgames where id = ?");
                    st.setInt(1, i.getId());
                    ResultSet rs = st.executeQuery();
                    while (rs.next()) {
                        Cart row = new Cart();
                        row.setId(rs.getInt("id"));
                        row.setTitle(rs.getString("title"));
                        row.setGenre(rs.getString("genre"));
                        row.setDescription(rs.getString("description"));
                        row.setPrice(rs.getInt("price"));
                        row.setImageName(rs.getString("image_name"));
                        row.setImage(rs.getBytes("image"));
                        gamesInCart.add(row);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return gamesInCart;
    }
}
