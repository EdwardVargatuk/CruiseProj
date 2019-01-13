package connection;

public interface TransactionHelper {

    void beginTransaction();

    // closes used connection
    void rollbackTransaction();


    void commitTransaction();

    /**
     * If transaction has been started returns
     * used connection, else new connection.
     *  */
    DaoConnection getConnection();
}