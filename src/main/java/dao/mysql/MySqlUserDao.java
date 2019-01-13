package dao.mysql;

import Beans.Client;
import connection.mysql.MySqlConnectionPool;
import dao.ClientDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//import connection.mysql.MySqlTransactionHelper;

public class MySqlUserDao implements ClientDao {

    public MySqlUserDao() {
    }

    @Override
    public void create(Client client) {
        String sqlStatement = "INSERT INTO user (userName, password) VALUES (?, ?)";
//        try (Connection connection = MySqlTransactionHelper.getInstance().getConnection()) {
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement,
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, client.getUserName());
            statement.setString(2, client.getPassword());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new RuntimeException("Creating user failed: no rows affected.");
            }
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (!generatedKeys.next()) {
                throw new RuntimeException("Creating user failed: no id obtained.");
            }
            Integer id = generatedKeys.getInt(1);
            client.setId(id);
            generatedKeys.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException("Can't create user", e);
        }
    }

    @Override
    public Client getById(Integer id) {
        String sqlStatement = "SELECT * FROM user WHERE id = ?";
        Client client;
//        try (DaoConnection connection = MySqlTransactionHelper.getInstance().getConnection()) {
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                throw new RuntimeException("User with id " + id + " doesn't exist");
            }
            String user_name = resultSet.getString("userName");
            String password = resultSet.getString("password");

            client = new Client(id, user_name, password);
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException("Can't get user", e);
        }
        return client;
    }

    @Override
    public Client getByLogin(String login) {
        String sqlStatement = "SELECT id, userName, password " +
                "FROM user WHERE userName = ?";
        Client client = null;
//        try (DaoConnection connection = MySqlTransactionHelper.getInstance().getConnection()) {
        try (Connection connection = MySqlConnectionPool.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String user_name = resultSet.getString("userName");
                String password = resultSet.getString("password");

//                if (resultSet.wasNull()) {
//                    superiorId = null;
//                }
//
//                user = new User.Builder().setId(id).setFirstName(firstName).setLastName(lastName)
//                        .setEmail(email).setRole(User.Role.valueOf(role)).setInfo(info)
//                        .setSuperiorId(superiorId).build();
                client = new Client(id, user_name, password);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException("Can't get user", e);
        }
        return client;
    }

//    @Override
//    public Client getByLoginAndPass(String login, String password) {
//        String sqlStatement = "SELECT id, user_name, password " +
//                "FROM user WHERE user_name, password = ?,?";
//        Client client = null;
//        try (DaoConnection connection = MySqlTransactionHelper.getInstance().getConnection()) {
//            PreparedStatement statement = connection.prepareStatement(sqlStatement);
//            statement.setString(1, login);
//            ResultSet resultSet = statement.executeQuery();
//            if (resultSet.next()) {
//                Integer id = resultSet.getInt("id");
//                String user_name = resultSet.getString("user_name");
//                String password = resultSet.getString("password");
//
////                if (resultSet.wasNull()) {
////                    superiorId = null;
////                }
////
////                user = new User.Builder().setId(id).setFirstName(firstName).setLastName(lastName)
////                        .setEmail(email).setRole(User.Role.valueOf(role)).setInfo(info)
////                        .setSuperiorId(superiorId).build();
//                client = new Client(id, user_name, password);
//            }
//
//            resultSet.close();
//            statement.close();
//        } catch (SQLException e) {
//            throw new RuntimeException("Can't get user", e);
//        }
//        return client;
//    }


    @Override
    public void update(Client client) {
        String sqlStatement = "UPDATE user SET userName = ?, password = ? WHERE id = ?";
        try (Connection connection = MySqlConnectionPool.getConnection()) {
//        try (DaoConnection connection = MySqlTransactionHelper.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement);
            statement.setString(1, client.getUserName());
            statement.setString(2, client.getPassword());
            statement.setInt(3, client.getId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new RuntimeException("Updating user failed: no rows affected.");
            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException("Can't update user", e);
        }
    }

    @Override
    public void delete(Client client) {
        String sqlStatement = "DELETE FROM user WHERE id = ?";
        try (Connection connection = MySqlConnectionPool.getConnection()) {
//        try (DaoConnection connection = MySqlTransactionHelper.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sqlStatement);
            statement.setInt(1, client.getId());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new RuntimeException("Deleting user failed: no rows affected.");
            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException("Can't delete user", e);
        }
    }

    @Override
    public List<Client> getAll() {
        String sqlStatement = "SELECT * FROM user";
        List<Client> clients = new ArrayList<>();
        try (Connection connection = MySqlConnectionPool.getConnection()) {
//        try (DaoConnection connection = MySqlTransactionHelper.getInstance().getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlStatement);
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String user_name = resultSet.getString("userName");
                String password = resultSet.getString("password");

                Client client = new Client(id,user_name,password);
                clients.add(client);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException("Can't get all users.", e);
        }
        return clients;
    }

}