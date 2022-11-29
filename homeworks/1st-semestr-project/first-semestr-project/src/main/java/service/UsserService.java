package service;

import entity.Usser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsserService {
    public void auth(Usser usser, HttpServletRequest req, HttpServletResponse resp) {
        req.getSession().setAttribute("usser", usser);
    }
    public boolean isNonAnonimus(HttpServletRequest req, HttpServletResponse resp) {
        return req.getSession().getAttribute("usser") != null;
    }
    public Usser getUsser(HttpServletRequest req, HttpServletResponse res) {
        return (Usser) req.getSession().getAttribute("usser");
    }
}

