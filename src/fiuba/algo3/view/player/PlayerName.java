package fiuba.algo3.view.player;

import fiuba.algo3.model.game.AlgoCraftModel;
import fiuba.algo3.view.player.PlayerData;

public class PlayerName extends PlayerData {

	public PlayerName(AlgoCraftModel algoCraftModel) {
		super(algoCraftModel);
		refreshLabel();
	}

	@Override
	public void refreshLabel(){
		setText(gameModel.getActivePlayer().getName());
	}
}