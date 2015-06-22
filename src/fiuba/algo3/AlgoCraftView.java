package fiuba.algo3;

import fiuba.algo3.game.AlgoCraftModel;

import javax.swing.*;
import java.awt.*;

public class AlgoCraftView extends JFrame{

	private SideMenu sideMenu;
	private MapView map;

	public AlgoCraftView(AlgoCraftModel algoCraftModel) {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		setResizable(false);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sideMenu = new SideMenu((int) (getWidth() * 0.2), getHeight());
		map = new MapView(getWidth(), getHeight());
		add(sideMenu, BorderLayout.WEST);
		add(map, BorderLayout.EAST);
	}
}