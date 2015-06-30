package fiuba.algo3.view;

import fiuba.algo3.model.game.AlgoCraftModel;

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