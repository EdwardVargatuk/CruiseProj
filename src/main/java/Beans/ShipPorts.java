package Beans;

public class ShipPorts  {
    public ShipPorts() {
    }

    public ShipPorts(Integer shipId, Integer portId) {
        this.shipId = shipId;
        this.portId = portId;
    }

    public Integer getShipId() {
        return shipId;
    }

    public void setShipId(Integer shipId) {
        this.shipId = shipId;
    }

    public Integer getPortId() {
        return portId;
    }

    public void setPortId(Integer portId) {
        this.portId = portId;
    }

    private Integer shipId;
    private Integer portId;


    @Override
    public String toString() {
        return "ShipPorts{" +
                "shipId=" + shipId +
                ", portId=" + portId +
                '}';
    }
}
