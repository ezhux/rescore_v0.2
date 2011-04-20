package org.rescore.gui.views;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.rescore.beans.YachtClass;
import org.rescore.beans.YachtClasses;
import org.rescore.dao.DAOFactory;
import org.rescore.dao.YachtClassDAO;
import org.rescore.persitence.HibernateUtil;
import org.jdesktop.beansbinding.BeanProperty;
import java.util.List;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;

public class YachtClassListView extends JPanel {

	private JTable yachtClassTable;
	private JButton button;
	private YachtClasses yachtClasses = new YachtClasses();
	
	public YachtClassListView(){

		yachtClasses = new YachtClasses();
		
		HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
    	DAOFactory factory = DAOFactory.instance(DAOFactory.HIBERNATE);
    	YachtClassDAO yachtClassDAO = factory.getYachtClassDAO();
    	
    	List<YachtClass> domainYachtClasses = yachtClassDAO.findAll();
		for(YachtClass yachtClass : domainYachtClasses){
			yachtClasses.addYachtClass(yachtClass);
		}
		
		yachtClassTable = new JTable();
		JScrollPane scrollPane = new JScrollPane(yachtClassTable);
		yachtClassTable.setFillsViewportHeight(true);
		button = new JButton("Add New Yacht Class");
		this.add(BorderLayout.CENTER, scrollPane);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				YachtClass newYachtClass = new YachtClass();
				yachtClasses.addYachtClass(newYachtClass);
				newYachtClass.setCoefficient(2.0f);
				AddYachtClassDialog dialog = new AddYachtClassDialog(newYachtClass, yachtClasses);
				dialog.setVisible(true);
			}
		});
        this.add(BorderLayout.SOUTH, button);
        initDataBindings();
    }
	
	protected void initDataBindings() {
		BeanProperty<YachtClasses, List<YachtClass>> yachtClassesBeanProperty = BeanProperty.create("yachtClasses");
		JTableBinding<YachtClass, YachtClasses, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ_WRITE, yachtClasses, yachtClassesBeanProperty, yachtClassTable);
		//
		BeanProperty<YachtClass, String> yachtClassBeanProperty = BeanProperty.create("name");
		jTableBinding.addColumnBinding(yachtClassBeanProperty).setColumnName("Name");
		//
		BeanProperty<YachtClass, Float> yachtClassBeanProperty_1 = BeanProperty.create("coefficient");
		jTableBinding.addColumnBinding(yachtClassBeanProperty_1).setColumnName("Coefficient");
		//
		BeanProperty<YachtClass, Integer> yachtClassBeanProperty_2 = BeanProperty.create("displacement");
		jTableBinding.addColumnBinding(yachtClassBeanProperty_2).setColumnName("Displacement");
		//
		jTableBinding.bind();
	}
}
