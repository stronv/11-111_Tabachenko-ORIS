package dao;

import Models.Game;
import util.ConnectionProvider;
import util.DbException;

public class GameDao {
    private ConnectionProvider connectionProvider;
    public GameDao(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }
    public GameDao() {}

    public void insertGame(Game game) throws DbException {

    }
}
