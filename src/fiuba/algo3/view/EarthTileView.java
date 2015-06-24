package fiuba.algo3.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Created by mporto on 22/06/15.
 */
public class EarthTileView extends TileView implements MouseListener{

    public EarthTileView() {
		addMouseListener(this);
		setBackground(Color.RED);
    }

    @Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("mouseClicked From Earth Tile");
		if (modelTile.isOccupied()){
			modelTile.clear();
			setBackground(Color.RED);
		} else{
			modelTile.ocuparTurbio();
			setBackground(Color.ORANGE);
			for(ActionButton observer : observers){
	            observer.build();
	        }
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("mouseExited From Earth Tile");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("mouseEntered From Earth Tile");
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("mouseReleased From Earth Tile");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("mousePressed From Earth Tile");
	}
}
