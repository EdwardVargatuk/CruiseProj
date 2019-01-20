package service;

import Beans.Ship;

import java.util.List;

public interface ShipService {

    void create(Ship ship);

    Ship getById(Integer id);

    void update(Ship ship);

    void delete(Ship ship);

    List<Ship> getAll();
}
