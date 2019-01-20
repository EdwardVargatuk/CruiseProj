package Beans;

public class PortExcursion  {
    private Integer portId;
    private Integer excursionId;

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
