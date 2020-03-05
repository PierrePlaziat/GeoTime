package org.geospatial.app.gui;

import com.bbn.openmap.LayerHandler;
import com.bbn.openmap.MouseDelegator;
import com.bbn.openmap.MultipleSoloMapComponentException;
import com.bbn.openmap.event.MapMouseEvent;
import com.bbn.openmap.event.MapMouseListener;
import com.bbn.openmap.event.OMMouseMode;
import com.bbn.openmap.event.SelectMouseMode;
import com.bbn.openmap.gui.LayersPanel;
import com.bbn.openmap.gui.ToolPanel;
import com.bbn.openmap.layer.GraticuleLayer;
import com.bbn.openmap.layer.learn.BasicLayer;
import com.bbn.openmap.layer.shape.ShapeLayer;
import com.bbn.openmap.omGraphics.OMGraphic;
import com.bbn.openmap.omGraphics.OMPoint;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.Properties;
import javax.swing.JPanel;
import org.geospatial.app.Context;
import org.openide.awt.StatusDisplayer;

public class Panel_Map extends JPanel {

    
    private final OLMapMouseListener mouseListener = new OLMapMouseListener();
    private MouseDelegator mouseDelegator = new MouseDelegator();
    private SelectMouseMode selectMouseMode = new SelectMouseMode();
    public OMGraphic selectedOMGraphic;
    
    public Panel_Map(){
        
        try {
            InitMap();
            InitLayers(); 
            InitLayout();
            InitMouse();
        } catch (MultipleSoloMapComponentException msmce) {
            System.out.println("ERROR --- "+msmce.getMessage());
        }
    }

    private void InitMap() {
        Context.mapRoot.addMapComponent(this);  
        Context.mapRoot.addMapComponent(Context.layerHandler);  
        Context.mapRoot.addMapComponent(new MouseDelegator());  
        Context.mapRoot.addMapComponent(new OMMouseMode());
        Context.mapRoot.addMapComponent(new ToolPanel());
        Context.mapRoot.addMapComponent(new LayersPanel());
        Context.mapRoot.getMapBean().setScale(120000000f);
        Context.mapRoot.getMapBean().setBackgroundColor(new Color(110,140,140));  
    }

    private void InitLayers() {
        
        // COUNTRIES LAYER
        ShapeLayer layer_Planet = new ShapeLayer() {
            @Override
            public synchronized MapMouseListener getMapMouseListener() {
                return mouseListener;
            }
        };
        Properties layerProps = new Properties();
        layerProps.put("lineColor", "CCCCDD");
        layerProps.put("fillColor", "DDDDCC");
        layerProps.put("shapeFile", "org/geospatial/map/dcwpo-browse.shp");
        layerProps.put("spatialIndex", "org/geospatial/map/dcwpo-browse.ssx");
        layer_Planet.setProperties(layerProps);
        layer_Planet.setVisible(true);
        Context.mapRoot.getMapHandler().add(layer_Planet); 
        
        // TOP LAYERS
        Context.mapRoot.addMapComponent(new GraticuleLayer());
        Context.mapRoot.addMapComponent(new BasicLayer());
        
    }

    private void InitLayout() {
        setLayout(new BorderLayout());          
        add(Context.mapRoot.getMapBean(), BorderLayout.CENTER);
    }

    private void InitMouse() {
        Context.mapRoot.getMapHandler().add(mouseDelegator);
        Context.mapRoot.getMapHandler().add(selectMouseMode);
        mouseDelegator.setActive(selectMouseMode);
        selectedOMGraphic = new OMPoint(0,0);
    }

    public class OLMapMouseListener implements MapMouseListener {
        @Override
        public String[] getMouseModeServiceList() {
            return new String[]{SelectMouseMode.modeID};
        }
        @Override
        public boolean mouseClicked(MouseEvent e) {
            MapMouseEvent mme = (MapMouseEvent) e;
            //Optionally:
//            LatLonPoint latLonPoint = LatLonPoint.getFloat(mme.getLatLon());
//            selectedOMGraphic.
//            GT_Context.getInstance().ic.set(Collections.singleton(mme.getLatLon()), null);
            StatusDisplayer.getDefault().setStatusText(mme.getLatLon().toString());
            return true;
        }
        @Override
        public boolean mousePressed(MouseEvent e) {return true;}
        @Override
        public boolean mouseReleased(MouseEvent e) {return true;}
        @Override
        public void mouseEntered(MouseEvent e) {}
        @Override
        public void mouseExited(MouseEvent e) {}
        @Override
        public boolean mouseDragged(MouseEvent e) {return true;}
        @Override
        public boolean mouseMoved(MouseEvent e) {return true;}
        @Override
        public void mouseMoved() {}
    }
    
}
