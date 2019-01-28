package controllers.servlets.filter;


import Beans.Client;
import controllers.utils.ConfigurationManager;
import controllers.utils.MessageManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

//filter for authentication
@WebFilter(filterName = "AccessFilter", servletNames = "Controller",
        initParams = {
                @WebInitParam(name = "admin", value = "allClients allOrders allCruises editCruise"),
                @WebInitParam(name = "client", value = "myOrder viewOrderInfo toOrder updateOrder confirmOrder"),
                @WebInitParam(name = "common", value = "logout"),
                @WebInitParam(name = "out-of-control", value = "login tourInfo home")
        })
public class AccessFilter implements Filter {
    private static final Logger log = LogManager.getLogger(AccessFilter.class.getName());

    private Map<Client.Role, List<String>> accessMap = new HashMap<>();
    private List<String> commons = new ArrayList<>();
    private List<String> outOfControl = new ArrayList<>();

    @Override
    public void init(FilterConfig config) throws ServletException {
        log.debug("Filter initialization starts");
        accessMap.put(Client.Role.OWNER, asList(config.getInitParameter("admin")));
        accessMap.put(Client.Role.CLIENT, asList(config.getInitParameter("client")));
        log.trace("Access map: " + accessMap);

        commons = asList(config.getInitParameter("common"));
        log.trace("Common commands: " + commons);
        outOfControl = asList(config.getInitParameter("out-of-control"));
        log.trace("Out of control commands: " + outOfControl);
        log.debug("Filter initialization finished");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        log.log(Level.DEBUG, "Access Filter starts");
        if (accessAllowed(request)) {
            log.log(Level.DEBUG, "Access Filter finished");
            chain.doFilter(request, response);
        } else {
            request.setAttribute("errorMessage", MessageManager.getProperty("message.err.access"));
            log.log(Level.INFO, "permissions don't fit the role");
            request.getRequestDispatcher(ConfigurationManager.getProperty("path.page.error")).forward(request, response);
        }
    }

    @Override
    public void destroy() {
    }

    private boolean accessAllowed(ServletRequest request) {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String commandName = request.getParameter("command");
        log.log(Level.INFO, "Command name: " + commandName);
        if (commandName == null || commandName.isEmpty()) {
            return false;
        }

        if (outOfControl.contains(commandName)) {
            return true;
        }

        HttpSession session = httpRequest.getSession(false);
        if (session == null) {
            return false;
        }

        Client.Role userRole = (Client.Role) session.getAttribute("clientRole");
        if (userRole == null) {
            return false;
        }

        return accessMap.get(userRole).contains(commandName) || commons.contains(commandName);
    }

    private List<String> asList(String str) {
        List<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(str);
        while (scanner.hasNext()) {
            list.add(scanner.next().trim());
        }
        scanner.close();
        return list;
    }
}
