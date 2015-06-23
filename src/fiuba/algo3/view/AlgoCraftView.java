package fiuba.algo3.view;

import fiuba.algo3.game.AlgoCraftModel;

import javax.swing.*;
import java.awt.*;

public class AlgoCraftView extends JFrame{

	private SideMenu sideMenu;
	private MapView mapView;

	public AlgoCraftView(AlgoCraftModel algoCraftModel) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		getContentPane().setLayout(null);
		sideMenu = new SideMenu(0, 0, (int) (getWidth() * 0.2), getHeight());
		mapView = new MapView((int) (getWidth() * 0.2), 0, (int) (getWidth() * 0.8), getHeight());
		getContentPane().add(sideMenu);
		getContentPane().add(mapView);
	}
}