package org.geospatial.app.gui;

import java.awt.BorderLayout;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.util.NbBundle;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;

@TopComponent.Description(
        preferredID = "LayerContentTopComponent",
        persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(
        mode = "editor", 
        openAtStartup = true)
@ActionID(
        category = "Window", 
        id = "org.geospatial.map.LayerContent")
@ActionReferences({
    @ActionReference(
        path = "Menu/Window", 
        position = 0)
})
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_LayerContentAction")
@NbBundle.Messages("CTL_LayerContentAction=Open LayerContent")

public class Win_LayerContent extends TopComponent{
    
    // CTOR
    @Messages("CTL_LayerContentName=Layer Content")
    public Win_LayerContent()
    {
        setDisplayName(Bundle.CTL_LayerContentName());
        InitLayout();
    }

    private void InitLayout() {
        setLayout(new BorderLayout());              
        add(new Panel_LayerContent(), BorderLayout.CENTER);
    }
    
}
