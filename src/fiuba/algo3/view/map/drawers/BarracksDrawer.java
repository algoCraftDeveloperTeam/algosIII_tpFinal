package fiuba.algo3.view.map.drawers;

import java.awt.*;

public class BarracksDrawer implements OccupantDrawer{

	private static BarracksDrawer instance = null;

	private BarracksDrawer(){}

	public static BarracksDrawer getInstance(){
		if(instance == null){
			instance = new BarracksDrawer();
		}
		return instance;
	}

	public void paintComponent(Graphics g, int w, int h){
		g.setColor(Color.BLACK);
		g.fillOval(0,0,w,h);
	}
}