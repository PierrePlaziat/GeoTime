package org.geospatial.app.gui;

import java.awt.BorderLayout;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;

@TopComponent.Description(
        preferredID = "Win_TimeBarValues",
        persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(
        mode = "editor", 
        openAtStartup = true)
@ActionID(
        category = "Window", 
        id = "org.geospatial.map.Win_TimeBarValues")
@ActionReferences({
    @ActionReference(
        path = "Menu/Window", 
        position = 0)
})
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_TimeBarValuesAction")
@Messages("CTL_TimeBarValuesAction=Open TimeBarValues")

public class Win_TimeBarValues extends TopComponent {

    // CTOR
    @Messages("CTL_Win_TimeBarValuesName=Win_TimeBarValues")
    public Win_TimeBarValues() 
    {
        setDisplayName(Bundle.CTL_Win_TimeBarValuesName());
        InitLayout();
    }

    private void InitLayout() {
        setLayout(new BorderLayout());              
        add(new Panel_TimeBarValues(), BorderLayout.CENTER);
    }

}