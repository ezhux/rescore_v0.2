package org.rescore.gui.views;

import javax.swing.*;

import org.rescore.gui.models.YachtTableModel;

import java.awt.*;

public class YachtListView extends JPanel {

	public YachtListView(){

        JTable yachtTable = new JTable(new YachtTableModel());
        JScrollPane scrollPane = new JScrollPane(yachtTable);
        yachtTable.setFillsViewportHeight(true);
        
        this.add(BorderLayout.CENTER, scrollPane);

    }

}
