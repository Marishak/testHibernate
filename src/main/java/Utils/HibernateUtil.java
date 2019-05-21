package Utils;

import entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory factory;

    private HibernateUtil() {}

    public static SessionFactory getSessionFactory() {
        if (factory == null) {
            try {
                System.out.println("CONFIGURATION");
                Configuration configuration = new Configuration().configure();
                System.out.println("ADD in configuration");
                configuration.addAnnotatedClass(Actor.class);
                configuration.addAnnotatedClass(Video.class);
                configuration.addAnnotatedClass(Cast1.class);
                System.out.println("Create какая-то хрень BUILDER");
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                System.out.println("Инициализируем наш factory");
                factory = configuration.buildSessionFactory(builder.build());
                System.out.println("ИнициализирИРОВАЛИ наш factory");

            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        }
        return factory;
    }
}
