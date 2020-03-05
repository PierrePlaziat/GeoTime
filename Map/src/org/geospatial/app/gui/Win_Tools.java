package org.geospatial.app.gui;

import java.awt.BorderLayout;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;

@TopComponent.Description(
        preferredID = "Tools",
        persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(
        mode = "editor", 
        openAtStartup = true)
@ActionID(
        category = "Window", 
        id = "org.geospatial.map.Tools")
@ActionReferences({
    @ActionReference(
        path = "Menu/Window", 
        position = 0)
})
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_ToolsAction")
@Messages("CTL_ToolsAction=Open Tools")

public class Win_Tools extends TopComponent {

    // CTOR
    @Messages("CTL_ToolsName=Tools")
    public Win_Tools() 
    {
        setDisplayName(Bundle.CTL_ToolsName());
        InitLayout();
    }

    private void InitLayout() {
        setLayout(new BorderLayout());              
        add(new Panel_Tools(), BorderLayout.CENTER);
    }

}