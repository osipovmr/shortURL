import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    static Connection connection = ConnectToPostgresDB.getConnection();
    static Statement statement = null;
    private static final Logger log = LogManager.getLogger(CreateTable.class);


    public static void CreateTable() throws SQLException {
        statement = connection.createStatement();
        String query = "Create Table url (id serial, original_url varchar, hash varchar, createdAt varchar)";
        statement.execute(query);
        log.info("Table URL created.");
    }
}
