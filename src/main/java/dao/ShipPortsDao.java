package dao;

import Beans.ShipPorts;

import java.util.List;

public interface ShipPortsDao {

    void add(ShipPorts shipPorts);

    void updatePortId(ShipPorts shipPorts);

    void delete(ShipPorts shipPorts);

    List<ShipPorts> getAll();

    ShipPorts getByShipIdAndPortId(Integer shipId, Integer portId);

    List<ShipPorts> getAllByShipId(Integer shipId);
}
