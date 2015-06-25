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
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		for(ActionButton observer : observers){
            observer.setBehavior(modelTile, this);
        }
	}
	
	@Override
	public void printOccupied(){
		setBackground(Color.ORANGE);
	}
}
