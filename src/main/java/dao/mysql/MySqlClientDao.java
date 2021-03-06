package dao.mysql;

import Beans.Client;
import connection.MySqlConnectionPool;
import dao.ClientDao;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MySqlClientDao implements ClientDao {
    private static final Logger log = LogManager.getLogger(MySqlClientDao.class.getName());

    MySqlClientDao() {
    }

    @Override
    public void create(Client client) {
        String sqlStatement = "INSERT INTO user (user_name, password, role) VALUES (?, ?, ?)";
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement,
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, client.getUserName());
            statement.setString(2, client.getPassword());
            statement.setString(3, (client.getRole().toString()));
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                log.log(Level.INFO, "Creating user failed: no rows affected");
//                throw new RuntimeException("Creating user failed: no rows affected.");
            }
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (!generatedKeys.next()) {
                log.log(Level.INFO, "Creating user failed: no id obtained");
//                throw new RuntimeException("Creating user failed: no id obtained.");
            }
            Integer id = generatedKeys.getInt(1);
            client.setId(id);
            generatedKeys.close();
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't create user" + e);
        }
    }

    @Override
    public Client getById(Integer id) {
        String sqlStatement = "SELECT * FROM user WHERE id = ?";
        Client client = null;
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                log.log(Level.INFO, "User with id " + id + " doesn't exist");
//                throw new RuntimeException("User with id " + id + " doesn't exist");
            }
            String user_name = resultSet.getString("user_name");
            String password = resultSet.getString("password");
            String role = resultSet.getString("role");

            client = new Client.Builder().setId(id).setUserName(user_name).setPassword(password).setRole(Client.Role.valueOf(role)).build();
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't get user by id" + e);
        }
        return client;
    }

    @Override
    public Client getByLogin(String login) {
        String sqlStatement = "SELECT id, user_name, password, role " +
                "FROM user  WHERE user_name = ?";
        Client client = null;
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String role = resultSet.getString("role");
                String clientName = resultSet.getString("user_name");
                String clientPassword = resultSet.getString("password");
                client = new Client.Builder().setId(id).setUserName(clientName).setPassword(clientPassword).setRole(Client.Role.valueOf(role)).build();
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't get user by login " + login + " " + e);
        }
        return client;
    }


    @Override
    public void update(Client client) {
        String sqlStatement = "UPDATE user SET user_name = ?, password = ?, role =? WHERE id = ?";
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement);
            statement.setString(1, client.getUserName());
            statement.setString(2, client.getPassword());
            statement.setString(3, (client.getRole().toString()));
            statement.setInt(4, client.getId());

            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                log.log(Level.INFO, "Updating user failed: no rows affected");
            }
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't update user" + e);
        }
    }

    @Override
    public void delete(Client client) {
        String sqlStatement = "DELETE FROM user WHERE id = ?";
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement);
            statement.setInt(1, client.getId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                log.log(Level.INFO, "Deleting user failed: no rows affected");
            }
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't delete user" + e);
        }
    }

    @Override
    public List<Client> getAll() {
        String sqlStatement = "SELECT * FROM user";
        List<Client> clients = new ArrayList<>();
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlStatement);
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String userName = resultSet.getString("user_name");
                String password = resultSet.getString("password");
                String role = resultSet.getString("role");

                Client client = new Client.Builder().setId(id).setUserName(userName).setPassword(password).setRole(Client.Role.valueOf(role)).build();
                clients.add(client);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            log.log(Level.ERROR, "Can't get all users" + e);
        }
        return clients;
    }

}