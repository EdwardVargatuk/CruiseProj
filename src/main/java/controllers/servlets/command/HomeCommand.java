package controllers.servlets.command;

import controllers.utils.ConfigurationManager;
import controllers.utils.SessionRequestContent;


/**
 * Home command bring to main.jsp
 *
 * @author Edward
 */

public class HomeCommand implements ActionCommand {
    @Override
    public String execute(SessionRequestContent sessionRequestContent) {
        return ConfigurationManager.getProperty("path.page.main");
    }
}
