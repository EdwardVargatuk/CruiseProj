package Beans;

import java.util.List;

public class Ship extends Entity {

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }


    public int getCountOfPorts() {
        return countOfPorts;
    }

    public void setCountOfPorts(int countOfPorts) {
        this.countOfPorts = countOfPorts;
    }



    public int getTourDuration() {
        return tourDuration;
    }

    public void setTourDuration(int tourDuration) {
        this.tourDuration = tourDuration;
    }

    public int getStaff() {
        return staff;
    }

    public void setStaff(int staff) {
        this.staff = staff;
    }


    public void setRoute(List<Port> route) {
        this.route = route;
    }

    public List<Port> getRoute() {
        return route;
    }

    private String shipName;
    private int passengerCapacity;
    private List<Port> route;
    private int countOfPorts;
    private int tourDuration;
    private int staff;

    public Ship() {
    }

    @Override
    public String toString() {
        return "Ship{" +
                "shipName='" + shipName + '\'' +
                ", passengerCapacity=" + passengerCapacity +
                ", route=" + route +
                ", countOfPorts=" + countOfPorts +
                ", tourDuration=" + tourDuration +
                ", staff=" + staff +
                '}';
    }



    public Ship(int id, String shipName, int passengerCapacity, List<Port> route, int countOfPorts, int tourDuration, int staff) {
        super(id);
        this.shipName = shipName;
        this.passengerCapacity = passengerCapacity;
        this.route = route;
        this.countOfPorts = countOfPorts;
        this.tourDuration = tourDuration;
        this.staff = staff;
    }



    public Ship(int id, String shipName, int passengerCapacity, int countOfPorts, int tourDuration, int staff) {
        super(id);
        this.shipName = shipName;
        this.passengerCapacity = passengerCapacity;
//        this.route = route;
        this.countOfPorts = countOfPorts;
        this.tourDuration = tourDuration;
        this.staff = staff;
    }

}
