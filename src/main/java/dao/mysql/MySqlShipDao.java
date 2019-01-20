package dao.mysql;


import Beans.Ship;
import connection.MySqlConnectionPool;
import dao.ShipDao;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlShipDao implements ShipDao {

    private static final Logger log = LogManager.getLogger(MySqlShipDao.class.getName());

    @Override
    public void create(Ship ship) {
        String sqlStatement = "INSERT INTO ship (ship_name, passenger_capacity, count_of_ports, tour_duration, staff) VALUES (?,?,?,?,?)";
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement,
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, ship.getShipName());
            statement.setInt(2, ship.getPassengerCapacity());
            statement.setInt(3, ship.getCountOfPorts());
            statement.setInt(4, ship.getTourDuration());
            statement.setInt(5, ship.getStaff());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                log.log(Level.INFO, "Creating ship failed: no rows affected");
            }
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (!generatedKeys.next()) {
                log.log(Level.INFO, "Creating ship failed: no id obtained");
            }
            int id = generatedKeys.getInt(1);
            ship.setId(id);
            generatedKeys.close();
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't create ship" + e);
        }
    }


    @Override
    public void update(Ship ship) {
        String sqlStatement = "UPDATE ship SET ship_name=?, passenger_capacity = ?, count_of_ports= ?, tour_duration=?, staff=? WHERE id = ?";
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement);
            statement.setString(1, ship.getShipName());
            statement.setInt(2, ship.getPassengerCapacity());
            statement.setInt(3, ship.getCountOfPorts());
            statement.setInt(4, ship.getTourDuration());
            statement.setInt(5, ship.getStaff());
            statement.setInt(6, ship.getId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                log.log(Level.INFO, "Updating ship failed: no rows affected");
            }
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't update ship" + e);
        }
    }

    @Override
    public void delete(Ship ship) {
        String sqlStatement = "DELETE FROM ship WHERE id = ?";
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement);
            statement.setInt(1, ship.getId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                log.log(Level.INFO, "Deleting ship failed: no rows affected");
            }
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't delete ship" + e);
        }
    }

    @Override
    public List<Ship> getAll() {
        String sqlStatement = "SELECT * FROM ship";
        List<Ship> shipList = new ArrayList<>();
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlStatement);
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String shipName = resultSet.getString("ship_name");
                Integer passengerCapacity = (resultSet.getInt("passenger_capacity"));
                int countOfPorts = resultSet.getInt("count_of_ports");
                int tourDuration = resultSet.getInt("tour_duration");
                int staff = resultSet.getInt("staff");

                Ship ship = new Ship(id, shipName, passengerCapacity, countOfPorts, tourDuration, staff);
                shipList.add(ship);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't get all ships" + e);
        }
        return shipList;
    }

    @Override
    public Ship getById(Integer id) {
        String sqlStatement = "SELECT * FROM ship WHERE id = ?";
        Ship ship = null;
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                log.log(Level.INFO, "Ship with id " + id + " doesn't exist");
            }
            String shipName = resultSet.getString("ship_name");
            int passengerCapacity = (resultSet.getInt("passenger_capacity"));
            int countOfPorts = resultSet.getInt("count_of_ports");
            int tourDuration = resultSet.getInt("tour_duration");
            int staff = resultSet.getInt("staff");

            ship = new Ship(id, shipName, passengerCapacity, countOfPorts, tourDuration, staff);
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't get ship" + e);
        }
        return ship;
    }

    @Override
    public Ship getByName(String name) {
        String sqlStatement = "SELECT id, passenger_capacity, count_of_ports, " +
                "tour_duration, staff FROM ship  WHERE ship_name = ?";
        Ship ship = null;
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String shipName = resultSet.getString("ship_name");
                int passengerCapacity = (resultSet.getInt("passenger_capacity"));
                Integer countOfPorts = resultSet.getInt("count_of_ports");
                int tourDuration = resultSet.getInt("tour_duration");
                Integer staff = resultSet.getInt("staff");

                ship = new Ship(id, shipName, passengerCapacity, countOfPorts, tourDuration, staff);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't get ship by name" + e);
        }
        return ship;
    }


}
