package fiuba.algo3.view.map;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.*;

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
		g.setColor(Color.BLACK);
		g.fillOval(0,0,w,h);
	}
}