package service;

import Beans.Bonus;

import java.util.List;

public interface BonusService {

    void create(Bonus bonus);

    Bonus getById(Integer id);

    void update(Bonus bonus);

    void delete(Bonus bonus);

    List<Bonus> getAll();

    List<Bonus> getAllByCruiseId(Integer cruiseId);


}
