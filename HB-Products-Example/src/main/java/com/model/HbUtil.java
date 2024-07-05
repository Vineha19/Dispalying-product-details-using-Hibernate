package com.model;

import org.hibernate.SessionFactory;


import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HbUtil {
private static SessionFactory sessionFactory;
    public static SessionFactory buildSessionFactory() {

            try {  
            	Configuration configuration=new Configuration();
            	configuration.configure("hibernate.cfg.xml");
            	System.out.println("Hibernate Configuration loaded");
            	ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            	System.out.println("Hibernate serviceRegistry created");
            	SessionFactory sessionFactory =configuration.buildSessionFactory(serviceRegistry);
                return sessionFactory;
            }
            
            catch (Throwable ex) {
               System.out.println("Initial SessionFactory creation failed."+ex);
               ex.printStackTrace();
               throw new ExceptionInInitializerError(ex);
                }
           
        
    }
    public static SessionFactory getSessionFactory() {
    	if(sessionFactory==null) sessionFactory= buildSessionFactory();
    	return sessionFactory;
    }
}