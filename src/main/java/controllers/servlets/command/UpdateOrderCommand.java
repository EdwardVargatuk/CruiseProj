package controllers.servlets.command;

import Beans.Cruise;

import controllers.utils.ConfigurationManager;
import controllers.utils.SessionRequestContent;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

/**
 * updateOrder command for add excursion to cruise and update price
 *
 * @author Edward
 */

public class UpdateOrderCommand implements ActionCommand {
    private static final Logger log = LogManager.getLogger(UpdateOrderCommand.class.getName());

    @Override
    public String execute(SessionRequestContent sessionRequestContent) {
        Map<String, String[]> requestParameters = sessionRequestContent.getRequestParameters();
        Map<String, Object> sessionAttributes = sessionRequestContent.getSessionAttributes();
        double finalSum;

        Cruise cruise = (Cruise) sessionAttributes.get("cruise");
        //get checkboxes items
        String[] selecteds = requestParameters.get("selected");
        if (selecteds != null) {
            double[] doubleValues = Arrays.stream(selecteds).mapToDouble(Double::parseDouble).toArray();
            //box to Double
            List<Double> excursionPrices = Arrays.stream(doubleValues).boxed().collect(Collectors.toList());
            double sumSelectedExcursions = excursionPrices.stream().mapToDouble(x -> x).sum();
            //calculate total price
            finalSum = sumSelectedExcursions + cruise.getPrice();
        } else {
            finalSum = cruise.getPrice();
        }
        //temp cruise for price
        Cruise updatedCruise = new Cruise(cruise.getId(), cruise.getShip_id(), cruise.getCruiseClass(), finalSum, cruise.getDate());
        sessionAttributes.put("cruise", updatedCruise);
        String page = ConfigurationManager.getProperty("path.page.updatedOrderPage");
        log.log(Level.INFO, "creation excursion list finished");
        return page;
    }
}
