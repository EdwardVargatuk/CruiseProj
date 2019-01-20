package service.impl;

import service.*;

public class ServiceFactoryImpl implements ServiceFactory {

    private static ServiceFactoryImpl instance = new ServiceFactoryImpl();

    private ServiceFactoryImpl() {
    }

    private BonusService bonusService;
    private ClientService clientService;
    private CruiseService cruiseService;
    private ExcursionService excursionService;
    private OrderService orderService;
    private PortService portService;
    private ShipService shipService;


    public static ServiceFactoryImpl getInstance() {
        return instance;
    }


    @Override
    public BonusService getBonusService() {
        if (bonusService == null) {
            bonusService = new BonusServiceImpl();
        }
        return bonusService;
    }

    @Override
    public ClientService getClientService() {
        if (clientService == null) {
            clientService = new ClientServiceImpl();
        }
        return clientService;
    }

    @Override
    public ShipService getShipService() {
        if (shipService == null) {
            shipService = new ShipServiceImpl();
        }
        return shipService;
    }

    @Override
    public PortService getPortService() {
        if (portService == null) {
            portService = new PortServiceImpl();
        }
        return portService;
    }

    @Override
    public CruiseService getCruiseService() {
        if (cruiseService == null) {
            cruiseService = new CruiseServiceImpl();
        }
        return cruiseService;
    }

    @Override
    public ExcursionService getExcursionService() {
        if (excursionService == null) {
            excursionService = new ExcursionServiceImpl();
        }
        return excursionService;
    }

    @Override
    public OrderService getOrderService() {
        if (orderService == null) {
            orderService = new OrderServiceImpl();
        }
        return orderService;
    }
}
