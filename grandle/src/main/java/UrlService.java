import java.sql.SQLException;

public class UrlService {


    static String getShortUrl(String originalUrl) throws SQLException {
        String shortUrl = RandomString.createShortUrlRandom();
        if (DAOImpl.check(originalUrl) == false) {
            DAOImpl.add(originalUrl, shortUrl);
            return DAOImpl.findShortUrl(originalUrl);
        } else return DAOImpl.findShortUrl(originalUrl);

    }
    static String getOriginalUrl(String shortUrl) throws SQLException {
        return DAOImpl.findOriginalUrl(shortUrl);
    }
}
