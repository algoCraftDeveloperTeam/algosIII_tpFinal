package fiuba.algo3;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.Border;
import java.awt.Color;
import fiuba.algo3.game.AlgoCraftModel;

public class SideMenu extends JPanel{

	public SideMenu(int width, int height) {
		Border etched = new EtchedBorder();
		setBorder(etched);
		setBackground(Color.orange);
		setSize(width, height);
	}
}