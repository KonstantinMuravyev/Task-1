package jm.task.core.jdbc.util;


import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Util {
    // реализуйте настройку соеденения с БД
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "poi48fea861";

    private static SessionFactory sessionFactory;

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return connection;
    }

    public static SessionFactory getSessionFactory() {

        try {
            Configuration configuration = new Configuration()
                    .setProperty("hibernate.connection.url", URL)
                    .setProperty("hibernate.connection.username", USERNAME)
                    .setProperty("hibernate.connection.password", PASSWORD)
                    .addAnnotatedClass(User.class);


            // собираем реестр метаданных для создания sessionFactory
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            // Используем настройки из configuration, чтобы сконфигурировать и построить sessionFactory.
            // Принимает в качестве аргумента serviceRegistry,
            // который представляет сервисный реестр, содержащий необходимые службы и настройки для работы Hibernate.
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return sessionFactory;
    }
}

