package Beans;

import java.util.List;

public class Client extends Entity {

    public Client() {
    }

    private String userName;
    private String password;
    private Role role;
    private List<Order> orders;


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Client(int id, String userName, String password, List<Order> orders) {
        super(id);
        this.userName = userName;
        this.password = password;
        this.orders = orders;
    }


    public Client(int id, String userName, String password) {
        super(id);
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Client{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public enum Role {
        OWNER, CLIENT;
    }
}
