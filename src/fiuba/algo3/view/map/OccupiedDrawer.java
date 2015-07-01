package fiuba.algo3.view.map;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.*;

public class OccupiedDrawer implements OccupantDrawer{

	private static OccupiedDrawer instance = null;

	private OccupiedDrawer(){}

	public void paintComponent(Graphics g, int w, int h){
		g.setColor(Color.BLACK);
		g.fillOval(0,0,w,h);
	}

	public static OccupiedDrawer getInstance(){
		if(instance == null){
			instance = new OccupiedDrawer();
		}
		return instance;
	}

}
