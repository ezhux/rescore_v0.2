package org.rescore;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.rescore.dao.DAOFactory;
import org.rescore.dao.HibernateDAOFactory;
import org.rescore.dao.YachtClassDAO;
import org.rescore.dao.YachtDAO;
import org.rescore.dao.HibernateDAOFactory.YachtClassDAOHibernate;
import org.rescore.dao.HibernateDAOFactory.YachtDAOHibernate;
import org.rescore.domain.Yacht;
import org.rescore.domain.YachtClass;
import org.rescore.persitence.HibernateUtil;


public class App 
{
	static Logger logger = Logger.getLogger(App.class);
	
    public static void main( String[] args )
    {

    	HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
    	
    	DAOFactory factory = DAOFactory.instance(DAOFactory.HIBERNATE);
    	YachtDAO yachtDAO = factory.getYachtDAO();
    	YachtClassDAO yachtClassDAO = factory.getYachtClassDAO();
    	
    	Yacht yacht = new Yacht();
    	yacht.setName("brandNewYacht");
    	yacht.setSailNumber("LTU113");
    	yacht.setBuildYear(2000);
    	yacht.setCaptain("manoKapitonas");
    	
    	List<YachtClass> yachtClasses = yachtClassDAO.findAll();
    	
    	yacht.setYachtClass(yachtClasses.get(0));
    	try {
    		yachtDAO.makePersistent(yacht);
    	} catch (Exception e){
    		System.out.println(e.getMessage());
    	} finally {
    		try {
    			HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
    		} catch (HibernateException he){
    			logger.error(he);
    		}
    	}
    }
}

