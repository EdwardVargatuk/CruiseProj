package controllers.servlets.filter;

import Beans.Client;

import controllers.utils.MyUtils;


import dao.mysql.MySqlDaoFactory;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;


@WebFilter(filterName = "cookieFilter", urlPatterns = {"/*"})
public class CookieFilter implements Filter {
    private static final Logger log = LogManager.getLogger(CookieFilter.class.getName());

    public CookieFilter() {
    }

    @Override
    public void init(FilterConfig fConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        Client client = MyUtils.getLoginedUser(session);
        if (client != null) {
            session.setAttribute("COOKIE_CHECKED", "CHECKED");
            log.log(Level.INFO, "client exist, cookie CHECKED");
            chain.doFilter(request, response);
            return;
        }
        Connection conn = MyUtils.getStoredConnection(request);
        String checked = (String) session.getAttribute("COOKIE_CHECKED");
        if (checked == null && conn != null) {
            String userName = MyUtils.getUserNameInCookie(req);
            Client client1 = MySqlDaoFactory.getInstance().getClientDao().getByLogin(userName);
            MyUtils.storeLoginedUser(session, client1);
            session.setAttribute("COOKIE_CHECKED", "CHECKED");
            log.log(Level.INFO, "client "+client1.getUserName()+" CHECKED for first time");
        }
        chain.doFilter(request, response);

    }

}
