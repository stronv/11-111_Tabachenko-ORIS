package service;

import dao.UserDao;
import entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class UserService {
    public void auth(User user, HttpServletRequest req, HttpServletResponse resp) {
        req.getSession().setAttribute("user", user);
    }
    public boolean isNonAnonimus(HttpServletRequest req, HttpServletResponse resp) {
        return req.getSession().getAttribute("user") != null;
    }
    public User getUser(HttpServletRequest req, HttpServletResponse res) {
        return (User) req.getSession().getAttribute("user");
    }
    private static final UserDao userDao = new UserDao();

    public List<User> getAllUsers() {
        return userDao.selectAllUsers();
    }
}

