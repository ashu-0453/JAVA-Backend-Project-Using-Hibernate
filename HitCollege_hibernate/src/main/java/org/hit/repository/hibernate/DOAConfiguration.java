package org.hit.repository.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.hit.model.Employee;

import java.util.HashMap;
import java.util.Map;

public class DOAConfiguration {

public static SessionFactory getSessionFactory(){

    SessionFactory sessionFactory=null;


    Map<String, Object> settings = new HashMap<>();
    settings.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
    settings.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/hit");
    settings.put("hibernate.connection.username", "root");         //Set Your Username
    settings.put("hibernate.connection.password", "ashu0453");    //Set Your Password
    settings.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
    settings.put("hibernate.show_sql", "true");
    settings.put("hibernate.format_sql", "true");
    settings.put("hibernate.hbm2ddl.auto", "update");
    settings.put("hibernate.current_session_context_class","thread");
    try {
        ServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                .applySettings(settings).build();
        Metadata metadata = new MetadataSources(standardRegistry)
                .addAnnotatedClass(Employee.class)
                .getMetadataBuilder()
                .build();

        sessionFactory = metadata.getSessionFactoryBuilder().build();
    } catch (Throwable ex) {
        throw new ExceptionInInitializerError(ex);
    }

    return sessionFactory;

}

}
