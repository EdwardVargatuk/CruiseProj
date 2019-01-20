package service;

import Beans.Cruise;

import java.util.List;

public interface CruiseService {

    void create(Cruise cruise);

    Cruise getById(Integer id);

    Cruise getByShipIdAndCruiseClass(Integer shipId, String cruiseClass);


    void update(Cruise cruise);

    void delete(Cruise cruise);

    List<Cruise> getAll();

}
