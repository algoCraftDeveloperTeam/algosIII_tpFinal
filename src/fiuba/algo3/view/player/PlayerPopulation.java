package fiuba.algo3.view.player;

import fiuba.algo3.model.game.AlgoCraftModel;
import fiuba.algo3.model.player.Player;
import fiuba.algo3.view.player.PlayerData;

/**
 * Created by mporto on 29/06/15.
 */
public class PlayerPopulation extends PlayerData {

    public PlayerPopulation(AlgoCraftModel algoCraftModel) {
        super(algoCraftModel);
        refreshLabel();
    }

    @Override
    public void refreshLabel() {
        Player activePlayer = gameModel.getActivePlayer();
        setText("Population: " + String.valueOf(activePlayer.getUsedPopulation())
                + "/" +String.valueOf(activePlayer.getAvailablePopulation()));
    }
}
