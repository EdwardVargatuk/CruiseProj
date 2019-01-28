package controllers.servlets.command;


import Beans.Cruise;
import Beans.Port;
import Beans.Ship;
import controllers.utils.ConfigurationManager;
import controllers.utils.MessageManager;
import controllers.utils.SessionRequestContent;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.impl.ServiceFactoryImpl;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * TourInfo command describes info about ship and price
 *
 * @author Edward
 */

public class CruiseInfoCommand implements ActionCommand {
    private static final Logger log = LogManager.getLogger(CruiseInfoCommand.class.getName());

    @Override
    public String execute(SessionRequestContent sessionRequestContent) {
        log.log(Level.INFO, "enter command cruiseInfo");
        Map<String, Object> requestAttributes = sessionRequestContent.getRequestAttributes();
        Map<String, Object> sessionAttributes = sessionRequestContent.getSessionAttributes();
        Integer shipId = Integer.valueOf(sessionRequestContent.getRequestParameter("shipId"));
        String page;
        Ship ship;
        Cruise cruiseUsual;
        Cruise cruisePremium;

        // find ship & cruise in DB.
        ship = ServiceFactoryImpl.getInstance().getShipService().getById(shipId);
        if (ship != null) {
            cruiseUsual = ServiceFactoryImpl.getInstance().getCruiseService().getByShipIdAndCruiseClass(shipId, "USUAL");
            cruisePremium = ServiceFactoryImpl.getInstance().getCruiseService().getByShipIdAndCruiseClass(shipId, "PREMIUM");
            requestAttributes.put("cruiseUsual", cruiseUsual);
            requestAttributes.put("cruisePremium", cruisePremium);
            sessionAttributes.put("ship", ship);
            String str;
            str = ship.getRoute().stream().map(Port::getPortName).collect(Collectors.joining(","));
            requestAttributes.put("shipRoute", str);
            page = ConfigurationManager.getProperty("path.page.tourInfo");
            log.log(Level.INFO, "get info about ship");
        } else {
            requestAttributes.put("error_ship_info", MessageManager.getProperty("message.shipInfoerror"));
            page = ConfigurationManager.getProperty("path.page.main");
            log.log(Level.ERROR, MessageManager.getProperty("message.shipInfoerror"));
        }
        return page;
    }
}
