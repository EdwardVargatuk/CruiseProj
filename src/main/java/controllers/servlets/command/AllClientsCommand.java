package controllers.servlets.command;

import Beans.Client;
import controllers.utils.ConfigurationManager;
import controllers.utils.SessionRequestContent;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.impl.ServiceFactoryImpl;

import java.util.*;

/**
 * AllClient command for get list of all clients who registered on web service
 *
 * @author Edward
 */

public class AllClientsCommand implements ActionCommand {
    private static final Logger log = LogManager.getLogger(AllClientsCommand.class.getName());

    @Override
    public String execute(SessionRequestContent sessionRequestContent) {
        Map<String, Object> requestAttributes = sessionRequestContent.getRequestAttributes();
        String page;
        List<Client> clientList;
        clientList = ServiceFactoryImpl.getInstance().getClientService().getAll();
        Map<Client, Integer> clientListWithNumOrders = new LinkedHashMap<>();
        clientList.forEach(client -> clientListWithNumOrders.put(client, ServiceFactoryImpl.getInstance().getOrderService().getAllByClientId(client.getId()).size()));
//        for (Client client : clientList) {
//            List<Order> orders = ServiceFactoryImpl.getInstance().getOrderService().getAllByClientId(client.getId());
//            long count = (long) orders.size();
//            clientListWithNumOrders.put(client, count);
//        }
        requestAttributes.put("clientListWithNumOrders", clientListWithNumOrders);
        page = ConfigurationManager.getProperty("path.page.allClients");
        log.log(Level.INFO, "Get All clients command finished");
        return page;
    }
}
