package org.geospatial.app.gui;

import com.bbn.openmap.gui.EmbeddedNavPanel;
import com.bbn.openmap.gui.NavigatePanel;
import com.bbn.openmap.gui.ProjectionStackTool;
import com.bbn.openmap.gui.ScaleTextPanel;
import com.bbn.openmap.gui.ZoomPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.JPanel;
import org.geospatial.app.Context;

public class Panel_Tools extends JPanel{
    
    // Custom         
    private final Panel                 menuPanel           = new Panel();
    private NavigatePanel               navigatePanel       = new NavigatePanel();
    private ProjectionStackTool         projectionStackTool = new ProjectionStackTool();
    private ZoomPanel                   zoomPanel           = new ZoomPanel();
    private ScaleTextPanel              scaleTextPanel      = new ScaleTextPanel();
    private EmbeddedNavPanel            embeddednavpanel    = new EmbeddedNavPanel();
    
    public Panel_Tools(){
    
        setLayout(new BorderLayout()); 
        menuPanel.add(embeddednavpanel);
        Context.mapRoot.getMapHandler().add(navigatePanel);
        Context.mapRoot.getMapHandler().add(zoomPanel);
        Context.mapRoot.getMapHandler().add(projectionStackTool);
        Context.mapRoot.getMapHandler().add(scaleTextPanel);
        Context.mapRoot.getMapHandler().add(embeddednavpanel); 
        menuPanel.setBackground(Color.lightGray);
        add(menuPanel, BorderLayout.CENTER);
        //add(embeddednavpanel);
        
    }
}
