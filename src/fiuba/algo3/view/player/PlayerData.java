package fiuba.algo3.view.player;

import javax.swing.*;

import fiuba.algo3.model.game.AlgoCraftModel;

public abstract class PlayerData extends JLabel{

	protected AlgoCraftModel gameModel;

	public PlayerData(AlgoCraftModel algoCraftModel) {
		gameModel = algoCraftModel;
		setText("null");
	}

	public abstract void refreshLabel();
}