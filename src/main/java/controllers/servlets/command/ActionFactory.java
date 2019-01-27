package controllers.servlets.command;


import controllers.utils.MessageManager;
import controllers.utils.SessionRequestContent;

import java.util.Map;

public class ActionFactory {
    public ActionCommand defineCommand(SessionRequestContent sessionRequestContent) {
        ActionCommand current = new EmptyCommand();
        Map<String, Object> requestAttributes = sessionRequestContent.getRequestAttributes();
        String action = sessionRequestContent.getRequestParameter("command");
        if (action == null || action.isEmpty()) {
            // если команда не задана в текущем запросе
            return current;
        }
        try {
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            requestAttributes.put("wrongAction", action + MessageManager.getProperty("message.wrongaction"));
        }
        return current;
    }
}