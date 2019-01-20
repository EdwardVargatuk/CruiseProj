package dao;

public interface DaoFactory {

    BonusDao getBonusDao();

    ClientDao getClientDao();

    CruiseBonusDao getCruiseBonusDao();

    CruiseDao getCruiseDao();

    ExcursionDao getExcursionDao();

    OrderDao getOrderDao();

    PortDao getPortDao();

    PortExcursionDao getPortExcursionDao();

    ShipDao getShipDao();

    ShipPortsDao getShipPortsDao();


}