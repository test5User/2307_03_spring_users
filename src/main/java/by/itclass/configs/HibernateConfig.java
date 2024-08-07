package by.itclass.configs;

import by.itclass.model.entities.Passport;
import by.itclass.model.entities.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;

public class HibernateConfig {
    @Bean
    public Configuration configuration() {
        var config = new Configuration();
        config.addAnnotatedClass(User.class);
        config.addAnnotatedClass(Passport.class);
        return config;
    }

    @Bean
    public SessionFactory factory(Configuration configuration) {
        return configuration.buildSessionFactory();
    }
}
