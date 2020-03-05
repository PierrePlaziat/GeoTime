package org.swingTimeBar;

import java.util.Date;
import javax.swing.JPanel;

public class TimeBar extends JPanel{
    
    Date dateMin = new Date();
    Date dateMax = new Date();
    Date dateSelected = new Date();
    
    int sightPastYears = 0;
    int sightPastDays = 5;
    int sightPastHours = 0;
    
    int sightFutureYears = 0;
    int sightFutureDays = 1;
    int sightFutureHours = 0;
    
    public TimeBar()
    {
        setBackground(new java.awt.Color(255, 0, 255));
    }
    
}


