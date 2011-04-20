package org.rescore.rescore_v2;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import org.rescore.beans.YachtClass;
import org.rescore.persitence.HibernateUtil;

public class AppTest {

	private Session session;

	/**
	 * is executed once before any tests 
	 */
	@Before
	public void prepareTests(){
    	session = HibernateUtil.getSessionFactory("test").openSession();
    	session.beginTransaction();
	}
    
	@AfterClass
	public static void endTests(){
		HibernateUtil.shutdown("test");
	}
	

	@Test
    public void createNewYachtClass()
    {
		Random random = new Random();
    	List<YachtClass> yachtClassesOld = session.createQuery("from YachtClass").list();
    	
    	YachtClass newYachtClass = new YachtClass();
    	newYachtClass.setCoefficient(1f);
    	newYachtClass.setName("model" + random.nextInt(1000));
    	newYachtClass.setProjectYear(2005);
    	newYachtClass.setLength(9999);
    	newYachtClass.setWidth(4999);
    	newYachtClass.setDisplacement(90000);
    	newYachtClass.setWaterlineLength(9999);
    	newYachtClass.setSailAreaDownwind(9999);
    	newYachtClass.setSailAreaUpwind(9999);
    	session.save(newYachtClass);
    	
    	session.getTransaction().commit();
    	
    	List<YachtClass> yachtClassesNew = session.createQuery("from YachtClass").list();
    	//check if the object was saved
    	assertEquals(yachtClassesOld.size()+1, yachtClassesNew.size());
    }
}
