package service.impl;

import Beans.Port;

import dao.mysql.MySqlDaoFactory;
import service.PortService;


import java.util.ArrayList;
import java.util.List;


public class PortServiceImpl implements PortService {
    @Override
    public void create(Port port) {
        MySqlDaoFactory.getInstance().getPortDao().create(port);
    }

    @Override
    public void delete(Port port) {
        MySqlDaoFactory.getInstance().getPortDao().delete(port);
    }

    @Override
    public void update(Port port) {
        MySqlDaoFactory.getInstance().getPortDao().update(port);
    }

    @Override
    public List<Port> getAllByShipId(Integer shipId) {


        List<Port> portList = new ArrayList<>();
        MySqlDaoFactory.getInstance().getShipPortsDao().getAllByShipId(shipId)
                .forEach(ports -> portList.add(MySqlDaoFactory.getInstance().getPortDao().getById(ports.getPortId())));
        return portList;
    }

    @Override
    public List<Port> getAll() {
        return MySqlDaoFactory.getInstance().getPortDao().getAll();
    }

    @Override
    public Port getById(Integer id) {
        return MySqlDaoFactory.getInstance().getPortDao().getById(id);
    }

}
