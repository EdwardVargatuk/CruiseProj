package service;

import Beans.Port;

import java.util.List;

public interface PortService {

    void create(Port port);

    void delete(Port port);

    void update(Port port);

    List<Port> getAllByShipId(Integer shipId);

    List<Port> getAll();

    Port getById(Integer id);
}
