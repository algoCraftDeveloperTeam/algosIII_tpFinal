package fiuba.algo3.view;

import fiuba.algo3.model.game.AlgoCraftModel;
import fiuba.algo3.view.map.MapView;
import fiuba.algo3.view.sideMenu.SideMenu;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class AlgoCraftView extends JFrame{

	private SideMenu sideMenu;
	private MapView mapView;

	public AlgoCraftView(AlgoCraftModel algoCraftModel)
			throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		//setExtendedState(Frame.MAXIMIZED_BOTH);
		setSize(700, 500);
		getContentPane().setLayout(null);
		sideMenu = new SideMenu(0, 0, (int) (getWidth() * 0.2), getHeight(), algoCraftModel);
		mapView = new MapView((int) (getWidth() * 0.2), 0, (int) (getWidth() * 0.8), getHeight(), algoCraftModel.getAlgoCraftMap(), sideMenu.getActionButtons());
		sideMenu.setMap(mapView);
		getContentPane().add(sideMenu);
		getContentPane().add(mapView);
	}
}