package dao.mysql;


import dao.ClientDao;
import dao.DaoFactory;

public class MySqlDaoFactory implements DaoFactory {

    private static MySqlDaoFactory instance = new MySqlDaoFactory();


    private ClientDao clientDao;


    private MySqlDaoFactory() {}

    public static MySqlDaoFactory getInstance() {
        return instance;
    }


    @Override
    public ClientDao getClientDao() {
        if (clientDao == null) {
            clientDao = new MySqlUserDao();
        }
        return clientDao;
    }


}