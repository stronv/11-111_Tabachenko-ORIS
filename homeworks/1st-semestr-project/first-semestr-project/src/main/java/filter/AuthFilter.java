//package filter;
//
//import dao.UsserDao;
//import service.UsserService;
//
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebFilter("/*")
//public class AuthFilter extends HttpFilter {
//    private static String[] securedPaths = new String[] {"/registration"};
//    private UsserService usserService;
//    @Override
//    public void init(FilterConfig config) throws ServletException {
//        super.init(config);
//        usserService = (UsserService) getServletContext().getAttribute("UsserService");
//    }
//    @Override
//    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
//        boolean prot = false;
//        for (String path : securedPaths) {
//            if (path.equals(req.getRequestURI().substring(req.getContextPath().length()))) {
//                prot = true;
//                break;
//            }
//        }
//        if (prot && !usserService.isNonAnonimus(req, res)) {
//            res.sendRedirect(req.getContextPath() + "/registration");
//            return;
//        } else {
//            if (usserService.isNonAnonimus(req, res)) {
//                req.setAttribute("user", usserService.getUsser(req, res));
//            }
//            chain.doFilter(req, res);
//        }
//    }
//}
