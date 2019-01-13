package connection.mysql;


import org.apache.commons.dbcp2.BasicDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

//import dao.mysql.MySqlDaoFactory;


public class MySqlConnectionPool2222 {


    private static final String DB_CONFIG_FILENAME = "WEB-INF/lib/dbConfig.properties";
    private static final String DB_CONFIG_PARAM_URL = "database.url";
    private static final String DB_CONFIG_PARAM_DB_NAME = "database.dbName";
    private static final String DB_CONFIG_PARAM_USER_NAME = "database.userName";
    private static final String DB_CONFIG_PARAM_USER_PASSWORD = "database.userPassword";
    private static final String DB_CONFIG_PARAM_DRIVER = "database.driver";
    private static final String DB_CONFIG_PARAM_MAX_CONNECTIONS = "database.maxConnections";
    private static final String DB_CONFIG_PARAM_CONNECTION_PROPERITES = "database.connectionProperties";
//    private static final Logger log = LogManager.getLogger(MySqlConnectionPool.class.getName());

//    private  MySqlConnectionPool instance = new MySqlConnectionPool();
//public MySqlConnectionPool(){}

    public static BasicDataSource connectionPool;
public static Properties properties= null;

    static {

//        connectionPool = null;
        try{

        properties = new Properties();
//File file = new File("dbConfig.properties");
//            System.out.println(file.getAbsolutePath());
            InputStream paths = properties.getClass().getResourceAsStream("WEB-INF/lib/dbConfig.properties");
//            String  paths2 = properties.getClass().getResourceAsStream("dbConfig.properties").toString();
//            System.out.println(paths+"\n"+paths2 );
           properties.load(paths);
//            else System.out.println("nuull");
//        properties.load(new FileInputStream("dbConfig.properties"));
//                InputStream is =
//                     MySqlConnectionPool.class.getClassLoader().getResourceAsStream(DB_CONFIG_FILENAME)) {
//            props.load(is);

//            String dbUrl = "jdbc:mysql://localhost:3306" + "/" + "cruisedb?serverTimezone=UTC";
            String dbUrl = properties.getProperty(DB_CONFIG_PARAM_URL) +"/"+ properties.getProperty(DB_CONFIG_PARAM_DB_NAME);
//            connectionPool = new BasicDataSource();
            connectionPool= new BasicDataSource();


            connectionPool.setDriverClassName("com.mysql.cj.jdbc.Driver");
            connectionPool.setUrl(dbUrl);
            connectionPool.setUsername(properties.getProperty(DB_CONFIG_PARAM_USER_NAME));
            connectionPool.setPassword(properties.getProperty(DB_CONFIG_PARAM_USER_PASSWORD));
            connectionPool.setMinIdle(100);
            connectionPool.setMaxIdle(1000);
            connectionPool.setMaxTotal(Integer.parseInt(properties.getProperty(DB_CONFIG_PARAM_MAX_CONNECTIONS)));
            connectionPool.setConnectionProperties(properties.getProperty(DB_CONFIG_PARAM_CONNECTION_PROPERITES));
//            connectionPool.setConnectionProperties("useUnicode=yes;characterEncoding=utf8;");
//            log.log(Level.INFO, "create ");
        } catch (IOException | RuntimeException e) {
//            log.log(Level.ERROR, "exception " + e);
            System.out.println(e);
        }
    }

    public MySqlConnectionPool2222() {
    }

    public static Connection getConnection() throws SQLException {
//        System.out.println(connectionPool.getCacheState());
        return connectionPool.getConnection();
    }
    //    public MySqlConnectionPool getInstance() {
//        return null;
//        //        return instance;
//    }
//    @Override
//    public MySqlDaoConnection getConnection() {
//        try {
//            return new MySqlDaoConnection(connectionPool.getConnection());
//        } catch (SQLException e) {
//            log.log(Level.ERROR, "Can't get dao connection " + e);
//            throw new RuntimeException("Can't get dao connection " + e);
//        }
//    }

//    public static void main(String[] args) {
//        try {
//            Connection con = MySqlConnectionPool.getConnection();
//            System.out.println("connect");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//
//        //        DaoConnection conn = MySqlConnectionPool.getInstance().getConnection();
//        MySqlUserDao mySqlUserDao = new MySqlUserDao();
//        Client user = mySqlUserDao.getByLogin("Ann");
//
//        System.out.println(user);
//
//
//    }
}


//    private BasicDataSource connectionPool;
//
//    {
//            Properties props = new Properties();
//            connectionPool = null;
//            try (InputStream is =
//            MySqlConnectionPool.class.getClassLoader().getResourceAsStream(DB_CONFIG_FILENAME)){
//        props.load(is);
//        String dbUrl = props.getProperty(DB_CONFIG_PARAM_URL) +"/"+ props.getProperty(DB_CONFIG_PARAM_DB_NAME);
//        connectionPool = new BasicDataSource();
//        connectionPool.setDriverClassName(props.getProperty(DB_CONFIG_PARAM_DRIVER));
//        connectionPool.setUrl(dbUrl);
//        connectionPool.setUsername(props.getProperty(DB_CONFIG_PARAM_USER_NAME));
//        connectionPool.setPassword(props.getProperty(DB_CONFIG_PARAM_USER_PASSWORD));
//        connectionPool.setMaxTotal(Integer.parseInt(props.getProperty(DB_CONFIG_PARAM_MAX_CONNECTIONS)));
//        connectionPool.setConnectionProperties(props.getProperty(DB_CONFIG_PARAM_CONNECTION_PROPERITES));
//        } catch (IOException e) {
//        throw new DaoException(e);
//        }
//        }