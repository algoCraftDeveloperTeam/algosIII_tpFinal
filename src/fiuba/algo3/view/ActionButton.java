package fiuba.algo3.view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.*;
import fiuba.algo3.map.Tile;
import fiuba.algo3.game.AlgoCraftModel;

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