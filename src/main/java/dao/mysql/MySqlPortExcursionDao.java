package dao.mysql;


import Beans.PortExcursion;
import connection.MySqlConnectionPool;
import dao.PortExcursionDao;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlPortExcursionDao implements PortExcursionDao {
    private static final Logger log = LogManager.getLogger(MySqlPortExcursionDao.class.getName());

    @Override
    public void add(PortExcursion portExcursion) {
        String sqlStatement = "INSERT INTO ports_excursions (port_id, excursion_id) VALUES (?,?)";
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement,
                    Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, portExcursion.getPortId());
            statement.setInt(2, portExcursion.getExcursionId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                log.log(Level.INFO, "Creating portExcursion failed: no rows affected");
            }
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (!generatedKeys.next()) {
                log.log(Level.INFO, "Creating portExcursion failed: no id obtained");
            }
            generatedKeys.close();
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't create portExcursion" + e);
        }

    }

    @Override
    public void updateExcursionId(PortExcursion portExcursion) {
        String sqlStatement = "UPDATE ports_excursions SET excursion_id=? WHERE (port_id = ? AND excursion_id=?)";
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement);
            statement.setInt(1, portExcursion.getExcursionId());
            statement.setInt(2, portExcursion.getPortId());
            statement.setInt(3, portExcursion.getExcursionId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                log.log(Level.INFO, "Updating portExcursion failed: no rows affected");
            }
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't update portExcursion" + e);
        }
    }

    @Override
    public void delete(PortExcursion portExcursion) {
        String sqlStatement = "DELETE FROM ports_excursions WHERE (port_id = ? AND excursion_id=?)";
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement);
            statement.setInt(1, portExcursion.getPortId());
            statement.setInt(2, portExcursion.getExcursionId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                log.log(Level.INFO, "Deleting portExcursion failed: no rows affected");
            }
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't delete portExcursion" + e);
        }
    }

    @Override
    public List<PortExcursion> getAllByPortId(Integer portId) {
        String sqlStatement = "SELECT * FROM ports_excursions WHERE port_id =?";
        List<PortExcursion> portExcursionList = new ArrayList<>();
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement);
            statement.setInt(1, portId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Integer port_id = resultSet.getInt("port_id");
                Integer excursionId = resultSet.getInt("excursion_id");


                PortExcursion portExcursion = new PortExcursion(port_id, excursionId);
                portExcursionList.add(portExcursion);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't get all port excursions by port id " + e);
        }
        return portExcursionList;
    }

    @Override
    public PortExcursion getByPortIdAndExcursionId(Integer portId, Integer excursionId) {
        String sqlStatement = "SELECT * FROM ports_excursions WHERE (port_id= ? AND excursion_id=?)";
        PortExcursion portExcursion = null;
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement);
            statement.setInt(1, portId);
            statement.setInt(2, excursionId);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                log.log(Level.INFO, "portExcursion doesn't exist");
            }
            Integer port_id = resultSet.getInt("port_id");
            Integer excursion_id = resultSet.getInt("excursion_id");


            portExcursion = new PortExcursion(port_id, excursion_id);
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't get PortExcursion by port and excursion id" + e);
        }
        return portExcursion;
    }

}
