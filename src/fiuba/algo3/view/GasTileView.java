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
	public void refreshOccupant(){
		if(modelTile.isOccupied()){
			setBackground(Color.ORANGE);
		} else{
			setBackground(Color.GREEN);
		}
	}
}
