package fiuba.algo3.buildings;

import fiuba.algo3.player.Player;

/**
 * Created by nsueiro on 28/05/15.
 */
public class MineralGetter extends ResourceGetter {

    @Override
    public void addToPlayerStorage(Player player){
        player.addMinerals(this.quantity);
    }

}
