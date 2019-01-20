package dao;

import Beans.Bonus;

import java.util.List;

public interface BonusDao {

    void create(Bonus bonus);

    Bonus getById(Integer id);

    Bonus getByName(String bonusName);

    void update(Bonus bonus);

    void delete(Bonus bonus);

    List<Bonus> getAll();

}
