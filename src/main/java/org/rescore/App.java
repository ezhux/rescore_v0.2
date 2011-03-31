package org.rescore;

import java.awt.EventQueue;
import org.apache.log4j.Logger;
import org.rescore.gui.views.MainWindow;


public class App 
{
	static Logger logger = Logger.getLogger(App.class);
	
    public static void main( String[] args )
    {
        EventQueue.invokeLater(new Runnable() {
    		public void run() {
    			try {

    				MainWindow window = new MainWindow();
    				window.frame.setVisible(true);
    				
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    		}
    	});
    }
}

