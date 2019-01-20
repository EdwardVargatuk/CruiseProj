package dao.mysql;


import dao.*;

public class MySqlDaoFactory implements DaoFactory {

    private static MySqlDaoFactory instance = new MySqlDaoFactory();

    private BonusDao bonusDao;
    private ClientDao clientDao;
    private CruiseBonusDao cruiseBonusDao;
    private CruiseDao cruiseDao;
    private ExcursionDao excursionDao;
    private OrderDao orderDao;
    private PortDao portDao;
    private PortExcursionDao portExcursionDao;
    private ShipDao shipDao;
    private ShipPortsDao shipPortsDao;


    private MySqlDaoFactory() {
    }

    public static MySqlDaoFactory getInstance() {
        return instance;
    }

    @Override
    public ShipDao getShipDao() {
        if (shipDao == null)
            shipDao = new MySqlShipDao();
        return shipDao;
    }

    @Override
    public ShipPortsDao getShipPortsDao() {
        if (shipPortsDao == null)
            shipPortsDao = new MySqlShipPortsDao();
        return shipPortsDao;
    }

    @Override
    public BonusDao getBonusDao() {
        if (bonusDao == null) {
            bonusDao = new MySqlBonusDao();
        }
        return bonusDao;

    }

    @Override
    public ClientDao getClientDao() {
        if (clientDao == null) {
            clientDao = new MySqlClientDao();
        }
        return clientDao;
    }

    @Override
    public CruiseBonusDao getCruiseBonusDao() {
        if (cruiseBonusDao == null) {
            cruiseBonusDao = new MySqlCruiseBonusDao();
        }
        return cruiseBonusDao;
    }

    @Override
    public CruiseDao getCruiseDao() {
        if (cruiseDao == null) {
            cruiseDao = new MySqlCruiseDao();
        }
        return cruiseDao;
    }

    @Override
    public ExcursionDao getExcursionDao() {
        if (excursionDao == null) {
            excursionDao = new MySqlExcursionDao();
        }
        return excursionDao;
    }

    @Override
    public OrderDao getOrderDao() {
        if (orderDao == null) {
            orderDao = new MySqlOrderDao();
        }
        return orderDao;
    }

    @Override
    public PortDao getPortDao() {
        if (portDao == null) {
            portDao = new MySqlPortDao();
        }
        return portDao;
    }

    @Override
    public PortExcursionDao getPortExcursionDao() {
        if (portExcursionDao == null) {
            portExcursionDao = new MySqlPortExcursionDao();
        }
        return portExcursionDao;
    }


}