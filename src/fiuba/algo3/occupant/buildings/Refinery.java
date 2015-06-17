package fiuba.algo3.occupant.buildings;

import fiuba.algo3.gameVariables.Life;
import fiuba.algo3.player.Player;

/**
 * Created by nsueiro on 01/06/15.
 */
public class Refinery extends GasGetter {
    public Refinery(Player player, int coordX, int coordY) {
        super(player, coordX, coordY);
        this.life = new Life(750, 0);
    }
}
