package controllers.servlets.command;


import Beans.Cruise;
import Beans.Port;
import Beans.Ship;
import controllers.resourse.ConfigurationManager;
import controllers.resourse.MessageManager;
import dao.mysql.MySqlShipDao;
import service.impl.ServiceFactoryImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Collectors;

public class CruiseInfoCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {

        Integer shipId = Integer.valueOf(request.getParameter("shipId"));
//        if (action == null || action.isEmpty()) {
//// если команда не задана в текущем запросе
//            return current;
//        }
        String page = null;
        Ship ship;
        Cruise cruiseUsual;
        Cruise cruisePremium;
        try {
            // Найти ship & cruise в DB.
//            MySqlShipDao mySqlShipDao = new MySqlShipDao();
            ship = ServiceFactoryImpl.getInstance().getShipService().getById(shipId);
//                    mySqlShipDao.getById(shipId);
            cruiseUsual = ServiceFactoryImpl.getInstance().getCruiseService().getByShipIdAndCruiseClass(shipId, "USUAL");
            cruisePremium = ServiceFactoryImpl.getInstance().getCruiseService().getByShipIdAndCruiseClass(shipId, "PREMIUM");

            if (ship != null || cruiseUsual != null || cruisePremium != null) {

                request.setAttribute("cruiseUsual", cruiseUsual);
                request.setAttribute("cruisePremium", cruisePremium);
                request.setAttribute("ship", ship);
                String str = ship.getRoute().stream().map(Port::getPortName).collect(Collectors.joining(","));
                request.setAttribute("shipRoute", str);

                page = ConfigurationManager.getProperty("path.page.tourInfo");
            } else {
                MessageManager.getProperty("message.shipInfoerror");
                page = ConfigurationManager.getProperty("path.page.main");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return page;
    }

}
