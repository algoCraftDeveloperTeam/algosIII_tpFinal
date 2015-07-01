package fiuba.algo3.view.map;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.*;

public class SupplyDepotDrawer implements OccupantDrawer{

	private static SupplyDepotDrawer instance = null;

	private SupplyDepotDrawer(){}

	public static SupplyDepotDrawer getInstance(){
		if(instance == null){
			instance = new SupplyDepotDrawer();
		}
		return instance;
	}

	public void paintComponent(Graphics g, int w, int h){
		g.setColor(Color.YELLOW);
		g.fillOval(0,0,w,h);
	}
}