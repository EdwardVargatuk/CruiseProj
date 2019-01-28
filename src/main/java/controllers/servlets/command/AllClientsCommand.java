package controllers.servlets.command;

import Beans.Client;
import controllers.utils.ConfigurationManager;
import controllers.utils.SessionRequestContent;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.impl.ServiceFactoryImpl;

import java.util.List;
import java.util.Map;

/**
 * AllClient command for get list of all clients who registered on web service
 *
 * @author Edward
 */

public class AllClientsCommand implements ActionCommand {
    private static final Logger log = LogManager.getLogger(MyOrderCommand.class.getName());

    @Override
    public String execute(SessionRequestContent sessionRequestContent) {
        Map<String, Object> requestAttributes = sessionRequestContent.getRequestAttributes();
        String page;
        List<Client> clientList;
        clientList = ServiceFactoryImpl.getInstance().getClientService().getAll();
        requestAttributes.put("clientList", clientList);
        page = ConfigurationManager.getProperty("path.page.allClients");
        log.log(Level.INFO, "Get All clients command finished");
        return page;
    }
}
