package org.geospatial.app.gui;

import com.sun.tools.example.debug.expr.ExpressionParser;
import java.awt.BorderLayout;
import org.geospatial.app.Context;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;

@TopComponent.Description(
        preferredID = "Map",
        persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(
        mode = "editor", 
        openAtStartup = true)
@ActionID(
        category = "Window", 
        id = "org.geospatial.map.Map")
@ActionReferences({
    @ActionReference(
        path = "Menu/Window", 
        position = 0)
})
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_MapAction")
@Messages("CTL_MapAction=Open Map")

public class Win_Map extends TopComponent {

    // CTOR
    @Messages("CTL_MapName=Map")
    public Win_Map() 
    {
        setDisplayName(Bundle.CTL_MapName());
        InitLayout();
    }

    private void InitLayout() {
        setLayout(new BorderLayout());              
        add(new Panel_Map(), BorderLayout.CENTER);
        //add(Context.mapRoot.getMapMenuBar(), BorderLayout.NORTH);
        
    }

}