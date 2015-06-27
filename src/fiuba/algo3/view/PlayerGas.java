package fiuba.algo3.view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.*;
import fiuba.algo3.map.Tile;
import fiuba.algo3.game.AlgoCraftModel;

public class PlayerGas extends PlayerData{

	public PlayerGas(AlgoCraftModel algoCraftModel) {
		super(algoCraftModel);
		refreshLabel();
	}

	@Override
	public void refreshLabel(){
		setText("Gas: " + String.valueOf(gameModel.getActivePlayer().getGasStorage()));
	}
}