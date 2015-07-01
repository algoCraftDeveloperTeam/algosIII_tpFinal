package fiuba.algo3.view.map.drawers;

import java.awt.*;

public class MineralCenterDrawer implements OccupantDrawer{

	private static MineralCenterDrawer instance = null;

	private MineralCenterDrawer(){}

	public static MineralCenterDrawer getInstance(){
		if(instance == null){
			instance = new MineralCenterDrawer();
		}
		return instance;
	}

	public void paintComponent(Graphics g, int w, int h){
		g.setColor(Color.GREEN);
		g.fillOval(0,0,w,h);
	}
}