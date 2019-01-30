package controllers.servlets.command;


import Beans.Cruise;
import Beans.Ship;
import controllers.utils.ConfigurationManager;
import controllers.utils.SessionRequestContent;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.impl.ServiceFactoryImpl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * AllCruises command for get list of all cruise in company
 *
 * @author Edward
 */

public class AllCruisesCommand implements ActionCommand {
    private static final Logger log = LogManager.getLogger(AllCruisesCommand.class.getName());

    @Override
    public String execute(SessionRequestContent sessionRequestContent) {
        Map<String, Object> requestAttributes = sessionRequestContent.getRequestAttributes();
        String page;
        List<Cruise> cruiseList;
        Map<Cruise, Ship> cruiseShipMap = new LinkedHashMap<>();
        cruiseList = ServiceFactoryImpl.getInstance().getCruiseService().getAll();
        cruiseList.forEach(cruise -> cruiseShipMap.put(cruise, ServiceFactoryImpl.getInstance().getShipService().getById(cruise.getShip_id())));
        requestAttributes.put("cruiseShipMap", cruiseShipMap);
        page = ConfigurationManager.getProperty("path.page.allCruises");
        log.log(Level.INFO, "Get All cruises command finished");
        return page;
    }
}
