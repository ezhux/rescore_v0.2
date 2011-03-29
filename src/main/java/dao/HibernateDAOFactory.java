package dao;

import org.hibernate.Session;
import org.rescore.domain.Yacht;
import org.rescore.domain.YachtClass;
import org.rescore.persitence.HibernateUtil;

public class HibernateDAOFactory extends DAOFactory {
	 
    public YachtDAO getYachtDAO() {
        return (YachtDAO)instantiateDAO(YachtDAOHibernate.class);
    }
 
    public YachtClassDAO getYachtClassDAO() {
        return (YachtClassDAO)instantiateDAO(YachtClassDAOHibernate.class);
    }
 
    private GenericHibernateDAO instantiateDAO(Class daoClass) {
        try {
            GenericHibernateDAO dao = (GenericHibernateDAO)daoClass.newInstance();
            dao.setSession(getCurrentSession());
            return dao;
        } catch (Exception ex) {
            throw new RuntimeException("Can not instantiate DAO: " + daoClass, ex);
        }
    }
 
    protected Session getCurrentSession() {
        return HibernateUtil.getSessionFactory("dev").getCurrentSession();
    }
 
    // Inline concrete DAO implementations with no business-related data access methods.
    // If we use public static nested classes, we can centralize all of them in one source file.
 
    public static class YachtDAOHibernate
            extends GenericHibernateDAO<Yacht, Long>
            implements YachtDAO {}
 
    public static class YachtClassDAOHibernate
            extends GenericHibernateDAO<YachtClass, Long>
            implements YachtClassDAO {}
 
}
