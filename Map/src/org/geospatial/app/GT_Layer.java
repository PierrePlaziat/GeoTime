package org.geospatial.app;

import org.geospatial.app.GT_Entity;
import com.bbn.openmap.layer.OMGraphicHandlerLayer;
import java.util.List;

public class GT_Layer {
    
    public List<GT_Entity> content;
    
    public boolean showInSpace = true;
    public boolean showInTime = true;
    
    private OMGraphicHandlerLayer mapObject;
    public OMGraphicHandlerLayer GetOMGraph() { return mapObject; }
}
