package fiuba.algo3.buildings;

import fiuba.algo3.gameVariables.Life;
import fiuba.algo3.player.Player;

/**
 * Created by nsueiro on 01/06/15.
 */
public class Asimilator extends GasGetter{
    public Asimilator(Player player) {
        this.owner = player;
        this.life = new Life(450, 450);
    }
}
