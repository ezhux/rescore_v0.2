package org.rescore.persitence;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.rescore.App;

public class HibernateUtil {
	static Logger logger = Logger.getLogger(HibernateUtil.class);
	//factory for development
	private static final SessionFactory dev_sessionFactory = (new HibernateUtil()). buildSessionFactory("dev"); 
	//factory for test
	private static final SessionFactory test_sessionFactory = (new HibernateUtil()).buildSessionFactory("test"); 
	
    private SessionFactory buildSessionFactory(String environment) {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
        	AnnotationConfiguration cfg = new AnnotationConfiguration().configure();
        	// create two separate databases: one for development
        	if (environment == "dev"){
        		cfg.setProperty("hibernate.connection.url", "jdbc:h2:~/test;AUTO_SERVER=TRUE");
        	// another - for testing
        	} else if(environment == "test"){
        		cfg.setProperty("hibernate.connection.url", "jdbc:h2:~/db_for_test;AUTO_SERVER=TRUE");
        	}
        	logger.info("sessionFactory created");
        	return cfg.buildSessionFactory();
        }
        catch (Throwable ex) {
            logger.error("Initial SessionFactory creation failed." + ex);
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory(String environment) {
    	if (environment == "dev"){
    		return dev_sessionFactory;
    	} else {
    		return test_sessionFactory;
    	}
    }
 
    public static void shutdown(String environment) {
    	getSessionFactory(environment).close();
    }
 
}
