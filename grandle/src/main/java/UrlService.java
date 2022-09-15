/*import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

import java.util.Date;
import java.util.Random;

public class UrlService {
    private static final Logger log = LogManager.getLogger(UrlService.class);

    String getCutUrl(String originalUrl) {
        try {
            String str = to.getShortUrl(originalUrl);
            log.info("—сылка уже записана");
            return str;
        } catch (SQLException e) {
            log.info("—сылка не записана");
            String shortURL = getShortUrlRandom();
            Date date = new Date();
            to.add(originalUrl, shortURL, date);
            String res = String.format("http://localhost:4567/%s", shortURL);
            return res;
        }
    }
    String getShortUrlRandom(){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<6;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
*/