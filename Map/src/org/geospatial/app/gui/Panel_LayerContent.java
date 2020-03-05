package org.geospatial.app.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import org.geospatial.app.Context;

public class Panel_LayerContent extends JPanel{
    
    private JButton b1,b2;
    private static JList entityList = new JList();  
    
    public Panel_LayerContent()
    {
        InitList();
        InitButton();
    }

    private void InitList() {    
        entityList.setModel(Context.entityListModel);
        entityList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        entityList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        entityList.setBounds(0, 30, 270, 500);
        add(entityList);
    }

    private void InitButton() {
        b1=new JButton("?");  
        b1.setBounds(0,0, 130,30);  
        add(b1);
        b2=new JButton("Delete");  
        b2.setBounds(130,0, 130,30);
        add(b2);
        b2.addActionListener( new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { Delete(); } 
                private void Delete() 
                {
                    Context.entities.remove(entityList.getSelectedIndex());
                    Context.entityListModel.remove(entityList.getSelectedIndex());
                }
            }
        );
    }
    
    
}
