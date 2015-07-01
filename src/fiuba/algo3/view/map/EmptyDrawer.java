package fiuba.algo3.view.map;

import fiuba.algo3.view.map.drawers.OccupantDrawer;

import java.awt.*;

public class EmptyDrawer implements OccupantDrawer {

	private static EmptyDrawer instance = null;

	private EmptyDrawer(){}

	public static EmptyDrawer getInstance(){
		if(instance == null){
			instance = new EmptyDrawer();
		}
		return instance;
	}

	public void paintComponent(Graphics g, int w, int h){
		
	}
}