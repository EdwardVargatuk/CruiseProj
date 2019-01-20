package dao.mysql;


import Beans.Order;
import connection.MySqlConnectionPool;
import dao.OrderDao;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlOrderDao implements OrderDao {
    private static final Logger log = LogManager.getLogger(MySqlOrderDao.class.getName());

    @Override
    public void create(Order order) {
        String sqlStatement = "INSERT INTO order (cruise_id, total_price) VALUES (?,?)";
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement,
                    Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, order.getCruiseId());
            statement.setDouble(2, order.getTotalPrice());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                log.log(Level.INFO, "Creating order failed: no rows affected");
            }
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (!generatedKeys.next()) {
                log.log(Level.INFO, "Creating order failed: no id obtained");
            }
            int id = generatedKeys.getInt(1);
            order.setId(id);
            generatedKeys.close();
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't create order" + e);
        }

    }

    @Override
    public void delete(Order order) {
        String sqlStatement = "DELETE FROM order WHERE id = ?";
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement);
            statement.setInt(1, order.getId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                log.log(Level.INFO, "Deleting order failed: no rows affected");
            }
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't delete order" + e);
        }
    }

    @Override
    public void update(Order order) {
        String sqlStatement = "UPDATE order SET cruise_id=?, total_price = ? WHERE id = ?";
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement);
            statement.setInt(1, order.getCruiseId());
            statement.setDouble(2, order.getTotalPrice());
            statement.setInt(3, order.getId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                log.log(Level.INFO, "Updating order failed: no rows affected");
            }
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't update order" + e);
        }
    }

    @Override
    public List<Order> getAll() {
        String sqlStatement = "SELECT * FROM order";
        List<Order> orderList = new ArrayList<>();
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlStatement);
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                Integer cruiseId = resultSet.getInt("cruise_id");
                double totalPrice = resultSet.getDouble("total_price");

                Order order = new Order(id, cruiseId, totalPrice);
                orderList.add(order);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't get all orders" + e);
        }
        return orderList;
    }

    @Override
    public Order getById(Integer id) {
        String sqlStatement = "SELECT * FROM order WHERE id = ?";
        Order order = null;
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                log.log(Level.INFO, "Order with id " + id + " doesn't exist");
            }
            Integer cruiseId = resultSet.getInt("cruise_id");
            double totalPrice = resultSet.getDouble("total_price");

            order = new Order(id, cruiseId, totalPrice);
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't get order by id" + e);
        }
        return order;
    }
}
