package controllers.servlets.command;


import Beans.Client;
import controllers.utils.ConfigurationManager;
import controllers.utils.MessageManager;

import controllers.utils.MyUtils;
import controllers.utils.SessionRequestContent;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.impl.ServiceFactoryImpl;


import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Login command to check user and role and store to session
 *
 * @author Edward
 *
 */
public class LoginCommand implements ActionCommand {
    private static final Logger log = LogManager.getLogger(LoginCommand.class.getName());

    @Override
    public String execute(SessionRequestContent sessionRequestContent) {
        log.log(Level.INFO, "enter action command LoginCommand");
        String page = null;
        Map<String, Object> requestAttributes = sessionRequestContent.getRequestAttributes();
        Map<String, Object> sessionAttributes = sessionRequestContent.getSessionAttributes();
        HttpServletResponse response = sessionRequestContent.getResponse();
        String userName = sessionRequestContent.getRequestParameter("userName");
        String password = sessionRequestContent.getRequestParameter("password");
        Client client;

        if (userName == null || password == null || userName.length() == 0 || password.length() == 0) {
            requestAttributes.put("errorLoginPassMessage",
                    MessageManager.getProperty("message.loginerrorNull"));
            page = ConfigurationManager.getProperty("path.page.login");
            log.log(Level.DEBUG, MessageManager.getProperty("message.loginerrorNull"));
        } else {
            try {
                client = ServiceFactoryImpl.getInstance().getClientService().getByLogin(userName);
                if (client != null) {
                    if (password.equals(client.getPassword())) {
                        Client.Role userRole = client.getRole();
                        requestAttributes.put("userName", userName);
                        sessionAttributes.put("loginedUser", client);
                        sessionAttributes.put("clientRole", userRole);
                        MyUtils.storeUserCookie(response, client);

                        page = ConfigurationManager.getProperty("path.page.main");
                        log.log(Level.INFO, "Login completed for user " + client.getUserName());
                    } else {
                        requestAttributes.put("errorLoginPassMessage",
                                MessageManager.getProperty("message.loginerror"));
                        page = ConfigurationManager.getProperty("path.page.login");
                        log.log(Level.DEBUG, MessageManager.getProperty("message.loginerror"));
                    }
                }
            } catch (Exception e) {
                log.log(Level.ERROR, "login error " + e);
            }
        }
        return page;
    }
}

