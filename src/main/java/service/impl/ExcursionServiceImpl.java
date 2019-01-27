package service.impl;

import Beans.Cruise;
import Beans.Excursion;
import dao.mysql.MySqlDaoFactory;
import service.ExcursionService;

import java.util.ArrayList;
import java.util.List;

public class ExcursionServiceImpl implements ExcursionService {

    @Override
    public void create(Excursion excursion) {
        MySqlDaoFactory.getInstance().getExcursionDao().create(excursion);
    }

    @Override
    public void delete(Excursion excursion) {
        MySqlDaoFactory.getInstance().getExcursionDao().delete(excursion);
    }

    @Override
    public void update(Excursion excursion) {
        MySqlDaoFactory.getInstance().getExcursionDao().update(excursion);
    }

    @Override
    public List<Excursion> getAll() {
        return MySqlDaoFactory.getInstance().getExcursionDao().getAll();
    }

    @Override
    public List<Excursion> getAllByPortId(Integer portId) {
        List<Excursion> excursionList = new ArrayList<>();
        MySqlDaoFactory.getInstance().getPortExcursionDao().getAllByPortId(portId)
                .forEach(excursion -> excursionList.add(MySqlDaoFactory.getInstance().getExcursionDao().getById(excursion.getExcursionId())));
        return excursionList;
    }

    @Override
    public List<Excursion> getAllByCruise(Cruise cruise) {
        List<Excursion> excursionList = new ArrayList<>();
        ServiceFactoryImpl.getInstance().getPortService().getAllByShipId(cruise.getShip_id())
                .forEach(port -> excursionList.addAll( ServiceFactoryImpl.getInstance().getExcursionService()
                        .getAllByPortId(port.getId())));
        return excursionList;
    }

    @Override
    public Excursion getById(Integer id) {
        return MySqlDaoFactory.getInstance().getExcursionDao().getById(id);
    }
}
