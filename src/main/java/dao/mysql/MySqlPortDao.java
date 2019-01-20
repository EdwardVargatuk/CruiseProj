package dao.mysql;


import Beans.Port;
import connection.MySqlConnectionPool;
import dao.PortDao;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlPortDao implements PortDao {
    private static final Logger log = LogManager.getLogger(MySqlPortDao.class.getName());

    @Override
    public void create(Port port) {
        String sqlStatement = "INSERT INTO ports (port_name) VALUES (?)";
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement,
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, port.getPortName());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                log.log(Level.INFO, "Creating port failed: no rows affected");
            }
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (!generatedKeys.next()) {
                log.log(Level.INFO, "Creating port failed: no id obtained");
            }
            int id = generatedKeys.getInt(1);
            port.setId(id);
            generatedKeys.close();
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't create port" + e);
        }
    }

    @Override
    public void delete(Port port) {
        String sqlStatement = "DELETE FROM ports WHERE id = ?";
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement);
            statement.setInt(1, port.getId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                log.log(Level.INFO, "Deleting port failed: no rows affected");
            }
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't delete port" + e);
        }
    }

    @Override
    public void update(Port port) {
        String sqlStatement = "UPDATE ports SET port_name = ? WHERE id = ?";
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement);
            statement.setString(1, port.getPortName());
            statement.setInt(2, port.getId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                log.log(Level.INFO, "Updating port failed: no rows affected");
            }
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't update port" + e);
        }
    }

    @Override
    public List<Port> getAll() {
        String sqlStatement = "SELECT * FROM ports";
        List<Port> portList = new ArrayList<>();
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlStatement);
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String portName = resultSet.getString("port_name");

                Port port = new Port(id, portName);
                portList.add(port);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't get all ports" + e);
        }
        return portList;
    }



    @Override
    public Port getById(Integer id) {
        String sqlStatement = "SELECT * FROM ports WHERE id = ?";
        Port port = null;
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                log.log(Level.INFO, "Port with id " + id + " doesn't exist");
            }
            String portName = resultSet.getString("port_name");
            port = new Port(id, portName);
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't get port by id" + e);
        }
        return port;

    }

    ///////////////////////
    @Override
    public Port getByName(String portName) {
        return null;
    }
}
