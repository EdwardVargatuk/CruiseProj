package controllers.servlets.command;

import Beans.Bonus;
import Beans.Client;
import Beans.Cruise;
import Beans.Order;

import controllers.utils.ConfigurationManager;
import controllers.utils.MessageManager;
import controllers.utils.SessionRequestContent;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import service.impl.ServiceFactoryImpl;

import java.util.List;
import java.util.Map;


/**
 * confirmOrder command for store order to DB and to Client; and to get Bonuses consider to current cruise
 *
 * @author Edward
 */

public class ConfirmOrderCommand implements ActionCommand {
    private static final Logger log = LogManager.getLogger(UpdateOrderCommand.class.getName());

    @Override
    public String execute(SessionRequestContent sessionRequestContent) {
        Map<String, Object> requestAttributes = sessionRequestContent.getRequestAttributes();
        Map<String, Object> sessionAttributes = sessionRequestContent.getSessionAttributes();
        String page;

        Client client = (Client) sessionAttributes.get("loginedUser");
        Cruise cruise = (Cruise) sessionAttributes.get("cruise");
        if (client != null || cruise != null) {
            List<Order> orderList;
            //the client already may have an order
            assert client != null;
            orderList = client.getOrders();
            //commit order to DB
            Order order = new Order(cruise.getId(), cruise.getPrice(), client.getId());
            ServiceFactoryImpl.getInstance().getOrderService().create(order);
            //for check
            Order confirmedOrder = ServiceFactoryImpl.getInstance().getOrderService().getByClientIdAndCruiseId(client.getId(), cruise.getId());
            if (confirmedOrder != null) {
                orderList.add(confirmedOrder);
                //for current user update list
                client.setOrders(orderList);
                ServiceFactoryImpl.getInstance().getClientService().update(client);
                //get all bonuses by cruise class(PREMIUM)
                List<Bonus> bonusList = ServiceFactoryImpl.getInstance().getBonusService().getAllByCruiseId(cruise.getId());

                sessionAttributes.put("submitOrder", confirmedOrder);
                sessionAttributes.put("loginedUser", client);
                sessionAttributes.put("bonusList", bonusList);
                page = ConfigurationManager.getProperty("path.page.confirmedOrder");
            } else {
                requestAttributes.put("error_orderNull", MessageManager.getProperty("message.orderError"));
                page = ConfigurationManager.getProperty("path.page.updatedOrderPage");
                log.log(Level.ERROR, MessageManager.getProperty("message.orderError"));
            }
        } else {
            requestAttributes.put("error_cruiseClientNull", MessageManager.getProperty("message.CruiseClientError"));
            page = ConfigurationManager.getProperty("path.page.updatedOrderPage");
            log.log(Level.ERROR, MessageManager.getProperty("message.CruiseClientError"));
        }
        return page;
    }
}
