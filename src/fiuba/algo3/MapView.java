package fiuba.algo3;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Graphics;
import java.awt.Image;
import fiuba.algo3.game.AlgoCraftModel;

public class MapView extends JPanel implements MouseListener{

	public MapView(int width, int height) {
		addMouseListener(this);
		Border etched = new EtchedBorder();
		setBorder(etched);
		setBackground(Color.yellow);
		setSize(width, height);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("mouseClicked");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("mouseExited");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("mouseEntered");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("mouseReleased");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("mousePressed");
	}
}