package service.impl;

import Beans.Ship;
import dao.mysql.MySqlDaoFactory;
import service.ShipService;

import java.util.List;

public class ShipServiceImpl implements ShipService {

    @Override
    public void create(Ship ship) {
        MySqlDaoFactory.getInstance().getShipDao().create(ship);
    }

    @Override
    public Ship getById(Integer id) {
        Ship ship = MySqlDaoFactory.getInstance().getShipDao().getById(id);
        if (ship != null)
            ship.setRoute(ServiceFactoryImpl.getInstance().getPortService().getAllByShipId(id));
        return ship;
    }

    @Override
    public void update(Ship ship) {
        MySqlDaoFactory.getInstance().getShipDao().update(ship);
    }

    @Override
    public void delete(Ship ship) {
        MySqlDaoFactory.getInstance().getShipDao().delete(ship);
    }

    @Override
    public List<Ship> getAll() {
        return MySqlDaoFactory.getInstance().getShipDao().getAll();
    }
}
