package fiuba.algo3.view.map.drawers;

import java.awt.*;

public class GoliathDrawer implements OccupantDrawer{

	private static GoliathDrawer instance = null;

	private GoliathDrawer(){}

	public static GoliathDrawer getInstance(){
		if(instance == null){
			instance = new GoliathDrawer();
		}
		return instance;
	}

	public void paintComponent(Graphics g, int w, int h){
		g.setColor(Color.MAGENTA);
		g.fillOval(w/4,h/4,w/2,h/2);
	}
}