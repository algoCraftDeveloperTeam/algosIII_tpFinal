package fiuba.algo3.model.occupant.buildings;

import fiuba.algo3.model.gameVariables.Life;
import fiuba.algo3.model.map.Coordinates;
import fiuba.algo3.model.player.Player;

/**
 * Created by nsueiro on 01/06/15.
 */
public class Asimilator extends GasGetter{
    public Asimilator(Player player, Coordinates coordinate) {
        super(player, coordinate);
        this.life = new Life(450, 450);
    }
}
