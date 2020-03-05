package org.geospatial.app.gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.geospatial.app.Context;
import javax.swing.JLabel;

public class Panel_Layers extends JPanel{
    
    JLabel t1;
    
    public Panel_Layers(){
        t1=new JLabel(""+Context.layerHandler.getLayerList().size());  
        t1.setBounds(60,0, 200,30);  
        add(t1);
    }
    
}
