package controllers.servlets.command;

import controllers.utils.ConfigurationManager;
import controllers.utils.SessionRequestContent;

public class MyOrderCommand implements ActionCommand {
    @Override
    public String execute(SessionRequestContent sessionRequestContent) {
        String page = ConfigurationManager.getProperty("path.page.clientInfoPage");

        return page;
    }
}
