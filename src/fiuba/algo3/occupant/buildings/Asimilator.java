package fiuba.algo3.occupant.buildings;

import fiuba.algo3.gameVariables.Life;
import fiuba.algo3.map.Coordinates;
import fiuba.algo3.player.Player;

/**
 * Created by nsueiro on 01/06/15.
 */
public class Asimilator extends GasGetter{
    public Asimilator(Player player, Coordinates coordinate) {
        super(player, coordinate);
        this.life = new Life(450, 450);
    }
}
