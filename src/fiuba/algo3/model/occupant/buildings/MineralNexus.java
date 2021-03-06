package fiuba.algo3.model.occupant.buildings;

import fiuba.algo3.model.gameVariables.Life;
import fiuba.algo3.model.map.Coordinates;
import fiuba.algo3.model.player.Player;

/**
 * Created by nsueiro on 31/05/15.
 */
public class MineralNexus extends MineralGetter {

	public MineralNexus(Player player, Coordinates coordinate) {
        super(player, coordinate);
        this.life = new Life(250, 250);
    	this.info = "MineralNexus";
    }
}
