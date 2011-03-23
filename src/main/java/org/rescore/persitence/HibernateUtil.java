package org.rescore.persitence;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.rescore.App;

public class HibernateUtil {
	static Logger logger = Logger.getLogger(HibernateUtil.class);
	private static final SessionFactory sessionFactory = buildSessionFactory();
	 
    private static SessionFactory buildSessionFactory() {
        try {
        	logger.info("sessionFactory created");
            // Create the SessionFactory from hibernate.cfg.xml
        	return new AnnotationConfiguration().configure().buildSessionFactory();
        }
        catch (Throwable ex) {
            logger.error("Initial SessionFactory creation failed." + ex);
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
 
    public static void shutdown() {
    	// Close caches and connection pools
    	getSessionFactory().close();
    }
 
}
