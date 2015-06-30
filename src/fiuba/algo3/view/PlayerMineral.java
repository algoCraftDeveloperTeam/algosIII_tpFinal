package fiuba.algo3.view;

import fiuba.algo3.model.game.AlgoCraftModel;

public class PlayerMineral extends PlayerData{

	public PlayerMineral(AlgoCraftModel algoCraftModel) {
		super(algoCraftModel);
		refreshLabel();
	}

	@Override
	public void refreshLabel(){
		setText("Mineral: " + String.valueOf(gameModel.getActivePlayer().getMineralStorage()));
	}
}