package dao.mysql;


import Beans.Excursion;
import connection.MySqlConnectionPool;
import dao.ExcursionDao;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlExcursionDao implements ExcursionDao {
    private static final Logger log = LogManager.getLogger(MySqlExcursionDao.class.getName());

    @Override
    public void create(Excursion excursion) {
        String sqlStatement = "INSERT INTO excursion (excursion_name, excursion_price) VALUES (?,?)";
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement,
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, excursion.getExcursionName());
            statement.setDouble(2, excursion.getExcursionPrice());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                log.log(Level.INFO, "Creating excursion failed: no rows affected");
            }
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (!generatedKeys.next()) {
                log.log(Level.INFO, "Creating excursion failed: no id obtained");
            }
            int id = generatedKeys.getInt(1);
            excursion.setId(id);
            generatedKeys.close();
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't create excursion" + e);
        }
    }

    @Override
    public void delete(Excursion excursion) {
        String sqlStatement = "DELETE FROM excursion WHERE id = ?";
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement);
            statement.setInt(1, excursion.getId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                log.log(Level.INFO, "Deleting excursion failed: no rows affected");
            }
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't delete excursion" + e);
        }
    }

    @Override
    public void update(Excursion excursion) {
        String sqlStatement = "UPDATE excursion SET excursion_name=?, excursion_price = ? WHERE id = ?";
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement);
            statement.setString(1, excursion.getExcursionName());
            statement.setDouble(2, excursion.getExcursionPrice());
            statement.setInt(3, excursion.getId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                log.log(Level.INFO, "Updating excursion failed: no rows affected");
            }
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't update excursion" + e);
        }
    }

    @Override
    public List<Excursion> getAll() {
        String sqlStatement = "SELECT * FROM excursion";
        List<Excursion> excursionList = new ArrayList<>();
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlStatement);
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String excursionName = resultSet.getString("excursion_name");
                double excursionPrice = resultSet.getDouble("excursion_price");
                Excursion excursion = new Excursion(id, excursionName, excursionPrice);
                excursionList.add(excursion);
                            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't get all excursions" + e);
        }
        return excursionList;
    }

    @Override
    public Excursion getById(Integer id) {
        String sqlStatement = "SELECT * FROM excursion WHERE id = ?";
        Excursion excursion = null;
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                log.log(Level.INFO, "Excursion with id " + id + " doesn't exist");
            }
            String excursionName = resultSet.getString("excursion_name");
            double excursionPrice = resultSet.getDouble("excursion_price");

            excursion = new Excursion(id, excursionName, excursionPrice);
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't get excursion by id" + e);
        }
        return excursion;
    }
}
