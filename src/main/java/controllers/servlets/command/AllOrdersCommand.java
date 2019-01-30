package controllers.servlets.command;

import Beans.Client;
import Beans.Order;

import controllers.utils.ConfigurationManager;
import controllers.utils.MessageManager;
import controllers.utils.SessionRequestContent;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.impl.ServiceFactoryImpl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * AllOrders command for get list of all confirmed orders
 *
 * @author Edward
 */

public class AllOrdersCommand implements ActionCommand {
    private static final Logger log = LogManager.getLogger(AllCruisesCommand.class.getName());

    @Override
    public String execute(SessionRequestContent sessionRequestContent) {
        Map<String, Object> requestAttributes = sessionRequestContent.getRequestAttributes();
        String page;
        List<Order> orderList;
        Map<Order, Client> orderClientMap = new LinkedHashMap<>();
        orderList = ServiceFactoryImpl.getInstance().getOrderService().getAll();
        if (orderList != null) {
            orderList.forEach(order -> orderClientMap.put(order, ServiceFactoryImpl.getInstance().getClientService().getById(order.getClientId())));
            requestAttributes.put("orderClientMap", orderClientMap);
            page = ConfigurationManager.getProperty("path.page.allOrders");
            log.log(Level.INFO, "Get All orders command finished");
        } else {
            requestAttributes.put("orderListNull", MessageManager.getProperty("message.orderListNullError"));
            page = ConfigurationManager.getProperty("path.page.allOrders");
            log.log(Level.WARN, MessageManager.getProperty("message.orderListNullError"));
        }
        return page;
    }
}
