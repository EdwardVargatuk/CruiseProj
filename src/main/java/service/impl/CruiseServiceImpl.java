package service.impl;

import Beans.Cruise;
import dao.mysql.MySqlDaoFactory;
import service.CruiseService;

import java.util.List;

public class CruiseServiceImpl implements CruiseService {

    @Override
    public void create(Cruise cruise) {
        MySqlDaoFactory.getInstance().getCruiseDao().create(cruise);
    }

    @Override
    public Cruise getById(Integer id) {
        return MySqlDaoFactory.getInstance().getCruiseDao().getById(id);
    }

    @Override
    public Cruise getByShipIdAndCruiseClass(Integer shipId, String cruiseClass) {
        return MySqlDaoFactory.getInstance().getCruiseDao().getByShipIdAndCruiseClass(shipId, cruiseClass);
    }

    @Override
    public void update(Cruise cruise) {
        MySqlDaoFactory.getInstance().getCruiseDao().update(cruise);
    }

    @Override
    public void delete(Cruise cruise) {
        MySqlDaoFactory.getInstance().getCruiseDao().delete(cruise);
    }

    @Override
    public List<Cruise> getAll() {
        return MySqlDaoFactory.getInstance().getCruiseDao().getAll();
    }
}
