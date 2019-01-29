package service.impl;

import Beans.Order;
import dao.mysql.MySqlDaoFactory;
import service.OrderService;

import java.util.List;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService {


    @Override
    public void create(Order order) {
        MySqlDaoFactory.getInstance().getOrderDao().create(order);
    }

    @Override
    public void delete(Order order) {
        MySqlDaoFactory.getInstance().getOrderDao().delete(order);
    }

    @Override
    public void update(Order order) {
        MySqlDaoFactory.getInstance().getOrderDao().update(order);
    }

    @Override
    public List<Order> getAll() {
        return MySqlDaoFactory.getInstance().getOrderDao().getAll();
    }

    @Override
    public Order getById(Integer id) {
        return MySqlDaoFactory.getInstance().getOrderDao().getById(id);
    }

    @Override
    public Order getLastByClientIdAndCruiseId(Integer clientId, Integer cruiseId) {
        return MySqlDaoFactory.getInstance().getOrderDao().getLastByClientIdAndCruiseId(clientId, cruiseId);
    }

    @Override
    public List<Order> getAllByClientId(Integer clientId) {
        List<Order> orderList = MySqlDaoFactory.getInstance().getOrderDao().getAll();
        return orderList.stream().filter(order -> order.getClientId().equals(clientId)).collect(Collectors.toList());
    }

    @Override
    public List<Order> getAllByCruiseId(Integer cruiseId) {
        List<Order> orderList = MySqlDaoFactory.getInstance().getOrderDao().getAll();
        return orderList.stream().filter(order -> order.getCruiseId().equals(cruiseId)).collect(Collectors.toList());
    }
}
