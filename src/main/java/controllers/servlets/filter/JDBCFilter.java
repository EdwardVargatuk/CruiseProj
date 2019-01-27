package controllers.servlets.filter;

import connection.ConnectionUtils;
import connection.MySqlConnectionPool;
import controllers.utils.MyUtils;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Connection;
import java.util.Collection;
import java.util.Map;

@WebFilter(filterName = "jdbcFilter", urlPatterns = {"/*"})
public class JDBCFilter implements Filter {
    private static final Logger log = LogManager.getLogger(JDBCFilter.class.getName());

    public JDBCFilter() {
    }

    @Override
    public void init(FilterConfig fConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    // Проверить является ли Servlet цель текущего request?
    private boolean needJDBC(HttpServletRequest request) {
        log.log(Level.INFO, "JDBC Filter");
        String servletPath = request.getServletPath();
        String pathInfo = request.getPathInfo();
        String urlPattern = servletPath;
        if (pathInfo != null) {
            urlPattern = servletPath + "/*";
        }
        // Key: servletName.
        // Value: ServletRegistration
        Map<String, ? extends ServletRegistration> servletRegistrations = request.getServletContext().getServletRegistrations();
        // Коллекционировать все Servlet в вашем WebApp.
        Collection<? extends ServletRegistration> values = servletRegistrations.values();
        for (ServletRegistration sr : values) {
            Collection<String> mappings = sr.getMappings();
            if (mappings.contains(urlPattern)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        log.log(Level.INFO, "jdbc filter start");
        HttpServletRequest req = (HttpServletRequest) request;
        // Открыть  connection (соединение) только для request со специальной ссылкой.
        // (Например ссылка к servlet, jsp, ..)
        // Избегать открытия Connection для обычных запросов.
        // (Например image, css, javascript,... )
        if (this.needJDBC(req)) {
            log.log(Level.INFO, "Open Connection for: " + req.getServletPath());
            Connection conn = null;
            try {
                conn = MySqlConnectionPool.getConnection();
                // Настроить автоматический commit false, чтобы активно контролировать.
                conn.setAutoCommit(false);
                MyUtils.storeConnection(request, conn);
                chain.doFilter(request, response);
                // метод commit() для завершения транзакции с DB.
                conn.commit();
            } catch (Exception e) {
                log.log(Level.ERROR, "connection false " + e);
                ConnectionUtils.rollbackQuietly(conn);
                throw new ServletException();
            } finally {
                ConnectionUtils.closeQuietly(conn);
                log.log(Level.INFO, "jdbc filter successful");
            }
        }
        // Для обычных request (image,css,html,..)
        else {
            chain.doFilter(request, response);
        }

    }
}