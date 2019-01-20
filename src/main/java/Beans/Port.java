package Beans;

public class Port extends Entity {

    private String portName;


    public Port() {
    }

    public Port(Integer id, String portName) {
        super(id);
        this.portName = portName;

    }

    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }


    @Override
    public String toString() {
        return "Port: {" +
                "portName='" + portName + '\'' +
                '}';
    }
}
