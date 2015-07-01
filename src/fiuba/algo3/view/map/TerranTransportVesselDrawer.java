package fiuba.algo3.view.map;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.*;

public class TerranTransportVesselDrawer implements OccupantDrawer{

	private static TerranTransportVesselDrawer instance = null;

	private TerranTransportVesselDrawer(){}

	public static TerranTransportVesselDrawer getInstance(){
		if(instance == null){
			instance = new TerranTransportVesselDrawer();
		}
		return instance;
	}

	public void paintComponent(Graphics g, int w, int h){
		g.setColor(Color.BLACK);
		g.fillOval(0,0,w,h);
	}
}