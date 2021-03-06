package fiuba.algo3.view.sideMenu;

import javax.swing.*;

import fiuba.algo3.model.map.Tile;
import fiuba.algo3.model.game.AlgoCraftModel;
import fiuba.algo3.view.map.MapView;
import fiuba.algo3.view.map.TileView;

public abstract class ActionButton extends JButton{

	protected AlgoCraftModel gameModel;
	protected MapView mapView;

	public ActionButton(AlgoCraftModel algoCraftModel) {
		gameModel = algoCraftModel;
		setVisible(true);
		setEnabled(false);
	}

	public void setMap(MapView map){
		mapView = map;
	}

	public abstract void setBehavior(Tile modelTile, TileView viewTile);
}