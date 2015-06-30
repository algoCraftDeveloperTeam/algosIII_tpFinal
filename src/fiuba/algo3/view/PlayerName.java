package fiuba.algo3.view;

import fiuba.algo3.model.game.AlgoCraftModel;

public class PlayerName extends PlayerData{

	public PlayerName(AlgoCraftModel algoCraftModel) {
		super(algoCraftModel);
		refreshLabel();
	}

	@Override
	public void refreshLabel(){
		setText(gameModel.getActivePlayer().getName());
	}
}