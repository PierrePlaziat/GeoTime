package org.geospatial.app.gui;

import java.awt.BorderLayout;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;

@TopComponent.Description(
        preferredID = "Win_TimeBar",
        persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(
        mode = "editor", 
        openAtStartup = true)
@ActionID(
        category = "Window", 
        id = "org.geospatial.map.Win_TimeBar")
@ActionReferences({
    @ActionReference(
        path = "Menu/Window", 
        position = 0)
})
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_Win_TimeBarAction")
@Messages("CTL_Win_TimeBarAction=Open Win_TimeBar")

public class Win_TimeBar extends TopComponent {

    // CTOR
    @Messages("CTL_Win_TimeBarName=Win_TimeBar")
    public Win_TimeBar() 
    {
        setDisplayName(Bundle.CTL_Win_TimeBarName());
        InitLayout();
    }

    private void InitLayout() {
        setLayout(new BorderLayout());              
        add(new Panel_TimeBar(), BorderLayout.CENTER);
    }

}