package Beans;

public class Order extends Entity {

    public Order(int id, int cruiseId, double totalPrice) {
        super(id);
        this.cruiseId = cruiseId;
        this.totalPrice = totalPrice;
    }

    public Order() {
    }

    private int cruiseId;
    private  double totalPrice;


    public int getCruiseId() {
        return cruiseId;
    }

    public void setCruiseId(int cruiseId) {
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
        return "Order: {" +
                "cruise Id=" + cruiseId +
                ", total Price=" + totalPrice +
                '}';
    }
}
