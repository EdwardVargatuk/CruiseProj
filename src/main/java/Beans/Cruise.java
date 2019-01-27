package Beans;

import java.util.Date;
import java.util.List;

public class Cruise extends Entity {


    public Cruise(Integer id, Integer ship_id, CruiseClass cruiseClass, double price, Date date, List<Client> clientList) {
        super(id);
        this.ship_id = ship_id;
        this.cruiseClass = cruiseClass;
        this.price = price;
        this.date = date;
        this.clientList = clientList;
    }

    public Cruise(Integer id, Integer ship_id, CruiseClass cruiseClass, double price, Date date) {
        super(id);
        this.ship_id = ship_id;
        this.cruiseClass = cruiseClass;
        this.price = price;
        this.date = date;
    }

    public enum CruiseClass {
        USUAL, PREMIUM
    }

    private Integer ship_id;
    private CruiseClass cruiseClass;
    private double price;
    private Date date;
    private List<Client> clientList;


    public Cruise() {
    }

    @Override
    public String toString() {
        return "Cruise{" +
                "ship_id=" + ship_id +
                ", cruiseClass=" + cruiseClass +
                ", price=" + price +
                ", date=" + date +
                ", clientList=" + clientList +
                '}';
    }

    public Integer getShip_id() {
        return ship_id;
    }

    public void setShip_id(Integer ship_id) {
        this.ship_id = ship_id;
    }

    public CruiseClass getCruiseClass() {
        return cruiseClass;
    }

    public void setCruiseClass(CruiseClass cruiseClass) {
        this.cruiseClass = cruiseClass;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }


}
