package fiuba.algo3.buildings;

import fiuba.algo3.gameVariables.Life;
import fiuba.algo3.player.Player;

/**
 * Created by nsueiro on 31/05/15.
 */
public class MineralNexus extends MineralGetter {
    public MineralNexus(Player player) {
        super(player);
        this.life = new Life(250, 250);
    }
}
