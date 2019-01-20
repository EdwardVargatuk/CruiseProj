package controllers.servlets.filter;

import Beans.Client;
import controllers.servlets.command.MyUtils;
import dao.mysql.MySqlClientDao;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

@WebFilter(filterName = "cookieFilter", urlPatterns = { "/*" })
public class CookieFilter implements Filter {

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
        //
        if (client != null) {
            session.setAttribute("COOKIE_CHECKED", "CHECKED");
            chain.doFilter(request, response);
            return;
        }

        // Connection создан в JDBCFilter.
        Connection conn = MyUtils.getStoredConnection(request);

        // Флаг(flag) для проверки Cookie.
        String checked = (String) session.getAttribute("COOKIE_CHECKED");
        if (checked == null && conn != null) {
            String userName = MyUtils.getUserNameInCookie(req);

                MySqlClientDao mySqlClientDao = new MySqlClientDao();
                Client client1 = mySqlClientDao.getByLogin(userName);
//                .findUser(conn, userName)
                MyUtils.storeLoginedUser(session, client1);

            // Отметить проверенные Cookie.
            session.setAttribute("COOKIE_CHECKED", "CHECKED");
        }

        chain.doFilter(request, response);
    }

}
