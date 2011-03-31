package org.rescore.gui.models;

import java.util.List;
import javax.swing.table.AbstractTableModel;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.rescore.App;
import org.rescore.dao.DAOFactory;
import org.rescore.dao.YachtClassDAO;
import org.rescore.dao.YachtDAO;
import org.rescore.domain.Yacht;
import org.rescore.domain.YachtClass;
import org.rescore.persitence.HibernateUtil;

public class YachtClassTableModel extends AbstractTableModel {

	static Logger logger = Logger.getLogger(YachtClassTableModel.class);
    private String[] columnNames = { "Modelis", "Koeficientas", "Proj. metai", "Ilgis", "Plotis" };
    private Object[][] data = getTableData();
	

    private static Object[][] getTableData(){
    	
    	HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
    	DAOFactory factory = DAOFactory.instance(DAOFactory.HIBERNATE);
    	YachtClassDAO yachtClassDAO = factory.getYachtClassDAO();
    	
    	List<YachtClass> yachtClasses = yachtClassDAO.findAll();
    	
        Object[][] data = new Object[yachtClasses.size()][];
        int i = 0;
        for(YachtClass yachtClass : yachtClasses){
            data[i] = new Object[] { yachtClass.getName(), yachtClass.getCoefficient(), yachtClass.getProjectYear(), yachtClass.getLength(), yachtClass.getWidth() } ;
            i++;
        }
        return data;
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

}
