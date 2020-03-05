package org.geospatial.app.gui;

import java.awt.BorderLayout;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;

@TopComponent.Description(
        preferredID = "MapValues",
        persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(
        mode = "editor", 
        openAtStartup = true)
@ActionID(
        category = "Window", 
        id = "org.geospatial.map.MapValues")
@ActionReferences({
    @ActionReference(
        path = "Menu/Window", 
        position = 0)
})
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_MapValuesAction")
@Messages("CTL_MapValuesAction=Open MapValues")

public class Win_MapValues extends TopComponent {

    // CTOR
    @Messages("CTL_MapValuesName=MapValues")
    public Win_MapValues() 
    {
        setDisplayName(Bundle.CTL_MapValuesName());
        InitLayout();
    } 

    private void InitLayout() {
        setLayout(new BorderLayout());              
        add(new Panel_MapValues(), BorderLayout.CENTER);
    }

}