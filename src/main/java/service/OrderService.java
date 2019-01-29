package service;

import Beans.Order;

import java.util.List;

public interface OrderService {

    void create(Order order);

    void delete(Order order);

    void update(Order order);

    List<Order> getAll();

    Order getById(Integer id);

    Order getLastByClientIdAndCruiseId(Integer clientId, Integer cruiseId);

    List<Order> getAllByClientId(Integer clientId);

    List<Order> getAllByCruiseId(Integer cruiseId);
}
