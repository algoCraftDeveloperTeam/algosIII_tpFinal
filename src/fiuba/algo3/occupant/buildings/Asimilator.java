package fiuba.algo3.occupant.buildings;

import fiuba.algo3.gameVariables.Life;
import fiuba.algo3.player.Player;

/**
 * Created by nsueiro on 01/06/15.
 */
public class Asimilator extends GasGetter{
    public Asimilator(Player player, int coordX, int coordY) {
        super(player, coordX, coordY);
        this.life = new Life(450, 450);
    }
}
