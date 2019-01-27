package dao.mysql;

import Beans.Bonus;

import connection.MySqlConnectionPool;
import dao.BonusDao;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlBonusDao implements BonusDao {
    private static final Logger log = LogManager.getLogger(MySqlBonusDao.class.getName());

    @Override
    public void create(Bonus bonus) {
        String sqlStatement = "INSERT INTO bonus (bonus_name) VALUES (?)";
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement,
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, bonus.getBonusName());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                log.log(Level.INFO, "Creating bonus failed: no rows affected");
//                throw new RuntimeException("Creating bonus failed: no rows affected.");
            }
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (!generatedKeys.next()) {
                log.log(Level.INFO, "Creating bonus failed: no id obtained");
//                throw new RuntimeException("Creating user failed: no id obtained.");
            }
            int id = generatedKeys.getInt(1);
            bonus.setId(id);
            generatedKeys.close();
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't create bonus" + e);
        }
    }


    @Override
    public Bonus getById(Integer id) {
        String sqlStatement = "SELECT * FROM bonus WHERE id = ?";
        Bonus bonus = null;
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                log.log(Level.INFO, "Bonus with id " + id + " doesn't exist");
            }
            String bonusName = resultSet.getString("bonus_name");

            bonus = new Bonus(id, bonusName);
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't get bonus by id" + id + " " + e);
        }
        return bonus;
    }


    @Override
    public void update(Bonus bonus) {
        String sqlStatement = "UPDATE bonus SET bonus_name = ? WHERE id = ?";
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement);
            statement.setString(1, bonus.getBonusName());
            statement.setInt(2, bonus.getId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                log.log(Level.INFO, "Updating bonus failed: no rows affected");
            }
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't update bonus" + e);
        }
    }

    @Override
    public void delete(Bonus bonus) {
        String sqlStatement = "DELETE FROM bonus WHERE id = ?";
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement);
            statement.setInt(1, bonus.getId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                log.log(Level.INFO, "Deleting bonus failed: no rows affected");
            }
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't delete bonus" + e);
        }
    }

    @Override
    public List<Bonus> getAll() {
        String sqlStatement = "SELECT * FROM bonus";
        List<Bonus> bonuses = new ArrayList<>();
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlStatement);
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String bonusName = resultSet.getString("bonus_name");

                Bonus bonus = new Bonus(id, bonusName);
                bonuses.add(bonus);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't get all bonuses" + e);
        }
        return bonuses;
    }

    @Override
    public Bonus getByName(String bonusName) {
        String sqlStatement = "SELECT * FROM bonus  WHERE bonus_name = ?";
        Bonus bonus = null;
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement);
            statement.setString(1, bonusName);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String bonus_name = resultSet.getString("bonus_name");
                bonus = new Bonus(id, bonus_name);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't get bonus by name" + e);
        }
        return bonus;
    }

}
