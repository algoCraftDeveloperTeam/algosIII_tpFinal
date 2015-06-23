package fiuba.algo3.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Created by mporto on 22/06/15.
 */
public class SpaceTileView extends TileView implements MouseListener{

    public SpaceTileView() {
		addMouseListener(this);
		setBackground(Color.BLACK);
    }

    @Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("mouseClicked From Space Tile");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("mouseExited From Space Tile");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("mouseEntered From Space Tile");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("mouseReleased From Space Tile");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("mousePressed From Space Tile");
	}
}
