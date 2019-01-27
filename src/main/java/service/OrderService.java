package service;

import Beans.Order;

import java.util.List;

public interface OrderService {

    void create(Order order);

    void delete(Order order);

    void update(Order order);

    List<Order> getAll();

    Order getById(Integer id);

    Order getByClientIdAndCruiseId(Integer clientId, Integer cruiseId);
}
