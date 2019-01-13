package connection.mysql;


import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

//import dao.mysql.MySqlDaoFactory;


public class MySqlConnectionPoolWWW {


    private static final String DB_CONFIG_FILENAME = "WEB-INF/lib/dbConfig.properties";
    private static final String DB_CONFIG_PARAM_URL = "database.url";
    private static final String DB_CONFIG_PARAM_DB_NAME = "database.dbName";
    private static final String DB_CONFIG_PARAM_USER_NAME = "database.userName";
    private static final String DB_CONFIG_PARAM_USER_PASSWORD = "database.userPassword";
    private static final String DB_CONFIG_PARAM_DRIVER = "database.driver";
    private static final String DB_CONFIG_PARAM_MAX_CONNECTIONS = "database.maxConnections";
    private static final String DB_CONFIG_PARAM_CONNECTION_PROPERITES = "database.connectionProperties";
    private static final Logger log = LogManager.getLogger(MySqlConnectionPoolWWW.class.getName());

//    private  MySqlConnectionPool instance = new MySqlConnectionPool();
//public MySqlConnectionPool(){}

    public static BasicDataSource connectionPool;
//public static Properties properties= null;

    static {

//        connectionPool = null;
        try{

//        properties = new Properties();
////File file = new File("dbConfig.properties");
////            System.out.println(file.getAbsolutePath());
//            InputStream paths = properties.getClass().getResourceAsStream("dbConfig.properties");
////            String  paths2 = properties.getClass().getResourceAsStream("dbConfig.properties").toString();
////            System.out.println(paths+"\n"+paths2 );
//           properties.load(paths);
//            else System.out.println("nuull");
//        properties.load(new FileInputStream("dbConfig.properties"));
//                InputStream is =
//                     MySqlConnectionPool.class.getClassLoader().getResourceAsStream(DB_CONFIG_FILENAME)) {
//            props.load(is);

//            String dbUrl = "jdbc:mysql://localhost:3306" + "/" + "cruisedb?serverTimezone=UTC";
            String dbUrl = "jdbc:mysql://localhost:3306/cruisedb?serverTimezone=UTC";
//            connectionPool = new BasicDataSource();
            connectionPool= new BasicDataSource();


            connectionPool.setDriverClassName("com.mysql.cj.jdbc.Driver");
            connectionPool.setUrl(dbUrl);
            connectionPool.setUsername("root");
            connectionPool.setPassword("1817");
            connectionPool.setMinIdle(100);
            connectionPool.setMaxIdle(1000);
            connectionPool.setMaxTotal(8);
            connectionPool.setConnectionProperties("useUnicode=yes;characterEncoding=utf8;");
//            connectionPool.setConnectionProperties("useUnicode=yes;characterEncoding=utf8;");
            log.log(Level.INFO, "create connnnn");
        } catch ( RuntimeException e) {
            log.log(Level.ERROR, "exception " + e);
            System.out.println(e);
        }
    }

    public MySqlConnectionPoolWWW() {
    }

    public static Connection getConnection() throws SQLException {
//        System.out.println(connectionPool.getCacheState());
        return connectionPool.getConnection();
    }


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
