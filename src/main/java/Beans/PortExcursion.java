package Beans;

public class PortExcursion {
    private Integer portId;
    private Integer excursionId;
    private String portName;
    private String excursionName;
    private double excursionPrice;

    @Override
    public String toString() {
        return "PortExcursion{" +
                "portId=" + portId +
                ", excursionId=" + excursionId +
                ", portName='" + portName + '\'' +
                ", excursionName='" + excursionName + '\'' +
                ", excursionPrice=" + excursionPrice +
                '}';
    }


    public PortExcursion(Integer portId, Integer excursionId, String portName, String excursionName, double excursionPrice) {
        this.portId = portId;
        this.excursionId = excursionId;
        this.portName = portName;
        this.excursionName = excursionName;
        this.excursionPrice = excursionPrice;
    }


    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }

    public String getExcursionName() {
        return excursionName;
    }

    public void setExcursionName(String excursionName) {
        this.excursionName = excursionName;
    }

    public double getExcursionPrice() {
        return excursionPrice;
    }

    public void setExcursionPrice(double excursionPrice) {
        this.excursionPrice = excursionPrice;
    }

    public PortExcursion() {
    }

    public Integer getPortId() {
        return portId;
    }

    public void setPortId(Integer portId) {
        this.portId = portId;
    }

    public Integer getExcursionId() {
        return excursionId;
    }

    public void setExcursionId(Integer excursionId) {
        this.excursionId = excursionId;
    }

    public PortExcursion(Integer portId, Integer excursionId) {
        this.portId = portId;
        this.excursionId = excursionId;
    }
}
