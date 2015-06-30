package fiuba.algo3.view.sideMenu;

import java.awt.event.*;
import fiuba.algo3.model.map.Tile;
import fiuba.algo3.model.game.AlgoCraftModel;
import fiuba.algo3.model.exceptions.EmptyTileException;
import fiuba.algo3.model.occupant.Occupant;
import fiuba.algo3.model.occupant.units.CombatUnit;
import fiuba.algo3.view.map.TileView;

public class AttackButton extends ActionButton implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Occupant occupant;

	public AttackButton(AlgoCraftModel algoCraftModel) {
		super(algoCraftModel);
		setText("Attack");
		addActionListener(this);
	}

	public void setBehavior(Tile modelTile, TileView viewTile){
		try{
			occupant = modelTile.getOccupant();
			setEnabled(occupant.canAttack() && (gameModel.getActivePlayer() == occupant.getOwner()));
		} catch (EmptyTileException ex){
			setEnabled(false);
		}
	}

	public void actionPerformed(ActionEvent e) {
		mapView.setAttackBehavior((CombatUnit) occupant);
    }  
}