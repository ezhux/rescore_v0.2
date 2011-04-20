package org.rescore.framework;

import java.awt.Container;
import org.apache.log4j.Logger;

public class AbstractController {

	static Logger logger = Logger.getLogger(AbstractController.class);

    private Container view;
    
    public AbstractController(Container view){
    	this.view = view;
    }
    
    public Container getView() {
        return view;
    }
    
}
