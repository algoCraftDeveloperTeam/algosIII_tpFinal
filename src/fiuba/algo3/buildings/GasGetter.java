package fiuba.algo3.buildings;

import fiuba.algo3.player.Player;
/**
 * Created by nsueiro on 29/05/15.
 */
public class GasGetter extends ResourceGetter{

    @Override
    public void addToPlayerStorage(Player player){
        player.addGas(this.quantity);
    }
}
