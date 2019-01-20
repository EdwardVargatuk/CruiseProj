package service;

import Beans.Excursion;

import java.util.List;

public interface ExcursionService {

    void create(Excursion excursion);

    void delete(Excursion excursion);

    void update(Excursion excursion);

    List<Excursion> getAll();

    List<Excursion> getAllByPortId(Integer portId);


    Excursion getById(Integer id);
}
