package fiuba.algo3.view.map;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.*;

public class StarPortDrawer implements OccupantDrawer{

	private static StarPortDrawer instance = null;

	private StarPortDrawer(){}

	public static StarPortDrawer getInstance(){
		if(instance == null){
			instance = new StarPortDrawer();
		}
		return instance;
	}

	public void paintComponent(Graphics g, int w, int h){
		g.setColor(Color.BLACK);
		g.fillOval(0,0,w,h);
	}
}