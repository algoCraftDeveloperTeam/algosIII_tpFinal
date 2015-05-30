package fiuba.algo3.buildings;

import fiuba.algo3.player.Player;

/**
 * Created by nsueiro on 29/05/15.
 */
public abstract class ResourceGetter {
    public int quantity = 10;
    public abstract void addToPlayerStorage(Player player);
}
