package service;

import Beans.Port;
import Beans.PortExcursion;

import java.util.List;

public interface PortService {

    void create(Port port);

    void delete(Port port);

    void update(Port port);

    List<Port> getAllByShipId(Integer shipId);

    List<Port> getAll();

    Port getById(Integer id);

    List<PortExcursion> getAllPortExcursionByExcursionId(Integer excursionId, Integer portId);
}
