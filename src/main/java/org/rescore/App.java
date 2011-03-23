package org.rescore;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.rescore.domain.Yacht;
import org.rescore.domain.YachtClass;
import org.rescore.persitence.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App 
{
	static Logger logger = Logger.getLogger(App.class);
	
    public static void main( String[] args )
    {
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	session.beginTransaction();
    	
    	List<YachtClass> yachtClasses = session.createQuery("from YachtClass").list();
    	YachtClass yachtClass = yachtClasses.get(1);
    	
//    	newYachtClass.setCoefficient(1f);
//    	newYachtClass.setName("model1");
//    	newYachtClass.setProjectYear(2005);
//    	newYachtClass.setLength(9999);
//    	newYachtClass.setWidth(4999);
//    	newYachtClass.setDisplacement(90000);
//    	newYachtClass.setWaterlineLength(9999);
//    	newYachtClass.setSailAreaDownwind(9999);
//    	newYachtClass.setSailAreaUpwind(9999);
//    	session.save(newYachtClass);
    	
    	Yacht newYacht = new Yacht();
    	newYacht.setId(1);
    	newYacht.setName("myName2");
    	newYacht.setSailNumber("LTU111");
    	newYacht.setYachtClass(yachtClass);
    	System.out.println("....done....");
    	session.save(newYacht);
    	session.getTransaction().commit();
    }
}

