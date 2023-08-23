package HibernateConfig;
import org.example.Product;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateConfig {
    private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=sevrlet;encrypt=false");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "vdt1410");
        properties.put(Environment.SHOW_SQL, "true");
        properties.put(Environment.HBM2DDL_AUTO,"create");

        conf.setProperties(properties);

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();

        conf.addAnnotatedClass(Product.class);
        FACTORY = conf.buildSessionFactory(registry);
    }

    public static SessionFactory getFactory() {
        return FACTORY;
    }
}

