package dao;

import Beans.CruiseBonus;

import java.util.List;

public interface CruiseBonusDao {

    void add(CruiseBonus cruiseBonus);

    void updateBonusId(CruiseBonus cruiseBonus);

    void delete(CruiseBonus cruiseBonus);

    List<CruiseBonus> getAllByCruiseId(Integer cruiseId);

    CruiseBonus getByCruiseIdAndBonusId(int cruiseId, int bonusId);

}
