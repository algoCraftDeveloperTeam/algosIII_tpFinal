package fiuba.algo3.view;

import fiuba.algo3.exceptions.EmptyTileException;
import fiuba.algo3.game.AlgoCraftModel;
import fiuba.algo3.map.Tile;
import fiuba.algo3.occupant.Occupant;
import fiuba.algo3.occupant.buildings.UnitCreator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateUnitButton extends ActionButton implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Occupant occupant;

	public CreateUnitButton(AlgoCraftModel algoCraftModel) {
		super(algoCraftModel);
		setText("Create Unit");
		addActionListener(this);
	}

	public void setBehavior(Tile modelTile, TileView viewTile){
		try{
			occupant = modelTile.getOccupant();
			setEnabled(occupant.canCreate() && (gameModel.getActivePlayer() == occupant.getOwner()));
		} catch (EmptyTileException ex){
			setEnabled(false);
		}
	}

	public void actionPerformed(ActionEvent e) {
    	/*String[] options = {"Access", "Barracks", "Asimilator", "MineralCenter", "MineralNexus", "Pylon", "Refinery"};
    	JFrame f = new JFrame("input");
    	String choice = (String) JOptionPane.showInputDialog(f,"Choose a Building","Build", JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
    	if(choice != null){
	    	try{
	    		Class<?> buildingClass = Class.forName("fiuba.algo3.occupant.buildings."+choice);
	    		Constructor constructor = buildingClass.getConstructor(new Class[]{Player.class, Coordinates.class});
                Building building = (Building) constructor.newInstance(gameModel.getActivePlayer(), actionTile.getPosition());
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
	    	} catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException | ClassNotFoundException ex){
	    		System.out.println("Instantiation Problem");
	    	}
    	}*/
    	System.out.println("creando...");
        UnitCreator unitCreator = (UnitCreator) occupant;
        unitCreator.trainUnit();
    }
}