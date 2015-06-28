package fiuba.algo3.view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.*;
import fiuba.algo3.map.Tile;
import fiuba.algo3.game.AlgoCraftModel;
import fiuba.algo3.exceptions.EmptyTileException;
import fiuba.algo3.occupant.Occupant;
import fiuba.algo3.occupant.units.Unit;

public class MoveButton extends ActionButton implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Occupant occupant;

	public MoveButton(AlgoCraftModel algoCraftModel) {
		super(algoCraftModel);
		setText("Move");
		addActionListener(this);
	}

	public void setBehavior(Tile modelTile, TileView viewTile){
		try{
			occupant = modelTile.getOccupant();
			setEnabled(occupant.canMove() && (gameModel.getActivePlayer() == occupant.getOwner()));
		} catch (EmptyTileException ex){
			setEnabled(false);
		}
	}

	public void actionPerformed(ActionEvent e) {
		mapView.setMoveBehavior((Unit) occupant);
    }
}