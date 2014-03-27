package main;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class HibernateUtil {

    private static Configuration configuration;
    private static StandardServiceRegistry builder;
    private static SessionFactory factory;

    static {
        try {
            configuration = new Configuration().configure();
            builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            factory = configuration.buildSessionFactory(builder);
        } catch (HibernateException he) {
            System.err.println("Error creating Session: " + he);
            throw new ExceptionInInitializerError(he);
        }
    }

    public static SessionFactory getSessionFactory() {
        return factory;
    }

    public static void closeSessionFactory() {
        if (factory != null) {
            try {
                StandardServiceRegistryBuilder.destroy(builder);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
