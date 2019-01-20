package connection;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

import java.sql.Connection;


public class ConnectionUtils {
    private static final org.apache.logging.log4j.Logger log = LogManager.getLogger(ConnectionUtils.class.getName());

    public static void closeQuietly(Connection conn) {
        try {
            conn.close();
        } catch (Exception e) {
            log.log(Level.ERROR, "cannot close " + e);
        }
    }

    public static void rollbackQuietly(Connection conn) {
        try {
            conn.rollback();
        } catch (Exception e) {
            log.log(Level.ERROR, "cannot rollback " + e);
        }
    }
}