package fiuba.algo3.view.map;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.*;

public class EmptyDrawer implements OccupantDrawer{

	public void paintComponent(Graphics g, int w, int h){
		g.setColor(Color.BLACK);
		g.fillOval(0,0,w,h);
	}

}
