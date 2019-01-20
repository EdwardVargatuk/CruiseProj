package service.impl;

import Beans.Order;
import dao.mysql.MySqlDaoFactory;
import service.OrderService;

import java.util.List;

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
}
