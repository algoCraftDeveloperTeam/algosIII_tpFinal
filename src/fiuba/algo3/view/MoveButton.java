package fiuba.algo3.view;

import java.awt.event.*;
import fiuba.algo3.model.map.Tile;
import fiuba.algo3.model.game.AlgoCraftModel;
import fiuba.algo3.model.exceptions.EmptyTileException;
import fiuba.algo3.model.occupant.Occupant;
import fiuba.algo3.model.occupant.units.Unit;

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