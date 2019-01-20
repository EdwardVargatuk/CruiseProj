package service.impl;

import Beans.Ship;
import dao.mysql.MySqlDaoFactory;
import service.ShipService;

import java.util.ArrayList;
import java.util.List;

public class ShipServiceImpl implements ShipService {

    @Override
    public void create(Ship ship) {

    }

    @Override
    public Ship getById(Integer id) {
        Ship ship = MySqlDaoFactory.getInstance().getShipDao().getById(id);
        ship.setRoute(ServiceFactoryImpl.getInstance().getPortService().getAllByShipId(id));
        return ship;
    }

    @Override
    public void update(Ship ship) {

    }

    @Override
    public void delete(Ship ship) {

    }

    @Override
    public List<Ship> getAll() {
        return null;
    }
}
