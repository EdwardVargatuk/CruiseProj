package controllers.servlets.command;

import Beans.*;
import controllers.utils.ConfigurationManager;
import controllers.utils.SessionRequestContent;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.impl.ServiceFactoryImpl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * ViewOrderInfo command for obtain detail info about each order
 *
 * @author Edward
 */

public class ViewOrderInfoCommand implements ActionCommand {
    private static final Logger log = LogManager.getLogger(ViewOrderInfoCommand.class.getName());

    @Override
    public String execute(SessionRequestContent sessionRequestContent) {
        Map<String, Object> requestAttributes = sessionRequestContent.getRequestAttributes();
        String page = null;

        Integer cruise_id = Integer.valueOf(sessionRequestContent.getRequestParameter("cruise_Id"));
        Cruise cruise = ServiceFactoryImpl.getInstance().getCruiseService().getById(cruise_id);
        if (cruise != null) {
            List<Bonus> bonusList = ServiceFactoryImpl.getInstance().getBonusService().getAllByCruiseId(cruise_id);
            String str;
            str = bonusList.stream().map(Bonus::getBonusName).collect(Collectors.joining(","));
            Ship ship = ServiceFactoryImpl.getInstance().getShipService().getById(cruise.getShip_id());

            requestAttributes.put("viewedCruise", cruise);
            requestAttributes.put("viewedCruiseShip", ship);
            requestAttributes.put("viewedCruiseBonus", str);
            page = ConfigurationManager.getProperty("path.page.clientOrderInfoPage");
            log.log(Level.INFO, "Client-view info about cruise command finished");
        }
        return page;
    }
}
