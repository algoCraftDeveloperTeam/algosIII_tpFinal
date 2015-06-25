package fiuba.algo3.view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.*;
import fiuba.algo3.map.Tile;
import fiuba.algo3.game.AlgoCraftModel;

public class MoveButton extends ActionButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MoveButton(AlgoCraftModel algoCraftModel) {
		super(algoCraftModel);
		setText("Move");
	}

	public void setBehavior(Tile modelTile, TileView viewTile){
		setEnabled(modelTile.isOccupied());
	}
}