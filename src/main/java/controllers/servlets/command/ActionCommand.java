package controllers.servlets.command;

import controllers.utils.SessionRequestContent;

public interface ActionCommand {
    String execute(SessionRequestContent sessionRequestContent);
}
