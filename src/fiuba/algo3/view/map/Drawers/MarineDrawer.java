package fiuba.algo3.view.map.Drawers;

import java.awt.*;

public class MarineDrawer implements OccupantDrawer{

	private static MarineDrawer instance = null;

	private MarineDrawer(){}

	public static MarineDrawer getInstance(){
		if(instance == null){
			instance = new MarineDrawer();
		}
		return instance;
	}

	public void paintComponent(Graphics g, int w, int h){
		g.setColor(Color.BLACK);
		g.fillOval(w/4,h/4,w/2,h/2);
	}
}