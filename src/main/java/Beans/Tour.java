package Beans;

import connection.mysql.MySqlConnectionPool;
import dao.mysql.MySqlUserDao;

import java.sql.Connection;
import java.sql.SQLException;

public class Tour extends Entity{
    private String code;
    private String name;
    private float price;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Tour(int id, String code, String name, float price) {
        super(id);
        this.code = code;
        this.name = name;
        this.price = price;
    }
    public static void main(String[] args) {
        try {
            Connection con = MySqlConnectionPool.getConnection();
            System.out.println("connect");
        } catch (SQLException e) {
            e.printStackTrace();
        }


        //        DaoConnection conn = MySqlConnectionPool.getInstance().getConnection();
        MySqlUserDao mySqlUserDao = new MySqlUserDao();
        Client user = mySqlUserDao.getByLogin("Ann");

        System.out.println(user);


    }
}
