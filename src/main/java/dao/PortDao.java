package dao;

import Beans.Port;

import java.util.List;

public interface PortDao {

    void create(Port port);

    void delete(Port port);

    void update(Port port);

    List<Port> getAll();

    Port getById(Integer id);

    Port getByName(String portName);


}
