package dao.mysql;

import Beans.CruiseBonus;
import connection.MySqlConnectionPool;
import dao.CruiseBonusDao;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlCruiseBonusDao implements CruiseBonusDao {
    private static final Logger log = LogManager.getLogger(MySqlCruiseBonusDao.class.getName());

    @Override
    public void add(CruiseBonus cruiseBonus) {
        String sqlStatement = "INSERT INTO cruise_bonus (cruise_id, bonus_id) VALUES (?,?)";
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement,
                    Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, cruiseBonus.getCruiseId());
            statement.setInt(2, cruiseBonus.getBonusId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                log.log(Level.INFO, "Creating cruiseBonus failed: no rows affected");
            }
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (!generatedKeys.next()) {
                log.log(Level.INFO, "Creating cruiseBonus failed: no id obtained");
            }
            generatedKeys.close();
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't create cruiseBonus" + e);
        }
    }

    @Override
    public void updateBonusId(CruiseBonus cruiseBonus) {
        String sqlStatement = "UPDATE cruise_bonus SET bonus_id=? WHERE (cruise_id = ? AND bonus_id=?)";
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement);
            statement.setInt(1, cruiseBonus.getBonusId());
            statement.setInt(2, cruiseBonus.getCruiseId());
            statement.setInt(3, cruiseBonus.getBonusId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                log.log(Level.INFO, "Updating cruiseBonus failed: no rows affected");
            }
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't update cruiseBonus" + e);
        }
    }

    @Override
    public void delete(CruiseBonus cruiseBonus) {
        String sqlStatement = "DELETE FROM cruise_bonus WHERE (cruise_id = ? AND bonus_id=?)";
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement);
            statement.setInt(1, cruiseBonus.getCruiseId());
            statement.setInt(2, cruiseBonus.getBonusId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                log.log(Level.INFO, "Deleting cruiseBonus failed: no rows affected");
            }
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't delete cruiseBonus" + e);
        }
    }

    @Override
    public List<CruiseBonus> getAllByCruiseId(Integer cruiseId) {
        String sqlStatement = "SELECT * FROM cruise_bonus WHERE cruise_id =?";
        List<CruiseBonus> cruiseBonuses = new ArrayList<>();
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement);
            statement.setInt(1, cruiseId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Integer cruise_id = resultSet.getInt("cruise_id");
                Integer bonusId = resultSet.getInt("bonus_id");


                CruiseBonus cruiseBonus = new CruiseBonus(cruise_id, bonusId);
                cruiseBonuses.add(cruiseBonus);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't get all cruise bonus by cruise id " + e);
        }
        return cruiseBonuses;
    }

    @Override
    public CruiseBonus getByCruiseIdAndBonusId(int cruiseId, int bonusId) {
        String sqlStatement = "SELECT * FROM cruise_bonus WHERE (cruise_id= ? AND bonus_id=?)";
        CruiseBonus cruiseBonus = null;
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement);
            statement.setInt(1, cruiseId);
            statement.setInt(2, bonusId);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                log.log(Level.INFO, "cruiseBonus doesn't exist");
            }
            Integer cruise_Id = resultSet.getInt("cruise_id");
            Integer bonus_Id = resultSet.getInt("bonus_id");


            cruiseBonus = new CruiseBonus(cruise_Id, bonus_Id);
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't get cruiseBonus by cruise and bonus id" + e);
        }
        return cruiseBonus;
    }
}
