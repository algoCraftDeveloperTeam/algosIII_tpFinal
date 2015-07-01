package fiuba.algo3.view.sideMenu;

import javax.swing.*;
import java.awt.event.*;
import fiuba.algo3.model.map.Tile;
import fiuba.algo3.model.map.Coordinates;
import fiuba.algo3.model.game.AlgoCraftModel;
import java.util.List;
import fiuba.algo3.model.occupant.buildings.*;
import java.lang.reflect.*;
import fiuba.algo3.model.exceptions.*;
import java.lang.reflect.Constructor;
import fiuba.algo3.model.player.Player;
import fiuba.algo3.view.map.TileView;
import fiuba.algo3.view.player.PlayerData;

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
    	String[] options = {"SupplyDepot", "Barracks", "MineralCenter", "Refinery", "TerranFactory", "StarPort"};
    	JFrame f = new JFrame("input");
    	String choice = (String) JOptionPane.showInputDialog(f,"Choose a Building","Build", JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
    	if(choice != null){
	    	try{
	    		Class<?> buildingClass = Class.forName("fiuba.algo3.model.occupant.buildings."+choice);
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