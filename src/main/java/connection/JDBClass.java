package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBClass {

//    public static Connection getMySQLConnection()
//            throws ClassNotFoundException, SQLException {
//        String hostName = "localhost";
//        String dbName = "cruisebd";
//        String userName = "root";
//        String password = "1817";
//        return getMySQLConnection(hostName, dbName, userName, password);
//    }

    public static Connection getMySQLConnection(String hostName, String dbName,
                                                String userName, String password) throws SQLException,
            ClassNotFoundException {
        // Declare the class Driver for Oracle DB
        // This is necessary with Java 5 (or older)
        // Java6 (or newer) automatically find the appropriate driver.
        // If you use Java> 5, then this line is not needed.
//        Class.forName("com.mysql.cj.jdbc.Driver");


        //jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName + "?serverTimezone=UTC";

        Connection conn = DriverManager.getConnection(connectionURL, userName,
                password);
        return conn;
    }

    public static void main(String[] args) {
        try {
            Connection conn = JDBClass.getMySQLConnection("localhost", "cruisedb", "root", "1817");


            if(conn!=null) System.out.println("Connection Successful !\n");
            if (conn==null) System.exit(0);
            Statement st = null;
//            if (conn != null) {
//                st = conn.createStatement();
//            }
//
////
//             st.execute("CREATE TABLE IF NOT EXISTS customer (\n" +
//                        "    customer_id INT AUTO_INCREMENT,\n" +
//                        "    first_name VARCHAR(255) NOT NULL,\n" +
//                        "       surname VARCHAR(255) NOT NULL," +
//                        "    age INT NOT NULL,\n" +
//                        "    PRIMARY KEY (customer_id)\n" +
//                        ")  ENGINE=INNODB;");
////            if(rs!=null)rs.close();
////
////        st.execute("ALTER TABLE ship DROP COLUMN description");
//
//
////                    st.execute(  "INSERT INTO ship VALUES(2, 'Slow')");
////            st.execute(  "INSERT INTO ship VALUES(3, 'Fast')");
//
//            st.close();
//            if(conn!=null)conn.close();

        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

}
