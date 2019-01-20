package controllers.servlets.command;

import controllers.resourse.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class HomeCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.main");

        return page;
    }
}
