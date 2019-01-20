package dao;

import Beans.Client;

import java.util.List;

public interface ClientDao {

    void create(Client user);

    Client getById(Integer id);

    Client getByLogin(String login);

    Client checkLogin(String login, String password);

    void update(Client user);

    void delete(Client user);

    List<Client> getAll();

}