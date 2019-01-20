package dao;


import Beans.Excursion;

import java.util.List;

public interface ExcursionDao {

    void create(Excursion excursion);

    void delete(Excursion excursion);

    void update(Excursion excursion);

    List<Excursion> getAll();

    Excursion getById(Integer id);


}
