package dao.mysql;


import Beans.ShipPorts;
import connection.MySqlConnectionPool;
import dao.ShipPortsDao;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlShipPortsDao implements ShipPortsDao {
    private static final Logger log = LogManager.getLogger(MySqlShipPortsDao.class.getName());

    @Override
    public void add(ShipPorts shipPorts) {
        String sqlStatement = "INSERT INTO ship_ports (ship_id, port_id) VALUES (?,?)";
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement,
                    Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, shipPorts.getShipId());
            statement.setInt(2, shipPorts.getPortId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                log.log(Level.INFO, "Creating shipPort failed: no rows affected");
            }
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (!generatedKeys.next()) {
                log.log(Level.INFO, "Creating shipPort failed: no id obtained");
            }
            generatedKeys.close();
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't create shipPort" + e);
        }
    }

    @Override
    public void updatePortId(ShipPorts shipPorts) {
        String sqlStatement = "UPDATE ship_ports SET port_id=? WHERE (ship_id = ? AND port_id=?)";
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement);
            statement.setInt(1, shipPorts.getPortId());
            statement.setInt(2, shipPorts.getShipId());
            statement.setInt(3, shipPorts.getPortId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                log.log(Level.INFO, "Updating ship_port failed: no rows affected");
            }
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't update ship_port" + e);
        }
    }

    @Override
    public void delete(ShipPorts shipPorts) {
        String sqlStatement = "DELETE FROM ship_ports WHERE (ship_id = ? AND port_id=?)";
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement);
            statement.setInt(1, shipPorts.getShipId());
            statement.setInt(2, shipPorts.getPortId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                log.log(Level.INFO, "Deleting ship_port failed: no rows affected");
            }
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't delete ship_port" + e);
        }
    }

    @Override
    public List<ShipPorts> getAll() {
        return null;
    }

    @Override
    public ShipPorts getByShipIdAndPortId(Integer shipId, Integer portId) {
        String sqlStatement = "SELECT * FROM ship_ports WHERE (ship_id = ? AND port_id=?)";
        ShipPorts shipPorts = null;
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement);
            statement.setInt(1, shipId);
            statement.setInt(2, portId);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                log.log(Level.INFO, "ship_ports doesn't exist");
            }
            Integer ship_Id = resultSet.getInt("ship_id");
            Integer port_Id = resultSet.getInt("port_id");


            shipPorts = new ShipPorts(ship_Id, port_Id);
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't get ship_port by ship and port id" + e);
        }
        return shipPorts;
    }

    @Override
    public List<ShipPorts> getAllByShipId(Integer shipId) {

        String sqlStatement = "SELECT * FROM ship_ports WHERE ship_id =?";
        List<ShipPorts> shipPortsList = new ArrayList<>();
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement);
            statement.setInt(1, shipId);
            ResultSet resultSet = statement.executeQuery();


            while (resultSet.next()) {
                Integer ship_id = resultSet.getInt("ship_id");
                Integer port_id = resultSet.getInt("port_id");


                ShipPorts shipPorts = new ShipPorts(ship_id, port_id);
                shipPortsList.add(shipPorts);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't get all ship_port by ship id " + e);
        }
        return shipPortsList;


    }
}
