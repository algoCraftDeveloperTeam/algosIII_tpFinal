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
    	String[] p = {"Access", "Barracks", "Asimilator", "Mineral Center", "Mineral Nexus", "Pylon", "Refinery"};
    	JFrame f = new JFrame("input");
    	String choice = (String) JOptionPane.showInputDialog(f,"Que edificio construir","elegir", JOptionPane.QUESTION_MESSAGE,null,p,p[0]);
    	if(choice != null){
	    	try{
	    		Building building = new Pylon(gameModel.getActivePlayer(), actionTile.getPosition());
	    		switch (choice){
	    			case "Access":
	    				building = new Access(gameModel.getActivePlayer(), actionTile.getPosition());
	    				break;
	    			case "Barracks":
	    				building = new Barracks(gameModel.getActivePlayer(), actionTile.getPosition());
	    				break;
	    			case "Asimilator":
	    				building = new Asimilator(gameModel.getActivePlayer(), actionTile.getPosition());
	    				break;
	    			case "Mineral Center":
	    				building = new MineralCenter(gameModel.getActivePlayer(), actionTile.getPosition());
	    				break;
	    			case "Mineral Nexus":
	    				building = new MineralNexus(gameModel.getActivePlayer(), actionTile.getPosition());
	    				break;
	    			case "Pylon":
	    				building = new Pylon(gameModel.getActivePlayer(), actionTile.getPosition());
	    				break;
	    			case "Refinery":
	    				building = new Refinery(gameModel.getActivePlayer(), actionTile.getPosition());
	    				break;
	    		}
	    		gameModel.build(building);
	    		actionTileView.printOccupied();
	    	} catch(KeyDoesNotExistsException ex){
	    		System.out.println("KeyDoesNotExistsException");
	    	} catch(InsufficientResourcesException ex){
	    		System.out.println("InsufficientResourcesException");
	    	} catch(CannotOccupyTileException ex){
	    		System.out.println("CannotOccupyTileException");
	    	} catch(MissingRequiredBuildingsException ex){
	    		System.out.println("MissingRequiredBuildingsException");
	    	} catch(DestinationIsOccupiedException ex){
	    		System.out.println("DestinationIsOccupiedException");
	    	}
    	}
    }  
	
	public void setBehavior(Tile modelTile, TileView viewTile){
		setEnabled(!modelTile.isOccupied());
		actionTile = modelTile;
		actionTileView = viewTile;
	}
}