import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateSessionFactory {
    private static final Logger log = LogManager.getLogger(HibernateSessionFactory.class);
    private static SessionFactory sessionFactory;
    protected static SessionFactory getSessionFactory() {
        log.info("Trying to create a test connection with the database.");
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(UrlEntity.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(builder.build());
        log.info("Connection with the database created successfuly.");
        return sessionFactory;
    }



}