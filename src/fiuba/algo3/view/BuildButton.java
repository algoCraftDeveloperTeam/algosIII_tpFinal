package fiuba.algo3.view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.*;
import fiuba.algo3.map.Tile;
import fiuba.algo3.map.Coordinates;
import fiuba.algo3.game.AlgoCraftModel;
import fiuba.algo3.occupant.buildings.*;
import fiuba.algo3.exceptions.*;

public class BuildButton extends ActionButton implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ActionListener build;
	private Tile actionTile;
	private TileView actionTileView;

	public BuildButton(AlgoCraftModel algoCraftModel) {
		super(algoCraftModel);
		setText("Build");
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent e)
    {
    	Access a = new Access(gameModel.getActivePlayer(), actionTile.getPosition());
    	try{
    		gameModel.build(a);
    		actionTileView.printOccupied();
    	} catch(InsufficientResourcesException | CannotOccupyTileException | MissingRequiredBuildingsException | DestinationIsOccupiedException | KeyDoesNotExistsException ex){
    		System.out.println("excepcion");
    	}
    	System.out.println(actionTile.isOccupied());
    }  
	
	public void setBehavior(Tile modelTile, TileView viewTile){
		setEnabled(!modelTile.isOccupied());
		actionTile = modelTile;
		actionTileView = viewTile;
	}
}