package org.geospatial.app.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.geospatial.app.Context;
import org.geospatial.app.GT_Entity;

public class Panel_Creator extends JPanel{
    
    JTextField t1,t2,t3,t4,t5,t6;
    JButton b1,b2;
    JLabel l1,l2,l3,l4,l5,l6;
    
    public Panel_Creator(){
        
        InitFields();
        InitButtons(); 
        InitSwing();
    }

    private void InitFields() {
        t1=new JTextField("");  
        t1.setBounds(60,0, 200,30);  
        t2=new JTextField("");  
        t2.setBounds(60,30, 200,30);  
        t3=new JTextField("");  
        t3.setBounds(60,60, 200,30);  
        t4=new JTextField("");  
        t4.setBounds(60,90, 200,30);  
        t5=new JTextField("");  
        t5.setBounds(60,120, 200,30);  
        t6=new JTextField("");  
        t6.setBounds(60,150, 200,30);   
        l1 = new JLabel("Title");     
        l1.setBounds(3,0, 60,30);  
        l2 = new JLabel("Description");    
        l2.setBounds(3,30, 60,30);   
        l3 = new JLabel("Instant");     
        l3.setBounds(3,60, 60,30);  
        l4 = new JLabel("Duration");  
        l4.setBounds(3,90, 60,30);      
        l5 = new JLabel("Lattitude");  
        l5.setBounds(3,120, 60,30);     
        l6 = new JLabel("Longitude"); 
        l6.setBounds(3,150, 60,30); 
    }

    private void InitButtons() {
        
        b1=new JButton("Validate");  
        b1.setBounds(1,180, 130,30);  
        b1.addActionListener( new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { Create(); } 
                private void Create() 
                {
                    if (!t1.getText().isBlank() && !t2.getText().isBlank())
                    {
                        GT_Entity e = new GT_Entity(t1.getText(),t2.getText());
                        // TODO spacetime  
                        Context.entities.add(e);
                        Context.entityListModel.addElement(e.toString());  
                    }                  
                }
            }
        );
        
        b2=new JButton("Cancel");  
        b2.setBounds(131,180, 130,30);
        b2.addActionListener( new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { Reset(); } 
                private void Reset() 
                {
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");
                    t6.setText("");
                }
            }
        );
        
    }

    private void InitSwing() {
        add(t1);
        add(t2);
        add(t3);
        add(t4);
        add(t5);
        add(t6);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(l6);
        add(b1);
        add(b2);
    }
}
