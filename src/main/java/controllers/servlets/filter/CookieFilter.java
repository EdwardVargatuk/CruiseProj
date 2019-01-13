package controllers.servlets.filter;

import Beans.Client;
import controllers.servlets.command.MyUtils;
import dao.mysql.MySqlUserDao;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

@WebFilter(filterName = "cookieFilter", urlPatterns = { "/*" })
public class CookieFilter implements Filter {

//    private ConnectionPool pool = MySqlConnectionPool.getInstance();

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

                MySqlUserDao mySqlUserDao = new MySqlUserDao();
                Client client1 = mySqlUserDao.getByLogin(userName);
//                .findUser(conn, userName)
                MyUtils.storeLoginedUser(session, client1);

            // Отметить проверенные Cookie.
            session.setAttribute("COOKIE_CHECKED", "CHECKED");
        }

        chain.doFilter(request, response);
    }

}
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) request;
//        HttpSession session = req.getSession();
//
//        Client client = MyUtils.getLoginedUser(session);
//        //
//        if (client != null) {
//            session.setAttribute("COOKIE_CHECKED", "CHECKED");
//            chain.doFilter(request, response);
//            return;
//        }
//
//
//
////        DaoConnection conn = MySqlConnectionPool.getInstance().getConnection();
//
//        Connection conn = null;
//        try {
//             conn = MySqlConnectionPool.getConnection();
//            System.out.println("connect");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        try {
//            conn.setAutoCommit(false);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
////                Client user = MySqlDaoFactory.getInstance().getClientDao().getByLogin("Ed");
////        System.out.println(user);
////        DaoConnection conn = MySqlTransactionHelper.getInstance().getConnection();
//        MyUtils.storeConnection(request, conn);
//
//        // Вызвать метод commit() чтобы завершить транзакцию с DB.
//        try {
//            conn.commit();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        try {
//            conn.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//         conn =  MyUtils.getStoredConnection(request);


//                pool.getConnection();
//        // Настроить автоматический commit false, чтобы активно контролировать.
//        conn.setAutoCommit(false);

        // Сохранить объект Connection в attribute в request.






//        // Connection создан в JDBCFilter.
//        Connection conn = MyUtils.getStoredConnection(request);

        // Флаг(flag) для проверки Cookie.



//from if    && conn != null

//        String checked = (String) session.getAttribute("COOKIE_CHECKED");
//        if (checked == null ) {
//            String userName = MyUtils.getUserNameInCookie(req);
////            try {
//                Client user = MySqlDaoFactory.getInstance().getClientDao().getByLogin(userName);
////                        DBUtils.findUser(conn, userName);
//                MyUtils.storeLoginedUser(session, user);
////            } catch (SQLException e) {
////                e.printStackTrace();
////            }
//            // Отметить проверенные Cookie.
//            session.setAttribute("COOKIE_CHECKED", "CHECKED");
//        }

//        chain.doFilter(request, response);
//    }

//}