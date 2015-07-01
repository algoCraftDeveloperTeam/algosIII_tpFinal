package fiuba.algo3.view.map.Drawers;

import java.awt.*;

public class TerranFactoryDrawer implements OccupantDrawer{

	private static TerranFactoryDrawer instance = null;

	private TerranFactoryDrawer(){}

	public static TerranFactoryDrawer getInstance(){
		if(instance == null){
			instance = new TerranFactoryDrawer();
		}
		return instance;
	}

	public void paintComponent(Graphics g, int w, int h){
		g.setColor(Color.BLACK);
		g.fillOval(0,0,w,h);
	}
}