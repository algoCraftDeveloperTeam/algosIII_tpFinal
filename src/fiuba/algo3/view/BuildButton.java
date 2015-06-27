package fiuba.algo3.view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.*;
import fiuba.algo3.map.Tile;
import fiuba.algo3.map.Coordinates;
import fiuba.algo3.game.AlgoCraftModel;
import java.util.List;
import fiuba.algo3.occupant.buildings.*;
import java.lang.reflect.*;
import fiuba.algo3.exceptions.*;
import java.lang.reflect.Constructor;
import fiuba.algo3.player.Player;

public class BuildButton extends ActionButton implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Tile actionTile;
	private TileView actionTileView;
	protected List<PlayerData> playerLabels;

	public BuildButton(AlgoCraftModel algoCraftModel, List<PlayerData> playerData) {
		super(algoCraftModel);
		setText("Build");
		addActionListener(this);
		playerLabels = playerData;
	}
	
	public void setBehavior(Tile modelTile, TileView viewTile){
		setEnabled(!modelTile.isOccupied());
		actionTile = modelTile;
		actionTileView = viewTile;
	}

	public void actionPerformed(ActionEvent e) {
    	String[] options = {"Access", "Barracks", "Asimilator", "MineralCenter", "MineralNexus", "Pylon", "Refinery"};
    	JFrame f = new JFrame("input");
    	String choice = (String) JOptionPane.showInputDialog(f,"Choose a Building","Build", JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
    	if(choice != null){
	    	try{
	    		Class<?> buildingClass = Class.forName("fiuba.algo3.occupant.buildings."+choice);
	    		Constructor constructor = buildingClass.getConstructor(new Class[]{Player.class, Coordinates.class});
                Building building = (Building) constructor.newInstance(gameModel.getActivePlayer(), actionTile.getPosition());
	    		gameModel.build(building);
	    		actionTileView.refreshOccupant();
	    	} catch(KeyDoesNotExistsException | InsufficientResourcesException | CannotOccupyTileException | 
	    			MissingRequiredBuildingsException | DestinationIsOccupiedException ex){
	    		System.out.println(ex.getMessage());
	    	} catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException | 
	    			InstantiationException | ClassNotFoundException ex){
	    		System.out.println("Instantiation Problem");
	    	}
    	}
    	for(PlayerData data : playerLabels){
    		data.refreshLabel();
    	}
    }  
}