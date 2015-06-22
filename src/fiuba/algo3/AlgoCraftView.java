package fiuba.algo3;

import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.Container;
import java.awt.BorderLayout;
import fiuba.algo3.game.AlgoCraftModel;

public class AlgoCraftView extends JFrame{

	private SideMenu sideMenu;

	public AlgoCraftView(AlgoCraftModel algoCraftModel) {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		setResizable(false);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sideMenu = new SideMenu((int) (getWidth() * 0.2), getHeight());
		add(sideMenu, BorderLayout.WEST);
	}
}