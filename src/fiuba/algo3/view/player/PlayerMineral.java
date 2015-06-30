package fiuba.algo3.view.player;

import fiuba.algo3.model.game.AlgoCraftModel;
import fiuba.algo3.view.player.PlayerData;

public class PlayerMineral extends PlayerData {

	public PlayerMineral(AlgoCraftModel algoCraftModel) {
		super(algoCraftModel);
		refreshLabel();
	}

	@Override
	public void refreshLabel(){
		setText("Mineral: " + String.valueOf(gameModel.getActivePlayer().getMineralStorage()));
	}
}