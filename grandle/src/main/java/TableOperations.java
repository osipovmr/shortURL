import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TableOperations {
    static Connection connection = ConnectToPostgresDB.getConnection();

    private static final Logger log = LogManager.getLogger(TableOperations.class);

    public static void add(String originalUrl, String shortUrl) {
        String queryAdd = """
                insert into url (original_url, hash, createdAt)
                values (?,?,?)""";
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(queryAdd);
            preparedStatement.setString(1, originalUrl);
            preparedStatement.setString(2, shortUrl);
            preparedStatement.setString(3, dateFormat.format(date));
            log.info("New data added.");
            preparedStatement.execute();
        } catch (SQLException e) {
            log.error("Error data add", e);
            throw new RuntimeException(e);
        }
    }

    public ResultSet getOriginalUrl(String shortUrl) throws SQLException {
        String query = """
                select original_Url from URL
                where short_url = ?
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, shortUrl);
        ResultSet result = preparedStatement.executeQuery();
        return result;
    }


    public static String getShortUrl(String originalUrl) throws SQLException {
        String query = """
                select hash
                from url
                where original_url = ?
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, originalUrl);
        ResultSet result = preparedStatement.executeQuery();
        result.next();
        String shortUrl = String.format("http://localhost:4567/%s", result.getString(1));
        return shortUrl;

    }
}