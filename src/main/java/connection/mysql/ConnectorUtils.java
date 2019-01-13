package connection.mysql;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectorUtils {

    public static Connection getConnection()
            throws ClassNotFoundException, SQLException {

        // Здесь я подключаюсь к Oracle Database.
        // (Вы можете поменять и использовать другую базу данных).
//        return OracleConnUtils.getOracleConnection();

        // return OracleConnUtils.getOracleConnection();
         return MySqlConnectionPool.getConnection();
        // return SQLServerConnUtils_JTDS.getSQLServerConnection_JTDS();
        // return SQLServerConnUtils_SQLJDBC.getSQLServerConnection_SQLJDBC();
        // return PostGresConnUtils.getPostGresConnection();
    }

    public static void closeQuietly(Connection conn) {
        try {
            conn.close();
        } catch (Exception e) {
        }
    }

    public static void rollbackQuietly(Connection conn) {
        try {
            conn.rollback();
        } catch (Exception e) {
        }
    }
}