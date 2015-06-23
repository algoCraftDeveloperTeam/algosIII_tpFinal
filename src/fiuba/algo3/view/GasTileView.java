package fiuba.algo3.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Created by mporto on 22/06/15.
 */
public class GasTileView extends TileView implements MouseListener{

    public GasTileView() {
		addMouseListener(this);
		setBackground(Color.GREEN);
    }

    @Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("mouseClicked From Gas Tile");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("mouseExited From Gas Tile");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("mouseEntered From Gas Tile");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("mouseReleased From Gas Tile");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("mousePressed From Gas Tile");
	}
}
