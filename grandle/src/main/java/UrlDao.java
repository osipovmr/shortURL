import org.hibernate.Session;
import org.hibernate.Transaction;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UrlDao {
    public static UrlPojo findByOriginalUrl(String originalUrl) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(UrlPojo.class, originalUrl);
    }

    public UrlPojo findByHash(String hash) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(UrlPojo.class, hash);
    }

    public static void save(String originalUrl) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String hash = RandomString.createShortUrlRandom();
        UrlPojo newString = new UrlPojo(originalUrl, hash, dateFormat.format(date));
        /*newString.setOriginal_url(originalUrl);
        newString.setHash(hash);
        newString.setCreatedAt(dateFormat.format(date));*/
        session.save(newString);
        tx1.commit();
        session.close();
    }

}
