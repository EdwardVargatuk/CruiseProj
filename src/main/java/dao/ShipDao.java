package dao;

import Beans.Ship;

import java.util.List;

public interface ShipDao {

    void create(Ship ship);

    Ship getById(Integer id);

    Ship getByName(String name);

    void update(Ship ship);

    void delete(Ship ship);

    List<Ship> getAll();
}
