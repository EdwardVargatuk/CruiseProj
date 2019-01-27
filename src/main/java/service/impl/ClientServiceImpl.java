package service.impl;

import Beans.Client;
import Beans.Order;
import dao.mysql.MySqlDaoFactory;
import service.ClientService;

import java.util.List;

public class ClientServiceImpl implements ClientService {

    @Override
    public void create(Client client) {
        MySqlDaoFactory.getInstance().getClientDao().create(client);
    }

    @Override
    public Client getById(Integer id) {
        return MySqlDaoFactory.getInstance().getClientDao().getById(id);
    }

    @Override
    public Client getByLogin(String login) {
        return MySqlDaoFactory.getInstance().getClientDao().getByLogin(login);
    }

    @Override
    public void update(Client client) {
        MySqlDaoFactory.getInstance().getClientDao().update(client);
    }

    @Override
    public void delete(Client client) {
        MySqlDaoFactory.getInstance().getClientDao().delete(client);
    }

    @Override
    public List<Client> getAll() {
        return MySqlDaoFactory.getInstance().getClientDao().getAll();
    }

    //not use yet
//    @Override
//    public List<Order> getAllOrders(Integer clientId, Integer cruiseId) {
//        List<Order> orderList = MySqlDaoFactory.getInstance().getOrderDao().getAll();
//        for (Order orders : orderList) {
//            MySqlDaoFactory.getInstance().getOrderDao().getByClientIdAndCruiseId(clientId, cruiseId);
//        }
//    }
}
