package service;

import Beans.Client;
import Beans.Order;

import java.util.List;

public interface ClientService {

    void create(Client client);

    Client getById(Integer id);

    Client getByLogin(String login);

    Client checkLogin(String login, String password);

    void update(Client client);

    void delete(Client client);

    List<Client> getAll();

    List<Order> getAllOrders();

}
