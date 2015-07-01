package fiuba.algo3.view.map.Drawers;

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
		g.fillOval(w/8,h/8,w/4,h/4);
	}
}