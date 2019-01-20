package service.impl;

import Beans.Bonus;
import dao.mysql.MySqlDaoFactory;
import service.BonusService;

import java.util.ArrayList;
import java.util.List;

public class BonusServiceImpl implements BonusService {


    @Override
    public void create(Bonus bonus) {
        MySqlDaoFactory.getInstance().getBonusDao().create(bonus);
    }

    @Override
    public Bonus getById(Integer id) {
        return MySqlDaoFactory.getInstance().getBonusDao().getById(id);
    }

    @Override
    public void update(Bonus bonus) {
        MySqlDaoFactory.getInstance().getBonusDao().update(bonus);
    }

    @Override
    public void delete(Bonus bonus) {
        MySqlDaoFactory.getInstance().getBonusDao().delete(bonus);
    }

    @Override
    public List<Bonus> getAll() {
        return MySqlDaoFactory.getInstance().getBonusDao().getAll();
    }

    @Override
    public List<Bonus> getAllByCruiseId(Integer cruiseId) {
        List<Bonus> bonusList = new ArrayList<>();
        MySqlDaoFactory.getInstance().getCruiseBonusDao().getAllByCruiseId(cruiseId)
                .forEach(bonus -> bonusList.add(MySqlDaoFactory.getInstance().getBonusDao().getById(bonus.getBonusId())));
        return bonusList;
    }
}
