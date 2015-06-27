package fiuba.algo3.view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.*;
import fiuba.algo3.map.Tile;
import fiuba.algo3.game.AlgoCraftModel;

public abstract class PlayerData extends JLabel{

	protected AlgoCraftModel gameModel;

	public PlayerData(AlgoCraftModel algoCraftModel) {
		gameModel = algoCraftModel;
		setText("null");
	}

	public abstract void refreshLabel();
}