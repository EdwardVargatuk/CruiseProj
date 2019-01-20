package dao;

import Beans.Order;


import java.util.List;

public interface OrderDao {

    void create(Order order);

    void delete(Order order);

    void update(Order order);

    List<Order> getAll();

    Order getById(Integer id);


}
