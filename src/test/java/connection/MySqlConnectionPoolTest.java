package connection;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;


import static org.junit.jupiter.api.Assertions.*;

class MySqlConnectionPoolTest {

    @Test
    void getConnection() throws SQLException {
        Connection connection =MySqlConnectionPool.getConnection();
        assertTrue(connection.isValid(1));
    }


}