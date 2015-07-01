package fiuba.algo3.view.map;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.*;

public class RefineryDrawer implements OccupantDrawer{

	private static RefineryDrawer instance = null;

	private RefineryDrawer(){}

	public static RefineryDrawer getInstance(){
		if(instance == null){
			instance = new RefineryDrawer();
		}
		return instance;
	}

	public void paintComponent(Graphics g, int w, int h){
		g.setColor(Color.BLUE);
		g.fillOval(0,0,w,h);
	}
}