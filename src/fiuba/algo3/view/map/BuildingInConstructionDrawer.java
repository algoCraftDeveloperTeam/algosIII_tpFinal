package fiuba.algo3.view.map;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.*;

public class BuildingInConstructionDrawer implements OccupantDrawer{

	private static BuildingInConstructionDrawer instance = null;

	private BuildingInConstructionDrawer(){}

	public static BuildingInConstructionDrawer getInstance(){
		if(instance == null){
			instance = new BuildingInConstructionDrawer();
		}
		return instance;
	}

	public void paintComponent(Graphics g, int w, int h){
		g.setColor(Color.BLACK);
		g.fillOval(0,0,w,h);
	}
}