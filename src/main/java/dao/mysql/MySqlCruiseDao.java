package dao.mysql;

import Beans.Cruise;
import connection.MySqlConnectionPool;
import dao.CruiseDao;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlCruiseDao implements CruiseDao {
    private static final Logger log = LogManager.getLogger(MySqlCruiseDao.class.getName());

    @Override
    public void create(Cruise cruise) {
        String sqlStatement = "INSERT INTO cruise (ship_id, cruise_class, price, date) VALUES (?,?,?,?)";
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement,
                    Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, cruise.getShip_id());
            statement.setString(2, cruise.getCruiseClass().toString());
            statement.setDouble(3, cruise.getPrice());
            statement.setDate(4, (Date) cruise.getDate());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                log.log(Level.INFO, "Creating cruise failed: no rows affected");
            }
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (!generatedKeys.next()) {
                log.log(Level.INFO, "Creating cruise failed: no id obtained");
            }
            int id = generatedKeys.getInt(1);
            cruise.setId(id);
            generatedKeys.close();
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't create cruise" + e);
        }
    }


    @Override
    public void update(Cruise cruise) {
        String sqlStatement = "UPDATE cruise SET ship_id=?, cruise_class=?, price = ?," +
                " date=? WHERE id = ?";
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement);
            statement.setInt(1, cruise.getShip_id());
            statement.setString(2, cruise.getCruiseClass().toString());
            statement.setDouble(3, cruise.getPrice());
            statement.setDate(4, (Date) cruise.getDate());
            statement.setInt(5, cruise.getId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                log.log(Level.INFO, "Updating cruise failed: no rows affected");
            }
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't update cruise" + e);
        }
    }

    @Override
    public void delete(Cruise cruise) {
        String sqlStatement = "DELETE FROM cruise WHERE id = ?";
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement);
            statement.setInt(1, cruise.getId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                log.log(Level.INFO, "Deleting cruise failed: no rows affected");
            }
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't delete cruise" + e);
        }
    }


    @Override
    public Cruise getById(Integer id) {
        String sqlStatement = "SELECT ship_id, cruise_class, price, date FROM cruise WHERE id = ?";
        Cruise cruise = null;
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                log.log(Level.INFO, "Cruise with id " + id + " doesn't exist");
            }
            Integer shipId = resultSet.getInt("ship_id");
            String cruiseClass = resultSet.getString("cruise_class");
            double price = resultSet.getDouble("price");
            java.util.Date date = resultSet.getDate("date");

            cruise = new Cruise(id, shipId, Cruise.CruiseClass.valueOf(cruiseClass), price, date);
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't get cruise by id" + e);
        }
        return cruise;
    }

    @Override
    public Cruise getByShipIdAndCruiseClass(Integer shipId, String cruiseClass){
    String sqlStatement = "SELECT id, ship_id, cruise_class, price, date FROM cruise WHERE ship_id = ? AND cruise_class =?";
        Cruise cruise = null;
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement);
            statement.setInt(1, shipId);
            statement.setString(2, cruiseClass);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                log.log(Level.INFO, "Cruise with ShipId " + shipId +"and cruise class"+cruiseClass+ " doesn't exist");
            }

            Integer id = resultSet.getInt("id");
            double price = resultSet.getDouble("price");
            java.util.Date date = resultSet.getDate("date");

            cruise = new Cruise(id, shipId, Cruise.CruiseClass.valueOf(cruiseClass), price, date);
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't get cruise by ship id and cruise class" + e);
        }
        return cruise;
    }


    @Override
    public List<Cruise> getAll() {
        String sqlStatement = "SELECT ship_id, cruise_class, price, date FROM cruise";
        List<Cruise> cruiseList = new ArrayList<>();
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlStatement);
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                Integer cruiseId = resultSet.getInt("ship_id");
                String cruiseClass = resultSet.getString("cruise_class");
                double price = resultSet.getDouble("price");
                java.util.Date date = resultSet.getDate("date");

                Cruise cruise = new Cruise(id, cruiseId, Cruise.CruiseClass.valueOf(cruiseClass), price, date);
                cruiseList.add(cruise);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't get all cruises" + e);
        }
        return cruiseList;
    }
}
