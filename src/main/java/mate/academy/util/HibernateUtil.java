package mate.academy.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory session = initFactory();

    private static SessionFactory initFactory() {
        return new Configuration().configure().buildSessionFactory();
    }

    public static SessionFactory getSession() {
        return session;
    }
}
