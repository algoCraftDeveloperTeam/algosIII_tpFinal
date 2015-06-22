package fiuba.algo3.view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class SideMenu extends JPanel{

	public SideMenu(int width, int height) {
		Border etched = new EtchedBorder();
		setBorder(etched);
		setBackground(Color.orange);
		setSize(width, height);
	}
}