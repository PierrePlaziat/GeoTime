package org.geospatial.app.gui;

import java.awt.BorderLayout;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;

@TopComponent.Description(
        preferredID = "Options",
        persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(
        mode = "editor", 
        openAtStartup = true)
@ActionID(
        category = "Window", 
        id = "org.geospatial.map.Options")
@ActionReferences({
    @ActionReference(
        path = "Menu/Window", 
        position = 0)
})
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_OptionsAction")
@Messages("CTL_OptionsAction=Open Options")

public class Win_Options extends TopComponent {

    // CTOR
    @Messages("CTL_OptionsName=Options")
    public Win_Options() 
    {
        setDisplayName(Bundle.CTL_OptionsName());
        InitLayout();
    }

    private void InitLayout() {
        setLayout(new BorderLayout());              
        add(new Panel_Options(), BorderLayout.CENTER);
    }

}