package controllers.servlets.command;


import controllers.utils.ConfigurationManager;
import controllers.utils.SessionRequestContent;


/**
 * Logout command
 *
 * @author Edward
 */

public class LogoutCommand implements ActionCommand {

    @Override
    public String execute(SessionRequestContent sessionRequestContent) {
        String page = ConfigurationManager.getProperty("path.page.index");
        // уничтожение сессии
        sessionRequestContent.clearSession();
        return page;
    }
}
