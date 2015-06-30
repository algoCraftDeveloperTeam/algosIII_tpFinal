package fiuba.algo3.view;

import fiuba.algo3.model.exceptions.EmptyTileException;
import fiuba.algo3.model.exceptions.InsufficientAvailablePopulationException;
import fiuba.algo3.model.exceptions.InsufficientResourcesException;
import fiuba.algo3.model.exceptions.SubtractedResourcesGreaterThanStoragedException;
import fiuba.algo3.model.game.AlgoCraftModel;
import fiuba.algo3.model.map.Tile;
import fiuba.algo3.model.occupant.Occupant;
import java.util.List;
import fiuba.algo3.model.occupant.buildings.UnitCreator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateUnitButton extends ActionButton implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Occupant occupant;
	protected List<PlayerData> playerLabels;

	public CreateUnitButton(AlgoCraftModel algoCraftModel, List<PlayerData> playerData) {
		super(algoCraftModel);
		setText("Create Unit");
		addActionListener(this);
		playerLabels = playerData;
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
        UnitCreator unitCreator = (UnitCreator) occupant;
        try {
            unitCreator.trainUnit();
        } catch (InsufficientAvailablePopulationException | InsufficientResourcesException | SubtractedResourcesGreaterThanStoragedException ex) {
            System.out.println(ex.getMessage());
        }
        for(PlayerData data : playerLabels){
    		data.refreshLabel();
    	}
    }
}