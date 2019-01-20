package dao;


import Beans.Cruise;


import java.util.List;

public interface CruiseDao {

    void create(Cruise cruise);

    Cruise getById(Integer id);

    Cruise getByShipIdAndCruiseClass(Integer shipId, String cruiseClass);

//    Cruise getByPrice( price);

    void update(Cruise cruise);

    void delete(Cruise cruise);

    List<Cruise> getAll();

}


