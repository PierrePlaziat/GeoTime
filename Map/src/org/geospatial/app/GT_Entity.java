package org.geospatial.app;

import com.bbn.openmap.omGraphics.OMGraphic;
import java.util.Date;

public class GT_Entity {
    
    // ID
    private static int id_iterator = 0;
    private int id = id_iterator++;
    public int GetId() { return id; }
    
    // DIALECTIC
    public String title;
    public String description;
    //public List<String> tags;
    
    
    // PHENOMENON
    public Date startInstant;
    public Date endInstant; 
    public OMGraphic manifestation;
    
    public GT_Entity(String title,String description){
        this.title = title;
        this.description = description;
    }
    
    @Override
    public String toString()
    {
        return id+" "+title;
    }
    
}
