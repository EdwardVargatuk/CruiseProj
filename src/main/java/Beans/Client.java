package Beans;

import java.util.ArrayList;
import java.util.List;

public class Client extends Entity {

    public Client() {
    }

    private String userName;
    private String password;
    private Role role;
    private List<Order> orders = new ArrayList<>();


    public Role getRole() {
        return role;
    }

    private void setRole(Role role) {
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

    @Override
    public String toString() {
        return "Client{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public enum Role {
        OWNER, CLIENT
    }

    //instead of many constructors
    public static class Builder {
        private Client client;

        public Builder() {
            client = new Client();
        }

        public Builder setId(Integer id) {
            client.setId(id);
            return this;
        }

        public Builder setUserName(String userName) {
            client.setUserName(userName);
            return this;
        }

        public Builder setPassword(String password) {
            client.setPassword(password);
            return this;
        }

        public Builder setRole(Role role) {
            client.setRole(role);
            return this;
        }

        public Builder setOrders(List<Order> orders) {
            client.setOrders(orders);
            return this;
        }


        public Client build() {
            return client;
        }
    }
}
