package dao;

import Beans.PortExcursion;

import java.util.List;

public interface PortExcursionDao {

    void add(PortExcursion portExcursion);

    void updateExcursionId(PortExcursion portExcursion);

    void delete(PortExcursion portExcursion);

    List<PortExcursion> getAllByPortId(Integer portId);

    PortExcursion getByPortIdAndExcursionId(Integer portId, Integer excursionId);

}
