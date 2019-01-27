package service;

import Beans.Cruise;
import Beans.Excursion;

import java.util.List;

public interface ExcursionService {

    void create(Excursion excursion);

    void delete(Excursion excursion);

    void update(Excursion excursion);

    List<Excursion> getAll();

    List<Excursion> getAllByPortId(Integer portId);

    List<Excursion> getAllByCruise(Cruise cruise);


    Excursion getById(Integer id);
}
