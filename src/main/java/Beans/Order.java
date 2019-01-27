package Beans;

public class Order extends Entity {

    public Order(Integer id, Integer cruiseId, double totalPrice, Integer clientId) {
        super(id);
        this.cruiseId = cruiseId;
        this.totalPrice = totalPrice;
        this.clientId = clientId;
    }

    public Order() {
    }

    private Integer cruiseId;
    private  double totalPrice;
    private Integer clientId;

    public Order(Integer cruiseId, double totalPrice, Integer clientId) {
        this.cruiseId = cruiseId;
        this.totalPrice = totalPrice;
        this.clientId = clientId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getCruiseId() {
        return cruiseId;
    }

    public void setCruiseId(Integer cruiseId) {
        this.cruiseId = cruiseId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "cruiseId=" + cruiseId +
                ", totalPrice=" + totalPrice +
                ", clientId=" + clientId +
                '}';
    }
}
