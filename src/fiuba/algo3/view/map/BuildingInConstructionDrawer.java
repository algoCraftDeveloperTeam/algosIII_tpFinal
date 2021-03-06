package fiuba.algo3.view.map;

import fiuba.algo3.view.map.drawers.OccupantDrawer;

import java.awt.*;

public class BuildingInConstructionDrawer implements OccupantDrawer {

	private static BuildingInConstructionDrawer instance = null;

	private BuildingInConstructionDrawer(){}

	public static BuildingInConstructionDrawer getInstance(){
		if(instance == null){
			instance = new BuildingInConstructionDrawer();
		}
		return instance;
	}

	public void paintComponent(Graphics g, int w, int h){
		g.setColor(Color.ORANGE);
		g.fillOval(0,0,w,h);
	}
}