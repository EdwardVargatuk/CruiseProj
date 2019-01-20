package service;

public interface ServiceFactory {

    BonusService getBonusService();

    ClientService getClientService();

    CruiseService getCruiseService();

    ExcursionService getExcursionService();

    OrderService getOrderService();

    PortService getPortService();

    ShipService getShipService();





}
