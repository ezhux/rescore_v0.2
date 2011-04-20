package org.rescore.framework;

import java.awt.Container;

import org.apache.log4j.Logger;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.rescore.persitence.HibernateUtil;

public class PersistenceController extends AbstractController {
	
	static Logger logger = Logger.getLogger(PersistenceController.class);

	private Session persistenceContext;
	
    public PersistenceController(Container view) {
    	super(view);
        // Open a new persistence context for this controller, if none should be joined
        if (persistenceContext == null) {
            logger.debug("Creating new persistence context for controller");
            this.persistenceContext = HibernateUtil.getSessionFactory().openSession();
            this.persistenceContext.setFlushMode(FlushMode.MANUAL);
        } else {
            logger.debug("Joining existing persistence context");
            this.persistenceContext = persistenceContext;
        }
    }
	
	
	public Session getPersistenceContext() {
		return persistenceContext;
	}
}
