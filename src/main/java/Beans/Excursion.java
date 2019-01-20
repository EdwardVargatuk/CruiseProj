package Beans;

public class Excursion extends Entity {
    private String excursionName;
    private double excursionPrice;



    public Excursion(int id, String excursionName, double excursionPrice) {
        super(id);
        this.excursionName = excursionName;
        this.excursionPrice = excursionPrice;
    }

    public Excursion() {
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

    @Override
    public String toString() {
        return "Excursion{" +
                "excursionName='" + excursionName + '\'' +
                ", excursionPrice=" + excursionPrice +
                '}';
    }
}
