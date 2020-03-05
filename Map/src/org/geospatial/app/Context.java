package org.geospatial.app;

import com.bbn.openmap.LayerHandler;
import com.bbn.openmap.gui.BasicMapPanel;
import com.bbn.openmap.gui.MapPanel;
import com.bbn.openmap.gui.OverlayMapPanel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;

public final class Context {
    
    // SINGLETON
    //private static final Context instance = new Context();
    //public static final Context Get() { return instance; }
    // NETBEANS
    //private static final InstanceContent lookUp = new InstanceContent();
    //public static final InstanceContent LookUp() { return lookUp; }
    
    public static MapPanel mapRoot = new OverlayMapPanel();
    
    public static List<GT_Entity> entities = new ArrayList<>();  
    public static DefaultListModel entityListModel = new DefaultListModel();
    
    public static LayerHandler layerHandler = new LayerHandler();
    
}

