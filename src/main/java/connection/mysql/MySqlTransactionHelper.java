package connection.mysql;//package connection.mysql;
//
//
//import connection.DaoConnection;
//import connection.TransactionHelper;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//
//public class MySqlTransactionHelper implements TransactionHelper {
//
//    private static MySqlTransactionHelper instance = new MySqlTransactionHelper();
//
//
////    private ConnectionPool pool ;
////            MySqlConnectionPool.getInstance();
//    private ThreadLocal<Connection> local = new ThreadLocal<>();
//
//    private MySqlTransactionHelper() {}
//
//    public static MySqlTransactionHelper getInstance() {
//        return instance;
//    }
//
//    @Override
//    public void beginTransaction() {
//
//        Connection connection = null;
//        try {
//            connection = MySqlConnectionPool.getConnection();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        connection.setIsInTransaction(true);
//        local.set(connection);
//    }
//
//    @Override
//    public void commitTransaction() {
//        Connection connection = local.get();
//        if (connection == null) {
//
//            throw new RuntimeException("Can't commit transaction: it has not been begun");
//        }
//        try {
//            connection.commit();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        endTransaction(connection);
//    }
//
//    @Override
//    public void rollbackTransaction() {
//        DaoConnection connection = local.get();
//        if (connection == null) {
//
//            throw new RuntimeException("Can't rollback transaction: it has not been begun");
//        }
//        connection.rollback();
//        endTransaction(connection);
//    }
//
//    @Override
//    public DaoConnection getConnection() {
//        DaoConnection connection = local.get();
//        if (connection == null) {
//            try {
//                connection = MySqlConnectionPool.getConnection();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return connection;
//    }
//
//    private void endTransaction(DaoConnection connection) {
//        connection.setIsInTransaction(false);
//        try {
//            connection.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        local.set(null);
//    }
//}