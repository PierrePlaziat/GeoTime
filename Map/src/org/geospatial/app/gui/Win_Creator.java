package org.geospatial.app.gui;

import java.awt.BorderLayout;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.util.NbBundle;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;


@TopComponent.Description(
        preferredID = "CreatorTopComponent",
        persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(
        mode = "editor", 
        openAtStartup = true)
@ActionID(
        category = "Window", 
        id = "org.geospatial.map.Creator")
@ActionReferences({
    @ActionReference(
        path = "Menu/Window", 
        position = 0)
})
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_CreatorAction")
@NbBundle.Messages("CTL_CreatorAction=Open Creator")

public class Win_Creator extends TopComponent{
    // CTOR
    @Messages("CTL_CreatorName=Creator")
    public Win_Creator()
    {
        setDisplayName(Bundle.CTL_CreatorName());
        InitLayout();
    }

    private void InitLayout() {
        setLayout(new BorderLayout());              
        add(new Panel_Creator(), BorderLayout.CENTER);
    }
    
}
