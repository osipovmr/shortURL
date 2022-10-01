import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateSessionFactoryUtil {
    private static final Logger log = LogManager.getLogger(HibernateSessionFactoryUtil.class);
    private static SessionFactory sessionFactory;
    protected static SessionFactory getSessionFactory() {
        log.info("Trying to create a test connection with the database.");
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(UrlPojo.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(builder.build());
        log.info("Test connection with the database created successfuly.");
        return sessionFactory;
    }



}