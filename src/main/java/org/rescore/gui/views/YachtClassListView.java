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

public class YachtClassListView extends JPanel {

	private JTable yachtClassTable;
	private JButton button;
	private YachtClasses yachtClasses;
	
	public YachtClassListView(){

		yachtClasses = new YachtClasses();
		yachtClassTable = new JTable();
		JScrollPane scrollPane = new JScrollPane(yachtClassTable);
		yachtClassTable.setFillsViewportHeight(true);
		button = new JButton("Add New Yacht Class");
		this.add(BorderLayout.CENTER, scrollPane);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				YachtClass newYachtClass = new YachtClass();
				yachtClasses.addYachtClass(newYachtClass);
				AddYachtClassDialog dialog = new AddYachtClassDialog(newYachtClass);
				dialog.setVisible(true);
			}
		});
        this.add(BorderLayout.SOUTH, button);
    }
	
}
