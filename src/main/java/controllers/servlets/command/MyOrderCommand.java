package controllers.servlets.command;

import Beans.Client;
import Beans.Order;
import controllers.utils.ConfigurationManager;
import controllers.utils.SessionRequestContent;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.impl.ServiceFactoryImpl;

import java.util.List;
import java.util.Map;

/**
 * MyOrder command for getting all info about client
 *
 * @author Edward
 */

public class MyOrderCommand implements ActionCommand {
    private static final Logger log = LogManager.getLogger(MyOrderCommand.class.getName());

    @Override
    public String execute(SessionRequestContent sessionRequestContent) {
        Map<String, Object> sessionAttributes = sessionRequestContent.getSessionAttributes();
        String page;

        Client client = (Client) sessionAttributes.get("loginedUser");
        List<Order> orderList = ServiceFactoryImpl.getInstance().getOrderService().getAllByClientId(client.getId());

        sessionAttributes.put("order_list", orderList);
        page = ConfigurationManager.getProperty("path.page.clientInfoPage");
        log.log(Level.INFO, "Client-My orders command finished");
        return page;
    }
}
