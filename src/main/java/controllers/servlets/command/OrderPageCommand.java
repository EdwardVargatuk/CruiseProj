package controllers.servlets.command;

import Beans.*;

import controllers.utils.ConfigurationManager;
import controllers.utils.MessageManager;
import controllers.utils.SessionRequestContent;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.impl.ServiceFactoryImpl;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ToOrder command for obtain info about excursions of cruise
 *
 * @author Edward
 */

public class OrderPageCommand implements ActionCommand {
    private static final Logger log = LogManager.getLogger(OrderPageCommand.class.getName());

    @Override
    public String execute(SessionRequestContent sessionRequestContent) {
        Map<String, Object> requestAttributes = sessionRequestContent.getRequestAttributes();
        Map<String, Object> sessionAttributes = sessionRequestContent.getSessionAttributes();
        Integer cruiseId = Integer.valueOf(sessionRequestContent.getRequestParameter("cruiseId"));
        String page;
        List<PortExcursion> portExcursionList = new ArrayList<>();
        List<PortExcursion> port_Excursions;
        //get current cruise which choose client
        Cruise cruise = ServiceFactoryImpl.getInstance().getCruiseService().getById(cruiseId);
        if (cruise != null) {
            //get excursions by cruise
            List<Excursion> excursionList = ServiceFactoryImpl.getInstance().getExcursionService().getAllByCruise(cruise);
            //get port list by cruise
            List<Port> portList = ServiceFactoryImpl.getInstance().getPortService().getAllByShipId(cruise.getShip_id());
            //get portExcursion list
            if (excursionList != null) {
                for (Excursion excursion : excursionList) {
                    for (Port port : portList) {
                        portExcursionList.addAll(ServiceFactoryImpl.getInstance().getPortService().getAllPortExcursionByExcursionId(excursion.getId(), port.getId()));
                    }
                }
                //filter portExcursionList
                Set<Integer> set = new HashSet<>(portExcursionList.size());
                port_Excursions = portExcursionList.stream().filter(p -> set.add(p.getExcursionId())).collect(Collectors.toList());

                sessionAttributes.put("cruise", cruise);
                sessionAttributes.put("excursionList", excursionList);
                sessionAttributes.put("portExcList", port_Excursions);
                page = ConfigurationManager.getProperty("path.page.orderPage");
                log.log(Level.INFO, "creation excursion list finished");
            } else {
                log.log(Level.INFO, "excursion list is empty, goes to updatedOrder");
                //if list is empty
                sessionAttributes.put("cruise", cruise);
                page = ConfigurationManager.getProperty("path.page.updatedOrderPage");
            }
        } else {
            requestAttributes.put("error_cruiseNull", MessageManager.getProperty("message.CruiseError"));
            page = ConfigurationManager.getProperty("path.page.tourInfo");
            log.log(Level.ERROR,"cruise not found");
        }
        return page;
    }
}

