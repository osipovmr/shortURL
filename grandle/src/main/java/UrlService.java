import java.sql.SQLException;

public class UrlService {


    public static String getShortUrl(String originalUrl) throws SQLException {
        String shortUrl = RandomString.createShortUrlRandom();
        if (TableOperations.check(originalUrl) == false) {
            TableOperations.add(originalUrl, shortUrl);
            return TableOperations.findShortUrl(originalUrl);
        } else return TableOperations.findShortUrl(originalUrl);

    }
    public static String getOriginalUrl (String shortUrl) throws SQLException {
        return TableOperations.findOriginalUrl(shortUrl);
    }
}
