package org.geospatial.app.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JPanel;
import org.geospatial.app.Context;

public class Panel_TimeBar extends JPanel{
    
    Calendar cal = Calendar.getInstance(); 
    // limits
    Date dateMin = new Date();
    Date dateMax = new Date();
    // Selection
    Date dateStart = dateMin;
    Date dateEnd = dateMax;
    Date dateSelected = new Date();
    int sightPastYears = 0;
    int sightPastDays = 5;
    int sightPastHours = 0;
    int sightFutureYears = 0;
    int sightFutureDays = 1;
    int sightFutureHours = 0;
    // Inputs
    
    
    public Panel_TimeBar()
    {
        setBackground(new java.awt.Color(50, 50, 50));
        InitLimits();
        InitSelection();
    }

    private void InitLimits() {
        dateMin.setTime(0);
        cal.setTimeInMillis(new Date().getTime());
        cal.add(Calendar.YEAR, 1);
        dateMax = cal.getTime();
    }

    private void InitSelection() {
        cal.setTimeInMillis(dateMin.getTime());
        cal.set(Calendar.YEAR,1900);
        dateStart = dateMin = cal.getTime();
        dateEnd = dateMax;
        dateSelected.setTime((dateMax.getTime()+dateMin.getTime())/2);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  
        DrawBg(g);
        DrawToday(g);
        //DrawItems(g); // TODO
        DrawSelection(g); 
        
    }

    private void DrawBg(Graphics g) {
        // SET
        cal.setTime(dateStart);
        int startYear = cal.get(Calendar.YEAR);
        cal.setTime(dateEnd);
        int endYear = cal.get(Calendar.YEAR);
        cal.setTimeInMillis(0);
        // DRAW
        for (int i=0; i<endYear-startYear; i++)
        {
            // SET YEAR
            cal.set(Calendar.YEAR,startYear+i);
            int startPosition = GetPositionOnBar(cal.getTime());
            cal.set(Calendar.YEAR,startYear+i+1);
            int endPosition = GetPositionOnBar(cal.getTime());
            // DRAW
            g.setColor( i%2==1 ? Color.GRAY : Color.LIGHT_GRAY);  
            g.fillRect(startPosition, 0, endPosition, 12);
            g.setColor(Color.WHITE); 
            g.drawString(Integer.toString(startYear+i), startPosition+3, 10);
            for (int j=0;j<12;j++)
            {
                // SET MONTH
                cal.set(Calendar.MONTH,j);
                int mStartPosition = GetPositionOnBar(cal.getTime());
                cal.set(Calendar.MONTH,j+1);
                int mEndPosition = GetPositionOnBar(cal.getTime());
                // DRAW
                g.setColor( j%2==1 ? Color.BLUE : Color.CYAN);  
                g.fillRect(mStartPosition, 12, mEndPosition, 10);
            }
        }
    }

    private void DrawSelection(Graphics g) {
        int position = GetPositionOnBar(dateSelected);
        g.setColor(Color.RED);  
        g.fillRect(position, 0, 1,getHeight() );
    }
    
    private int GetPositionOnBar(Date date)
    {
        long start = dateStart.getTime();
        long end = dateEnd.getTime();
        long position = date.getTime();
        end -= start;
        position -= start;
        return (int)(position*getWidth()/end);
    }


    private void DrawItems(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Font font = new Font(null, Font.PLAIN, 10);
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.rotate(Math.toRadians(90), 0, 0);
        Font rotatedFont = font.deriveFont(affineTransform);
        g2.setFont(rotatedFont);
        Iterator it = Context.entities.iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            int position = GetPositionOnBar((Date)pair.getValue());
            g.setColor(Color.GRAY);  
            g.fillRect(position, 23, 1,20);     
            g.setColor(Color.WHITE); 
            g2.drawString((String)pair.getKey(), position, 30);
        }
        g2.dispose();
    }

    private void DrawToday(Graphics g) {
        int position = GetPositionOnBar(new Date());
        g.setColor(Color.BLUE);  
        g.fillRect(position, 0, 1,getHeight() );
    }
            
    
    
}
