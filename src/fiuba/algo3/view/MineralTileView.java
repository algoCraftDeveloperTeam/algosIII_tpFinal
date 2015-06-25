package fiuba.algo3.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Created by mporto on 22/06/15.
 */
public class MineralTileView extends TileView implements MouseListener{

    public MineralTileView() {
		addMouseListener(this);
		setBackground(Color.BLUE);
    }

    @Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("mouseClicked From Mineral Tile");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("mouseExited From Mineral Tile");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("mouseEntered From Mineral Tile");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("mouseReleased From Mineral Tile");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("mousePressed From Mineral Tile");
	}
	
	@Override
	public void printOccupied(){
		setBackground(Color.ORANGE);
	}
}
