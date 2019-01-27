package controllers.servlets.command;


import controllers.utils.ConfigurationManager;
import controllers.utils.SessionRequestContent;

/**
 * Empty command - default command
 *
 * @author Edward
 */

public class EmptyCommand implements ActionCommand {
    @Override
    public String execute(SessionRequestContent sessionRequestContent) {
        /* в случае ошибки или прямого обращения к контроллеру
         * переадресация на страницу ввода логина*/
        return ConfigurationManager.getProperty("path.page.login");
    }
}
