package fiuba.algo3.view.map.drawers;

import java.awt.*;

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
		g.setColor(Color.CYAN);
		g.fillOval(w/4,h/4,w/2,h/2);
	}
}