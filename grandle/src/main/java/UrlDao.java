public class UrlDao {
    public UrlPojo findByOriginalUrl(String originalUrl) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(UrlPojo.class, originalUrl);
    }

    public UrlPojo findByHash(String hash) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(UrlPojo.class, hash);
    }

/*    public void save(UrlPojo urlPojo) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        //session.save(urlPojo);
        tx1.commit();
        session.close();
    }*/

/*    public void update(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }*/

/*    public void delete(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }*/

/*    public Auto findAutoById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Auto.class, id);
    }

    public List<User> findAll() {
        List<User> users = (List<User>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From User").list();
        return users;
    }*/
}
