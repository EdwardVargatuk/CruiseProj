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
        Integer shipId = Integer.valueOf(sessionRequestContent.getRequestParameter("shipId"));
        String page = null;
        Ship ship;
        Cruise cruiseUsual;
        Cruise cruisePremium;

        try {
            // Найти ship & cruise в DB.
            ship = ServiceFactoryImpl.getInstance().getShipService().getById(shipId);
            cruiseUsual = ServiceFactoryImpl.getInstance().getCruiseService().getByShipIdAndCruiseClass(shipId, "USUAL");
            cruisePremium = ServiceFactoryImpl.getInstance().getCruiseService().getByShipIdAndCruiseClass(shipId, "PREMIUM");
            if (ship != null || cruiseUsual != null || cruisePremium != null) {
                requestAttributes.put("cruiseUsual", cruiseUsual);
                requestAttributes.put("cruisePremium", cruisePremium);
                requestAttributes.put("ship", ship);
                String str = null;
                if (ship != null) {
                    str = ship.getRoute().stream().map(Port::getPortName).collect(Collectors.joining(","));
                }
                requestAttributes.put("shipRoute", str);
                page = ConfigurationManager.getProperty("path.page.tourInfo");
                log.log(Level.INFO, "get info about ship");
            } else {
                MessageManager.getProperty("message.shipInfoerror");
                page = ConfigurationManager.getProperty("path.page.main");
                log.log(Level.DEBUG, MessageManager.getProperty("message.shipInfoerror"));
            }
        } catch (Exception e) {
            log.log(Level.ERROR, "cruise info error " + e);
        }
        return page;
    }
}
