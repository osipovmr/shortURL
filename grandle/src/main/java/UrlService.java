import jakarta.persistence.criteria.Root;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaParameterExpression;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UrlService {
    private static final Logger log = LogManager.getLogger(UrlService.class);

    public static String save(String originalUrl) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String hash = RandomString.createShortUrlRandom();
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        UrlEntity urlPojo = new UrlEntity();
        urlPojo.setOriginal_url(originalUrl);
        urlPojo.setHash(hash);
        urlPojo.setCreatedAt(dateFormat.format(date));
        log.info("New line is created" +"\n"+ originalUrl +"\n"+ hash +"\n"+ dateFormat.format(date));
        session.persist(urlPojo);
        session.getTransaction().commit();
        session.close();
        return hash;
    }

    public static String getOriginalUrl(String hash) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        JpaCriteriaQuery<UrlEntity> criteria = builder.createQuery(UrlEntity.class);
        Root<UrlEntity> root = criteria.from(UrlEntity.class);
        JpaParameterExpression<String> nameParam = builder.parameter(String.class);
        criteria.select(root)
                .where(builder.equal(root.get("hash"), nameParam));
        Query<UrlEntity> query = session.createQuery(criteria);
        query.setParameter(nameParam, hash);
        String originalUrl = query.getSingleResult().getOriginal_url();
        String note = query.getSingleResult().toString();
        System.out.println(note);
        return  originalUrl;
    }
}